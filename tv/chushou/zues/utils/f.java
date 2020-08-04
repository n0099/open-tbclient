package tv.chushou.zues.utils;

import android.os.Environment;
import android.support.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.Properties;
/* loaded from: classes6.dex */
public class f {
    private static SoftReference<Properties> otg;

    public static String get(@NonNull String str) {
        Object obj = eah().get(str);
        if (obj == null) {
            obj = TT(str);
        }
        return obj == null ? "" : String.valueOf(obj);
    }

    private static String TT(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [56=4] */
    private static synchronized Properties eah() {
        Properties properties;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        synchronized (f.class) {
            properties = otg != null ? otg.get() : null;
            if (properties == null) {
                properties = new Properties();
                try {
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                } catch (Exception e) {
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    properties.load(fileInputStream);
                    tv.chushou.a.a.d.a.b(fileInputStream);
                } catch (Exception e2) {
                    tv.chushou.a.a.d.a.b(fileInputStream);
                    otg = new SoftReference<>(properties);
                    return properties;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    tv.chushou.a.a.d.a.b(fileInputStream2);
                    throw th;
                }
                otg = new SoftReference<>(properties);
            }
        }
        return properties;
    }
}
