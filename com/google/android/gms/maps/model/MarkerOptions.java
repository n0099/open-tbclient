package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.dd;
/* loaded from: classes.dex */
public final class MarkerOptions implements ae {
    public static final MarkerOptionsCreator a = new MarkerOptionsCreator();
    private final int b;
    private LatLng c;
    private String d;
    private String e;
    private BitmapDescriptor f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;

    public MarkerOptions() {
        this.g = 0.5f;
        this.h = 1.0f;
        this.j = true;
        this.b = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2) {
        this.g = 0.5f;
        this.h = 1.0f;
        this.j = true;
        this.b = i;
        this.c = latLng;
        this.d = str;
        this.e = str2;
        this.f = iBinder == null ? null : new BitmapDescriptor(bc.a.a(iBinder));
        this.g = f;
        this.h = f2;
        this.i = z;
        this.j = z2;
    }

    public int a() {
        return this.b;
    }

    public MarkerOptions a(BitmapDescriptor bitmapDescriptor) {
        this.f = bitmapDescriptor;
        return this;
    }

    public MarkerOptions a(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public MarkerOptions a(String str) {
        this.d = str;
        return this;
    }

    public IBinder b() {
        if (this.f == null) {
            return null;
        }
        return this.f.a().asBinder();
    }

    public MarkerOptions b(String str) {
        this.e = str;
        return this;
    }

    public LatLng c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public float f() {
        return this.g;
    }

    public float g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            dd.a(this, parcel, i);
        } else {
            MarkerOptionsCreator.a(this, parcel, i);
        }
    }
}
