package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes10.dex */
public class f {
    public static volatile f ayQ;
    public String ayR = Eb();

    public static f DZ() {
        if (ayQ == null) {
            synchronized (f.class) {
                if (ayQ == null) {
                    ayQ = new f();
                }
            }
        }
        return ayQ;
    }

    @Nullable
    @WorkerThread
    public static String Eb() {
        try {
            return q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            return null;
        }
    }

    @Nullable
    @WorkerThread
    public final String Ea() {
        return this.ayR;
    }

    @WorkerThread
    public static void dV(String str) {
        try {
            q.a(new File(aw.cP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    @WorkerThread
    public final void dU(String str) {
        if (!bg.isEquals(this.ayR, str)) {
            this.ayR = str;
            dV(str);
        }
    }
}
