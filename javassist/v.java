package javassist;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class v {
    public static boolean a(int i) {
        return (i & 1) != 0;
    }

    public static boolean b(int i) {
        return (i & 2) != 0;
    }

    public static boolean c(int i) {
        return (i & 7) == 0;
    }

    public static boolean d(int i) {
        return (i & 8) != 0;
    }

    public static boolean e(int i) {
        return (i & ImageManager.DEFAULT_MAX_CACHEABLE_SIZE) != 0;
    }

    public static boolean f(int i) {
        return (i & 1024) != 0;
    }

    public static int g(int i) {
        return (i & (-7)) | 1;
    }

    public static String h(int i) {
        return Modifier.toString(i);
    }
}
