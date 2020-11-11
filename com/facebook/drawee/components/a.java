package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a oNy = null;
    private final Runnable oNA = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.eln();
            for (InterfaceC0972a interfaceC0972a : a.this.oNz) {
                interfaceC0972a.release();
            }
            a.this.oNz.clear();
        }
    };
    private final Set<InterfaceC0972a> oNz = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0972a {
        void release();
    }

    public static synchronized a elm() {
        a aVar;
        synchronized (a.class) {
            if (oNy == null) {
                oNy = new a();
            }
            aVar = oNy;
        }
        return aVar;
    }

    public void a(InterfaceC0972a interfaceC0972a) {
        eln();
        if (this.oNz.add(interfaceC0972a) && this.oNz.size() == 1) {
            this.mUiHandler.post(this.oNA);
        }
    }

    public void b(InterfaceC0972a interfaceC0972a) {
        eln();
        this.oNz.remove(interfaceC0972a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eln() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
