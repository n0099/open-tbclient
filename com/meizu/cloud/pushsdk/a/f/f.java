package com.meizu.cloud.pushsdk.a.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.a.e.o;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class f extends Handler {
    private final WeakReference<o> a;

    public f(o oVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(oVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        o oVar = this.a.get();
        switch (message.what) {
            case 1:
                if (oVar != null) {
                    com.meizu.cloud.pushsdk.a.g.a aVar = (com.meizu.cloud.pushsdk.a.g.a) message.obj;
                    oVar.a(aVar.a, aVar.b);
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
