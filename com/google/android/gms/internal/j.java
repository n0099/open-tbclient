package com.google.android.gms.internal;

import android.net.Uri;
/* loaded from: classes.dex */
public abstract class j {
    protected final k a;
    protected final int b;
    private final int c;

    public j(k kVar, int i) {
        this.a = (k) x.a(kVar);
        x.a(i >= 0 && i < kVar.d());
        this.b = i;
        this.c = kVar.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long a(String str) {
        return this.a.a(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b(String str) {
        return this.a.b(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(String str) {
        return this.a.d(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(String str) {
        return this.a.c(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] e(String str) {
        return this.a.e(str, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            return w.a(Integer.valueOf(jVar.b), Integer.valueOf(this.b)) && w.a(Integer.valueOf(jVar.c), Integer.valueOf(this.c)) && jVar.a == this.a;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Uri f(String str) {
        return this.a.f(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(String str) {
        return this.a.g(str, this.b, this.c);
    }

    public int hashCode() {
        return w.a(Integer.valueOf(this.b), Integer.valueOf(this.c), this.a);
    }
}
