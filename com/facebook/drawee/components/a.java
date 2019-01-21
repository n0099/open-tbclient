package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a ilW = null;
    private final Runnable ilY = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bVG();
            for (InterfaceC0360a interfaceC0360a : a.this.ilX) {
                interfaceC0360a.release();
            }
            a.this.ilX.clear();
        }
    };
    private final Set<InterfaceC0360a> ilX = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0360a {
        void release();
    }

    public static synchronized a bVF() {
        a aVar;
        synchronized (a.class) {
            if (ilW == null) {
                ilW = new a();
            }
            aVar = ilW;
        }
        return aVar;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        bVG();
        if (this.ilX.add(interfaceC0360a) && this.ilX.size() == 1) {
            this.mUiHandler.post(this.ilY);
        }
    }

    public void b(InterfaceC0360a interfaceC0360a) {
        bVG();
        this.ilX.remove(interfaceC0360a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bVG() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
