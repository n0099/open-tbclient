package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes10.dex */
public class b {
    public static volatile b RU = null;
    public static volatile int RV = 204800;
    public static volatile boolean RW = true;
    public static volatile boolean RX;
    public static volatile Set<c> RY = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static b qn() {
        if (RU == null) {
            synchronized (b.class) {
                if (RU == null) {
                    RU = new b();
                }
            }
        }
        return RU;
    }

    public static boolean qo() {
        return RW;
    }

    public static int qp() {
        return RV / 1024;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public final synchronized int qq() {
        int i;
        i = 0;
        try {
            for (c cVar : RY) {
                i += (int) cVar.qr();
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (RY.contains(cVar)) {
                RY.remove(cVar);
            }
        }
    }

    public static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, RV / (RY.size() + 1));
            RY.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public static void f(boolean z, int i) {
        if (i > 0) {
            RV = i * 1024;
        }
        RW = z;
    }
}
