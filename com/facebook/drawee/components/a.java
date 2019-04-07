package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jBc = null;
    private final Runnable jBe = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cuJ();
            for (InterfaceC0432a interfaceC0432a : a.this.jBd) {
                interfaceC0432a.release();
            }
            a.this.jBd.clear();
        }
    };
    private final Set<InterfaceC0432a> jBd = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0432a {
        void release();
    }

    public static synchronized a cuI() {
        a aVar;
        synchronized (a.class) {
            if (jBc == null) {
                jBc = new a();
            }
            aVar = jBc;
        }
        return aVar;
    }

    public void a(InterfaceC0432a interfaceC0432a) {
        cuJ();
        if (this.jBd.add(interfaceC0432a) && this.jBd.size() == 1) {
            this.mUiHandler.post(this.jBe);
        }
    }

    public void b(InterfaceC0432a interfaceC0432a) {
        cuJ();
        this.jBd.remove(interfaceC0432a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cuJ() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
