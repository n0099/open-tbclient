package d.b.g0.l.r;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static String a(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                if (strArr.length > 0 && strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        String str = strArr[i];
                        String str2 = strArr[i + 1];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put(str, str2);
                        }
                    }
                }
            } catch (Exception e2) {
                if (d.b.g0.l.f.f48888a) {
                    e2.printStackTrace();
                }
            }
        }
        return "errmsg:" + jSONObject.toString();
    }

    public static File b(String str, String str2) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            String d2 = d(str, str2);
            String str3 = d2;
            for (int i = 0; i < 1000; i++) {
                File file2 = new File(str3);
                try {
                    if (!file2.exists() && file2.createNewFile()) {
                        return file2;
                    }
                } catch (IOException e2) {
                    if (d.b.g0.l.f.f48888a) {
                        e2.printStackTrace();
                    }
                }
                str3 = d2 + "_" + i;
            }
            return null;
        }
        return null;
    }

    public static File c(Context context) {
        File dir = context.getDir("pms_dir", 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    public static String d(String str, String str2) {
        return e(str, str2, File.separator);
    }

    public static String e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.endsWith(str3)) {
            if (str2.startsWith(str3)) {
                return str.concat(str2.substring(str3.length()));
            }
            return str.concat(str2);
        } else if (str2.startsWith(str3)) {
            return str.concat(str2);
        } else {
            return str.concat(str3).concat(str2);
        }
    }
}
