package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes14.dex */
public class a {
    private static a oPc = null;
    private final Runnable oPe = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.ell();
            for (InterfaceC0975a interfaceC0975a : a.this.oPd) {
                interfaceC0975a.release();
            }
            a.this.oPd.clear();
        }
    };
    private final Set<InterfaceC0975a> oPd = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0975a {
        void release();
    }

    public static synchronized a elk() {
        a aVar;
        synchronized (a.class) {
            if (oPc == null) {
                oPc = new a();
            }
            aVar = oPc;
        }
        return aVar;
    }

    public void a(InterfaceC0975a interfaceC0975a) {
        ell();
        if (this.oPd.add(interfaceC0975a) && this.oPd.size() == 1) {
            this.mUiHandler.post(this.oPe);
        }
    }

    public void b(InterfaceC0975a interfaceC0975a) {
        ell();
        this.oPd.remove(interfaceC0975a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ell() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
