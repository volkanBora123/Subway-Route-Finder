// Volkan Bora Seki 2021400156 26.03.2023
/*
Takes two String inputs from user
Checks they are convenient
Checks how many transfer should be done and determine tha path inductively
Print it and animate it on the canvas
 */


import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // These are derived from another program which is not included since maximize the speed.
        String[] b1Stations = {"Bahcesehir", "Halkali", "MustafaKemal", "Kucukcekmece", "Florya", "FloryaAkvaryum", "Yesilkoy", "Yesilyurt", "Atakoy", "Bakirkoy", "Yenimahalle", "Zeytinburnu", "Kazlicesme", "Yenikapi", "Sirkeci", "Uskudar", "AyrilikCesmesi", "Sogutlucesme", "Feneryolu", "Goztepe", "Erenkoy", "Suadiye", "Bostanci", "Kucukyali", "Idealtepe", "SureyyaPlaji", "Maltepe", "Cevizli", "Atalar", "Basak", "Kartal", "Yunus", "Pendik", "Kaynarca", "Tersane", "Guzelyali", "Aydintepe", "Icmeler", "Tuzla", "Cayirova", "Fatih", "Osmangazi", "Darica", "Gebze"};
        String[] mAStations = {"AtaturkHavalimani", "DTM-IstanbulFuarMerkezi", "Yenibosna", "Atakoy-Sirinevler", "Bahcelievler", "Bakirkoy-Incirli", "Zeytinburnu2", "Merter", "Davutpasa-YTU", "Terazidere", "Otogar", "Kocatepe", "Sagmalcilar", "Bayrampasa-Maltepe", "TopkapiUlubatli", "Emniyet-Fatih", "Aksaray", "Yenikapi"};
        String[] mBStations = {"Kirazli", "BagcilarMeydan", "Ucyuzlu", "Menderes", "Esenler", "Otogar"};
        String[] m2Stations = {"Yenikapi", "Vezneciler", "Halic", "Sishane", "Taksim", "Osmanbey", "Sisli-Mecidiyekoy", "Gayrettepe", "Levent", "4.Levent", "SanayiMahallesi", "IYU-Ayazaga", "AtaturkOtoSanayi", "Darusafaka", "Haciosman"};
        String[] m4Stations = {"Kadikoy", "AyrilikCesmesi", "Acibadem", "Unalan", "Goztepe2", "Yenisahra", "Kozyatagi", "Bostanci2", "Kucukyali2", "Maltepe2", "Huzurevi", "Gulsuyu", "Esenkent", "Hastane-Adliye", "Soganlik", "Kartal2", "Yakacik", "Pendik2", "Tavsantepe", "FevziCakmak", "Yayalar", "Kurtkoy", "SabihaGokcenHavalimani"};
        String[] m5Stations = {"Uskudar", "Fistikagaci", "Baglarbasi", "Altunizade", "Kisikli", "Bulgurlu", "Umraniye", "Carsi", "Yamanevler", "Cakmak", "Ihlamurkuyu", "Altinsehir", "ImamHatipLisesi", "Dudullu", "NecipFazil", "Cekmekoy"};
        String[] m6Stations = {"Levent", "Nispetiye", "Etiler", "Hisarustu"};
        String[] m7Stations = {"Mahmutbey", "GoztepeMah", "OrucReis", "Tekstilkent-Giyimkent", "KaradenizMahallesi", "Yenimahalle2", "KazimKarabekir", "Yesilpinar", "VeyselKarani-Aksemsettin", "CircirMahallesi", "Alibeykoy", "Nurtepe", "Kagithane", "Caglayan", "Sisli-Mecidiyekoy", "Fulya", "Yildiz"};
        String[] m9Stations = {"Olimpiyat", "ZiyaGokalpMahallesi", "IkitelliSanayi", "Masko", "Bahariye"};
        String[] m11Stations = {"IstanbulHavalimani", "Ihsaniye", "Gokturk", "Kemerburgaz", "Hasdal", "Kagithane"};
        String[][] stationArraysCompilation = {b1Stations, mAStations, mBStations, m2Stations, m4Stations, m5Stations, m6Stations, m7Stations, m9Stations, m11Stations};
        // these 3 ones are integrated to each one. for example the index of a random station x at wholeStationNameListatinOneArray is also the apcissa of x at wholeApcissaArray
        // and the ordinate of x at wholeOrdinatesArray.
        String[] wholeStationNameListatinOneArray = {"Bahcesehir", "Halkali", "MustafaKemal", "Kucukcekmece", "Florya", "FloryaAkvaryum", "Yesilkoy", "Yesilyurt", "Atakoy", "Bakirkoy", "Yenimahalle", "Zeytinburnu", "Kazlicesme", "Yenikapi", "Sirkeci", "Uskudar", "AyrilikCesmesi", "Sogutlucesme", "Feneryolu", "Goztepe", "Erenkoy", "Suadiye", "Bostanci", "Kucukyali", "Idealtepe", "SureyyaPlaji", "Maltepe", "Cevizli", "Atalar", "Basak", "Kartal", "Yunus", "Pendik", "Kaynarca", "Tersane", "Guzelyali", "Aydintepe", "Icmeler", "Tuzla", "Cayirova", "Fatih", "Osmangazi", "Darica", "Gebze", "AtaturkHavalimani", "DTM-IstanbulFuarMerkezi", "Yenibosna", "Atakoy-Sirinevler", "Bahcelievler", "Bakirkoy-Incirli", "Zeytinburnu2", "Merter", "Davutpasa-YTU", "Terazidere", "Otogar", "Kocatepe", "Sagmalcilar", "Bayrampasa-Maltepe", "TopkapiUlubatli", "Emniyet-Fatih", "Aksaray", "Yenikapi", "Kirazli", "BagcilarMeydan", "Ucyuzlu", "Menderes", "Esenler", "Otogar", "Yenikapi", "Vezneciler", "Halic", "Sishane", "Taksim", "Osmanbey", "Sisli-Mecidiyekoy", "Gayrettepe", "Levent", "4.Levent", "SanayiMahallesi", "IYU-Ayazaga", "AtaturkOtoSanayi", "Darusafaka", "Haciosman", "Kadikoy", "AyrilikCesmesi", "Acibadem", "Unalan", "Goztepe2", "Yenisahra", "Kozyatagi", "Bostanci2", "Kucukyali2", "Maltepe2", "Huzurevi", "Gulsuyu", "Esenkent", "Hastane-Adliye", "Soganlik", "Kartal2", "Yakacik", "Pendik2", "Tavsantepe", "FevziCakmak", "Yayalar", "Kurtkoy", "SabihaGokcenHavalimani", "Uskudar", "Fistikagaci", "Baglarbasi", "Altunizade", "Kisikli", "Bulgurlu", "Umraniye", "Carsi", "Yamanevler", "Cakmak", "Ihlamurkuyu", "Altinsehir", "ImamHatipLisesi", "Dudullu", "NecipFazil", "Cekmekoy", "Levent", "Nispetiye", "Etiler", "Hisarustu", "Mahmutbey", "GoztepeMah", "OrucReis", "Tekstilkent-Giyimkent", "KaradenizMahallesi", "Yenimahalle2", "KazimKarabekir", "Yesilpinar", "VeyselKarani-Aksemsettin", "CircirMahallesi", "Alibeykoy", "Nurtepe", "Kagithane", "Caglayan", "Sisli-Mecidiyekoy", "Fulya", "Yildiz", "Olimpiyat", "ZiyaGokalpMahallesi", "IkitelliSanayi", "Masko", "Bahariye", "IstanbulHavalimani", "Ihsaniye", "Gokturk", "Kemerburgaz", "Hasdal", "Kagithane"};
        int[] wholeApcissaArray = {39, 98, 113, 127, 157, 177, 200, 227, 257, 276, 296, 325, 349, 413, 474, 530, 545, 557, 580, 602, 621, 642, 664, 683, 700, 718, 736, 754, 772, 790, 806, 828, 850, 866, 884, 904, 925, 936, 948, 959, 971, 983, 993, 1003,214, 223, 235, 249, 265, 275, 287, 291, 302, 315, 329, 340, 351, 360, 374, 390, 402, 413,214, 236, 259, 280, 303, 329,413, 430, 437, 452, 451, 451, 452, 452, 452, 464, 464, 464, 465, 477, 488,525, 545, 562, 578, 595, 619, 642, 660, 679, 697, 714, 732, 750, 769, 787, 805, 823, 840, 849, 882, 893, 903, 907,530, 537, 546, 557, 570, 586, 603, 619, 634, 647, 661, 675, 692, 706, 719, 731,452, 465, 473, 482,210, 221, 230, 246, 264, 282, 300, 319, 339, 356, 374, 397, 415, 430, 452, 460, 467,146, 171, 193, 189, 176,218, 304, 371, 393, 394, 415};
        int[] wholeOrdinatesArray = {282, 114, 94, 79, 50, 29, 28, 28, 35, 46, 46, 46, 45, 61, 109, 138, 103, 74, 58, 58, 49, 49, 48, 48, 48, 49, 49, 48, 48, 49, 49, 48, 50, 50, 49, 48, 48, 57, 68, 79, 91, 101, 112, 124,44, 55, 66, 68, 77, 88, 99, 120, 134, 149, 160, 152, 141, 132, 118, 102, 90, 61,160, 169, 169, 169, 169, 160,61, 84, 91, 129, 148, 175, 218, 239, 257, 274, 298, 319, 338, 357, 369, 83, 103, 109, 109, 97, 90, 91, 90, 91, 91, 91, 91, 90, 91, 91, 91, 91, 88, 79, 85, 96, 107, 123,138, 154, 164, 173, 186, 186, 186, 187, 186, 186, 185, 186, 186, 186, 186, 186,257, 256, 256, 256,205, 216, 226, 234, 233, 233, 233, 233, 234, 233, 233, 233, 234, 221, 218, 208, 200,261, 260, 251, 226, 214,462, 409, 342, 318, 295, 234};
        Scanner input = new Scanner(System.in);
        String departureStation = input.next();
        String targetStation = input.next();
        // Checker is a function that takes 2 argument,first a string second a string array, and if the string in the array returns true,else --
        // false. this if statement check bot departure and target stations are decent or not.
        if (Checker(departureStation,wholeStationNameListatinOneArray)&&Checker(targetStation,wholeStationNameListatinOneArray)) {
            //If I am here I know both stations are contained some subway lines, here I check if they are connected or
            // not. Since every line are connected but 9th line. It's enough to check if they are both or none of them in the 9th line
            if(Checker(departureStation,m9Stations) == Checker(targetStation,m9Stations)) {
                ArrayList<String> path = new ArrayList<>(); // This is the path will be the path we are looking for.
                // Since it can be transfer four times max, I defined 5 functions for (0,1,2,3,4) transfers. they are inductive functions, depends on the functions before them.
                if(checkSameLine(departureStation,targetStation,stationArraysCompilation)) {
                    String[] pathArray  = sameLinePathFinder(departureStation, targetStation, stationArraysCompilation);
                    for (String e :pathArray){
                        System.out.println(e);
                        path.add(e);
                    }

                }
                if(checkTwoDistance(departureStation,targetStation,stationArraysCompilation)){
                    path = pathOneTransfer(departureStation,targetStation,stationArraysCompilation);
                    for(String pastedStations:path)System.out.println(pastedStations);
                }
                if(checkThreeDistence(departureStation,targetStation,stationArraysCompilation)){
                    path = pathTwoTransfer(departureStation,targetStation,stationArraysCompilation);
                    for(String e:path)System.out.println(e);
                }
                if(checkFourDistance(departureStation,targetStation,stationArraysCompilation)){
                    path =pathThreeTransfer(departureStation,targetStation,stationArraysCompilation);
                    for(String e:path)System.out.println(e);
                }
                if(checkFiveDistence(departureStation,targetStation,stationArraysCompilation)) {
                    path = pathFourTransfer(departureStation, targetStation, stationArraysCompilation);
                    for (String e :path ) System.out.println(e);
                }
                ArrayList<ArrayList<Integer>> pastThroughStations = new ArrayList<>(); // Since the passed stations will be remained orange, I defined this arraylist.
                // The canvas arrangments.
                StdDraw.setCanvasSize(1024, 482);
                StdDraw.setXscale(0, 1024);
                StdDraw.setYscale(0, 482);
                StdDraw.picture(512, 241, "background.jpg");
                StdDraw.enableDoubleBuffering();
                for(String station: path){
                    StdDraw.picture(512, 241, "background.jpg");
                    String[][] stationNameList = {b1Stations, mAStations, mBStations, m2Stations, m4Stations, m5Stations, m6Stations, m7Stations, m9Stations, m11Stations};
                    // these ones are also derived from another project at java and copied here.
                    String[] stationstoBeonCanvas = {"Levent", "Olimpiyat", "IstanbulHavalimani", "Kucukyali", "Uskudar", "Kadikoy", "AtaturkHavalimani", "Bostanci2", "Kirazli", "Bahcesehir", "Halkali", "Florya", "Mahmutbey", "Bakirkoy", "Zeytinburnu", "Sirkeci", "AyrilikCesmesi", "Sogutlucesme", "Kartal", "Feneryolu", "Erenkoy", "Maltepe", "Kartal", "Guzelyali", "Tuzla", "Fatih", "Gebze", "Yenibosna", "Bahcelievler", "Zeytinburnu2", "Merter", "Sagmalcilar", "Aksaray", "Yenikapi", "Menderes", "Otogar", "Halic", "Taksim", "Gayrettepe", "4.Levent", "SanayiMahallesi", "AtaturkOtoSanayi", "Haciosman", "AyrilikCesmesi", "Unalan", "Bostanci2", "Esenkent", "Pendik2", "SabihaGokcenHavalimani", "Kisikli", "Carsi", "Ihlamurkuyu", "Cekmekoy", "Hisarustu", "GoztepeMah", "Tekstilkent-Giyimkent", "Yesilpinar", "Alibeykoy", "Sisli-Mecidiyekoy", "Yildiz", "IkitelliSanayi", "Bahariye", "Ihsaniye", "Gokturk", "Kemerburgaz", "Kagithane"};
                    int[] b1Apcissa = {39, 98, 113, 127, 157, 177, 200, 227, 257, 276, 296, 325, 349, 413, 474, 530, 545, 557, 580, 602, 621, 642, 664, 683, 700, 718, 736, 754, 772, 790, 806, 828, 850, 866, 884, 904, 925, 936, 948, 959, 971, 983, 993, 1003};
                    int[] b1Ordinates = {282, 114, 94, 79, 50, 29, 28, 28, 35, 46, 46, 46, 45, 61, 109, 138, 103, 74, 58, 58, 49, 49, 48, 48, 48, 49, 49, 48, 48, 49, 49, 48, 50, 50, 49, 48, 48, 57, 68, 79, 91, 101, 112, 124};
                    int[] b1Color = {101, 102, 106};
                    int[] mAApcissa = {214, 223, 235, 249, 265, 275, 287, 291, 302, 315, 329, 340, 351, 360, 374, 390, 402, 413};
                    int[] mAOrdinates = {44, 55, 66, 68, 77, 88, 99, 120, 134, 149, 160, 152, 141, 132, 118, 102, 90, 61};
                    int[] mAColor = {225, 30, 28};
                    int[] mBApcissa = {214, 236, 259, 280, 303, 329};
                    int[] mBOrdinates = {160, 169, 169, 169, 169, 160};
                    int[] mBColor = {141, 31, 22};
                    int[] m2Apcissa = {413, 430, 437, 452, 451, 451, 452, 452, 452, 464, 464, 464, 465, 477, 488};
                    int[] m2Ordinates = {61, 84, 91, 129, 148, 175, 218, 239, 257, 274, 298, 319, 338, 357, 369};
                    int[] m2Color = {0, 152, 66};
                    int[] m4Apcissa = {525, 545, 562, 578, 595, 619, 642, 660, 679, 697, 714, 732, 750, 769, 787, 805, 823, 840, 849, 882, 893, 903, 907};
                    int[] m4Ordinates = {83, 103, 109, 109, 97, 90, 91, 90, 91, 91, 91, 91, 90, 91, 91, 91, 91, 88, 79, 85, 96, 107, 123};
                    int[] m4Color = {231, 27, 116};
                    int[] m5Apcissa = {530, 537, 546, 557, 570, 586, 603, 619, 634, 647, 661, 675, 692, 706, 719, 731};
                    int[] m5Ordinates = {138, 154, 164, 173, 186, 186, 186, 187, 186, 186, 185, 186, 186, 186, 186, 186};
                    int[] m5Color = {97, 38, 93};
                    int[] m6Apcissa = {452, 465, 473, 482};
                    int[] m6Ordinates = {257, 256, 256, 256};
                    int[] m6Color = {201, 171, 120};
                    int[] m7Apcissa = {210, 221, 230, 246, 264, 282, 300, 319, 339, 356, 374, 397, 415, 430, 452, 460, 467};
                    int[] m7Ordinates = {205, 216, 226, 234, 233, 233, 233, 233, 234, 233, 233, 233, 234, 221, 218, 208, 200};
                    int[] m7Color = {242, 158, 192};
                    int[] m9Apcissa = {146, 171, 193, 189, 176};
                    int[] m9Ordinates = {261, 260, 251, 226, 214};
                    int[] m9Color = {254, 211, 0};
                    int[] m11Apcissa = {218, 304, 371, 393, 394, 415};
                    int[] m11Ordinates = {462, 409, 342, 318, 295, 234};
                    int[] m11Colors = {165, 90, 150};
                    // this multidimensional array is associate colours with the coordinates
                    int[][][] colorCoordinateList = {{b1Color, b1Apcissa, b1Ordinates}, {mAColor, mAApcissa, mAOrdinates}, {mBColor, mBApcissa, mBOrdinates}, {m2Color, m2Apcissa, m2Ordinates}, {m4Color, m4Apcissa, m4Ordinates}, {m5Color, m5Apcissa, m5Ordinates}, {m6Color, m6Apcissa, m6Ordinates}, {m7Color, m7Apcissa, m7Ordinates}, {m9Color, m9Apcissa, m9Ordinates}, {m11Colors, m11Apcissa, m11Ordinates}};
                    for (int[][] tempStation : colorCoordinateList) {
                        // here data took from colourcoordinatelist is used to draw lines and mark the points and
                        StdDraw.setPenRadius(0.012);
                        StdDraw.setPenColor(tempStation[0][0], tempStation[0][1], tempStation[0][2]);
                        //these one draws the lines
                        for (int index = 0; index < tempStation[1].length - 1; index++) {
                            StdDraw.line(tempStation[1][index], tempStation[2][index], tempStation[1][index + 1], tempStation[2][index + 1]);
                        }
                        //these marks white all stations
                        for (int index = 0; index < tempStation[1].length; index++) {
                            StdDraw.setPenRadius(0.01);
                            StdDraw.setPenColor(Color.white);
                            StdDraw.point(tempStation[1][index], tempStation[2][index]);
                        }
                    }
                    StdDraw.setFont(new Font("Helvatica", Font.BOLD, 8));
                    StdDraw.setPenColor(Color.BLACK);
                    // these one is to write station on the canvas
                    for (int index = 0; index < 10; index++) {
                        for (int indexTwo = 0; indexTwo < stationNameList[index].length; indexTwo++) {
                            if (Checker(stationNameList[index][indexTwo], stationstoBeonCanvas)) {
                                StdDraw.text(colorCoordinateList[index][1][indexTwo], colorCoordinateList[index][2][indexTwo] + 5, stationNameList[index][indexTwo]);
                            }
                        }
                    }
                    // These make pen ready to mark passed and current station
                    StdDraw.setPenRadius(0.01);
                    StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                    // these one point the passed ones
                    if(pastThroughStations.size() > 0){
                        for (ArrayList<Integer> pasted : pastThroughStations) {
                            StdDraw.point(pasted.get(0),pasted.get(1));
                        }
                    }
                    int index = stringIndexFinder(station,wholeStationNameListatinOneArray);
                    //these store the current one
                    ArrayList<Integer> toadd = new ArrayList<>();
                    toadd.add(wholeApcissaArray[index]);
                    toadd.add(wholeOrdinatesArray[index]);
                    pastThroughStations.add(toadd);
                    StdDraw.setPenRadius(0.02);
                    //here points
                    StdDraw.point(wholeApcissaArray[index],wholeOrdinatesArray[index]);
                    StdDraw.show();
                    StdDraw.pause(300);
                    StdDraw.clear();

                }
            }
            else System.out.println("These two stations are not connected");
        }
        else System.out.println("The station names provided are not present in this map.");
    }
    // a function to check if the string argument is contained by the array argument
    public static boolean Checker(String element, String[] beChecked) {
        for (String e : beChecked) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }
    //this one checks whether they are at the same line.
    public static boolean checkSameLine(String first, String second, String[][] sourceList){
        for(String[] station:sourceList){
            // using the Checker method, if there is a station include both, returns true else false.
            if(Checker(first,station) && Checker(second,station)) return true;
        }
        return false;
    }
    // this is the method to find the index of a string in a list. if not it returns -1 but I used only that I know it is in
    public static int stringIndexFinder(String finder,String[] findee){
        for(int i = 0; i < findee.length;i ++){
            if (findee[i].equals(finder))
                return i;
        }
        return -1;
    }

    // from here code checks how many transfer will you have to do. If code starts to check transfer x times, code had already checked the range (0,x-1) times.
    // this is a precaution to some errors in code
    // this one finds the path between two station in a line in order.
    public static String[] sameLinePathFinder(String first, String second, String[][] sourceList){
        for(String[] station:sourceList){
            // I could use the checkSameLine method, but it made after these so a bit repetitive.
            if(Checker(first,station)){
                if(Checker(second,station)){
                    // the location of the arguments in the common station.
                    int firstLocation = stringIndexFinder(first,station);
                    int secondLocation = stringIndexFinder(second,station);
                    // this one returns the path both included so I arranged the size = difference + 1
                    String[] retArray = new String[absoluteValue(firstLocation,secondLocation)+1];
                    // if the arguments are sorted, I just copy the relevant part
                    if (firstLocation<secondLocation) {
                        if (secondLocation + 1 - firstLocation >= 0)
                            System.arraycopy(station, firstLocation, retArray, 0, secondLocation + 1 - firstLocation);
                        return retArray;
                    }
                    // else I copy the relevant path but reversed
                    else{
                        if (firstLocation + 1 - secondLocation >= 0)
                            System.arraycopy(station, secondLocation, retArray, 0, firstLocation + 1 - secondLocation);
                        String[] arrayToReturn = new String[absoluteValue(firstLocation,secondLocation)+1];
                        // here I recerse again
                        for(int i = retArray.length-1;i >= 0;i--){
                            arrayToReturn[retArray.length - i-1] = retArray[i];
                        }
                        return arrayToReturn;
                    }
                }
            }
        }
        // this is an array to be never used. I just defined it because It didn't turn anything besides the for loop
        // even though I know it can't be return java gives an error.
        String[] failure = {"hayda"};
        return failure;
    }
    // TransferpointFindermethod is a method that give you all breakpoints which are in the same line with the string argument.
    public static String[] transferPointFinderMethod(String theStation,String[][] stationArray){
        // these handmade list include all breakpoints.
        String[] transferPoints = {"Yenikapi", "Otogar", "Kagithane", "Levent", "Sisli-Mecidiyekoy", "Uskudar", "AyrilikCesmesi"};
        int size = 0;
        // this is a for loop to determine the size of the array.
        for(String transfer : transferPoints){
            for(String[] station : stationArray){
                if (Checker(transfer,station)){
                    if(Checker(theStation,station)) size++;
                }
            }
        }
        String[] retArray = new String[size];
        int index = 0;
        // this adds all breakpoints to the array will return.
        for(String transfer : transferPoints){
            for(String[] station : stationArray){
                if (Checker(transfer,station)){
                    if(Checker(theStation,station)){
                        retArray[index] = transfer;
                        index++;

                    }
                }
            }
        }
        return retArray;
    }
    // this is the same method before but returns the array from the beginning until the last element(not included)
    public static String[] sameLinePathFinderButLastStation(String first, String second, String[][] sourceList){
        for(String[] station:sourceList){
            if(Checker(first,station)){
                if(Checker(second,station)){
                    int firstLocation = stringIndexFinder(first,station);
                    int secondLocation = stringIndexFinder(second,station);
                    String[] retArray = new String[absoluteValue(firstLocation,secondLocation)];
                    if (firstLocation<secondLocation) {
                        if (secondLocation - firstLocation >= 0)
                            System.arraycopy(station, firstLocation, retArray, 0, secondLocation - firstLocation);
                        return retArray;
                    }
                    else{
                        if (firstLocation - secondLocation >= 0)
                            System.arraycopy(station, secondLocation+1, retArray, 0, firstLocation - secondLocation);
                        String[] arrayToReturn = new String[absoluteValue(firstLocation,secondLocation)];
                        for(int i = retArray.length-1;i >= 0;i--){
                            arrayToReturn[retArray.length - i-1] = retArray[i];
                        }
                        return arrayToReturn;
                    }

                }
            }
        }
        String[] failure = {"hayda"};
        return failure;
    }

    // Now I know how to travel between two station which are in a common line.
    // this one checks if the argument stations can be traveled by just one transfer. It does this by using transferPointFinderMethod.
    // We can know if we can travel but transferring, also transferPointFinderMethod finds the breakpoints in the same line.
    // So if one of the first argument's breakpoints share the same line with the second one, I can choose the breakpoint and
    // travel to it, after travel to second argument. This is the main thing this program do, so which I told so long.
    // Check x Distance (x is an element of (1,2,3,4,5) is the common way to name them because I simply check every breakpoint
    // and goes there and is it x-1 distanced means x-1 transfer enough to go there
    public static boolean checkTwoDistance(String first, String second, String[][] sourceList){
        if (!checkSameLine(first,second,sourceList)){
            for(String element:transferPointFinderMethod(first,sourceList)){
                if (checkSameLine(element,second,sourceList)) return true;
            }
        }
        return false;
    }
    // this one takes the action. find the transfer point before and goes it by using sameLinePathFinderButLastStation,
    // store the path and combine it with the path with the breakpoint and the second one.
    public static ArrayList<String> pathOneTransfer(String first, String second, String[][] sourceList){
        ArrayList<String> arrayToReturn = new ArrayList<>();
        String usefulTransferPoint = "";
        if (checkTwoDistance(first,second,sourceList)){
            for(String transferPoint: transferPointFinderMethod(first,sourceList)){
                if (checkSameLine(transferPoint,second,sourceList)) usefulTransferPoint = transferPoint;

            }
            for(String station:sameLinePathFinderButLastStation(first,usefulTransferPoint,sourceList))arrayToReturn.add(station);
            for(String station:sameLinePathFinder(usefulTransferPoint,second,sourceList))arrayToReturn.add(station);
        }
        return arrayToReturn;
    }

    // Now, I know check if we can go 1 and 2 distanced places. I go all breakpoints and check if the target is 2 distanced.

    public static boolean checkThreeDistence(String first, String second, String[][] sourceList){
        if (!checkSameLine(first,second,sourceList)){
            if (!checkTwoDistance(first,second,sourceList)){
                for(String transfer: transferPointFinderMethod(first,sourceList)){
                    if (checkTwoDistance(transfer,second,sourceList))return true;
                }
            }
        }
        return false;
    }
    // If I can I go to the breakpoint and use the pathOnetransferMethod and combine them.
    public static ArrayList<String> pathTwoTransfer(String first, String second, String[][] sourceList){
        ArrayList<String> arrayToReturn = new ArrayList<>();
        String usefulTransferPoint = "";
        if (checkThreeDistence(first,second,sourceList)){
            for(String transferPoint: transferPointFinderMethod(first,sourceList)){
                if (checkTwoDistance(transferPoint,second,sourceList)) usefulTransferPoint = transferPoint;

            }
            for(String station:sameLinePathFinderButLastStation(first,usefulTransferPoint,sourceList))arrayToReturn.add(station);
            for(String station:pathOneTransfer(usefulTransferPoint,second,sourceList))arrayToReturn.add(station);
        }
        return arrayToReturn;
    }
    // Now, I know check if we can go 1 2 and 3 distanced places. I go all breakpoints and check if the target is 3 distanced.
    public static boolean checkFourDistance(String first, String second, String[][] sourceList){
        if (!checkSameLine(first,second,sourceList)){
            if (!checkTwoDistance(first,second,sourceList)){
                if(!checkThreeDistence(first,second,sourceList)){
                    for(String transfer: transferPointFinderMethod(first,sourceList)){
                        if (checkThreeDistence(transfer,second,sourceList))return true;
                    }
                }
            }
        }
        return false;
    }
    // If I can, I go to the breakpoint and use the pathTwotransferMethod and combine them.
    public static ArrayList<String> pathThreeTransfer(String first, String second, String[][] sourceList){
        ArrayList<String> arrayToReturn = new ArrayList<>();
        String usefulTransferPoint = "";
        if (checkFourDistance(first,second,sourceList)){
            for(String transferPoint: transferPointFinderMethod(first,sourceList)){
                if (checkThreeDistence(transferPoint,second,sourceList)) usefulTransferPoint = transferPoint;

            }
            for(String station:sameLinePathFinderButLastStation(first,usefulTransferPoint,sourceList))arrayToReturn.add(station);
            for(String station:pathTwoTransfer(usefulTransferPoint,second,sourceList))arrayToReturn.add(station);
        }
        return arrayToReturn;
    }
    // Now, I know check if we can go 1 2 3 and 4 distanced places. I go all breakpoints and check if the target is 4 distanced.
    public static boolean checkFiveDistence(String first, String second, String[][] sourceList){
        if (!checkSameLine(first,second,sourceList)){
            if (!checkTwoDistance(first,second,sourceList)){
                if(!checkThreeDistence(first,second,sourceList)){
                    if(!checkFourDistance(first,second,sourceList)){
                        for(String transfer: transferPointFinderMethod(first,sourceList)){
                            if (checkFourDistance(transfer,second,sourceList))return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    // If I can I go to the breakpoint and use the pathThreeTransferMethod and combine them.
    public static ArrayList<String> pathFourTransfer(String first, String second, String[][] sourceList){
        ArrayList<String> arrayToReturn = new ArrayList<>();
        String usefulTransferPoint = "";
        if (checkFiveDistence(first,second,sourceList)){
            for(String transferPoint: transferPointFinderMethod(first,sourceList)){
                if (checkFourDistance(transferPoint,second,sourceList)) usefulTransferPoint = transferPoint;

            }
            for(String station:sameLinePathFinderButLastStation(first,usefulTransferPoint,sourceList))arrayToReturn.add(station);
            for(String station:pathThreeTransfer(usefulTransferPoint,second,sourceList))arrayToReturn.add(station);
        }
        return arrayToReturn;
    }

    //This one used to determine the size of some arrays
    public static int absoluteValue(int numOne,int numTwo){
        if (numOne - numTwo >= 0) return numOne - numTwo;
        else return numTwo - numOne;
    }

}