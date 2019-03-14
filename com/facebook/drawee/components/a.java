package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a jBI = null;
    private final Runnable jBK = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cuQ();
            for (InterfaceC0432a interfaceC0432a : a.this.jBJ) {
                interfaceC0432a.release();
            }
            a.this.jBJ.clear();
        }
    };
    private final Set<InterfaceC0432a> jBJ = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0432a {
        void release();
    }

    public static synchronized a cuP() {
        a aVar;
        synchronized (a.class) {
            if (jBI == null) {
                jBI = new a();
            }
            aVar = jBI;
        }
        return aVar;
    }

    public void a(InterfaceC0432a interfaceC0432a) {
        cuQ();
        if (this.jBJ.add(interfaceC0432a) && this.jBJ.size() == 1) {
            this.mUiHandler.post(this.jBK);
        }
    }

    public void b(InterfaceC0432a interfaceC0432a) {
        cuQ();
        this.jBJ.remove(interfaceC0432a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cuQ() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
