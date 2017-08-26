package reveilleMatin;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.5139 modeling language!*/



// line 2 "model.ump"
// line 73 "model.ump"
public class ReveilMatin
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ReveilMatin Attributes
  private int heure;
  private int minute;
  private int minuteAlarme;
  private int heureAlarme;
  private int entered;
  private Intensite volume;
  private Sonnerie son;

  //ReveilMatin State Machines
  enum UniteControl { tempsCourant, changeTime, changeAlarmTime, alarme }
  private UniteControl uniteControl;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ReveilMatin()
  {
    heure = 0;
    minute = 0;
    minuteAlarme = -1;
    heureAlarme = -1;
    entered = 0;
    volume = Intensite.BAS;
    son = Sonnerie.SONNERIE;
    setUniteControl(UniteControl.tempsCourant);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHeure(int aHeure)
  {
    boolean wasSet = false;
    heure = aHeure;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinute(int aMinute)
  {
    boolean wasSet = false;
    minute = aMinute;
    wasSet = true;
    return wasSet;
  }

  public boolean setMinuteAlarme(int aMinuteAlarme)
  {
    boolean wasSet = false;
    minuteAlarme = aMinuteAlarme;
    wasSet = true;
    return wasSet;
  }

  public boolean setHeureAlarme(int aHeureAlarme)
  {
    boolean wasSet = false;
    heureAlarme = aHeureAlarme;
    wasSet = true;
    return wasSet;
  }

  public boolean setEntered(int aEntered)
  {
    boolean wasSet = false;
    entered = aEntered;
    wasSet = true;
    return wasSet;
  }

  public boolean setVolume(Intensite aVolume)
  {
    boolean wasSet = false;
    volume = aVolume;
    wasSet = true;
    return wasSet;
  }

  public boolean setSon(Sonnerie aSon)
  {
    boolean wasSet = false;
    son = aSon;
    wasSet = true;
    return wasSet;
  }

  public int getHeure()
  {
    return heure;
  }

  public int getMinute()
  {
    return minute;
  }

  public int getMinuteAlarme()
  {
    return minuteAlarme;
  }

  public int getHeureAlarme()
  {
    return heureAlarme;
  }

  public int getEntered()
  {
    return entered;
  }

  public Intensite getVolume()
  {
    return volume;
  }

  public Sonnerie getSon()
  {
    return son;
  }

  public String getUniteControlFullName()
  {
    String answer = uniteControl.toString();
    return answer;
  }

  public UniteControl getUniteControl()
  {
    return uniteControl;
  }

  public boolean bouton(String message)
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case tempsCourant:
        if (message.equals("temps"))
        {
          setUniteControl(UniteControl.changeTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("alarme"))
        {
        // line 15 "model.ump"
          System.out.println(this.alarmToString());
          setUniteControl(UniteControl.changeAlarmTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("volume"))
        {
        // line 23 "model.ump"
          if(volume==Intensite.BAS){volume=Intensite.MOYEN;System.out.println("The volume of the alarm now has a medium intensity");}else if(volume==Intensite.MOYEN){volume=Intensite.HAUT;System.out.println("The volume of the alarm now has a high intensity");}else{volume=Intensite.BAS;System.out.println("The volume of the alarm now has a low intensity");}
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("son"))
        {
        // line 24 "model.ump"
          if(son==Sonnerie.SONNERIE){son=Sonnerie.RADIO;System.out.println("The sound of the alarm has been changed to radio");}else{son=Sonnerie.SONNERIE;System.out.println("The sound of the alarm has been changed to ringing");}
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        break;
      case changeTime:
        if (message.equals("minute"))
        {
        // line 31 "model.ump"
          this.minute=(minute+1)%60; System.out.println(this.toString());
          setUniteControl(UniteControl.changeTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("10 minutes"))
        {
        // line 33 "model.ump"
          this.minute=(minute+10)%60; System.out.println(this.toString());
          setUniteControl(UniteControl.changeTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("heure"))
        {
        // line 35 "model.ump"
          this.heure=(heure+1)%24; System.out.println(this.toString());
          setUniteControl(UniteControl.changeTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("temps"))
        {
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        break;
      case changeAlarmTime:
        if (message.equals("minute"))
        {
        // line 44 "model.ump"
          if(minuteAlarme==-1){minuteAlarme=0;}this.minuteAlarme=(minuteAlarme+1)%60; System.out.println(this.alarmToString());
          setUniteControl(UniteControl.changeAlarmTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("10 minutes"))
        {
        // line 47 "model.ump"
          if(minuteAlarme==-1){minuteAlarme=0;}this.minuteAlarme=(minuteAlarme+10)%60; System.out.println(this.alarmToString());
          setUniteControl(UniteControl.changeAlarmTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("heure"))
        {
        // line 50 "model.ump"
          if(heureAlarme==-1){heureAlarme=0;}this.heureAlarme=(heureAlarme+1)%24;
          System.out.println(this.alarmToString());
          setUniteControl(UniteControl.changeAlarmTime);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("alarme"))
        {
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        break;
      case alarme:
        if (message.equals("snooze"))
        {
        // line 60 "model.ump"
          System.out.println("alarm has stopped ringing but will restart in 5 minutes"); if(minuteAlarme+5>=60){minuteAlarme=(minuteAlarme+5)%60;heureAlarme=(heureAlarme+1)%24;}else{
          minuteAlarme=minuteAlarme+5;}entered=0;
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        if (message.equals("alarme"))
        {
        // line 62 "model.ump"
          System.out.println("The alarm has been stopped");entered=0;minuteAlarme=-1;heureAlarme=-1;
          setUniteControl(UniteControl.tempsCourant);
          wasEventProcessed = true;
          break;
        }
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean alarm()
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case tempsCourant:
        setUniteControl(UniteControl.alarme);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean incrementTime()
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case tempsCourant:
        // line 19 "model.ump"
        if(minute+1>=60){
        minute=(minute+1)%60;heure=(heure+1)%24;}else{
        minute=minute+1;}
        setUniteControl(UniteControl.tempsCourant);
        wasEventProcessed = true;
        break;
      case changeTime:
        // line 27 "model.ump"
        if(minute+1>=60){
        minute=(minute+1)%60;heure=(heure+1)%24;}else{
        minute=minute+1;}if(minuteAlarme==minute &&       heureAlarme==heure){this.alarm();}
        setUniteControl(UniteControl.changeTime);
        wasEventProcessed = true;
        break;
      case changeAlarmTime:
        // line 40 "model.ump"
        if(minute+1>=60){
        minute=(minute+1)%60;heure=(heure+1)%24;}else{
        minute=minute+1;}
        setUniteControl(UniteControl.changeAlarmTime);
        wasEventProcessed = true;
        break;
      case alarme:
        // line 65 "model.ump"
        if(minute+1>=60){
        minute=(minute+1)%60;heure=(heure+1)%24;}else{         minute=minute+1;}System.out.println(this.toString());entered++; if(entered==2){if(volume==Intensite.BAS){volume=Intensite.MOYEN;}else if(volume==Intensite.MOYEN){volume=Intensite.HAUT;}if(son==Sonnerie.SONNERIE){this.ringingAlarm();}else{this.radioAlarm();}}
        setUniteControl(UniteControl.alarme);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean radioAlarm()
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case alarme:
        // line 58 "model.ump"
        if(volume==Intensite.BAS){System.out.println("The radio is playing at low intensity");}else if(volume==Intensite.MOYEN){System.out.println("The radio is playing at medium intensity");}else{System.out.println("The radio is playing at high intensity");}
        setUniteControl(UniteControl.alarme);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean stopAlarm()
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case alarme:
        // line 67 "model.ump"
        entered=0;System.out.println("The alarm has stopped ringing");
        setUniteControl(UniteControl.tempsCourant);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean ringingAlarm()
  {
    boolean wasEventProcessed = false;
    
    UniteControl aUniteControl = uniteControl;
    switch (aUniteControl)
    {
      case alarme:
        // line 68 "model.ump"
        if(volume==Intensite.BAS){System.out.println("The alarm is ringing at low intensity");}else if(volume==Intensite.MOYEN){System.out.println("The alarm is ringing at medium intensity");}else{System.out.println("The alarm is ringing at high intensity");}if(entered==0){this.entered++;}
        setUniteControl(UniteControl.alarme);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setUniteControl(UniteControl aUniteControl)
  {
    uniteControl = aUniteControl;

    // entry actions and do activities
    switch(uniteControl)
    {
      case tempsCourant:
        // line 12 "model.ump"
        System.out.println(this.toString());if(minuteAlarme==minute && heureAlarme==heure){this.alarm();}
        break;
      case alarme:
        // line 57 "model.ump"
        if(entered==0 && son==Sonnerie.RADIO){this.radioAlarm();}else if(entered==0){this.ringingAlarm();}else if(entered==3){this.stopAlarm();}
        break;
    }
  }

  public void delete()
  {}







public String toString()
  {
    String time=""; 
    if(heure<10){
    	time=time+"0";
    }
    time=time+heure+":";
    if(minute<10){
    	time=time+"0";
    }
    time=time+minute;
    return time;
  }
  public String alarmToString(){
	  String time="";
	  if(this.heureAlarme<10){
		  time=time+"0";
	  }
	  time=time+heureAlarme+":";
	  if(this.minuteAlarme<10){
		  time=time+"0";
	  }
	  time=time+this.minuteAlarme;
	  return time;
  }
}