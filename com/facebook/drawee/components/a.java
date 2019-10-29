package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a kcM = null;
    private final Runnable kcO = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cDO();
            for (InterfaceC0562a interfaceC0562a : a.this.kcN) {
                interfaceC0562a.release();
            }
            a.this.kcN.clear();
        }
    };
    private final Set<InterfaceC0562a> kcN = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0562a {
        void release();
    }

    public static synchronized a cDN() {
        a aVar;
        synchronized (a.class) {
            if (kcM == null) {
                kcM = new a();
            }
            aVar = kcM;
        }
        return aVar;
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        cDO();
        if (this.kcN.add(interfaceC0562a) && this.kcN.size() == 1) {
            this.mUiHandler.post(this.kcO);
        }
    }

    public void b(InterfaceC0562a interfaceC0562a) {
        cDO();
        this.kcN.remove(interfaceC0562a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cDO() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
