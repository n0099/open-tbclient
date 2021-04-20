package d.b.h0.z0;

import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.switchs.TBCdnPortraitSwitch;
/* loaded from: classes3.dex */
public class o {
    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (b(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (SwitchManager.getInstance().findType(TBCdnPortraitSwitch.CDNPORTRAIT_SWITCH_KEY) != 0) && c(str);
        }
        return true;
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }

    public static boolean c(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }

    public static boolean d(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tiebapic")) > 0 && indexOf < 20;
    }

    public static boolean e() {
        return f();
    }

    public static boolean f() {
        return FileHelper.checkSD() && d.b.c.d.c.c();
    }
}
