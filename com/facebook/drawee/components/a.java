package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lKI = null;
    private final Runnable lKK = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dlT();
            for (InterfaceC0658a interfaceC0658a : a.this.lKJ) {
                interfaceC0658a.release();
            }
            a.this.lKJ.clear();
        }
    };
    private final Set<InterfaceC0658a> lKJ = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0658a {
        void release();
    }

    public static synchronized a dlS() {
        a aVar;
        synchronized (a.class) {
            if (lKI == null) {
                lKI = new a();
            }
            aVar = lKI;
        }
        return aVar;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        dlT();
        if (this.lKJ.add(interfaceC0658a) && this.lKJ.size() == 1) {
            this.mUiHandler.post(this.lKK);
        }
    }

    public void b(InterfaceC0658a interfaceC0658a) {
        dlT();
        this.lKJ.remove(interfaceC0658a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dlT() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
