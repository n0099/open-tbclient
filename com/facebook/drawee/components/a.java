package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a pBG = null;
    private final Runnable pBI = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.etR();
            for (InterfaceC1048a interfaceC1048a : a.this.pBH) {
                interfaceC1048a.release();
            }
            a.this.pBH.clear();
        }
    };
    private final Set<InterfaceC1048a> pBH = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC1048a {
        void release();
    }

    public static synchronized a etQ() {
        a aVar;
        synchronized (a.class) {
            if (pBG == null) {
                pBG = new a();
            }
            aVar = pBG;
        }
        return aVar;
    }

    public void a(InterfaceC1048a interfaceC1048a) {
        etR();
        if (this.pBH.add(interfaceC1048a) && this.pBH.size() == 1) {
            this.mUiHandler.post(this.pBI);
        }
    }

    public void b(InterfaceC1048a interfaceC1048a) {
        etR();
        this.pBH.remove(interfaceC1048a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void etR() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
