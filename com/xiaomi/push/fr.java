package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class fr extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fq f14325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr(fq fqVar, String str) {
        super(str);
        this.f14325a = fqVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fm fmVar;
        try {
            fmVar = this.f14325a.f14324a;
            fmVar.m308a();
        } catch (Exception e) {
            this.f14325a.c(9, e);
        }
    }
}
