package Projekt;

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Room[] room = new Room[9];
        room[0] = new Room("Room 1", 0, false,true,true,false);
        room[1] = new Room("Room 2", 1, false,true,false,true);
        room[2] = new Room("Room 3", 2, false,false,true,true);
        room[3] = new Room("Room 4", 3, true,false,true,false);
        room[4] = new Room("Room 5", 4, false,false,true,false);
        room[5] = new Room("Room 6", 5, true,false,true,false);
        room[6] = new Room("Room 7", 6, true,true,false,false);
        room[7] = new Room("Room 8", 7, true,true,false,true);
        room[8] = new Room("Room 9", 8, true,false,false,true);
        Room theVoid = new Room("Void");
        Room currentRoom=null;
        currentRoom=room[0];

        while(true){
            System.out.println("Which direction would you like to go?");
            String direction = sc.nextLine();

            if(currentRoom.validDirection(direction)) {
                int nextRoom=currentRoom.travelMenu(direction);
                currentRoom.setRoomPartner(room[nextRoom]);
                currentRoom = room[nextRoom];
                System.out.println("You enter " + currentRoom.roomName); //Du har skiftet rum
            }
            else if(currentRoom.directionCheck(direction)){
                if(!currentRoom.validDirection(direction)){
                    currentRoom.setRoomPartner(theVoid);
                    System.out.println("You cannot walk in this direction");
                }
            }

            else if(currentRoom.commandCheck(direction)){
                currentRoom.mainMenu(direction);
            }
            else {
                System.out.println("This command does not exist");
            }
        }
    }
}
