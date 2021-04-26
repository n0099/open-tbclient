package d.o.a.e.a.h;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import d.o.a.e.b.l.e;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(e.i(str), 0));
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(e.i(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (byte b2 : decode) {
            if (i2 >= length) {
                i2 %= length;
            }
            sb.append((char) (b2 ^ str2.charAt(i2)));
            i2++;
        }
        return sb.toString();
    }

    public static String c(@NonNull JSONObject jSONObject, String str, String str2) {
        return b(jSONObject.optString(str), str2);
    }
}
