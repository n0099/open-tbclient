package com.google.zxing;
/* loaded from: classes.dex */
public final class Dimension {
    private final int height;
    private final int width;

    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.width = i;
        this.height = i2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            return this.width == dimension.width && this.height == dimension.height;
        }
        return false;
    }

    public final int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public final String toString() {
        return String.valueOf(this.width) + "x" + this.height;
    }
}
