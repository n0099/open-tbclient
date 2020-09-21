package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public class a {
    private static a nxt = null;
    private final Runnable nxv = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.dTP();
            for (InterfaceC0863a interfaceC0863a : a.this.nxu) {
                interfaceC0863a.release();
            }
            a.this.nxu.clear();
        }
    };
    private final Set<InterfaceC0863a> nxu = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0863a {
        void release();
    }

    public static synchronized a dTO() {
        a aVar;
        synchronized (a.class) {
            if (nxt == null) {
                nxt = new a();
            }
            aVar = nxt;
        }
        return aVar;
    }

    public void a(InterfaceC0863a interfaceC0863a) {
        dTP();
        if (this.nxu.add(interfaceC0863a) && this.nxu.size() == 1) {
            this.mUiHandler.post(this.nxv);
        }
    }

    public void b(InterfaceC0863a interfaceC0863a) {
        dTP();
        this.nxu.remove(interfaceC0863a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dTP() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
