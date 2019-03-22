package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int itemNumber = 0; itemNumber < items.length; itemNumber++) {
            switch(items[itemNumber].name){

                case "Aged Brie":
                    decreaseSellInByOne(itemNumber);
                    increaseQualityAgedBrie(itemNumber);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    increaseQualityBackstage(itemNumber);
                    if (items[itemNumber].sellIn < 0) {
                        setQualityToZero(itemNumber);
                    }
                    decreaseSellInByOne(itemNumber);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    increaseQuality(itemNumber, 1);
                    break;

                default:
                    decreaseSellInByOne(itemNumber);
                    decreaseQualityDefault(itemNumber);

            }

        }
    }

    private void increaseQualityBackstage(int itemNumber) {
        increaseQuality(itemNumber, 1);
        if (items[itemNumber].sellIn < 11) {
            increaseQuality(itemNumber, 1);
        }
        if (items[itemNumber].sellIn < 6) {
            increaseQuality(itemNumber, 1);
        }
    }

    private void increaseQualityAgedBrie(int itemNumber) {
        if (items[itemNumber].sellIn < 0) {
            increaseQuality(itemNumber, 2);
        } else {
            increaseQuality(itemNumber, 1);
        }
    }

    private void decreaseQualityDefault(int itemNumber) {
        if (items[itemNumber].sellIn < 0) {
            decreaseQuality(itemNumber, 2);
        } else {
            decreaseQuality(itemNumber, 1);
        }
    }

    private void decreaseSellInByOne(int itemNumber) {
        items[itemNumber].sellIn = items[itemNumber].sellIn - 1;
    }

    private void setQualityToZero(int itemNumber) {
        items[itemNumber].quality = 0;
    }

    private void increaseQuality(int itemNumber, int increment) {
        if (items[itemNumber].quality < 50) {
            items[itemNumber].quality = items[itemNumber].quality + increment;
        }
    }

    private void decreaseQuality(int itemNumber, int decrement) {
        if ((items[itemNumber].quality > 0)) {
            items[itemNumber].quality = items[itemNumber].quality - decrement;
        }
    }
}

