package d.a.b0.b.f;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import com.facebook.common.util.UriUtil;
import d.a.b0.a.c.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f39323a = d.a.b0.a.a.a.f39286a;

    public static List<g> a(JSONArray jSONArray, String str, boolean z) throws ParseError {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        List<g> h2 = g.h(jSONArray);
        if (z) {
            for (g gVar : h2) {
                gVar.x = true;
            }
        } else {
            HashMap<String, g> o = f.o();
            if (o != null && o.size() != 0) {
                f.f(h2);
                f.v(h2);
            } else {
                f.v(h2);
            }
            f.s(h2);
        }
        return h2;
    }

    public static List<g> b(String str, String str2) throws ParseError {
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

    public static List<g> c(JSONObject jSONObject, String str) throws ParseError {
        JSONObject optJSONObject;
        List<g> n;
        if (f39323a) {
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
            if (TextUtils.equals(IMTrack.DbBuilder.ACTION_UPDATE, optString)) {
                List<g> a2 = a(optJSONArray, str, false);
                String optString2 = optJSONObject2.optString("empty_ext_info");
                if (!TextUtils.isEmpty(optString2)) {
                    j.f("empty_ext_info", optString2);
                    return a2;
                } else if (f39323a) {
                    throw new IllegalStateException("splash empty接口没有empty_ext_info信息");
                } else {
                    return a2;
                }
            } else if (TextUtils.equals("query", optString)) {
                if (optJSONObject2.optInt("realTimeLoading") == 1) {
                    return a(optJSONArray, str, true);
                }
                String optString3 = optJSONObject2.optString("ukey");
                if (TextUtils.isEmpty(optString3) || (n = f.n()) == null) {
                    return arrayList;
                }
                for (g gVar : n) {
                    if (TextUtils.equals(gVar.f39346c, optString3)) {
                        arrayList.add(gVar);
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
