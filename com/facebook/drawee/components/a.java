package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a hYH = null;
    private final Runnable hYJ = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bSH();
            for (InterfaceC0319a interfaceC0319a : a.this.hYI) {
                interfaceC0319a.release();
            }
            a.this.hYI.clear();
        }
    };
    private final Set<InterfaceC0319a> hYI = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0319a {
        void release();
    }

    public static synchronized a bSG() {
        a aVar;
        synchronized (a.class) {
            if (hYH == null) {
                hYH = new a();
            }
            aVar = hYH;
        }
        return aVar;
    }

    public void a(InterfaceC0319a interfaceC0319a) {
        bSH();
        if (this.hYI.add(interfaceC0319a) && this.hYI.size() == 1) {
            this.mUiHandler.post(this.hYJ);
        }
    }

    public void b(InterfaceC0319a interfaceC0319a) {
        bSH();
        this.hYI.remove(interfaceC0319a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bSH() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
