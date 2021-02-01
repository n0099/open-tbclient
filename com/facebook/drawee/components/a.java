package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a pBg = null;
    private final Runnable pBi = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.etJ();
            for (InterfaceC1046a interfaceC1046a : a.this.pBh) {
                interfaceC1046a.release();
            }
            a.this.pBh.clear();
        }
    };
    private final Set<InterfaceC1046a> pBh = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1046a {
        void release();
    }

    public static synchronized a etI() {
        a aVar;
        synchronized (a.class) {
            if (pBg == null) {
                pBg = new a();
            }
            aVar = pBg;
        }
        return aVar;
    }

    public void a(InterfaceC1046a interfaceC1046a) {
        etJ();
        if (this.pBh.add(interfaceC1046a) && this.pBh.size() == 1) {
            this.mUiHandler.post(this.pBi);
        }
    }

    public void b(InterfaceC1046a interfaceC1046a) {
        etJ();
        this.pBh.remove(interfaceC1046a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void etJ() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
