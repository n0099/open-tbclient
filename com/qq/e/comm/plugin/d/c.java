package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.GDTFileProvider;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Class f11984a;

    /* renamed from: b  reason: collision with root package name */
    private static Class f11985b;
    private static Class c;

    static {
        f11984a = null;
        f11985b = null;
        c = null;
        try {
            f11984a = Class.forName("androidx.core.content.FileProvider");
        } catch (ClassNotFoundException e) {
            f11984a = null;
        }
        try {
            f11985b = Class.forName("androidx.core.content.FileProvider");
        } catch (ClassNotFoundException e2) {
            f11985b = null;
        }
        try {
            c = Class.forName("com.qq.e.comm.GDTFileProvider");
        } catch (ClassNotFoundException e3) {
            c = null;
        }
    }

    public static Uri a(Context context, File file) {
        if (Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT >= 24 && context.getApplicationInfo().targetSdkVersion >= 24)) {
            String packageName = context.getPackageName();
            Uri a2 = a(context, packageName + ".fileprovider", file);
            if (a2 == null || TextUtils.isEmpty(a2.getPath())) {
                a2 = a(context, packageName + ".gdt.fileprovider", file);
            }
            return (a2 == null || (TextUtils.isEmpty(a2.getPath()) && c != null)) ? GDTFileProvider.getUriForFile(context, packageName + ".gdt.fileprovider", file) : a2;
        }
        return Uri.fromFile(file);
    }

    private static Uri a(Context context, String str, File file) {
        Method method = null;
        Uri uri = Uri.EMPTY;
        try {
            if (f11984a != null) {
                method = f11984a.getMethod("getUriForFile", Context.class, String.class, File.class);
                GDTLogger.d("FileProvider androidx support->androidx");
            } else if (f11985b != null) {
                method = f11985b.getMethod("getUriForFile", Context.class, String.class, File.class);
                GDTLogger.d("FileProvider support support->androidx");
            }
            if (method != null) {
                return (Uri) method.invoke(null, context, str, file);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return uri;
    }
}
