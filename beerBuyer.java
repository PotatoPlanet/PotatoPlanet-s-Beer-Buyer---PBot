package beerBuyer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.bot.event.listener.PaintListener;

public class beerBuyer extends ActiveScript implements PaintListener {

	@Override
	protected void setup() {
		provide(new buyBeer());
		provide(new bankBeer());
		provide(new antibanTask());
		ID.startTime = System.currentTimeMillis();
	}

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(255, 255, 255);

	private final Font font1 = new Font("Arial", 0, 20);

	private final Image img1 = getImage("http://i1230.photobucket.com/albums/ee494/XF1taX/Potatoplanet.png");

	public void onRepaint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		g.drawImage(img1, 3, 2, null);
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("Beers Bought: " + ID.beerBought, 263, 449);
		g.drawString("Time Running: " + runTime(ID.startTime), 25, 409);
		g.drawString("Money Gained: " + ID.beerBought * ID.beerPrice, 264, 406);
	}

	public String runTime(long i) {
		DecimalFormat nf = new DecimalFormat("00");
		long millis = System.currentTimeMillis() - i;
		long hours = millis / (1000 * 60 * 60);
		millis -= hours * (1000 * 60 * 60);
		long minutes = millis / (1000 * 60);
		millis -= minutes * (1000 * 60);
		long seconds = millis / 1000;
		return nf.format(hours) + ":" + nf.format(minutes) + ":"
				+ nf.format(seconds);
	}

}
