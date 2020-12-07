package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class a {
    private static a pej = null;
    private final Runnable pel = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.era();
            for (InterfaceC0992a interfaceC0992a : a.this.pek) {
                interfaceC0992a.release();
            }
            a.this.pek.clear();
        }
    };
    private final Set<InterfaceC0992a> pek = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0992a {
        void release();
    }

    public static synchronized a eqZ() {
        a aVar;
        synchronized (a.class) {
            if (pej == null) {
                pej = new a();
            }
            aVar = pej;
        }
        return aVar;
    }

    public void a(InterfaceC0992a interfaceC0992a) {
        era();
        if (this.pek.add(interfaceC0992a) && this.pek.size() == 1) {
            this.mUiHandler.post(this.pel);
        }
    }

    public void b(InterfaceC0992a interfaceC0992a) {
        era();
        this.pek.remove(interfaceC0992a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void era() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
