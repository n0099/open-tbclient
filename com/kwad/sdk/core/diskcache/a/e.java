package com.kwad.sdk.core.diskcache.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.kwai.a;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class e {
    public static Object a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str) {
        InputStream inputStream;
        a.c a;
        com.kwad.sdk.core.diskcache.kwai.a aVar2 = null;
        try {
            try {
                a = aVar.a(str);
            } catch (Throwable th) {
                th = th;
                aVar2 = aVar;
                d.a(aVar2);
                throw th;
            }
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a(aVar2);
            throw th;
        }
        if (a == null) {
            d.a((Closeable) null);
            return null;
        }
        inputStream = a.a(0);
        try {
            Object a2 = d.a(inputStream);
            d.a((Closeable) inputStream);
            return a2;
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.a.a(e);
            d.a((Closeable) inputStream);
            return null;
        }
    }

    public static void a(@NonNull com.kwad.sdk.core.diskcache.kwai.a aVar, @NonNull String str, @NonNull Object obj) {
        OutputStream outputStream = null;
        try {
            try {
                a.C0293a b = aVar.b(str);
                if (b != null) {
                    outputStream = b.a(0);
                    if (d.a(outputStream, obj)) {
                        b.a();
                    } else {
                        b.b();
                    }
                    aVar.b();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        } finally {
            d.a(outputStream);
        }
    }
}
