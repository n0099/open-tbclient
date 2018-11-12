package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a iar = null;
    private final Runnable iat = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bSc();
            for (InterfaceC0347a interfaceC0347a : a.this.ias) {
                interfaceC0347a.release();
            }
            a.this.ias.clear();
        }
    };
    private final Set<InterfaceC0347a> ias = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0347a {
        void release();
    }

    public static synchronized a bSb() {
        a aVar;
        synchronized (a.class) {
            if (iar == null) {
                iar = new a();
            }
            aVar = iar;
        }
        return aVar;
    }

    public void a(InterfaceC0347a interfaceC0347a) {
        bSc();
        if (this.ias.add(interfaceC0347a) && this.ias.size() == 1) {
            this.mUiHandler.post(this.iat);
        }
    }

    public void b(InterfaceC0347a interfaceC0347a) {
        bSc();
        this.ias.remove(interfaceC0347a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bSc() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
