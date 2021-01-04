package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a pvr = null;
    private final Runnable pvt = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.evd();
            for (InterfaceC1021a interfaceC1021a : a.this.pvs) {
                interfaceC1021a.release();
            }
            a.this.pvs.clear();
        }
    };
    private final Set<InterfaceC1021a> pvs = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1021a {
        void release();
    }

    public static synchronized a evc() {
        a aVar;
        synchronized (a.class) {
            if (pvr == null) {
                pvr = new a();
            }
            aVar = pvr;
        }
        return aVar;
    }

    public void a(InterfaceC1021a interfaceC1021a) {
        evd();
        if (this.pvs.add(interfaceC1021a) && this.pvs.size() == 1) {
            this.mUiHandler.post(this.pvt);
        }
    }

    public void b(InterfaceC1021a interfaceC1021a) {
        evd();
        this.pvs.remove(interfaceC1021a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void evd() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
