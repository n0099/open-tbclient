package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jBQ = null;
    private final Runnable jBS = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cuN();
            for (InterfaceC0339a interfaceC0339a : a.this.jBR) {
                interfaceC0339a.release();
            }
            a.this.jBR.clear();
        }
    };
    private final Set<InterfaceC0339a> jBR = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0339a {
        void release();
    }

    public static synchronized a cuM() {
        a aVar;
        synchronized (a.class) {
            if (jBQ == null) {
                jBQ = new a();
            }
            aVar = jBQ;
        }
        return aVar;
    }

    public void a(InterfaceC0339a interfaceC0339a) {
        cuN();
        if (this.jBR.add(interfaceC0339a) && this.jBR.size() == 1) {
            this.mUiHandler.post(this.jBS);
        }
    }

    public void b(InterfaceC0339a interfaceC0339a) {
        cuN();
        this.jBR.remove(interfaceC0339a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cuN() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
