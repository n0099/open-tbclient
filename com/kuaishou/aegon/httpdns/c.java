package com.kuaishou.aegon.httpdns;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f8413a;

    private c(String str) {
        this.f8413a = str;
    }

    public static Runnable ZX(String str) {
        return new c(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeSetJsonConfig(this.f8413a);
    }
}
