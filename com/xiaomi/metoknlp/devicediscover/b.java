package com.xiaomi.metoknlp.devicediscover;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends Handler {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(n nVar) {
        this.a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Object obj;
        d dVar;
        d dVar2;
        k kVar;
        k kVar2;
        obj = this.a.b;
        synchronized (obj) {
            switch (message.what) {
                case 0:
                    this.a.a((HashMap) message.obj);
                    break;
                case 1:
                    this.a.d = 0;
                    kVar = this.a.g;
                    if (kVar != null) {
                        kVar2 = this.a.g;
                        kVar2.cancel(true);
                    }
                    this.a.c();
                    break;
                case 3:
                    if (message.obj != null) {
                        String str = (String) message.obj;
                        dVar = this.a.e;
                        if (dVar != null) {
                            dVar2 = this.a.e;
                            dVar2.d(str);
                        }
                    }
                    this.a.c();
                    break;
            }
        }
    }
}
