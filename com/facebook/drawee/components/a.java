package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a ikO = null;
    private final Runnable ikQ = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bUY();
            for (InterfaceC0361a interfaceC0361a : a.this.ikP) {
                interfaceC0361a.release();
            }
            a.this.ikP.clear();
        }
    };
    private final Set<InterfaceC0361a> ikP = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0361a {
        void release();
    }

    public static synchronized a bUX() {
        a aVar;
        synchronized (a.class) {
            if (ikO == null) {
                ikO = new a();
            }
            aVar = ikO;
        }
        return aVar;
    }

    public void a(InterfaceC0361a interfaceC0361a) {
        bUY();
        if (this.ikP.add(interfaceC0361a) && this.ikP.size() == 1) {
            this.mUiHandler.post(this.ikQ);
        }
    }

    public void b(InterfaceC0361a interfaceC0361a) {
        bUY();
        this.ikP.remove(interfaceC0361a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bUY() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
