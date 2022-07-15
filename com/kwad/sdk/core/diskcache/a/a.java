package com.kwad.sdk.core.diskcache.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.utils.aj;
import java.io.File;
import java.io.IOException;
/* loaded from: classes5.dex */
public class a {
    public static a a;
    public com.kwad.sdk.core.diskcache.kwai.a b;
    public Context c;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private boolean c() {
        return this.b == null;
    }

    @Nullable
    private File d(String str) {
        if (c() || TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a(this.b, str);
    }

    @SuppressLint({"MissingPermission"})
    public final void a(b bVar) {
        if (this.b != null) {
            return;
        }
        try {
            this.c = bVar.a;
            if (!bVar.d.exists()) {
                bVar.d.mkdirs();
            }
            this.b = com.kwad.sdk.core.diskcache.kwai.a.a(bVar.d, bVar.b, 1, bVar.c * 1024 * 1024);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        if (c() || TextUtils.isEmpty(str)) {
            return;
        }
        c.a(this.b, str, d.a(str));
    }

    public final boolean a(String str, c.a aVar) {
        File d;
        if (!c() && !TextUtils.isEmpty(str)) {
            String a2 = d.a(str);
            if (c.a(this.b, str, a2, aVar) && (d = d(a2)) != null && d.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(String str, @NonNull String str2, c.a aVar) {
        File d;
        if (!c() && !TextUtils.isEmpty(str)) {
            String a2 = d.a(str2);
            if (c.a(this.b, str, a2, aVar) && (d = d(a2)) != null && d.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File b(String str) {
        if (c() || TextUtils.isEmpty(str)) {
            return null;
        }
        return d(d.a(str));
    }

    public final void b() {
        if (c()) {
            return;
        }
        try {
            this.b.e();
        } catch (IOException unused) {
        }
    }

    public final boolean c(String str) {
        if (c()) {
            return false;
        }
        try {
            aj.a(str, "cacheKey is not allowed empty");
            return this.b.c(d.a(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
