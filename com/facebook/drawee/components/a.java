package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes13.dex */
public class a {
    private static a mKZ = null;
    private final Runnable mLb = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dAr();
            for (InterfaceC0798a interfaceC0798a : a.this.mLa) {
                interfaceC0798a.release();
            }
            a.this.mLa.clear();
        }
    };
    private final Set<InterfaceC0798a> mLa = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC0798a {
        void release();
    }

    public static synchronized a dAq() {
        a aVar;
        synchronized (a.class) {
            if (mKZ == null) {
                mKZ = new a();
            }
            aVar = mKZ;
        }
        return aVar;
    }

    public void a(InterfaceC0798a interfaceC0798a) {
        dAr();
        if (this.mLa.add(interfaceC0798a) && this.mLa.size() == 1) {
            this.mUiHandler.post(this.mLb);
        }
    }

    public void b(InterfaceC0798a interfaceC0798a) {
        dAr();
        this.mLa.remove(interfaceC0798a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dAr() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
