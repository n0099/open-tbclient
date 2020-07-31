package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private static a mTi = null;
    private final Runnable mTl = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dDH();
            for (InterfaceC0808a interfaceC0808a : a.this.mTk) {
                interfaceC0808a.release();
            }
            a.this.mTk.clear();
        }
    };
    private final Set<InterfaceC0808a> mTk = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0808a {
        void release();
    }

    public static synchronized a dDG() {
        a aVar;
        synchronized (a.class) {
            if (mTi == null) {
                mTi = new a();
            }
            aVar = mTi;
        }
        return aVar;
    }

    public void a(InterfaceC0808a interfaceC0808a) {
        dDH();
        if (this.mTk.add(interfaceC0808a) && this.mTk.size() == 1) {
            this.mUiHandler.post(this.mTl);
        }
    }

    public void b(InterfaceC0808a interfaceC0808a) {
        dDH();
        this.mTk.remove(interfaceC0808a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dDH() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
