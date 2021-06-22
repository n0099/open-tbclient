package d.a.c.e.q;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static int f42666a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f42667b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f42668c = {"meizu"};

    public static String a(int i2) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i2);
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int i2 = 0;
        while (true) {
            String[] strArr = f42668c;
            if (i2 >= strArr.length) {
                return false;
            }
            if (strArr[i2].equals(lowerCase)) {
                return true;
            }
            i2++;
        }
    }
}
