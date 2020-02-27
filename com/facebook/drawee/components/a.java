package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lKG = null;
    private final Runnable lKI = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dlR();
            for (InterfaceC0658a interfaceC0658a : a.this.lKH) {
                interfaceC0658a.release();
            }
            a.this.lKH.clear();
        }
    };
    private final Set<InterfaceC0658a> lKH = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0658a {
        void release();
    }

    public static synchronized a dlQ() {
        a aVar;
        synchronized (a.class) {
            if (lKG == null) {
                lKG = new a();
            }
            aVar = lKG;
        }
        return aVar;
    }

    public void a(InterfaceC0658a interfaceC0658a) {
        dlR();
        if (this.lKH.add(interfaceC0658a) && this.lKH.size() == 1) {
            this.mUiHandler.post(this.lKI);
        }
    }

    public void b(InterfaceC0658a interfaceC0658a) {
        dlR();
        this.lKH.remove(interfaceC0658a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dlR() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
