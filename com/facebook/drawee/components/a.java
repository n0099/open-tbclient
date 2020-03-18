package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lMz = null;
    private final Runnable lMB = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dmr();
            for (InterfaceC0659a interfaceC0659a : a.this.lMA) {
                interfaceC0659a.release();
            }
            a.this.lMA.clear();
        }
    };
    private final Set<InterfaceC0659a> lMA = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0659a {
        void release();
    }

    public static synchronized a dmq() {
        a aVar;
        synchronized (a.class) {
            if (lMz == null) {
                lMz = new a();
            }
            aVar = lMz;
        }
        return aVar;
    }

    public void a(InterfaceC0659a interfaceC0659a) {
        dmr();
        if (this.lMA.add(interfaceC0659a) && this.lMA.size() == 1) {
            this.mUiHandler.post(this.lMB);
        }
    }

    public void b(InterfaceC0659a interfaceC0659a) {
        dmr();
        this.lMA.remove(interfaceC0659a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dmr() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
