package d.a.l0.h.y;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(String str, int i2) throws JSONException {
        return 200 == i2 && !TextUtils.isEmpty(str) && new JSONObject(str).optInt("errorno") == 0;
    }
}
