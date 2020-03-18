package com.dd.plist;

import com.baidu.android.util.devices.NetWorkUtils;
/* loaded from: classes7.dex */
public class h extends i implements Comparable<Object> {
    private long lIx;
    private double lIy;
    private boolean lIz;
    private int type;

    public h(byte[] bArr, int i) {
        switch (i) {
            case 0:
                long ag = c.ag(bArr);
                this.lIx = ag;
                this.lIy = ag;
                break;
            case 1:
                this.lIy = c.ah(bArr);
                this.lIx = Math.round(this.lIy);
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
            this.lIx = parseLong;
            this.lIy = parseLong;
            this.type = 0;
        } catch (Exception e) {
            try {
                this.lIy = Double.parseDouble(str);
                this.lIx = Math.round(this.lIy);
                this.type = 1;
            } catch (Exception e2) {
                try {
                    this.lIz = (str.toLowerCase().equals("true") || str.toLowerCase().equals("yes")) ? true : z;
                    if (!this.lIz && !str.toLowerCase().equals("false") && !str.toLowerCase().equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                        throw new Exception("not a boolean");
                    }
                    this.type = 2;
                    long j = this.lIz ? 1L : 0L;
                    this.lIx = j;
                    this.lIy = j;
                } catch (Exception e3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
    }

    public h(long j) {
        this.lIx = j;
        this.lIy = j;
        this.type = 0;
    }

    public h(double d) {
        this.lIy = d;
        this.lIx = (long) d;
        this.type = 1;
    }

    public h(boolean z) {
        this.lIz = z;
        long j = z ? 1L : 0L;
        this.lIx = j;
        this.lIy = j;
        this.type = 2;
    }

    public boolean dka() {
        if (this.type == 2) {
            return this.lIz;
        }
        return this.lIx != 0;
    }

    public long longValue() {
        return this.lIx;
    }

    public double doubleValue() {
        return this.lIy;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.type == hVar.type && this.lIx == hVar.lIx && this.lIy == hVar.lIy && this.lIz == hVar.lIz;
        }
        return false;
    }

    public int hashCode() {
        return (dka() ? 1 : 0) + (((((this.type * 37) + ((int) (this.lIx ^ (this.lIx >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.lIy) ^ (Double.doubleToLongBits(this.lIy) >>> 32)))) * 37);
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return String.valueOf(longValue());
            case 1:
                return String.valueOf(doubleValue());
            case 2:
                return String.valueOf(dka());
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
