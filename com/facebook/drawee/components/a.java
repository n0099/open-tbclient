package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public class a {
    private static a ihE = null;
    private final Runnable ihG = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.bUi();
            for (InterfaceC0361a interfaceC0361a : a.this.ihF) {
                interfaceC0361a.release();
            }
            a.this.ihF.clear();
        }
    };
    private final Set<InterfaceC0361a> ihF = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0361a {
        void release();
    }

    public static synchronized a bUh() {
        a aVar;
        synchronized (a.class) {
            if (ihE == null) {
                ihE = new a();
            }
            aVar = ihE;
        }
        return aVar;
    }

    public void a(InterfaceC0361a interfaceC0361a) {
        bUi();
        if (this.ihF.add(interfaceC0361a) && this.ihF.size() == 1) {
            this.mUiHandler.post(this.ihG);
        }
    }

    public void b(InterfaceC0361a interfaceC0361a) {
        bUi();
        this.ihF.remove(interfaceC0361a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bUi() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
