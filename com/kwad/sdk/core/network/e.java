package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public class e {
    public static volatile e XW;
    public String XX = tA();

    @WorkerThread
    public static void bV(String str) {
        try {
            com.kwad.sdk.utils.o.a(new File(as.dc(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    @Nullable
    @WorkerThread
    public static String tA() {
        try {
            return com.kwad.sdk.utils.o.a(new File(as.dc(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            return null;
        }
    }

    public static e ty() {
        if (XW == null) {
            synchronized (e.class) {
                if (XW == null) {
                    XW = new e();
                }
            }
        }
        return XW;
    }

    @WorkerThread
    public final void bU(String str) {
        if (ax.V(this.XX, str)) {
            return;
        }
        this.XX = str;
        bV(str);
    }

    @Nullable
    @WorkerThread
    public final String tz() {
        return this.XX;
    }
}
