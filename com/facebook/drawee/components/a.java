package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a mLc = null;
    private final Runnable mLe = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dAv();
            for (InterfaceC0799a interfaceC0799a : a.this.mLd) {
                interfaceC0799a.release();
            }
            a.this.mLd.clear();
        }
    };
    private final Set<InterfaceC0799a> mLd = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0799a {
        void release();
    }

    public static synchronized a dAu() {
        a aVar;
        synchronized (a.class) {
            if (mLc == null) {
                mLc = new a();
            }
            aVar = mLc;
        }
        return aVar;
    }

    public void a(InterfaceC0799a interfaceC0799a) {
        dAv();
        if (this.mLd.add(interfaceC0799a) && this.mLd.size() == 1) {
            this.mUiHandler.post(this.mLe);
        }
    }

    public void b(InterfaceC0799a interfaceC0799a) {
        dAv();
        this.mLd.remove(interfaceC0799a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dAv() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
