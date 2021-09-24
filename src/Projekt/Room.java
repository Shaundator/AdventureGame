package Projekt;

public class Room {
    int roomId;
    String roomName;
    String currentDirection;

    boolean north;
    boolean east;
    boolean south;
    boolean west;
    private Room northRoom;
    private Room eastRoom;
    private Room southRoom;
    private Room westRoom;


    public Room(String name, int roomId, boolean north, boolean east, boolean south, boolean west) {
        this.roomName=name;
        this.north=north;
        this.east=east;
        this.south=south;
        this.west=west;
        this.roomId = roomId;
    }

    public void mainMenu(String input){
        if (input.equalsIgnoreCase("look")) {
            System.out.println("You look around");
            System.out.println("You are in Room " + roomId +
                    "\nNorth: " + roomPartner(1) +
                    "\nEast: " + roomPartner(2) +
                    "\nSouth: " + roomPartner(3) +
                    "\nWest: " + roomPartner(4));
        } else if (input.equalsIgnoreCase("Help")) {
            System.out.println("You ask for help");
            help();
        } else if (input.equalsIgnoreCase("Exit")) {
            System.out.println("You exit the program");
            System.exit(0);
        }  else {
            System.out.println("Invalid command");
        }
    }
    public void help(){
        System.out.println("""
                Movement:
                Go North, Go East, Go South, Go West
                Commands:
                Look - Inspect the room
                Help - Open user guide
                Exit - Exit the program
                """);
    }
    public String roomPartner(int x){
        if(x==1){
            if(northRoom!=null){
                return northRoom.roomName;
            }
            else{
                return "Unknown";
            }
        }
        if(x==2){
            if(eastRoom!=null){
                return eastRoom.roomName;
            }
            else{
                return "Unknown";
            }
        }
        if(x==3){
            if(southRoom!=null){
                return southRoom.roomName;
            }
            else{
                return "Unknown";
            }
        }
        if(x==4){
            if(westRoom!=null){
                return westRoom.roomName;
            }
            else{
                return "Unknown";
            }
        }
        return "wtf";
    }
    public int travelMenu(String input){
        if(validDirection(input)){
            return setRoomID();
        }
        System.out.println("This is not a valid direction");
        return roomId;
    }
    public int setRoomID(){
        if(currentDirection.equalsIgnoreCase("north")){
            return (roomId-3);
        }
        if (currentDirection.equalsIgnoreCase("east")){
            return (roomId+1);
        }
        if(currentDirection.equalsIgnoreCase("west")){
            return (roomId-1);
        }
        if(currentDirection.equalsIgnoreCase("south")){
            return (roomId+3);
        }
        return roomId;
    }
    public boolean validDirection(String input){
        if ((input.equalsIgnoreCase("Go North")) || (input.equalsIgnoreCase("Go N"))) {
            currentDirection="North";
            return north;
        } else if ((input.equalsIgnoreCase("Go East")) || (input.equalsIgnoreCase("Go E"))) {
            currentDirection="East";
            return east;
        } else if ((input.equalsIgnoreCase("Go South")) || (input.equalsIgnoreCase("Go S"))) {
            currentDirection="South";
            return south;
        } else if ((input.equalsIgnoreCase("Go West")) || (input.equalsIgnoreCase("Go W"))) {
            currentDirection="West";
            return west;
        }
        return false;
    }
    public boolean directionCheck(String input){
        if ((input.equalsIgnoreCase("Go North")) || (input.equalsIgnoreCase("Go N"))){
            return true;
        }if ((input.equalsIgnoreCase("Go East")) || (input.equalsIgnoreCase("Go E"))){
            return true;
        }if ((input.equalsIgnoreCase("Go South")) || (input.equalsIgnoreCase("Go S"))){
            return true;
        }if ((input.equalsIgnoreCase("Go West")) || (input.equalsIgnoreCase("Go W"))){
            return true;
        }return false;
    }
    public boolean commandCheck(String input){
        if (input.equalsIgnoreCase("look")) {
            return true;
        }if (input.equalsIgnoreCase("Help")) {
            return true;
        }if (input.equalsIgnoreCase("Exit")) {
            return true;
        }
        return false;
    }
    public void setRoomPartner(Room partnerRoom){
        if (northRoom == null) {
            if (currentDirection.equals("North")) {
                northRoom = partnerRoom;
                partnerRoom.southRoom=this;
            }
        }
        if (eastRoom==null) {
            if (currentDirection.equals("East")) {
                eastRoom = partnerRoom;
                partnerRoom.westRoom=this;
            }
        }
        if(southRoom==null) {
            if (currentDirection.equals("South")) {
                southRoom = partnerRoom;
                partnerRoom.northRoom=this;
            }
        }
        if(westRoom==null) {
            if (currentDirection.equals("West")) {
                westRoom = partnerRoom;
                partnerRoom.eastRoom=this;
            }
        }
    }
}