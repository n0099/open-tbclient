package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppState;
/* loaded from: classes.dex */
public final class c extends j implements AppState {
    public c(k kVar, int i) {
        super(kVar, i);
    }

    @Override // com.google.android.gms.appstate.AppState
    public int a() {
        return b("key");
    }

    @Override // com.google.android.gms.appstate.AppState
    public String b() {
        return d("local_version");
    }

    @Override // com.google.android.gms.appstate.AppState
    public byte[] c() {
        return e("local_data");
    }

    @Override // com.google.android.gms.appstate.AppState
    public boolean d() {
        return !g("conflict_version");
    }

    @Override // com.google.android.gms.appstate.AppState
    public String e() {
        return d("conflict_version");
    }

    @Override // com.google.android.gms.internal.j
    public boolean equals(Object obj) {
        return b.a(this, obj);
    }

    @Override // com.google.android.gms.appstate.AppState
    public byte[] f() {
        return e("conflict_data");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h */
    public AppState g() {
        return new b(this);
    }

    @Override // com.google.android.gms.internal.j
    public int hashCode() {
        return b.a(this);
    }

    public String toString() {
        return b.b(this);
    }
}
