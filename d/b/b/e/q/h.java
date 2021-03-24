package d.b.b.e.q;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static int f42050a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f42051b = 3;

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f42052c = {RomUtils.MANUFACTURER_MEIZU};

    public static String a(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int i = 0;
        while (true) {
            String[] strArr = f42052c;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(lowerCase)) {
                return true;
            }
            i++;
        }
    }
}
