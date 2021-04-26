package com.kwad.sdk.core.network;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.api.KsAdSDK;
import java.io.File;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f33221a;

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f33221a == null) {
                f33221a = new e();
            }
            eVar = f33221a;
        }
        return eVar;
    }

    @WorkerThread
    private void b(String str) {
        try {
            com.kwad.sdk.utils.l.a(new File(d()), str, Charset.forName("UTF-8"), false);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Nullable
    @WorkerThread
    private String c() {
        try {
            return com.kwad.sdk.utils.l.a(new File(d()), Charset.forName("UTF-8"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
            return null;
        }
    }

    private String d() {
        return com.kwad.sdk.e.a(KsAdSDK.getContext()).getPath() + "/cookie";
    }

    @WorkerThread
    public void a(String str) {
        String c2 = c();
        if (c2 == null || !c2.equals(str)) {
            com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper saveCookieString newCookieString=" + str);
            b(str);
        }
    }

    @Nullable
    @WorkerThread
    public String b() {
        String c2 = c();
        com.kwad.sdk.core.d.a.a("CookieStrHelper", "CookieStrHelper getCookieString cookieString=" + c2);
        return c2;
    }
}
