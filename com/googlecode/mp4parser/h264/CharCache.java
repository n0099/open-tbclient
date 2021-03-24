package com.googlecode.mp4parser.h264;
/* loaded from: classes6.dex */
public class CharCache {
    public char[] cache;
    public int pos;

    public CharCache(int i) {
        this.cache = new char[i];
    }

    public void append(String str) {
        char[] charArray = str.toCharArray();
        int length = this.cache.length - this.pos;
        if (charArray.length < length) {
            length = charArray.length;
        }
        System.arraycopy(charArray, 0, this.cache, this.pos, length);
        this.pos += length;
    }

    public void clear() {
        this.pos = 0;
    }

    public int length() {
        return this.pos;
    }

    public String toString() {
        return new String(this.cache, 0, this.pos);
    }

    public void append(char c2) {
        int i = this.pos;
        char[] cArr = this.cache;
        if (i < cArr.length - 1) {
            cArr[i] = c2;
            this.pos = i + 1;
        }
    }
}
