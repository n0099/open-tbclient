package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    private static a mTl = null;
    private final Runnable mTn = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dDI();
            for (InterfaceC0808a interfaceC0808a : a.this.mTm) {
                interfaceC0808a.release();
            }
            a.this.mTm.clear();
        }
    };
    private final Set<InterfaceC0808a> mTm = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0808a {
        void release();
    }

    public static synchronized a dDH() {
        a aVar;
        synchronized (a.class) {
            if (mTl == null) {
                mTl = new a();
            }
            aVar = mTl;
        }
        return aVar;
    }

    public void a(InterfaceC0808a interfaceC0808a) {
        dDI();
        if (this.mTm.add(interfaceC0808a) && this.mTm.size() == 1) {
            this.mUiHandler.post(this.mTn);
        }
    }

    public void b(InterfaceC0808a interfaceC0808a) {
        dDI();
        this.mTm.remove(interfaceC0808a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dDI() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
