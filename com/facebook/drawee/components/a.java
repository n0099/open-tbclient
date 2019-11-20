package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a kbV = null;
    private final Runnable kbX = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.cDM();
            for (InterfaceC0562a interfaceC0562a : a.this.kbW) {
                interfaceC0562a.release();
            }
            a.this.kbW.clear();
        }
    };
    private final Set<InterfaceC0562a> kbW = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0562a {
        void release();
    }

    public static synchronized a cDL() {
        a aVar;
        synchronized (a.class) {
            if (kbV == null) {
                kbV = new a();
            }
            aVar = kbV;
        }
        return aVar;
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        cDM();
        if (this.kbW.add(interfaceC0562a) && this.kbW.size() == 1) {
            this.mUiHandler.post(this.kbX);
        }
    }

    public void b(InterfaceC0562a interfaceC0562a) {
        cDM();
        this.kbW.remove(interfaceC0562a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cDM() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
