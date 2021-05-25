package com.xiaomi.push;
/* loaded from: classes7.dex */
public class fi extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fh f37583a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(fh fhVar, String str) {
        super(str);
        this.f37583a = fhVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fc fcVar;
        try {
            fcVar = this.f37583a.f37582a;
            fcVar.m298a();
        } catch (Exception e2) {
            this.f37583a.c(9, e2);
        }
    }
}
