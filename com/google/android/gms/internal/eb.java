package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class eb implements ae {
    public static final ec a = new ec();
    private final int b;
    private final String c;
    private final ArrayList d;
    private final ArrayList e;
    private final boolean f;

    public eb(int i, String str, ArrayList arrayList, ArrayList arrayList2, boolean z) {
        this.b = i;
        this.c = str;
        this.d = arrayList;
        this.e = arrayList2;
        this.f = z;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public ArrayList c() {
        return this.d;
    }

    public ArrayList d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ec.a(this, parcel, i);
    }
}
