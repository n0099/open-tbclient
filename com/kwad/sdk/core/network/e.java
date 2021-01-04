package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.KsAdSDK;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f9619a = null;

    private e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f9619a == null) {
                f9619a = new e();
            }
            eVar = f9619a;
        }
        return eVar;
    }

    @WorkerThread
    private void b(String str) {
        try {
            com.kwad.sdk.utils.k.a(new File(d()), str, Charset.forName("UTF-8"), false);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    @Nullable
    @WorkerThread
    private String c() {
        try {
            return com.kwad.sdk.utils.k.a(new File(d()), Charset.forName("UTF-8"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
            return null;
        }
    }

    private String d() {
        return com.kwad.sdk.e.a(KsAdSDK.getContext()).getPath() + "/cookie";
    }

    @WorkerThread
    public void a(String str) {
        String c = c();
        if (c == null || !c.equals(str)) {
            com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper saveCookieString newCookieString=" + str);
            b(str);
        }
    }

    @Nullable
    @WorkerThread
    public String b() {
        String c = c();
        com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper getCookieString cookieString=" + c);
        return c;
    }
}
