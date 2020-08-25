package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private static a nnb = null;
    private final Runnable nnd = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dPI();
            for (InterfaceC0866a interfaceC0866a : a.this.nnc) {
                interfaceC0866a.release();
            }
            a.this.nnc.clear();
        }
    };
    private final Set<InterfaceC0866a> nnc = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0866a {
        void release();
    }

    public static synchronized a dPH() {
        a aVar;
        synchronized (a.class) {
            if (nnb == null) {
                nnb = new a();
            }
            aVar = nnb;
        }
        return aVar;
    }

    public void a(InterfaceC0866a interfaceC0866a) {
        dPI();
        if (this.nnc.add(interfaceC0866a) && this.nnc.size() == 1) {
            this.mUiHandler.post(this.nnd);
        }
    }

    public void b(InterfaceC0866a interfaceC0866a) {
        dPI();
        this.nnc.remove(interfaceC0866a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dPI() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
