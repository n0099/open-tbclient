package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.internal.an;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class ef extends an implements ae, Moment {
    public static final eg a = new eg();
    private static final HashMap b = new HashMap();
    private final Set c;
    private final int d;
    private String e;
    private ed f;
    private String g;
    private ed h;
    private String i;

    static {
        b.put("id", an.a.d("id", 2));
        b.put("result", an.a.a("result", 4, ed.class));
        b.put("startDate", an.a.d("startDate", 5));
        b.put("target", an.a.a("target", 6, ed.class));
        b.put("type", an.a.d("type", 7));
    }

    public ef() {
        this.d = 1;
        this.c = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(Set set, int i, String str, ed edVar, String str2, ed edVar2, String str3) {
        this.c = set;
        this.d = i;
        this.e = str;
        this.f = edVar;
        this.g = str2;
        this.h = edVar2;
        this.i = str3;
    }

    @Override // com.google.android.gms.internal.an
    protected Object a(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.an
    public HashMap a() {
        return b;
    }

    @Override // com.google.android.gms.internal.an
    protected boolean a(an.a aVar) {
        return this.c.contains(Integer.valueOf(aVar.g()));
    }

    @Override // com.google.android.gms.internal.an
    protected Object b(an.a aVar) {
        switch (aVar.g()) {
            case 2:
                return this.e;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            case 4:
                return this.f;
            case 5:
                return this.g;
            case 6:
                return this.h;
            case 7:
                return this.i;
        }
    }

    @Override // com.google.android.gms.internal.an
    protected boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        eg egVar = a;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ef) {
            if (this == obj) {
                return true;
            }
            ef efVar = (ef) obj;
            for (an.a aVar : b.values()) {
                if (a(aVar)) {
                    if (efVar.a(aVar) && b(aVar).equals(efVar.b(aVar))) {
                    }
                    return false;
                } else if (efVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed h() {
        return this.f;
    }

    public int hashCode() {
        int i = 0;
        Iterator it = b.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            an.a aVar = (an.a) it.next();
            if (a(aVar)) {
                i = b(aVar).hashCode() + i2 + aVar.g();
            } else {
                i = i2;
            }
        }
    }

    public String i() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed j() {
        return this.h;
    }

    public String k() {
        return this.i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: l */
    public ef g() {
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        eg egVar = a;
        eg.a(this, parcel, i);
    }
}
