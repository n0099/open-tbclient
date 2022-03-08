package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes8.dex */
public class a {
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static String f55102b;

    public static File a() {
        File file = !TextUtils.isEmpty(f55102b) ? new File(f55102b) : new File(a(a), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File a(Context context) {
        File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (file.exists()) {
                return file;
            }
            return new File("/data/data/" + context.getPackageName());
        }
        return dataDir;
    }

    public static void a(@NonNull Context context, @Nullable String str) {
        a = context;
        f55102b = str;
    }

    public static File b() {
        return new File(a(), "java_crash/dump");
    }
}
