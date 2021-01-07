package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {
    private static a pvy = null;
    private final Runnable pvA = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.evk();
            for (InterfaceC1059a interfaceC1059a : a.this.pvz) {
                interfaceC1059a.release();
            }
            a.this.pvz.clear();
        }
    };
    private final Set<InterfaceC1059a> pvz = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1059a {
        void release();
    }

    public static synchronized a evj() {
        a aVar;
        synchronized (a.class) {
            if (pvy == null) {
                pvy = new a();
            }
            aVar = pvy;
        }
        return aVar;
    }

    public void a(InterfaceC1059a interfaceC1059a) {
        evk();
        if (this.pvz.add(interfaceC1059a) && this.pvz.size() == 1) {
            this.mUiHandler.post(this.pvA);
        }
    }

    public void b(InterfaceC1059a interfaceC1059a) {
        evk();
        this.pvz.remove(interfaceC1059a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void evk() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
