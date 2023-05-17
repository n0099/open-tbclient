package com.google.zxing.oned.rss.expanded.decoders;
/* loaded from: classes9.dex */
public final class DecodedChar extends DecodedObject {
    public static final char FNC1 = '$';
    public final char value;

    public DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        if (this.value == '$') {
            return true;
        }
        return false;
    }
}
