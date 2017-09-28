package com.googlecode.mp4parser.boxes.cenc;

import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class CencSampleAuxiliaryDataFormat {
    public byte[] iv;
    public List<Pair> pairs = new LinkedList();

    public int getSize() {
        int length = this.iv.length;
        if (this.pairs != null && this.pairs.size() > 0) {
            return length + 2 + (this.pairs.size() * 6);
        }
        return length;
    }

    public Pair createPair(int i, long j) {
        return new Pair(i, j);
    }

    /* loaded from: classes2.dex */
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
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return this.clear == pair.clear && this.encrypted == pair.encrypted;
        }

        public int hashCode() {
            return (this.clear * 31) + ((int) (this.encrypted ^ (this.encrypted >>> 32)));
        }

        public String toString() {
            return "clr:" + this.clear + " enc:" + this.encrypted;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
        if (new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
            if (this.pairs != null) {
                if (this.pairs.equals(cencSampleAuxiliaryDataFormat.pairs)) {
                    return true;
                }
            } else if (cencSampleAuxiliaryDataFormat.pairs == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((this.iv != null ? Arrays.hashCode(this.iv) : 0) * 31) + (this.pairs != null ? this.pairs.hashCode() : 0);
    }

    public String toString() {
        return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + this.pairs + '}';
    }
}
