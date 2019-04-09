package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jBd = null;
    private final Runnable jBf = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cuJ();
            for (InterfaceC0432a interfaceC0432a : a.this.jBe) {
                interfaceC0432a.release();
            }
            a.this.jBe.clear();
        }
    };
    private final Set<InterfaceC0432a> jBe = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0432a {
        void release();
    }

    public static synchronized a cuI() {
        a aVar;
        synchronized (a.class) {
            if (jBd == null) {
                jBd = new a();
            }
            aVar = jBd;
        }
        return aVar;
    }

    public void a(InterfaceC0432a interfaceC0432a) {
        cuJ();
        if (this.jBe.add(interfaceC0432a) && this.jBe.size() == 1) {
            this.mUiHandler.post(this.jBf);
        }
    }

    public void b(InterfaceC0432a interfaceC0432a) {
        cuJ();
        this.jBe.remove(interfaceC0432a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cuJ() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
