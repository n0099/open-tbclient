package com.vivo.push;
/* loaded from: classes7.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.b f39525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f39526b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p f39527c;

    public t(p pVar, com.vivo.push.b.b bVar, String str) {
        this.f39527c = pVar;
        this.f39525a = bVar;
        this.f39526b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39527c.a(this.f39525a);
        this.f39527c.d(this.f39526b);
    }
}
