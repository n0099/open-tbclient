package com.kwad.sdk.core.diskcache.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public final class b {
    public static File a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str) {
        try {
            a.c cQ = aVar.cQ(str);
            if (cQ != null) {
                return cQ.cp(0);
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void a(@NonNull final com.kwad.sdk.core.diskcache.a.a aVar, @NonNull final String str, @NonNull final String str2) {
        g.execute(new Runnable() { // from class: com.kwad.sdk.core.diskcache.b.b.1
            @Override // java.lang.Runnable
            public final void run() {
                OutputStream outputStream = null;
                try {
                    a.C0701a cR = com.kwad.sdk.core.diskcache.a.a.this.cR(str2);
                    if (cR != null) {
                        outputStream = cR.cm(0);
                        if (b.a(str, outputStream, new a.C0709a())) {
                            cR.commit();
                        } else {
                            cR.abort();
                        }
                        com.kwad.sdk.core.diskcache.a.a.this.flush();
                    }
                } catch (IOException unused) {
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                }
            }
        });
    }

    public static boolean a(@NonNull com.kwad.sdk.core.diskcache.a.a aVar, @NonNull String str, @NonNull String str2, a.C0709a c0709a) {
        boolean z = false;
        OutputStream outputStream = null;
        try {
            try {
                a.C0701a cR = aVar.cR(str2);
                if (cR != null) {
                    outputStream = cR.cm(0);
                    if (a(str, outputStream, c0709a)) {
                        cR.commit();
                        z = true;
                    } else {
                        cR.abort();
                    }
                    aVar.flush();
                }
            } catch (IOException e) {
                c0709a.msg = e.getMessage();
            }
            return z;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
        }
    }

    public static boolean a(String str, OutputStream outputStream, a.C0709a c0709a) {
        return com.kwad.sdk.core.network.a.a.a(str, outputStream, c0709a, -1L, null);
    }
}
