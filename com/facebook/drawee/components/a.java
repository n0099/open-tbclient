package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private static a pqW = null;
    private final Runnable pqY = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.erq();
            for (InterfaceC1042a interfaceC1042a : a.this.pqX) {
                interfaceC1042a.release();
            }
            a.this.pqX.clear();
        }
    };
    private final Set<InterfaceC1042a> pqX = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1042a {
        void release();
    }

    public static synchronized a erp() {
        a aVar;
        synchronized (a.class) {
            if (pqW == null) {
                pqW = new a();
            }
            aVar = pqW;
        }
        return aVar;
    }

    public void a(InterfaceC1042a interfaceC1042a) {
        erq();
        if (this.pqX.add(interfaceC1042a) && this.pqX.size() == 1) {
            this.mUiHandler.post(this.pqY);
        }
    }

    public void b(InterfaceC1042a interfaceC1042a) {
        erq();
        this.pqX.remove(interfaceC1042a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void erq() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
