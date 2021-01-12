package com.kwad.sdk.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes4.dex */
class v {

    /* renamed from: a  reason: collision with root package name */
    private boolean f10251a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10252b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes4.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((s) message.obj).d_();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(s<?> sVar) {
        if (this.f10251a) {
            this.f10252b.obtainMessage(1, sVar).sendToTarget();
        } else {
            this.f10251a = true;
            sVar.d_();
            this.f10251a = false;
        }
    }
}
