package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a mnP = null;
    private final Runnable mnR = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dvA();
            for (InterfaceC0778a interfaceC0778a : a.this.mnQ) {
                interfaceC0778a.release();
            }
            a.this.mnQ.clear();
        }
    };
    private final Set<InterfaceC0778a> mnQ = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0778a {
        void release();
    }

    public static synchronized a dvz() {
        a aVar;
        synchronized (a.class) {
            if (mnP == null) {
                mnP = new a();
            }
            aVar = mnP;
        }
        return aVar;
    }

    public void a(InterfaceC0778a interfaceC0778a) {
        dvA();
        if (this.mnQ.add(interfaceC0778a) && this.mnQ.size() == 1) {
            this.mUiHandler.post(this.mnR);
        }
    }

    public void b(InterfaceC0778a interfaceC0778a) {
        dvA();
        this.mnQ.remove(interfaceC0778a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dvA() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
