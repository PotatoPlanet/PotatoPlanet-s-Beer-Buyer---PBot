package beerBuyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class ID {

	static Area bankArea = new Area(new Tile[] { new Tile(3249, 3424, 0),
			new Tile(3257, 3424, 0), new Tile(3257, 3415, 0),
			new Tile(3249, 3415, 0), new Tile(3249, 3424, 0) });

	static Area barArea = new Area(new Tile[] { new Tile(3214, 3403, 0),
			new Tile(3228, 3403, 0), new Tile(3228, 3392, 0),
			new Tile(3215, 3392, 0), new Tile(3214, 3392, 0),
			new Tile(3214, 3403, 0) });

	static Tile[] bankToBeerShop = new Tile[] { new Tile(3219, 3395, 0),
			new Tile(3214, 3395, 0), new Tile(3213, 3390, 0),
			new Tile(3218, 3391, 0), new Tile(3223, 3390, 0),
			new Tile(3228, 3390, 0), new Tile(3233, 3390, 0),
			new Tile(3238, 3390, 0), new Tile(3243, 3390, 0),
			new Tile(3248, 3390, 0), new Tile(3250, 3395, 0),
			new Tile(3255, 3397, 0), new Tile(3257, 3402, 0),
			new Tile(3258, 3407, 0), new Tile(3259, 3412, 0),
			new Tile(3262, 3416, 0), new Tile(3263, 3421, 0),
			new Tile(3263, 3426, 0), new Tile(3259, 3429, 0),
			new Tile(3254, 3428, 0), new Tile(3253, 3423, 0),
			new Tile(3253, 3418, 0) };

	static int beerID = 1917;
	static int barKeepID = 733;
	static int bankerID = 553;

	public static long startTime;

	static int beerPrice = getPrice(beerID);

	static int beerBought;

	static Boolean Bank = true;

	static private int getPrice(int itemID) {
		URL url;
		InputStream in_stream;
		String line = "0";
		BufferedReader reader;
		try {
			url = new URL("http://scripts.audefy.com/l/" + itemID);
			in_stream = url.openConnection().getInputStream();
			reader = new BufferedReader(new InputStreamReader(in_stream));
			line = reader.readLine();
		} catch (IOException ex) {
			System.out.println("An error occured while trying to load price");
		}
		return Integer.parseInt(line);
	}
}
