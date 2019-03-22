package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int itemNumber = 0; itemNumber < items.length; itemNumber++) {
            if (!items[itemNumber].name.equals("Aged Brie")
                    && !items[itemNumber].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[itemNumber].quality > 0) {
                    if (!items[itemNumber].name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(itemNumber, 1);
                    }
                }
            } else {
                if (items[itemNumber].quality < 50) {
                    increaseQuality(itemNumber, 1);

                    if (items[itemNumber].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[itemNumber].sellIn < 11) {
                            if (items[itemNumber].quality < 50) {
                                increaseQuality(itemNumber, 1);
                            }
                        }

                        if (items[itemNumber].sellIn < 6) {
                            if (items[itemNumber].quality < 50) {
                                increaseQuality(itemNumber, 1);
                            }
                        }
                    }
                }
            }


            passOneDay(itemNumber);


            if (items[itemNumber].sellIn < 0) {
                if (!items[itemNumber].name.equals("Aged Brie")) {
                    if (!items[itemNumber].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[itemNumber].quality > 0) {
                            if (!items[itemNumber].name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(itemNumber, 1);
                            }
                        }
                    } else {
                        setQualityToZero(itemNumber);
                    }
                } else {
                    if (items[itemNumber].quality < 50) {
                        increaseQuality(itemNumber, 1);
                    }
                }
            }
        }
    }

    private void passOneDay(int itemNumber) {
        if (!items[itemNumber].name.equals("Sulfuras, Hand of Ragnaros")) {
            items[itemNumber].sellIn = items[itemNumber].sellIn - 1;
        }
    }

    private void setQualityToZero(int itemNumber) {
        items[itemNumber].quality = 0;
    }

    private void increaseQuality(int itemNumber, int increment) {
        items[itemNumber].quality = items[itemNumber].quality + increment;
    }

    private void decreaseQuality(int itemNumber, int decrement) {
        if ((items[itemNumber].quality > 0)) {
            items[itemNumber].quality = items[itemNumber].quality - decrement;
        }
    }
}