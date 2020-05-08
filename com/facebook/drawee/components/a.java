package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a lTX = null;
    private final Runnable lTZ = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.doh();
            for (InterfaceC0723a interfaceC0723a : a.this.lTY) {
                interfaceC0723a.release();
            }
            a.this.lTY.clear();
        }
    };
    private final Set<InterfaceC0723a> lTY = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0723a {
        void release();
    }

    public static synchronized a dog() {
        a aVar;
        synchronized (a.class) {
            if (lTX == null) {
                lTX = new a();
            }
            aVar = lTX;
        }
        return aVar;
    }

    public void a(InterfaceC0723a interfaceC0723a) {
        doh();
        if (this.lTY.add(interfaceC0723a) && this.lTY.size() == 1) {
            this.mUiHandler.post(this.lTZ);
        }
    }

    public void b(InterfaceC0723a interfaceC0723a) {
        doh();
        this.lTY.remove(interfaceC0723a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doh() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
