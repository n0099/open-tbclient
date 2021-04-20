package d.b.g0.n;

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
    public static final ConcurrentHashMap<String, String> f49693f;

    /* renamed from: a  reason: collision with root package name */
    public int f49694a;

    /* renamed from: b  reason: collision with root package name */
    public int f49695b;

    /* renamed from: c  reason: collision with root package name */
    public String f49696c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49697d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f49698e = new ArrayList();

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f49693f = concurrentHashMap;
        concurrentHashMap.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.f49696c = str;
        this.f49697d = jSONObject;
    }

    public List<g> a() {
        return this.f49698e;
    }

    public String b() {
        return this.f49696c;
    }

    public int c() {
        return this.f49694a;
    }

    public int d() {
        return this.f49695b;
    }

    public boolean e() {
        String str;
        try {
            JSONObject jSONObject = this.f49697d;
            this.f49694a = jSONObject.getInt("threshold");
            this.f49695b = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !f49693f.containsKey(string)) {
                    str = string;
                } else {
                    String optString = jSONObject2.optString("bizid");
                    f49693f.get(string);
                    str = optString;
                }
                String string2 = jSONObject2.getString(SetImageWatermarkTypeReqMsg.SWITCH);
                String string3 = jSONObject2.getString(Constant.IS_REAL);
                String string4 = jSONObject2.getString("isAbtest");
                int intValue = Integer.valueOf(jSONObject2.getString("timeout")).intValue();
                String string5 = jSONObject2.getString("type");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string5)) {
                    g gVar = new g(str, string2, string3, intValue, string5, string4);
                    if (jSONObject2.has("rate")) {
                        gVar.r(Integer.valueOf(jSONObject2.getString("rate")).intValue());
                    }
                    if (jSONObject2.has("bizid")) {
                        gVar.m(jSONObject2.getString("bizid"));
                    }
                    if (jSONObject2.has("c")) {
                        gVar.n(jSONObject2.getString("c"));
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.q(Integer.valueOf(jSONObject2.getString("limitUnit")).intValue());
                    }
                    if (jSONObject2.has("limitCnt")) {
                        gVar.p(Integer.valueOf(jSONObject2.getString("limitCnt")).intValue());
                    }
                    if (jSONObject2.has(Constant.ID_TYPE)) {
                        gVar.o(jSONObject2.getString(Constant.ID_TYPE));
                    }
                    if (jSONObject2.has("appblacklist")) {
                        gVar.l(jSONObject2.getString("appblacklist"));
                    }
                    this.f49698e.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException unused) {
            return false;
        }
    }
}
