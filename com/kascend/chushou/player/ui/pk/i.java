package com.kascend.chushou.player.ui.pk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kascend.chushou.player.ui.pk.b;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class i<T extends b> extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<T> f4212a;

    private i() {
    }

    public i(T t) {
        super(Looper.getMainLooper());
        this.f4212a = new WeakReference<>(t);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        T t;
        super.handleMessage(message);
        if (this.f4212a != null && (t = this.f4212a.get()) != null) {
            t.a(message);
        }
    }
}
