package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.internal.ae;
import com.google.android.gms.internal.cx;
import com.google.android.gms.internal.de;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PolygonOptions implements ae {
    public static final PolygonOptionsCreator a = new PolygonOptionsCreator();
    private final int b;
    private final List c;
    private final List d;
    private float e;
    private int f;
    private int g;
    private float h;
    private boolean i;
    private boolean j;

    public PolygonOptions() {
        this.e = 10.0f;
        this.f = -16777216;
        this.g = 0;
        this.h = 0.0f;
        this.i = true;
        this.j = false;
        this.b = 1;
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonOptions(int i, List list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.e = 10.0f;
        this.f = -16777216;
        this.g = 0;
        this.h = 0.0f;
        this.i = true;
        this.j = false;
        this.b = i;
        this.c = list;
        this.d = list2;
        this.e = f;
        this.f = i2;
        this.g = i3;
        this.h = f2;
        this.i = z;
        this.j = z2;
    }

    public int a() {
        return this.b;
    }

    public List b() {
        return this.d;
    }

    public List c() {
        return this.c;
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

    public boolean i() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (cx.a()) {
            de.a(this, parcel, i);
        } else {
            PolygonOptionsCreator.a(this, parcel, i);
        }
    }
}
