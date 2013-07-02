package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.df;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PolylineOptions implements ae {
    public static final PolylineOptionsCreator a = new PolylineOptionsCreator();
    private final int b;
    private final List c;
    private float d;
    private int e;
    private float f;
    private boolean g;
    private boolean h;

    public PolylineOptions() {
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0.0f;
        this.g = true;
        this.h = false;
        this.b = 1;
        this.c = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.d = 10.0f;
        this.e = -16777216;
        this.f = 0.0f;
        this.g = true;
        this.h = false;
        this.b = i;
        this.c = list;
        this.d = f;
        this.e = i2;
        this.f = f2;
        this.g = z;
        this.h = z2;
    }

    public int a() {
        return this.b;
    }

    public List b() {
        return this.c;
    }

    public float c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            df.a(this, parcel, i);
        } else {
            PolylineOptionsCreator.a(this, parcel, i);
        }
    }
}
