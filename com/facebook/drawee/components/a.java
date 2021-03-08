package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private static a pDL = null;
    private final Runnable pDN = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.eua();
            for (InterfaceC1063a interfaceC1063a : a.this.pDM) {
                interfaceC1063a.release();
            }
            a.this.pDM.clear();
        }
    };
    private final Set<InterfaceC1063a> pDM = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1063a {
        void release();
    }

    public static synchronized a etZ() {
        a aVar;
        synchronized (a.class) {
            if (pDL == null) {
                pDL = new a();
            }
            aVar = pDL;
        }
        return aVar;
    }

    public void a(InterfaceC1063a interfaceC1063a) {
        eua();
        if (this.pDM.add(interfaceC1063a) && this.pDM.size() == 1) {
            this.mUiHandler.post(this.pDN);
        }
    }

    public void b(InterfaceC1063a interfaceC1063a) {
        eua();
        this.pDM.remove(interfaceC1063a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eua() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
