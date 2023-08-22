package com.xiaomi.push;
/* loaded from: classes10.dex */
public class fs extends Thread {
    public final /* synthetic */ fr a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs(fr frVar, String str) {
        super(str);
        this.a = frVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        fm fmVar;
        try {
            fmVar = this.a.a;
            fmVar.m491a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
