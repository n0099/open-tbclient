package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes12.dex */
public class a {
    private static a lJU = null;
    private final Runnable lJW = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dkC();
            for (InterfaceC0650a interfaceC0650a : a.this.lJV) {
                interfaceC0650a.release();
            }
            a.this.lJV.clear();
        }
    };
    private final Set<InterfaceC0650a> lJV = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0650a {
        void release();
    }

    public static synchronized a dkB() {
        a aVar;
        synchronized (a.class) {
            if (lJU == null) {
                lJU = new a();
            }
            aVar = lJU;
        }
        return aVar;
    }

    public void a(InterfaceC0650a interfaceC0650a) {
        dkC();
        if (this.lJV.add(interfaceC0650a) && this.lJV.size() == 1) {
            this.mUiHandler.post(this.lJW);
        }
    }

    public void b(InterfaceC0650a interfaceC0650a) {
        dkC();
        this.lJV.remove(interfaceC0650a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dkC() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
