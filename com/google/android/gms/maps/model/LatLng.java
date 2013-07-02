package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dc;
/* loaded from: classes.dex */
public final class LatLng implements ae {
    public static final LatLngCreator a = new LatLngCreator();
    public final double b;
    public final double c;
    private final int d;

    public LatLng(double d, double d2) {
        this(1, d, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLng(int i, double d, double d2) {
        this.d = i;
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.c = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.c = d2;
        }
        this.b = Math.max(-90.0d, Math.min(90.0d, d));
    }

    public int a() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLng) {
            LatLng latLng = (LatLng) obj;
            return Double.doubleToLongBits(this.b) == Double.doubleToLongBits(latLng.b) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(latLng.c);
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.c);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.b + "," + this.c + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            dc.a(this, parcel, i);
        } else {
            LatLngCreator.a(this, parcel, i);
        }
    }
}
