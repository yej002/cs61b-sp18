public class NBody{
	public static double readRadius(String path){
		In in = new In(path);
		int firstItem = in.readInt();
		double raduis= in.readDouble();

		return raduis;
	}

	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int numberOfPlanets = in.readInt();
		Planet[] planets = new Planet[numberOfPlanets];
		double raduis = in.readDouble();
		int i = 0;
		while (i < numberOfPlanets){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, name);
			i = i + 1;
		}
		return planets;
	}
	public static void drawAll(Planet[] planets){
		int i = 0;
    	while (i < planets.length){
    		Planet p = planets[i];
    		p.draw();
    		i ++;
    	}

	}

	//how to use args :  java NBody 2 2 ./data/planets.txt /

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        String filename = args[2];

		double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        //StdDraw.setScale(-radius, radius);
        // StdDraw.picture(0, 0, "./images/starfield.jpg");

        // drawAll(planets);
    	

    	StdDraw.enableDoubleBuffering();

    	double time = 0;
    	while(time <= T){
    		double[] xForces = new double[planets.length];
    		double[] yForces = new double[planets.length];
    		int i = 0;
    		while (i < planets.length){
    			xForces[i] = planets[i].calcNetForceExertedByX(planets);
    			yForces[i] = planets[i].calcNetForceExertedByX(planets);
    			i ++;
    		}
    		i = 0;
    		while(i < planets.length){
    			planets[i].update(dt, xForces[i], yForces[i]);
    			i ++;
    		}
    		StdDraw.setScale(-radius, radius);
    		StdDraw.picture(0, 0, "./images/starfield.jpg");
    		
    		drawAll(planets);
    		
    		StdDraw.show();
    		StdDraw.pause(10);
    		time = time + dt;

    	}
    	StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}

    }
}
   
