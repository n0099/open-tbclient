package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a keE = null;
    private final Runnable keG = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cGQ();
            for (InterfaceC0467a interfaceC0467a : a.this.keF) {
                interfaceC0467a.release();
            }
            a.this.keF.clear();
        }
    };
    private final Set<InterfaceC0467a> keF = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0467a {
        void release();
    }

    public static synchronized a cGP() {
        a aVar;
        synchronized (a.class) {
            if (keE == null) {
                keE = new a();
            }
            aVar = keE;
        }
        return aVar;
    }

    public void a(InterfaceC0467a interfaceC0467a) {
        cGQ();
        if (this.keF.add(interfaceC0467a) && this.keF.size() == 1) {
            this.mUiHandler.post(this.keG);
        }
    }

    public void b(InterfaceC0467a interfaceC0467a) {
        cGQ();
        this.keF.remove(interfaceC0467a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cGQ() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
