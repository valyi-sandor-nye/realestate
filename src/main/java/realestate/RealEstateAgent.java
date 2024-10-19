package realestate;

import realestate.exceptions.BadInputFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class RealEstateAgent {

    TreeSet<RealEstate> stock = new TreeSet<>();

    RealEstateAgent(String inputFilename) throws FileNotFoundException {
        populateStockFromTextFile(inputFilename);

    }

    void populateStockFromTextFile(String filename) {
        int lineNo = 0;
        try {
            File inputFile = new File(filename);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                process(line);
                lineNo++;
            }
            scanner.close();


        } catch (BadInputFormatException e) {
            System.err.println(e.getMessage()+"in the "+lineNo+"the line");
        }   catch (FileNotFoundException e) {
        System.err.println("No such file.");

    }
    }

    private void process(String line) throws BadInputFormatException {
        String[] pieces = line.split("#");
        if (!sizeCheck(pieces)) throw new BadInputFormatException("wrong size");
        if (!(correctFirstPiece(pieces[0]))) throw new BadInputFormatException("no correct start");
        else if (pieces.length == 6) {
            if (!pieces[0].equals("REALESTATE")) {
                System.err.println("Six pieces but no" +
                        " REALESTATE start");
            } else {

                Genre newGenre = genreFromString(pieces[5]);

                stock.add(
                        new RealEstate(pieces[1],
                                Double.parseDouble(pieces[2]),
                                Integer.parseInt(pieces[3]),
                                Double.parseDouble(pieces[4]),
                                newGenre));

            }
        }


        if (pieces.length == 8) {
            if (!pieces[0].equals("PANEL")) {
                System.err.println("Eight pieces but no PANEL start");

            } else {

                Genre newGen;
                switch (pieces[5]) {

                    case "CONDOMINIUM":
                        newGen = Genre.CONDOMINIUM;
                        break;
                    case "FARM":
                        newGen = Genre.FARM;
                        break;
                    case "FAMILYHOUSE":
                        newGen = Genre.FAMILY_HOUSE;
                        break;
                    default:
                        newGen = Genre.FARM;
                        break;
                }
                boolean insu = false;
                switch (pieces[6]) {

                    case "yes":
                        insu = true;
                        break;
                    case "no":
                        break;
                }

                stock.add(
                        new Panel(pieces[1],
                                Double.parseDouble(pieces[2]),
                                Integer.parseInt(pieces[3]),
                                Double.parseDouble(pieces[4]),
                                newGen,
                                Integer.parseInt(pieces[6]),
                                insu));


            }
        }
    }

    private Boolean correctFirstPiece(String piece) {
        return null;
    }

    private boolean sizeCheck(String[] pieces) {
        return (pieces.length == 6 || pieces.length == 8);

    }

    private Genre genreFromString(String piece) {
        switch (piece) {
            case "CONDOMINIUM":
                return Genre.CONDOMINIUM;
            case "FARM":
                return Genre.FARM;
            case "FAMILY_HOUSE":
                return Genre.FAMILY_HOUSE;
            default:
                return null;
        }

    }
}


