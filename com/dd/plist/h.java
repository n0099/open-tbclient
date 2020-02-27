package com.dd.plist;

import com.baidu.android.util.devices.NetWorkUtils;
/* loaded from: classes7.dex */
public class h extends i implements Comparable<Object> {
    private long lGE;
    private double lGF;
    private boolean lGG;
    private int type;

    public h(byte[] bArr, int i) {
        switch (i) {
            case 0:
                long ag = c.ag(bArr);
                this.lGE = ag;
                this.lGF = ag;
                break;
            case 1:
                this.lGF = c.ah(bArr);
                this.lGE = Math.round(this.lGF);
                break;
            default:
                throw new IllegalArgumentException("Type argument is not valid.");
        }
        this.type = i;
    }

    public h(String str) {
        boolean z = false;
        if (str == null) {
            throw new IllegalArgumentException("The given string is null and cannot be parsed as number.");
        }
        try {
            long parseLong = Long.parseLong(str);
            this.lGE = parseLong;
            this.lGF = parseLong;
            this.type = 0;
        } catch (Exception e) {
            try {
                this.lGF = Double.parseDouble(str);
                this.lGE = Math.round(this.lGF);
                this.type = 1;
            } catch (Exception e2) {
                try {
                    this.lGG = (str.toLowerCase().equals("true") || str.toLowerCase().equals("yes")) ? true : z;
                    if (!this.lGG && !str.toLowerCase().equals("false") && !str.toLowerCase().equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                        throw new Exception("not a boolean");
                    }
                    this.type = 2;
                    long j = this.lGG ? 1L : 0L;
                    this.lGE = j;
                    this.lGF = j;
                } catch (Exception e3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
    }

    public h(long j) {
        this.lGE = j;
        this.lGF = j;
        this.type = 0;
    }

    public h(double d) {
        this.lGF = d;
        this.lGE = (long) d;
        this.type = 1;
    }

    public h(boolean z) {
        this.lGG = z;
        long j = z ? 1L : 0L;
        this.lGE = j;
        this.lGF = j;
        this.type = 2;
    }

    public boolean djA() {
        if (this.type == 2) {
            return this.lGG;
        }
        return this.lGE != 0;
    }

    public long longValue() {
        return this.lGE;
    }

    public double doubleValue() {
        return this.lGF;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.type == hVar.type && this.lGE == hVar.lGE && this.lGF == hVar.lGF && this.lGG == hVar.lGG;
        }
        return false;
    }

    public int hashCode() {
        return (djA() ? 1 : 0) + (((((this.type * 37) + ((int) (this.lGE ^ (this.lGE >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.lGF) ^ (Double.doubleToLongBits(this.lGF) >>> 32)))) * 37);
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return String.valueOf(longValue());
            case 1:
                return String.valueOf(doubleValue());
            case 2:
                return String.valueOf(djA());
            default:
                return super.toString();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        double doubleValue = doubleValue();
        if (obj instanceof h) {
            double doubleValue2 = ((h) obj).doubleValue();
            if (doubleValue < doubleValue2) {
                return -1;
            }
            return doubleValue == doubleValue2 ? 0 : 1;
        } else if (obj instanceof Number) {
            double doubleValue3 = ((Number) obj).doubleValue();
            if (doubleValue >= doubleValue3) {
                return doubleValue == doubleValue3 ? 0 : 1;
            }
            return -1;
        } else {
            return -1;
        }
    }
}
