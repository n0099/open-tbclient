package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f8030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f8030a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        switch (message.what) {
            case 1:
                com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
                atomicInteger2 = this.f8030a.f;
                if (atomicInteger2.get() == 2) {
                    this.f8030a.a(1);
                    break;
                }
                break;
            case 2:
                atomicInteger = this.f8030a.f;
                if (atomicInteger.get() == 4) {
                    this.f8030a.e();
                }
                this.f8030a.a(1);
                break;
            default:
                com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + "]");
                break;
        }
        return true;
    }
}
