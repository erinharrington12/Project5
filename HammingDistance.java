//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class HammingDistance {
//
//	public static int[] asciiCodes = new int[4];
//	public String stationID;
//
//	public HammingDistance() throws IOException {
//
//	}
//
//	public HammingDistance(int hamDist, String station) throws IOException {
//		// TODO Auto-generated constructor stub\
//		// TODO Auto-generated method stub
//
//		String fileName = "Mesonet.txt";
//		BufferedReader br = new BufferedReader(new FileReader(fileName));
//
//		ArrayList<String> stationId = new ArrayList<String>();
//
//		String lineOfData = br.readLine();
//
//		for (int i = 0; i < 120; i++) {
//
//			stationId.add(lineOfData);
//			lineOfData = br.readLine();
//
//		}
//
//		br.close();
//		System.out.println(stationId);
//
//		char[] firstChar = station.toCharArray();
//		char[] secondChar = new char[4];
//		ArrayList<String> station0 = new ArrayList<String>();
//		ArrayList<String> station1 = new ArrayList<String>();
//		ArrayList<String> station2 = new ArrayList<String>();
//		ArrayList<String> station3 = new ArrayList<String>();
//		ArrayList<String> station4 = new ArrayList<String>();
//		int distance = 0;
//		int minLength = Math.min(firstChar.length, secondChar.length);
//
//		for (int j = 0; j < stationId.size(); ++j) {
//			secondChar = stationId.get(j).toCharArray();
//			for (int i = 0; i < minLength; ++i) {
//				if (firstChar[i] != secondChar[i]) {
//
//					distance++;
//
//				}
//
//			}
//
//			if (distance == 0 && hamDist == 0) {
//				station0.add(stationId.get(j));
//
//			} else if (distance == 1 && hamDist == 1) {
//				station1.add(stationId.get(j));
//			} else if (distance == 2 && hamDist == 2) {
//				station2.add(stationId.get(j));
//
//			} else if (distance == 3) {
//				station3.add(stationId.get(j));
//			} else if (distance == 4) {
//				station4.add(stationId.get(j));
//			}
//
//			System.out.println(getStationID(station1.toString()));
//			distance = 0;
//		}
//
//	}
//
//	public String getStationID(String station) {
//		this.stationID = station;
//		return stationID;
//	}
//
//	public String getStation() {
//		return stationID;
//	}
//
//}
