package com.meizu.cloud.pushsdk.networking.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meizu.cloud.pushsdk.networking.c.o;
import com.meizu.cloud.pushsdk.networking.model.Progress;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
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
                    Progress progress = (Progress) message.obj;
                    oVar.a(progress.currentBytes, progress.totalBytes);
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
