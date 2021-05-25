package d.a.d0.b.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.facebook.common.util.UriUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39637a = d.a.d0.a.a.a.f39588a;

    public static List<h> a(JSONArray jSONArray, String str, boolean z) throws ParseError {
        List<h> h2;
        if (jSONArray == null || jSONArray.length() == 0 || (h2 = h.h(jSONArray)) == null || h2.size() == 0) {
            return null;
        }
        if (z) {
            for (h hVar : h2) {
                hVar.x = true;
            }
        } else {
            HashMap<String, h> q = f.q();
            if (q != null && q.size() != 0) {
                f.g(h2);
                f.z(h2);
            } else {
                f.z(h2);
            }
            f.w(h2);
        }
        return h2;
    }

    public static List<h> b(String str, String str2) throws ParseError {
        if (!TextUtils.isEmpty(str)) {
            try {
                return c(new JSONObject(str), str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
                throw new ParseError(1, "afd/entry retun invalid json");
            }
        }
        throw new ParseError(1, "afd/entry retun null");
    }

    public static List<h> c(JSONObject jSONObject, String str) throws ParseError {
        JSONObject optJSONObject;
        List<h> s;
        if (f39637a) {
            Log.d("AfdResponseParser", "AFD response : " + jSONObject.toString());
        }
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || jSONObject.optInt("errno", 0) > 0 || (optJSONObject = jSONObject.optJSONObject(UriUtil.LOCAL_RESOURCE_SCHEME)) == null) {
            return null;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("splash");
        JSONArray optJSONArray = optJSONObject.optJSONArray("ad");
        if (optJSONObject2 != null) {
            String optString = optJSONObject2.optString("cmd");
            SplashStyleRecorder.b(optJSONObject2.optJSONObject("style_desc"));
            g.j(optJSONObject2.optString("src_ext_info"));
            if (TextUtils.equals(IMTrack.DbBuilder.ACTION_UPDATE, optString)) {
                List<h> a2 = a(optJSONArray, str, false);
                String optString2 = optJSONObject2.optString("empty_ext_info");
                if (!TextUtils.isEmpty(optString2)) {
                    d.a.d0.a.c.j.j("empty_ext_info", optString2);
                    return a2;
                } else if (f39637a) {
                    throw new IllegalStateException("splash empty接口没有empty_ext_info信息");
                } else {
                    return a2;
                }
            } else if (TextUtils.equals("query", optString)) {
                if (optJSONObject2.optInt("realTimeLoading") == 1) {
                    return a(optJSONArray, str, true);
                }
                String optString3 = optJSONObject2.optString("ukey");
                if (TextUtils.isEmpty(optString3) || (s = f.s()) == null) {
                    return arrayList;
                }
                for (h hVar : s) {
                    if (TextUtils.equals(hVar.f39660c, optString3)) {
                        arrayList.add(hVar);
                        return arrayList;
                    }
                }
                return arrayList;
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }
}
