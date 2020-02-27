package com.xiaomi.push;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class fl extends Thread {
    final /* synthetic */ fk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fl(fk fkVar, String str) {
        super(str);
        this.a = fkVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fg fgVar;
        try {
            fgVar = this.a.a;
            fgVar.m278a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
