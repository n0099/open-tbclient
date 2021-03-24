package com.googlecode.mp4parser.boxes.cenc;

import com.coremedia.iso.Hex;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class CencSampleAuxiliaryDataFormat {
    public byte[] iv;
    public List<Pair> pairs = new LinkedList();

    /* loaded from: classes6.dex */
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
            return this.clear == pair.clear && this.encrypted == pair.encrypted;
        }

        public int hashCode() {
            long j = this.encrypted;
            return (this.clear * 31) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            return "clr:" + this.clear + " enc:" + this.encrypted;
        }
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
        if (new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
            List<Pair> list = this.pairs;
            List<Pair> list2 = cencSampleAuxiliaryDataFormat.pairs;
            return list == null ? list2 == null : list.equals(list2);
        }
        return false;
    }

    public int getSize() {
        int length = this.iv.length;
        List<Pair> list = this.pairs;
        return (list == null || list.size() <= 0) ? length : length + 2 + (this.pairs.size() * 6);
    }

    public int hashCode() {
        byte[] bArr = this.iv;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        List<Pair> list = this.pairs;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + this.pairs + '}';
    }
}
