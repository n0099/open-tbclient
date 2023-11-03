package com.google.zxing.oned.rss;
/* loaded from: classes10.dex */
public final class Pair extends DataCharacter {
    public int count;
    public final FinderPattern finderPattern;

    public Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    public int getCount() {
        return this.count;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public void incrementCount() {
        this.count++;
    }
}
