package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jTS = null;
    private final Runnable jTU = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cCF();
            for (InterfaceC0451a interfaceC0451a : a.this.jTT) {
                interfaceC0451a.release();
            }
            a.this.jTT.clear();
        }
    };
    private final Set<InterfaceC0451a> jTT = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0451a {
        void release();
    }

    public static synchronized a cCE() {
        a aVar;
        synchronized (a.class) {
            if (jTS == null) {
                jTS = new a();
            }
            aVar = jTS;
        }
        return aVar;
    }

    public void a(InterfaceC0451a interfaceC0451a) {
        cCF();
        if (this.jTT.add(interfaceC0451a) && this.jTT.size() == 1) {
            this.mUiHandler.post(this.jTU);
        }
    }

    public void b(InterfaceC0451a interfaceC0451a) {
        cCF();
        this.jTT.remove(interfaceC0451a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cCF() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
