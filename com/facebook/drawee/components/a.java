package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a {
    private static a pqX = null;
    private final Runnable pqZ = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.erq();
            for (InterfaceC1042a interfaceC1042a : a.this.pqY) {
                interfaceC1042a.release();
            }
            a.this.pqY.clear();
        }
    };
    private final Set<InterfaceC1042a> pqY = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1042a {
        void release();
    }

    public static synchronized a erp() {
        a aVar;
        synchronized (a.class) {
            if (pqX == null) {
                pqX = new a();
            }
            aVar = pqX;
        }
        return aVar;
    }

    public void a(InterfaceC1042a interfaceC1042a) {
        erq();
        if (this.pqY.add(interfaceC1042a) && this.pqY.size() == 1) {
            this.mUiHandler.post(this.pqZ);
        }
    }

    public void b(InterfaceC1042a interfaceC1042a) {
        erq();
        this.pqY.remove(interfaceC1042a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void erq() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
