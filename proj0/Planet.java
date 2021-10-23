import java.lang.Math;
public class Planet{
	/** current x position */
	public double xxPos;
	/** current y position */
	public double yyPos;
	/** current velocity in the x direction */
	public double xxVel;
	/** current velocity in the y direction */
	public double yyVel;
	/** it is mass */
	public double mass;
	/**  The name of the file that corresponds to the image 
	that depicts the planet (for example, jupiter.gif)*/
	public String imgFileName;
	/** same as 6.67*Math.pow(10,-11); */
	private static final double G = 6.67e-11;


	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;

	}


	public double calcDistance(Planet p){
		double distance = 
		Math.sqrt((p.xxPos - xxPos)*(p.xxPos - xxPos)+
		(p.yyPos - yyPos)*(p.yyPos - yyPos));
		return distance;
	}

	public double calcForceExertedBy(Planet p){
		double force = (G*p.mass*mass)/(calcDistance(p)*calcDistance(p));
		return force;
	}

	public double calcForceExertedByX(Planet p){
		double forceX = calcForceExertedBy(p)*(p.xxPos - xxPos)/calcDistance(p);
		return forceX;
	}
	public double calcForceExertedByY(Planet p){
		double forceY = calcForceExertedBy(p)*(p.yyPos - yyPos)/calcDistance(p);
		return forceY;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		int i = 0;
		double netForceX = 0;
		while(i < allPlanets.length ){
			if(!this.equals(allPlanets[i])){
				netForceX = netForceX + calcForceExertedByX(allPlanets[i]);
			}
			i = i + 1;
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		int i = 0;
		double netForceY = 0;
		while(i < allPlanets.length ){
			if(!this.equals(allPlanets[i])){
				netForceY = netForceY + calcForceExertedByY(allPlanets[i]);
			}
			i = i + 1;
		}
		return netForceY;
	}

	public void update(double dtime, double dfX, double dfY){
		double accX = dfX/mass;
		double accY = dfY/mass;
		double newVelX = xxVel + dtime * accX;
		double newVelY = yyVel + dtime * accY;
		double newPosX = xxPos + dtime * newVelX;
		double newPosY = yyPos + dtime * newVelY;
		
		this.xxVel = newVelX;
		this.yyVel = newVelY;
		this.xxPos = newPosX;
		this.yyPos = newPosY;

	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}

}