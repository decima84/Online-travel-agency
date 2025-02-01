public class Room {
    private String roomType;
    private int roomPrice;
    private boolean freeRoom;

    public Room(String type) {

        if (type.equals("double") || type.equals("queen") || type.equals("king")) {
            roomType = type.toLowerCase();
        } else {
            throw new IllegalArgumentException("Room of such type can't be created");
        }

        if (roomType.equals("double")) {
            roomPrice = 90 * 100;

        } else if (roomType.equals("queen")) {
            roomPrice = 110 * 100;

        } else if (roomType.equals("king")) {
            roomPrice = 150 * 100;
        }
        freeRoom = true;
    }

    public Room(Room a) {
        this.roomType = a.roomType;
        this.roomPrice = a.roomPrice;
        this.freeRoom = a.freeRoom;
    }

    public String getType() {

        return roomType;
    }

    public int getPrice() {

        return roomPrice;
    }

    public void changeAvailability() {

        freeRoom = !freeRoom;
    }

    public static Room findAvailableRoom(Room rooms[], String type) {
        int size = rooms.length;
        //Room result = null;


        for (int i = 0; i < size; i++) {
            if (rooms[i] != null && rooms[i].roomType.equals(type) && rooms[i].freeRoom == true) {
                return rooms[i];

            }
        } return null;
    }


    public static boolean makeRoomAvailable(Room rooms[], String roomType) {
        int size = rooms.length;

        for (int i = 0; i < size; i++) {
            if (rooms[i] != null && rooms[i].roomType.equals(roomType) && !rooms[i].freeRoom) {
                rooms[i].freeRoom = true;
                return true;
            }
        }
        return false;

    }

}
