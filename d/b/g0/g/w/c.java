package d.b.g0.g.w;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(String str, int i) throws JSONException {
        return 200 == i && !TextUtils.isEmpty(str) && new JSONObject(str).optInt("errorno") == 0;
    }
}
