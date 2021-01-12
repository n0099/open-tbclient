package com.kwad.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.utils.ad;
import java.io.File;
/* loaded from: classes4.dex */
public class e {
    @Nullable
    public static AdDownloadProxy a(Context context, AdInstallProxy adInstallProxy, boolean z) {
        try {
            return com.kwad.sdk.core.download.b.e.a(context, ad.c(context), adInstallProxy, z);
        } catch (Throwable th) {
            return null;
        }
    }

    @NonNull
    public static AdHttpProxy a() {
        try {
            return com.kwad.sdk.core.network.a.b.a() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable th) {
            return new com.kwad.sdk.core.network.b.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Context context) {
        String str;
        File file;
        String path;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
            try {
                file = context.getExternalCacheDir();
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a(e3);
                file = null;
            }
            if (file != null) {
                path = file.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = context.getCacheDir().getPath();
                }
                return new File(path + File.separator + "ksadsdk");
            }
        }
        path = null;
        if (TextUtils.isEmpty(path)) {
        }
        return new File(path + File.separator + "ksadsdk");
    }

    @NonNull
    public static AdInstallProxy b() {
        return new com.kwad.sdk.core.download.d.b();
    }
}
