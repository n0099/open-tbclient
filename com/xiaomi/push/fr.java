package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class fr extends Thread {
    final /* synthetic */ fq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr(fq fqVar, String str) {
        super(str);
        this.a = fqVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fm fmVar;
        try {
            fmVar = this.a.a;
            fmVar.m284a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
