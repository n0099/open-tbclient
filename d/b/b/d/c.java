package d.b.b.d;

import android.os.Build;
import com.baidu.adp.gif.NSGif;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f41578a = {"ZTE-T U880", "U880"};

    public static boolean a() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean b(String str) {
        for (String str2 : f41578a) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c() {
        return b(Build.MODEL) && a() && NSGif.f2135f;
    }
}
