package com.kuaishou.aegon.httpdns;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final String f32261a;

    public c(String str) {
        this.f32261a = str;
    }

    public static Runnable a(String str) {
        return new c(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeSetJsonConfig(this.f32261a);
    }
}
