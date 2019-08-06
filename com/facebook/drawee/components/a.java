package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a kcg = null;
    private final Runnable kci = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cGc();
            for (InterfaceC0456a interfaceC0456a : a.this.kch) {
                interfaceC0456a.release();
            }
            a.this.kch.clear();
        }
    };
    private final Set<InterfaceC0456a> kch = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0456a {
        void release();
    }

    public static synchronized a cGb() {
        a aVar;
        synchronized (a.class) {
            if (kcg == null) {
                kcg = new a();
            }
            aVar = kcg;
        }
        return aVar;
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        cGc();
        if (this.kch.add(interfaceC0456a) && this.kch.size() == 1) {
            this.mUiHandler.post(this.kci);
        }
    }

    public void b(InterfaceC0456a interfaceC0456a) {
        cGc();
        this.kch.remove(interfaceC0456a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cGc() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
