package com.dd.plist;

import com.baidu.android.util.devices.NetWorkUtils;
/* loaded from: classes4.dex */
public class h extends i implements Comparable<Object> {
    private long lCu;
    private double lCv;
    private boolean lCw;
    private int type;

    public h(byte[] bArr, int i) {
        switch (i) {
            case 0:
                long ac = c.ac(bArr);
                this.lCu = ac;
                this.lCv = ac;
                break;
            case 1:
                this.lCv = c.ad(bArr);
                this.lCu = Math.round(this.lCv);
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
            this.lCu = parseLong;
            this.lCv = parseLong;
            this.type = 0;
        } catch (Exception e) {
            try {
                this.lCv = Double.parseDouble(str);
                this.lCu = Math.round(this.lCv);
                this.type = 1;
            } catch (Exception e2) {
                try {
                    this.lCw = (str.toLowerCase().equals("true") || str.toLowerCase().equals("yes")) ? true : z;
                    if (!this.lCw && !str.toLowerCase().equals("false") && !str.toLowerCase().equals(NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED)) {
                        throw new Exception("not a boolean");
                    }
                    this.type = 2;
                    long j = this.lCw ? 1L : 0L;
                    this.lCu = j;
                    this.lCv = j;
                } catch (Exception e3) {
                    throw new IllegalArgumentException("The given string neither represents a double, an int nor a boolean value.");
                }
            }
        }
    }

    public h(long j) {
        this.lCu = j;
        this.lCv = j;
        this.type = 0;
    }

    public h(double d) {
        this.lCv = d;
        this.lCu = (long) d;
        this.type = 1;
    }

    public h(boolean z) {
        this.lCw = z;
        long j = z ? 1L : 0L;
        this.lCu = j;
        this.lCv = j;
        this.type = 2;
    }

    public boolean dhk() {
        if (this.type == 2) {
            return this.lCw;
        }
        return this.lCu != 0;
    }

    public long longValue() {
        return this.lCu;
    }

    public double doubleValue() {
        return this.lCv;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.type == hVar.type && this.lCu == hVar.lCu && this.lCv == hVar.lCv && this.lCw == hVar.lCw;
        }
        return false;
    }

    public int hashCode() {
        return (dhk() ? 1 : 0) + (((((this.type * 37) + ((int) (this.lCu ^ (this.lCu >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.lCv) ^ (Double.doubleToLongBits(this.lCv) >>> 32)))) * 37);
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return String.valueOf(longValue());
            case 1:
                return String.valueOf(doubleValue());
            case 2:
                return String.valueOf(dhk());
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
