package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private static a nnt = null;
    private final Runnable nnv = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dPR();
            for (InterfaceC0866a interfaceC0866a : a.this.nnu) {
                interfaceC0866a.release();
            }
            a.this.nnu.clear();
        }
    };
    private final Set<InterfaceC0866a> nnu = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0866a {
        void release();
    }

    public static synchronized a dPQ() {
        a aVar;
        synchronized (a.class) {
            if (nnt == null) {
                nnt = new a();
            }
            aVar = nnt;
        }
        return aVar;
    }

    public void a(InterfaceC0866a interfaceC0866a) {
        dPR();
        if (this.nnu.add(interfaceC0866a) && this.nnu.size() == 1) {
            this.mUiHandler.post(this.nnv);
        }
    }

    public void b(InterfaceC0866a interfaceC0866a) {
        dPR();
        this.nnu.remove(interfaceC0866a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dPR() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
