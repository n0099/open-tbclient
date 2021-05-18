package d.a.i0.r;

import android.text.TextUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: f  reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f48280f;

    /* renamed from: a  reason: collision with root package name */
    public int f48281a;

    /* renamed from: b  reason: collision with root package name */
    public int f48282b;

    /* renamed from: c  reason: collision with root package name */
    public String f48283c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f48284d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f48285e = new ArrayList();

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f48280f = concurrentHashMap;
        concurrentHashMap.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.f48283c = str;
        this.f48284d = jSONObject;
    }

    public List<g> a() {
        return this.f48285e;
    }

    public String b() {
        return this.f48283c;
    }

    public int c() {
        return this.f48281a;
    }

    public int d() {
        return this.f48282b;
    }

    public boolean e() {
        String str;
        try {
            JSONObject jSONObject = this.f48284d;
            this.f48281a = jSONObject.getInt("threshold");
            this.f48282b = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !f48280f.containsKey(string)) {
                    str = string;
                } else {
                    String optString = jSONObject2.optString("bizid");
                    f48280f.get(string);
                    str = optString;
                }
                String string2 = jSONObject2.getString(SetImageWatermarkTypeReqMsg.SWITCH);
                String string3 = jSONObject2.getString(Constant.IS_REAL);
                String string4 = jSONObject2.getString("isAbtest");
                int parseInt = Integer.parseInt(jSONObject2.getString("timeout"));
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, parseInt, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.f48214g = Integer.parseInt(jSONObject2.getString("rate"));
                    }
                    if (jSONObject2.has("bizid")) {
                        jSONObject2.getString("bizid");
                    }
                    if (jSONObject2.has("c")) {
                        gVar.f48215h = jSONObject2.getString("c");
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.f48216i = Integer.parseInt(jSONObject2.getString("limitUnit"));
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.j = Integer.parseInt(jSONObject2.getString("limitCnt"));
                    }
                    if (jSONObject2.has(Constant.ID_TYPE)) {
                        gVar.k = jSONObject2.getString(Constant.ID_TYPE);
                    }
                    if (jSONObject2.has("appblacklist")) {
                        jSONObject2.getString("appblacklist");
                    }
                    this.f48285e.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException unused) {
            return false;
        }
    }
}
