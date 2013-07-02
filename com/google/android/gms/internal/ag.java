package com.google.android.gms.internal;

import android.os.Parcel;
/* loaded from: classes.dex */
public final class ag implements ae {
    public static final ah a = new ah();
    private final int b;
    private final int c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;

    public ag(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ag) {
            ag agVar = (ag) obj;
            return this.b == agVar.b && this.c == agVar.c && this.d == agVar.d && w.a(this.e, agVar.e) && w.a(this.f, agVar.f);
        }
        return false;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public boolean h() {
        return this.c == 1 && this.d == -1;
    }

    public int hashCode() {
        return w.a(Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), this.e, this.f);
    }

    public boolean i() {
        return this.c == 2;
    }

    public String toString() {
        return i() ? String.format("Person [%s] %s", e(), f()) : h() ? String.format("Circle [%s] %s", d(), f()) : String.format("Group [%s] %s", d(), f());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ah.a(this, parcel, i);
    }
}
