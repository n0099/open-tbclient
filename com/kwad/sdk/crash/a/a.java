package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f9619a;

    /* renamed from: b  reason: collision with root package name */
    private static String f9620b;

    public static File a() {
        File file = !TextUtils.isEmpty(f9620b) ? new File(f9620b) : new File(a(f9619a), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static File a(Context context) {
        File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            return !file.exists() ? new File("/data/data/" + context.getPackageName()) : file;
        }
        return dataDir;
    }

    public static void a(@NonNull Context context, @Nullable String str) {
        f9619a = context;
        f9620b = str;
    }

    public static File b() {
        return new File(a(), "java_crash/dump");
    }
}
