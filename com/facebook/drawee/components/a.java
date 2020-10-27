package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a {
    private static a oEf = null;
    private final Runnable oEh = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.ehy();
            for (InterfaceC0953a interfaceC0953a : a.this.oEg) {
                interfaceC0953a.release();
            }
            a.this.oEg.clear();
        }
    };
    private final Set<InterfaceC0953a> oEg = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0953a {
        void release();
    }

    public static synchronized a ehx() {
        a aVar;
        synchronized (a.class) {
            if (oEf == null) {
                oEf = new a();
            }
            aVar = oEf;
        }
        return aVar;
    }

    public void a(InterfaceC0953a interfaceC0953a) {
        ehy();
        if (this.oEg.add(interfaceC0953a) && this.oEg.size() == 1) {
            this.mUiHandler.post(this.oEh);
        }
    }

    public void b(InterfaceC0953a interfaceC0953a) {
        ehy();
        this.oEg.remove(interfaceC0953a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ehy() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
