package com.xiaomi.slim;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g extends Thread {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, String str) {
        super(str);
        this.a = fVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        c cVar;
        try {
            cVar = this.a.w;
            cVar.a();
        } catch (Exception e) {
            this.a.c(9, e);
        }
    }
}
