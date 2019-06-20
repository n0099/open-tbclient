package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jTW = null;
    private final Runnable jTY = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cCG();
            for (InterfaceC0451a interfaceC0451a : a.this.jTX) {
                interfaceC0451a.release();
            }
            a.this.jTX.clear();
        }
    };
    private final Set<InterfaceC0451a> jTX = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0451a {
        void release();
    }

    public static synchronized a cCF() {
        a aVar;
        synchronized (a.class) {
            if (jTW == null) {
                jTW = new a();
            }
            aVar = jTW;
        }
        return aVar;
    }

    public void a(InterfaceC0451a interfaceC0451a) {
        cCG();
        if (this.jTX.add(interfaceC0451a) && this.jTX.size() == 1) {
            this.mUiHandler.post(this.jTY);
        }
    }

    public void b(InterfaceC0451a interfaceC0451a) {
        cCG();
        this.jTX.remove(interfaceC0451a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cCG() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
