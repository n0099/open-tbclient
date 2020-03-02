package com.dd.plist;

import com.baidu.android.util.devices.NetWorkUtils;
/* loaded from: classes7.dex */
public class h extends i implements Comparable<Object> {
    private long lGG;
    private double lGH;
    private boolean lGI;
    private int type;

    public h(byte[] bArr, int i) {
        switch (i) {
            case 0:
                long ag = c.ag(bArr);
                this.lGG = ag;
                this.lGH = ag;
                break;
            case 1:
                this.lGH = c.ah(bArr);
                this.lGG = Math.round(this.lGH);
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
            this.lGG = parseLong;
            this.lGH = parseLong;
            this.type = 0;
        } catch (Exception e) {
            try {
                this.lGH = Double.parseDouble(str);
                this.lGG = Math.round(this.lGH);
                this.type = 1;
            } catch (Exception e2) {
                try {
                    this.lGI = (str.toLowerCase().equals("true") || str.toLowerCase().equals("yes")) ? true : z;
                    if (!this.lGI && !str.toLowerCase().equals("false") && !str.toLowerCase().equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                        throw new Exception("not a boolean");
                    }
                    this.type = 2;
                    long j = this.lGI ? 1L : 0L;
                    this.lGG = j;
                    this.lGH = j;
                } catch (Exception e3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
    }

    public h(long j) {
        this.lGG = j;
        this.lGH = j;
        this.type = 0;
    }

    public h(double d) {
        this.lGH = d;
        this.lGG = (long) d;
        this.type = 1;
    }

    public h(boolean z) {
        this.lGI = z;
        long j = z ? 1L : 0L;
        this.lGG = j;
        this.lGH = j;
        this.type = 2;
    }

    public boolean djC() {
        if (this.type == 2) {
            return this.lGI;
        }
        return this.lGG != 0;
    }

    public long longValue() {
        return this.lGG;
    }

    public double doubleValue() {
        return this.lGH;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.type == hVar.type && this.lGG == hVar.lGG && this.lGH == hVar.lGH && this.lGI == hVar.lGI;
        }
        return false;
    }

    public int hashCode() {
        return (djC() ? 1 : 0) + (((((this.type * 37) + ((int) (this.lGG ^ (this.lGG >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.lGH) ^ (Double.doubleToLongBits(this.lGH) >>> 32)))) * 37);
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return String.valueOf(longValue());
            case 1:
                return String.valueOf(doubleValue());
            case 2:
                return String.valueOf(djC());
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
