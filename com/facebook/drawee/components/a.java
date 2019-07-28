package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a kba = null;
    private final Runnable kbc = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cFH();
            for (InterfaceC0456a interfaceC0456a : a.this.kbb) {
                interfaceC0456a.release();
            }
            a.this.kbb.clear();
        }
    };
    private final Set<InterfaceC0456a> kbb = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0456a {
        void release();
    }

    public static synchronized a cFG() {
        a aVar;
        synchronized (a.class) {
            if (kba == null) {
                kba = new a();
            }
            aVar = kba;
        }
        return aVar;
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        cFH();
        if (this.kbb.add(interfaceC0456a) && this.kbb.size() == 1) {
            this.mUiHandler.post(this.kbc);
        }
    }

    public void b(InterfaceC0456a interfaceC0456a) {
        cFH();
        this.kbb.remove(interfaceC0456a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cFH() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
