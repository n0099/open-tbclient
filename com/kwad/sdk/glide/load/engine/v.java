package com.kwad.sdk.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36313a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f36314b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes7.dex */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((s) message.obj).d_();
                return true;
            }
            return false;
        }
    }

    public synchronized void a(s<?> sVar) {
        if (this.f36313a) {
            this.f36314b.obtainMessage(1, sVar).sendToTarget();
        } else {
            this.f36313a = true;
            sVar.d_();
            this.f36313a = false;
        }
    }
}
