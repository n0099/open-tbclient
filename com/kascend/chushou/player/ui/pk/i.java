package com.kascend.chushou.player.ui.pk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kascend.chushou.player.ui.pk.b;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class i<T extends b> extends Handler {
    private WeakReference<T> a;

    private i() {
    }

    public i(T t) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(t);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        T t;
        super.handleMessage(message);
        if (this.a != null && (t = this.a.get()) != null) {
            t.a(message);
        }
    }
}
