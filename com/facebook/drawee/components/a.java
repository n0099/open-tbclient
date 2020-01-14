package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes12.dex */
public class a {
    private static a lJZ = null;
    private final Runnable lKb = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dkE();
            for (InterfaceC0650a interfaceC0650a : a.this.lKa) {
                interfaceC0650a.release();
            }
            a.this.lKa.clear();
        }
    };
    private final Set<InterfaceC0650a> lKa = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0650a {
        void release();
    }

    public static synchronized a dkD() {
        a aVar;
        synchronized (a.class) {
            if (lJZ == null) {
                lJZ = new a();
            }
            aVar = lJZ;
        }
        return aVar;
    }

    public void a(InterfaceC0650a interfaceC0650a) {
        dkE();
        if (this.lKa.add(interfaceC0650a) && this.lKa.size() == 1) {
            this.mUiHandler.post(this.lKb);
        }
    }

    public void b(InterfaceC0650a interfaceC0650a) {
        dkE();
        this.lKa.remove(interfaceC0650a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dkE() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
