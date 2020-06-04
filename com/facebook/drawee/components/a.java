package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a mpa = null;
    private final Runnable mpc = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dvO();
            for (InterfaceC0779a interfaceC0779a : a.this.mpb) {
                interfaceC0779a.release();
            }
            a.this.mpb.clear();
        }
    };
    private final Set<InterfaceC0779a> mpb = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0779a {
        void release();
    }

    public static synchronized a dvN() {
        a aVar;
        synchronized (a.class) {
            if (mpa == null) {
                mpa = new a();
            }
            aVar = mpa;
        }
        return aVar;
    }

    public void a(InterfaceC0779a interfaceC0779a) {
        dvO();
        if (this.mpb.add(interfaceC0779a) && this.mpb.size() == 1) {
            this.mUiHandler.post(this.mpc);
        }
    }

    public void b(InterfaceC0779a interfaceC0779a) {
        dvO();
        this.mpb.remove(interfaceC0779a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dvO() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
