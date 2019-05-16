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
        synchronized (n.a(this.a)) {
            switch (message.what) {
                case 0:
                    n.a(this.a, (HashMap) message.obj);
                    break;
                case 1:
                    n.a(this.a, 0);
                    if (n.b(this.a) != null) {
                        n.b(this.a).cancel(true);
                    }
                    this.a.c();
                    break;
                case 3:
                    if (message.obj != null) {
                        String str = (String) message.obj;
                        if (n.c(this.a) != null) {
                            n.c(this.a).d(str);
                        }
                    }
                    this.a.c();
                    break;
            }
        }
    }
}
