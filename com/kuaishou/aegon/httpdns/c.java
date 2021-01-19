package com.kuaishou.aegon.httpdns;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f8114a;

    private c(String str) {
        this.f8114a = str;
    }

    public static Runnable YR(String str) {
        return new c(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.nativeSetJsonConfig(this.f8114a);
    }
}
