package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lKT = null;
    private final Runnable lKV = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dlU();
            for (InterfaceC0658a interfaceC0658a : a.this.lKU) {
                interfaceC0658a.release();
            }
            a.this.lKU.clear();
        }
    };
    private final Set<InterfaceC0658a> lKU = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0658a {
        void release();
    }

    public static synchronized a dlT() {
        a aVar;
        synchronized (a.class) {
            if (lKT == null) {
                lKT = new a();
            }
            aVar = lKT;
        }
        return aVar;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        dlU();
        if (this.lKU.add(interfaceC0658a) && this.lKU.size() == 1) {
            this.mUiHandler.post(this.lKV);
        }
    }

    public void b(InterfaceC0658a interfaceC0658a) {
        dlU();
        this.lKU.remove(interfaceC0658a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dlU() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
