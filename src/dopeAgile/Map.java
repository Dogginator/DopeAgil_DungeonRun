package dopeAgile;

public class Map {
    private final mapSize currentMapSize;
    private final Room[][] mapArray;
    private int[] spawnPointXYCoordinates;
    private Room spawnRoom;

    public mapSize getCurrentMapSize() {
        return currentMapSize;
    }

    public Room[][] getMapArray() {
        return mapArray;
    }

    Map (mapSize sizeEnum, cardinalDirection spawnCardinal) {
        this.currentMapSize = sizeEnum;
        spawnPointXYCoordinates = calcSpawnPointCoordinates(spawnCardinal);
        mapArray = createMapArray(sizeEnum.getSize());
        calcAdjacentRooms();
    }

    public enum mapSize {
        SMALL(4),
        MEDIUM(5),
        LARGE(8);

        private final int size;

        mapSize(final int newSize) {
            size = newSize;
        }

        int getSize() {
            return this.size;
        }
    }

    public enum cardinalDirection {
        N, W, S, E, NW, NE, SW, SE;
    }

    private Room[][] createMapArray(int size) {
        Room[][] mapArray = new Room[size][size];
        for (int y = 0; y < mapArray.length; y++) {
            for (int x = 0; x < mapArray[y].length; x++) {
                boolean isEdge = (y == 0 || x == 0 || y == (mapArray.length-1) || x == (mapArray.length-1));
                if (y == spawnPointXYCoordinates[0] && x == spawnPointXYCoordinates[1]) {
                    Room newRoom = new Room(x, y, isEdge, true);
                    mapArray[y][x] = newRoom;
                    this.spawnRoom = newRoom;
                } else {
                    mapArray[y][x] = new Room(x, y, isEdge, false);
                }
            }
        }
        return mapArray;
    }

    private void calcAdjacentRooms() {
        for (Room[] mapRowArray: mapArray) {
            for (Room thisRoom: mapRowArray) {
                int xPos = thisRoom.getMapX();
                int yPos = thisRoom.getMapY();

                // ERROR IS HERE, TRYING TO ACCESS OUT OF BOUND

                // Try to add north room
                if (getRoomFromArray(xPos, yPos-1) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.N, getRoomFromArray(xPos, yPos-1));
                }
                // Try to add east room
                if (getRoomFromArray(xPos+1, yPos) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.E, getRoomFromArray(xPos+1, yPos));
                }
                // Try to add south room
                if (getRoomFromArray(xPos, yPos+1) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.S, getRoomFromArray(xPos, yPos+1));
                }
                // Try to add west room
                if (getRoomFromArray(xPos-1, yPos) != null) {
                    thisRoom.addAdjacentRoom(cardinalDirection.W, getRoomFromArray(xPos-1, yPos));
                }
            }
        }
    }

    private int[] calcSpawnPointCoordinates(cardinalDirection spawnCardinal) {
        int[] returnInt = new int[] {0, 0};
        switch (spawnCardinal) {
            case NE:
                returnInt[1] = currentMapSize.getSize() - 1;
                break;
            case SE:
                returnInt[0] = currentMapSize.getSize() - 1;
                returnInt[1] = currentMapSize.getSize() - 1;
                break;
            case SW:
                returnInt[0] = currentMapSize.getSize() - 1;
                break;
        }
        return returnInt;
    }

    public Room getRoomFromArray(int x, int y) {
        try {
            return mapArray[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    public String toString(){
        String result = "";
        for (Room[] roomRows : mapArray) {
            for (Room room : roomRows) {
                if (room == getSpawnRoom()) {
                    result += "[*]";
                } else if (room.getIsRoomExplored()) {
                    result += "[ ]";
                } else {
                    result += "[?]";
                }
            }
          result += "\n";  
        }
        return result;
    }

    public Room getSpawnRoom() {
        if (this.spawnRoom == null) {
            int x = spawnPointXYCoordinates[0];
            int y = spawnPointXYCoordinates[1];
            return getRoomFromArray(x, y);
        } else {
            return this.spawnRoom;
        }
    }

}
