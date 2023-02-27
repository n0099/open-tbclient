package com.googlecode.mp4parser.boxes.cenc;

import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class CencSampleAuxiliaryDataFormat {
    public byte[] iv;
    public List<Pair> pairs = new LinkedList();

    /* loaded from: classes8.dex */
    public class Pair {
        public int clear;
        public long encrypted;

        public Pair(int i, long j) {
            this.clear = i;
            this.encrypted = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Pair.class != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            if (this.clear == pair.clear && this.encrypted == pair.encrypted) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.encrypted;
            return (this.clear * 31) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "clr:" + this.clear + " enc:" + this.encrypted;
        }
    }

    public int getSize() {
        int length = this.iv.length;
        List<Pair> list = this.pairs;
        if (list != null && list.size() > 0) {
            return length + 2 + (this.pairs.size() * 6);
        }
        return length;
    }

    public int hashCode() {
        int i;
        byte[] bArr = this.iv;
        int i2 = 0;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = 0;
        }
        int i3 = i * 31;
        List<Pair> list = this.pairs;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + this.pairs + '}';
    }

    public Pair createPair(int i, long j) {
        return new Pair(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CencSampleAuxiliaryDataFormat.class != obj.getClass()) {
            return false;
        }
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
        if (!new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
            return false;
        }
        List<Pair> list = this.pairs;
        List<Pair> list2 = cencSampleAuxiliaryDataFormat.pairs;
        if (list == null ? list2 == null : list.equals(list2)) {
            return true;
        }
        return false;
    }
}
