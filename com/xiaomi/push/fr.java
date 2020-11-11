package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class fr extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ fq f4910a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fr(fq fqVar, String str) {
        super(str);
        this.f4910a = fqVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fm fmVar;
        try {
            fmVar = this.f4910a.f4909a;
            fmVar.m289a();
        } catch (Exception e) {
            this.f4910a.c(9, e);
        }
    }
}
