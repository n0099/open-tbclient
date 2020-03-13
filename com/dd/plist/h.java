package com.dd.plist;

import com.baidu.android.util.devices.NetWorkUtils;
/* loaded from: classes7.dex */
public class h extends i implements Comparable<Object> {
    private long lGR;
    private double lGS;
    private boolean lGT;
    private int type;

    public h(byte[] bArr, int i) {
        switch (i) {
            case 0:
                long ag = c.ag(bArr);
                this.lGR = ag;
                this.lGS = ag;
                break;
            case 1:
                this.lGS = c.ah(bArr);
                this.lGR = Math.round(this.lGS);
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
            this.lGR = parseLong;
            this.lGS = parseLong;
            this.type = 0;
        } catch (Exception e) {
            try {
                this.lGS = Double.parseDouble(str);
                this.lGR = Math.round(this.lGS);
                this.type = 1;
            } catch (Exception e2) {
                try {
                    this.lGT = (str.toLowerCase().equals("true") || str.toLowerCase().equals("yes")) ? true : z;
                    if (!this.lGT && !str.toLowerCase().equals("false") && !str.toLowerCase().equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                        throw new Exception("not a boolean");
                    }
                    this.type = 2;
                    long j = this.lGT ? 1L : 0L;
                    this.lGR = j;
                    this.lGS = j;
                } catch (Exception e3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
    }

    public h(long j) {
        this.lGR = j;
        this.lGS = j;
        this.type = 0;
    }

    public h(double d) {
        this.lGS = d;
        this.lGR = (long) d;
        this.type = 1;
    }

    public h(boolean z) {
        this.lGT = z;
        long j = z ? 1L : 0L;
        this.lGR = j;
        this.lGS = j;
        this.type = 2;
    }

    public boolean djD() {
        if (this.type == 2) {
            return this.lGT;
        }
        return this.lGR != 0;
    }

    public long longValue() {
        return this.lGR;
    }

    public double doubleValue() {
        return this.lGS;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.type == hVar.type && this.lGR == hVar.lGR && this.lGS == hVar.lGS && this.lGT == hVar.lGT;
        }
        return false;
    }

    public int hashCode() {
        return (djD() ? 1 : 0) + (((((this.type * 37) + ((int) (this.lGR ^ (this.lGR >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.lGS) ^ (Double.doubleToLongBits(this.lGS) >>> 32)))) * 37);
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return String.valueOf(longValue());
            case 1:
                return String.valueOf(doubleValue());
            case 2:
                return String.valueOf(djD());
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
