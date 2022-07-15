package com.kwad.sdk.f.kwai;
/* loaded from: classes5.dex */
public final class c implements Comparable<c> {
    public String a;
    public boolean f;
    public int g;
    public float e = -1.0f;
    public int c = 20;
    public int b = 3;
    public StringBuffer d = new StringBuffer();

    public c(String str) {
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(c cVar) {
        return (int) (this.e - cVar.e);
    }

    public final int a() {
        return this.b;
    }

    public final void a(float f) {
        this.e = f;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c() {
        return this.f;
    }

    public final float d() {
        return this.e;
    }

    public final int e() {
        return this.g;
    }

    public final String toString() {
        return "PingNetEntity{ip='" + this.a + "', pingCount=" + this.b + ", pingWaitTime=" + this.c + ", pingTime='" + this.e + " ms', success=" + this.f + '}';
    }
}
