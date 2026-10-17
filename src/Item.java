class Item {
    double price;
    int stock;

    int purchaseCount = 0;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
    }

    void restock(int amount) {
        if (amount > 0) {
            this.stock = this.stock + amount;
        }
    }

    void purchase(int amount) {
        if (amount > 0 && amount <= stock) {
            this.stock -= amount;
            this.purchaseCount += amount;
        }
    }


}