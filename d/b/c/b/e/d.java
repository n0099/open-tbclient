package d.b.c.b.e;

import android.content.Context;
import java.util.LinkedHashMap;
/* loaded from: classes6.dex */
public class d {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, int i2) {
        String str;
        if (i2 == 1) {
            try {
                str = d.b.c.b.a.a().a(context, "tnc_config", "");
            } catch (Exception unused) {
                str = "";
            }
            return !(str instanceof String) ? String.valueOf(str) : "";
        }
        str = "";
        if (!(str instanceof String)) {
        }
    }

    public static void b(Context context, int i2, String str) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i2 == 1) {
                linkedHashMap.put("tnc_config", str);
            }
            com.bytedance.sdk.adnet.d.d.c("MultiProcessFileUtils", "saveData = " + str);
            d.b.c.b.a.a().a(context, linkedHashMap);
        } catch (Exception unused) {
        }
    }
}
