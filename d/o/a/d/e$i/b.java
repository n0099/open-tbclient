package d.o.a.d.e$i;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import d.o.a.d.f.n;
/* loaded from: classes6.dex */
public class b {
    public static String a() {
        return d(n.a());
    }

    public static String b(Context context) {
        try {
            return c(c.b(a(), "MD5"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        return a.a(bArr);
    }

    public static String d(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
