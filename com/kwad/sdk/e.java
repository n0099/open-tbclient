package com.kwad.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.utils.aq;
import java.io.File;
/* loaded from: classes3.dex */
public class e {
    @Nullable
    public static AdDownloadProxy a(Context context, AdInstallProxy adInstallProxy, boolean z) {
        try {
            return com.kwad.sdk.core.download.a.f.a(context, aq.c(context), adInstallProxy, z && b(context));
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static AdHttpProxy a() {
        try {
            return com.kwad.sdk.core.network.kwai.b.a() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable unused) {
            return new com.kwad.sdk.core.network.b.a();
        }
    }

    public static File a(Context context) {
        File file;
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        String str2 = null;
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalCacheDir();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                file = null;
            }
            if (file != null) {
                str2 = file.getPath();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = context.getCacheDir().getPath();
        }
        return new File(str2 + File.separator + "ksadsdk");
    }

    @NonNull
    public static AdInstallProxy b() {
        return new com.kwad.sdk.core.download.c.b();
    }

    public static boolean b(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
