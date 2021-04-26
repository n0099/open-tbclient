package com.googlecode.mp4parser.h264.model;
/* loaded from: classes6.dex */
public class ChromaFormat {
    public static ChromaFormat MONOCHROME = new ChromaFormat(0, 0, 0);
    public static ChromaFormat YUV_420 = new ChromaFormat(1, 2, 2);
    public static ChromaFormat YUV_422 = new ChromaFormat(2, 2, 1);
    public static ChromaFormat YUV_444 = new ChromaFormat(3, 1, 1);
    public int id;
    public int subHeight;
    public int subWidth;

    public ChromaFormat(int i2, int i3, int i4) {
        this.id = i2;
        this.subWidth = i3;
        this.subHeight = i4;
    }

    public static ChromaFormat fromId(int i2) {
        ChromaFormat chromaFormat = MONOCHROME;
        if (i2 == chromaFormat.id) {
            return chromaFormat;
        }
        ChromaFormat chromaFormat2 = YUV_420;
        if (i2 == chromaFormat2.id) {
            return chromaFormat2;
        }
        ChromaFormat chromaFormat3 = YUV_422;
        if (i2 == chromaFormat3.id) {
            return chromaFormat3;
        }
        ChromaFormat chromaFormat4 = YUV_444;
        if (i2 == chromaFormat4.id) {
            return chromaFormat4;
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public int getSubHeight() {
        return this.subHeight;
    }

    public int getSubWidth() {
        return this.subWidth;
    }

    public String toString() {
        return "ChromaFormat{\nid=" + this.id + ",\n subWidth=" + this.subWidth + ",\n subHeight=" + this.subHeight + '}';
    }
}
