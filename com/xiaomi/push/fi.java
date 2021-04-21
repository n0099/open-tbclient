package com.xiaomi.push;
/* loaded from: classes7.dex */
public class fi extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fh f40887a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fi(fh fhVar, String str) {
        super(str);
        this.f40887a = fhVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fc fcVar;
        try {
            fcVar = this.f40887a.f40886a;
            fcVar.m296a();
        } catch (Exception e2) {
            this.f40887a.c(9, e2);
        }
    }
}
