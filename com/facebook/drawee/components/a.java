package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a nMM = null;
    private final Runnable nMO = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dXA();
            for (InterfaceC0881a interfaceC0881a : a.this.nMN) {
                interfaceC0881a.release();
            }
            a.this.nMN.clear();
        }
    };
    private final Set<InterfaceC0881a> nMN = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0881a {
        void release();
    }

    public static synchronized a dXz() {
        a aVar;
        synchronized (a.class) {
            if (nMM == null) {
                nMM = new a();
            }
            aVar = nMM;
        }
        return aVar;
    }

    public void a(InterfaceC0881a interfaceC0881a) {
        dXA();
        if (this.nMN.add(interfaceC0881a) && this.nMN.size() == 1) {
            this.mUiHandler.post(this.nMO);
        }
    }

    public void b(InterfaceC0881a interfaceC0881a) {
        dXA();
        this.nMN.remove(interfaceC0881a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dXA() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
