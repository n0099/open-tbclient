package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c implements Runnable {
    private /* synthetic */ a qnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.qnh = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        int i;
        int i2;
        Context context2;
        String str;
        b bVar;
        b bVar2;
        Context context3;
        b bVar3;
        try {
            context = this.qnh.b;
            if (context == null) {
                bVar3 = this.qnh.qmy;
                bVar3.a(-3, "parameter error");
                return;
            }
            i = a.c;
            if (i == -1) {
                context3 = this.qnh.b;
                if (context3.getPackageName().equals(com.yxcorp.kuaishou.addfp.android.b.e.a(Process.myPid()))) {
                    int unused = a.c = 1;
                } else {
                    int unused2 = a.c = 0;
                }
            }
            i2 = a.c;
            if (i2 == 0) {
                bVar2 = this.qnh.qmy;
                bVar2.a(-4, "need main process");
                return;
            }
            a aVar = this.qnh;
            context2 = this.qnh.b;
            aVar.d = context2.getPackageName();
            com.yxcorp.kuaishou.addfp.android.a.a eJr = com.yxcorp.kuaishou.addfp.android.a.a.eJr();
            str = this.qnh.d;
            eJr.a(str);
            a aVar2 = this.qnh;
            bVar = this.qnh.qmy;
            aVar2.a(bVar);
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }
}
