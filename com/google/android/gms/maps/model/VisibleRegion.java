package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.w;
/* loaded from: classes.dex */
public final class VisibleRegion implements ae {
    public static final VisibleRegionCreator a = new VisibleRegionCreator();
    public final LatLng b;
    public final LatLng c;
    public final LatLng d;
    public final LatLng e;
    public final LatLngBounds f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.g = i;
        this.b = latLng;
        this.c = latLng2;
        this.d = latLng3;
        this.e = latLng4;
        this.f = latLngBounds;
    }

    public int a() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VisibleRegion) {
            VisibleRegion visibleRegion = (VisibleRegion) obj;
            return this.b.equals(visibleRegion.b) && this.c.equals(visibleRegion.c) && this.d.equals(visibleRegion.d) && this.e.equals(visibleRegion.e) && this.f.equals(visibleRegion.f);
        }
        return false;
    }

    public int hashCode() {
        return w.a(this.b, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return w.a(this).a("nearLeft", this.b).a("nearRight", this.c).a("farLeft", this.d).a("farRight", this.e).a("latLngBounds", this.f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            di.a(this, parcel, i);
        } else {
            VisibleRegionCreator.a(this, parcel, i);
        }
    }
}
