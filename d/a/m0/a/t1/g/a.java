package d.a.m0.a.t1.g;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.open.SocialOperation;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.o;
import d.a.m0.n.h.h;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48578a = k.f46983a;

    public static String a(String str, long j, String str2) {
        e i2 = e.i();
        String[] strArr = {i2 != null ? d.a.m0.a.v.a.a(i2.D()) : "", str, String.valueOf(j), str2};
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < 4; i3++) {
            sb.append(strArr[i3]);
        }
        try {
            return o.c("SHA-1", sb.toString().getBytes(), false);
        } catch (NoSuchAlgorithmException e2) {
            if (f48578a) {
                Log.e("SwanPluginHostSign", "getSignature occurs exception:", e2);
                return "";
            }
            return "";
        }
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
            d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
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
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
                return d.a.m0.a.b2.a.b.b(new URI(str2).getHost(), arrayList);
            } catch (URISyntaxException | JSONException e2) {
                d.a.m0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
        }
        return false;
    }
}
