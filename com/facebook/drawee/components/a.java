package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a hYG = null;
    private final Runnable hYI = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bSH();
            for (InterfaceC0319a interfaceC0319a : a.this.hYH) {
                interfaceC0319a.release();
            }
            a.this.hYH.clear();
        }
    };
    private final Set<InterfaceC0319a> hYH = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0319a {
        void release();
    }

    public static synchronized a bSG() {
        a aVar;
        synchronized (a.class) {
            if (hYG == null) {
                hYG = new a();
            }
            aVar = hYG;
        }
        return aVar;
    }

    public void a(InterfaceC0319a interfaceC0319a) {
        bSH();
        if (this.hYH.add(interfaceC0319a) && this.hYH.size() == 1) {
            this.mUiHandler.post(this.hYI);
        }
    }

    public void b(InterfaceC0319a interfaceC0319a) {
        bSH();
        this.hYH.remove(interfaceC0319a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bSH() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
