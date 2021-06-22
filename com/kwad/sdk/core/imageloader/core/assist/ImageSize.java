package com.kwad.sdk.core.imageloader.core.assist;
/* loaded from: classes7.dex */
public class ImageSize {
    public static final String SEPARATOR = "x";
    public static final int TO_STRING_MAX_LENGHT = 9;
    public final int height;
    public final int width;

    public ImageSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public ImageSize(int i2, int i3, int i4) {
        if (i4 % 180 == 0) {
            this.width = i2;
            this.height = i3;
            return;
        }
        this.width = i3;
        this.height = i2;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f2) {
        return new ImageSize((int) (this.width * f2), (int) (this.height * f2));
    }

    public ImageSize scaleDown(int i2) {
        return new ImageSize(this.width / i2, this.height / i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.width);
        sb.append("x");
        sb.append(this.height);
        return sb.toString();
    }
}
