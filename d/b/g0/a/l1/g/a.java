package d.b.g0.a.l1.g;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.SocialOperation;
import d.b.g0.a.i2.n;
import d.b.g0.a.r1.e;
import d.b.g0.l.k.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str, long j, String str2) {
        e y = e.y();
        String[] strArr = {y != null ? d.b.g0.a.u.a.a(y.B()) : "", str, String.valueOf(j), str2};
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(strArr[i]);
        }
        return n.c("SHA-1", sb.toString().getBytes(), false);
    }

    public static String b(h hVar) {
        if (hVar == null) {
            return "";
        }
        String str = hVar.p;
        JSONObject jSONObject = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            jSONObject.put("noncestr", uuid);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put(SocialOperation.GAME_SIGNATURE, a(uuid, currentTimeMillis, str));
        } catch (JSONException e2) {
            d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
        }
        return jSONObject.toString();
    }

    public static boolean c(String str, String str2, h hVar) {
        int length;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hVar != null) {
            String str3 = hVar.q;
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            try {
                JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str);
                if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                return d.b.g0.a.s1.a.b.b(new URI(str2).getHost(), arrayList);
            } catch (URISyntaxException | JSONException e2) {
                d.b.g0.a.l1.d.a.a(Log.getStackTraceString(e2));
            }
        }
        return false;
    }
}
