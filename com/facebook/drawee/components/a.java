package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jBx = null;
    private final Runnable jBz = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cuD();
            for (InterfaceC0336a interfaceC0336a : a.this.jBy) {
                interfaceC0336a.release();
            }
            a.this.jBy.clear();
        }
    };
    private final Set<InterfaceC0336a> jBy = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0336a {
        void release();
    }

    public static synchronized a cuC() {
        a aVar;
        synchronized (a.class) {
            if (jBx == null) {
                jBx = new a();
            }
            aVar = jBx;
        }
        return aVar;
    }

    public void a(InterfaceC0336a interfaceC0336a) {
        cuD();
        if (this.jBy.add(interfaceC0336a) && this.jBy.size() == 1) {
            this.mUiHandler.post(this.jBz);
        }
    }

    public void b(InterfaceC0336a interfaceC0336a) {
        cuD();
        this.jBy.remove(interfaceC0336a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cuD() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
