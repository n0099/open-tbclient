package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.g;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class a {
    private static a pel = null;
    private final Runnable pen = new Runnable() { // from class: com.facebook.drawee.components.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.erb();
            for (InterfaceC0992a interfaceC0992a : a.this.pem) {
                interfaceC0992a.release();
            }
            a.this.pem.clear();
        }
    };
    private final Set<InterfaceC0992a> pem = new HashSet();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0992a {
        void release();
    }

    public static synchronized a era() {
        a aVar;
        synchronized (a.class) {
            if (pel == null) {
                pel = new a();
            }
            aVar = pel;
        }
        return aVar;
    }

    public void a(InterfaceC0992a interfaceC0992a) {
        erb();
        if (this.pem.add(interfaceC0992a) && this.pem.size() == 1) {
            this.mUiHandler.post(this.pen);
        }
    }

    public void b(InterfaceC0992a interfaceC0992a) {
        erb();
        this.pem.remove(interfaceC0992a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void erb() {
        g.checkState(Looper.getMainLooper().getThread() == Thread.currentThread());
    }
}
