package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a ilV = null;
    private final Runnable ilX = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bVG();
            for (InterfaceC0360a interfaceC0360a : a.this.ilW) {
                interfaceC0360a.release();
            }
            a.this.ilW.clear();
        }
    };
    private final Set<InterfaceC0360a> ilW = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0360a {
        void release();
    }

    public static synchronized a bVF() {
        a aVar;
        synchronized (a.class) {
            if (ilV == null) {
                ilV = new a();
            }
            aVar = ilV;
        }
        return aVar;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        bVG();
        if (this.ilW.add(interfaceC0360a) && this.ilW.size() == 1) {
            this.mUiHandler.post(this.ilX);
        }
    }

    public void b(InterfaceC0360a interfaceC0360a) {
        bVG();
        this.ilW.remove(interfaceC0360a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bVG() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
