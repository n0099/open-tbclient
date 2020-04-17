package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lTT = null;
    private final Runnable lTV = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dok();
            for (InterfaceC0702a interfaceC0702a : a.this.lTU) {
                interfaceC0702a.release();
            }
            a.this.lTU.clear();
        }
    };
    private final Set<InterfaceC0702a> lTU = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0702a {
        void release();
    }

    public static synchronized a doj() {
        a aVar;
        synchronized (a.class) {
            if (lTT == null) {
                lTT = new a();
            }
            aVar = lTT;
        }
        return aVar;
    }

    public void a(InterfaceC0702a interfaceC0702a) {
        dok();
        if (this.lTU.add(interfaceC0702a) && this.lTU.size() == 1) {
            this.mUiHandler.post(this.lTV);
        }
    }

    public void b(InterfaceC0702a interfaceC0702a) {
        dok();
        this.lTU.remove(interfaceC0702a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dok() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
