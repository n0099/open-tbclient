package com.google.android.gms.internal;

import com.google.android.gms.appstate.AppState;
/* loaded from: classes.dex */
public final class b implements AppState {
    private final int a;
    private final String b;
    private final byte[] c;
    private final boolean d;
    private final String e;
    private final byte[] f;

    public b(AppState appState) {
        this.a = appState.a();
        this.b = appState.b();
        this.c = appState.c();
        this.d = appState.d();
        this.e = appState.e();
        this.f = appState.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(AppState appState) {
        return w.a(Integer.valueOf(appState.a()), appState.b(), appState.c(), Boolean.valueOf(appState.d()), appState.e(), appState.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AppState appState, Object obj) {
        if (obj instanceof AppState) {
            if (appState != obj) {
                AppState appState2 = (AppState) obj;
                return w.a(Integer.valueOf(appState2.a()), Integer.valueOf(appState.a())) && w.a(appState2.b(), appState.b()) && w.a(appState2.c(), appState.c()) && w.a(Boolean.valueOf(appState2.d()), Boolean.valueOf(appState.d())) && w.a(appState2.e(), appState.e()) && w.a(appState2.f(), appState.f());
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(AppState appState) {
        return w.a(appState).a("Key", Integer.valueOf(appState.a())).a("LocalVersion", appState.b()).a("LocalData", appState.c()).a("HasConflict", Boolean.valueOf(appState.d())).a("ConflictVersion", appState.e()).a("ConflictData", appState.f()).toString();
    }

    @Override // com.google.android.gms.appstate.AppState
    public int a() {
        return this.a;
    }

    @Override // com.google.android.gms.appstate.AppState
    public String b() {
        return this.b;
    }

    @Override // com.google.android.gms.appstate.AppState
    public byte[] c() {
        return this.c;
    }

    @Override // com.google.android.gms.appstate.AppState
    public boolean d() {
        return this.d;
    }

    @Override // com.google.android.gms.appstate.AppState
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return a(this, obj);
    }

    @Override // com.google.android.gms.appstate.AppState
    public byte[] f() {
        return this.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: h */
    public AppState g() {
        return this;
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }
}
