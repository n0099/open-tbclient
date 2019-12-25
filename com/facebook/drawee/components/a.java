package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class a {
    private static a lGw = null;
    private final Runnable lGy = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.djB();
            for (InterfaceC0645a interfaceC0645a : a.this.lGx) {
                interfaceC0645a.release();
            }
            a.this.lGx.clear();
        }
    };
    private final Set<InterfaceC0645a> lGx = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0645a {
        void release();
    }

    public static synchronized a djA() {
        a aVar;
        synchronized (a.class) {
            if (lGw == null) {
                lGw = new a();
            }
            aVar = lGw;
        }
        return aVar;
    }

    public void a(InterfaceC0645a interfaceC0645a) {
        djB();
        if (this.lGx.add(interfaceC0645a) && this.lGx.size() == 1) {
            this.mUiHandler.post(this.lGy);
        }
    }

    public void b(InterfaceC0645a interfaceC0645a) {
        djB();
        this.lGx.remove(interfaceC0645a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void djB() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
