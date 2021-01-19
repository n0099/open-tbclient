package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class c implements Runnable {
    private /* synthetic */ a qcb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.qcb = aVar;
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
            context = this.qcb.f14334b;
            if (context == null) {
                bVar3 = this.qcb.qbt;
                bVar3.a(-3, "parameter error");
                return;
            }
            i = a.c;
            if (i == -1) {
                context3 = this.qcb.f14334b;
                if (context3.getPackageName().equals(com.yxcorp.kuaishou.addfp.android.b.e.a(Process.myPid()))) {
                    int unused = a.c = 1;
                } else {
                    int unused2 = a.c = 0;
                }
            }
            i2 = a.c;
            if (i2 == 0) {
                bVar2 = this.qcb.qbt;
                bVar2.a(-4, "need main process");
                return;
            }
            a aVar = this.qcb;
            context2 = this.qcb.f14334b;
            aVar.d = context2.getPackageName();
            com.yxcorp.kuaishou.addfp.android.a.a eHl = com.yxcorp.kuaishou.addfp.android.a.a.eHl();
            str = this.qcb.d;
            eHl.a(str);
            a aVar2 = this.qcb;
            bVar = this.qcb.qbt;
            aVar2.a(bVar);
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }
}
