package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.location.Geofence;
/* loaded from: classes.dex */
public class cf implements ae, Geofence {
    public static final cg a = new cg();
    private final int b;
    private final String c;
    private final long d;
    private final short e;
    private final double f;
    private final double g;
    private final float h;
    private final int i;

    public cf(int i, String str, int i2, short s, double d, double d2, float f, long j) {
        a(str);
        a(f);
        a(d, d2);
        int a2 = a(i2);
        this.b = i;
        this.e = s;
        this.c = str;
        this.f = d;
        this.g = d2;
        this.h = f;
        this.d = j;
        this.i = a2;
    }

    private static int a(int i) {
        int i2 = i & 3;
        if (i2 == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + i);
        }
        return i2;
    }

    private static void a(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void a(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void a(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public int a() {
        return this.b;
    }

    public short b() {
        return this.e;
    }

    public double c() {
        return this.f;
    }

    public double d() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        cg cgVar = a;
        return 0;
    }

    public float e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof cf)) {
            cf cfVar = (cf) obj;
            return this.h == cfVar.h && this.f == cfVar.f && this.g == cfVar.g && this.e == cfVar.e;
        }
        return false;
    }

    public String f() {
        return this.c;
    }

    public long g() {
        return this.d;
    }

    public int h() {
        return this.i;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        long doubleToLongBits2 = Double.doubleToLongBits(this.g);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.h)) * 31) + this.e) * 31) + this.i;
    }

    public String toString() {
        return String.format("Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, @%d]", b(this.e), this.c, Integer.valueOf(this.i), Double.valueOf(this.f), Double.valueOf(this.g), Float.valueOf(this.h), Long.valueOf(this.d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        cg cgVar = a;
        cg.a(this, parcel, i);
    }
}
