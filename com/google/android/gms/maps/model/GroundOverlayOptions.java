package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.da;
/* loaded from: classes.dex */
public final class GroundOverlayOptions implements ae {
    public static final GroundOverlayOptionsCreator a = new GroundOverlayOptionsCreator();
    private final int b;
    private BitmapDescriptor c;
    private LatLng d;
    private float e;
    private float f;
    private LatLngBounds g;
    private float h;
    private float i;
    private boolean j;
    private float k;
    private float l;
    private float m;

    public GroundOverlayOptions() {
        this.j = true;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.5f;
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.j = true;
        this.k = 0.0f;
        this.l = 0.5f;
        this.m = 0.5f;
        this.b = i;
        this.c = new BitmapDescriptor(bc.a.a(iBinder));
        this.d = latLng;
        this.e = f;
        this.f = f2;
        this.g = latLngBounds;
        this.h = f3;
        this.i = f4;
        this.j = z;
        this.k = f5;
        this.l = f6;
        this.m = f7;
    }

    public IBinder a() {
        return this.c.a().asBinder();
    }

    public int b() {
        return this.b;
    }

    public LatLng c() {
        return this.d;
    }

    public float d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.f;
    }

    public LatLngBounds f() {
        return this.g;
    }

    public float g() {
        return this.h;
    }

    public float h() {
        return this.i;
    }

    public float i() {
        return this.k;
    }

    public float j() {
        return this.l;
    }

    public float k() {
        return this.m;
    }

    public boolean l() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            da.a(this, parcel, i);
        } else {
            GroundOverlayOptionsCreator.a(this, parcel, i);
        }
    }
}
