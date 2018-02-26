package craps;

public class Craps
{
    private GVdie d1;
    private GVdie d2;
    int credits;
    int points;
    String message;
    boolean comeOut;
    int total;
    
    public Craps(){
        points=-1;
        d1 = new GVdie();
        d2= new GVdie();
        credits=10;
        comeOut=true;
        message=("welcome to my craps game");

    }

    public int getCredits(){
        return credits;
    }

    public int getPoint(){
        return points;
    }

    public String getMessage(){
        return message;
    }

    public GVdie getDie(int num){
        if(num==1){
            return d1;
        }
        else{
            return d2;
        }
    }

    public void setCredits(int amount){
        if (amount>=0){
            credits=amount;
        }
        else{
            credits=credits;
        }
    }

    public void comeOut(){
        if (comeOut && credits>=1){
            d1.roll();
            d2.roll();
            total=d1.getValue()+d2.getValue();
            if ((total==7 || total==11) && credits>=1){

                credits+=1;
                message="You gained one more credit!";
            }
            else{
                if(total==2 || total==3 || total==12){
                    credits-=1;
                    message="You lost one credit!";
                }
                else{
                    comeOut=false;
                    points=total;
                    message="You need to gain some credits!";
                }
            }
        }
    }

    public void roll(){

        if(okToRoll()){
            d1.roll();
            d2.roll();
            total=d1.getValue()+d2.getValue();
            if(total==7){
                comeOut=true;
                credits-=1;
                points=-1;
                message="You lost one credit and a point!";
            }
            else{
                if(total==points){
                    comeOut=true;
                    credits+=1;
                    points-=1;
                    message="You gained a credit but lost a point!";
                }
                else{
                    message="Nothing new happened keep playing!";
                }
            }
        }
    }

    public boolean okToRoll(){
        if (comeOut==true){
            return false;
        }
        else{
            return true;
        }
    }
}