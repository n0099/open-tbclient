package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class fr extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fq f14026a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr(fq fqVar, String str) {
        super(str);
        this.f14026a = fqVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fm fmVar;
        try {
            fmVar = this.f14026a.f14025a;
            fmVar.m315a();
        } catch (Exception e) {
            this.f14026a.c(9, e);
        }
    }
}
