package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f36567a;

    public c(b bVar) {
        this.f36567a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i2 = message.what;
        if (i2 == 1) {
            com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.f36567a.f36520f;
            if (atomicInteger.get() == 2) {
                this.f36567a.a(1);
            }
        } else if (i2 == 2) {
            atomicInteger2 = this.f36567a.f36520f;
            if (atomicInteger2.get() == 4) {
                this.f36567a.e();
            }
            this.f36567a.a(1);
        } else {
            com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + "]");
        }
        return true;
    }
}
