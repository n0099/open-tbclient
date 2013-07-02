package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.cz;
/* loaded from: classes.dex */
public final class CircleOptions implements ae {
    public static final CircleOptionsCreator a = new CircleOptionsCreator();
    private final int b;
    private LatLng c;
    private double d;
    private float e;
    private int f;
    private int g;
    private float h;
    private boolean i;

    public CircleOptions() {
        this.c = null;
        this.d = 0.0d;
        this.e = 10.0f;
        this.f = -16777216;
        this.g = 0;
        this.h = 0.0f;
        this.i = true;
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.c = null;
        this.d = 0.0d;
        this.e = 10.0f;
        this.f = -16777216;
        this.g = 0;
        this.h = 0.0f;
        this.i = true;
        this.b = i;
        this.c = latLng;
        this.d = d;
        this.e = f;
        this.f = i2;
        this.g = i3;
        this.h = f2;
        this.i = z;
    }

    public int a() {
        return this.b;
    }

    public LatLng b() {
        return this.c;
    }

    public double c() {
        return this.d;
    }

    public float d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public float g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            cz.a(this, parcel, i);
        } else {
            CircleOptionsCreator.a(this, parcel, i);
        }
    }
}
