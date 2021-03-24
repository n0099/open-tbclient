package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f34412a;

    /* renamed from: b  reason: collision with root package name */
    public static String f34413b;

    public static File a() {
        File file = !TextUtils.isEmpty(f34413b) ? new File(f34413b) : new File(a(f34412a), "kwad_ex");
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
        f34412a = context;
        f34413b = str;
    }

    public static File b() {
        return new File(a(), "java_crash/dump");
    }
}
