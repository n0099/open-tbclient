package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.db;
import com.google.android.gms.internal.w;
import com.google.android.gms.internal.x;
/* loaded from: classes.dex */
public final class LatLngBounds implements ae {
    public static final LatLngBoundsCreator a = new LatLngBoundsCreator();
    public final LatLng b;
    public final LatLng c;
    private final int d;

    /* loaded from: classes.dex */
    public final class Builder {
        private double a = Double.POSITIVE_INFINITY;
        private double b = Double.NEGATIVE_INFINITY;
        private double c = Double.NaN;
        private double d = Double.NaN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        x.a(latLng, "null southwest");
        x.a(latLng2, "null northeast");
        x.a(latLng2.b >= latLng.b, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.b), Double.valueOf(latLng2.b));
        this.d = i;
        this.b = latLng;
        this.c = latLng2;
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
        if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            return this.b.equals(latLngBounds.b) && this.c.equals(latLngBounds.c);
        }
        return false;
    }

    public int hashCode() {
        return w.a(this.b, this.c);
    }

    public String toString() {
        return w.a(this).a("southwest", this.b).a("northeast", this.c).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            db.a(this, parcel, i);
        } else {
            LatLngBoundsCreator.a(this, parcel, i);
        }
    }
}
