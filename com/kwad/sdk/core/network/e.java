package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.at;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public class e {
    public static volatile e a;
    public String b = c();

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    @WorkerThread
    public static void b(String str) {
        try {
            com.kwad.sdk.utils.o.a(new File(ap.e(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
        }
    }

    @Nullable
    @WorkerThread
    public static String c() {
        try {
            return com.kwad.sdk.utils.o.a(new File(ap.e(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a())), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.b(e);
            return null;
        }
    }

    @WorkerThread
    public final void a(String str) {
        if (at.a(this.b, str)) {
            return;
        }
        this.b = str;
        b(str);
    }

    @Nullable
    @WorkerThread
    public final String b() {
        return this.b;
    }
}
