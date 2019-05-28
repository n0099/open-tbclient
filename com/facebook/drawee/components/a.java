package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jTT = null;
    private final Runnable jTV = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cCH();
            for (InterfaceC0451a interfaceC0451a : a.this.jTU) {
                interfaceC0451a.release();
            }
            a.this.jTU.clear();
        }
    };
    private final Set<InterfaceC0451a> jTU = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0451a {
        void release();
    }

    public static synchronized a cCG() {
        a aVar;
        synchronized (a.class) {
            if (jTT == null) {
                jTT = new a();
            }
            aVar = jTT;
        }
        return aVar;
    }

    public void a(InterfaceC0451a interfaceC0451a) {
        cCH();
        if (this.jTU.add(interfaceC0451a) && this.jTU.size() == 1) {
            this.mUiHandler.post(this.jTV);
        }
    }

    public void b(InterfaceC0451a interfaceC0451a) {
        cCH();
        this.jTU.remove(interfaceC0451a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cCH() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
