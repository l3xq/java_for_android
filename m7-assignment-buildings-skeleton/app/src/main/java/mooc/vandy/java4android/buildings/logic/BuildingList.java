package mooc.vandy.java4android.buildings.logic;

public class BuildingList {

    private House[] mHouse;
    private Office[] mOffice;

    public BuildingList() {
        mHouse = new House[9];
        mHouse[0] = new House(20, 40, 56, 60);
        mHouse[0].setOwner("George Washington");
        mHouse[0].setPool(true);
        mHouse[1] = new House(90, 190, 100, 200, "John Adams");
        mHouse[2] = new Cottage(40, 60, 56, "Thomas Jefferson", true);
        mHouse[3] = new House(20, 40, 56, 60, "James Madison", true);
        mHouse[4] = new Cottage(100, 130, 110, "James Monroe", false);
        mHouse[5] = new House(100, 100, 110, 110, "John Quincy Adams", true);
        mHouse[6] = new House(10, 10, 100, 100, "Andrew Jackson", true);
        mHouse[7] = new House(10, 10, 12, 12);
        mHouse[8] = new House(10, 10, 12, 12);
        mHouse[8].setPool(true);
		
        mOffice = new Office[6];
        mOffice[0] = new Office(20, 40, 56, 60);
        mOffice[1] = new Office(200, 400, 600, 560, "Bridgestone/Firestone", 100);
        mOffice[2] = new Office(200, 400, 560, 600, "Caterpillar");
        mOffice[2].setParkingSpaces(100);
        mOffice[3] = new Office(100, 400, 200, 500, "Cracker Barrel");
        mOffice[4] = new Office(300, 100, 400, 200);
        mOffice[4].setParkingSpaces(50);
        mOffice[5] = new Office(200, 100, 300, 200, "Nissan");
    }

    public House[] getHouses() {
        return mHouse;
    }

    public Office[] getOffices() {
        return mOffice;
    }
}
