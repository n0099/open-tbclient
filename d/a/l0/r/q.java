package d.a.l0.r;

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
    public static final ConcurrentHashMap<String, String> f52130f;

    /* renamed from: a  reason: collision with root package name */
    public int f52131a;

    /* renamed from: b  reason: collision with root package name */
    public int f52132b;

    /* renamed from: c  reason: collision with root package name */
    public String f52133c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f52134d;

    /* renamed from: e  reason: collision with root package name */
    public List<g> f52135e = new ArrayList();

    static {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        f52130f = concurrentHashMap;
        concurrentHashMap.put("1415", "66");
    }

    public q(String str, JSONObject jSONObject) {
        this.f52133c = str;
        this.f52134d = jSONObject;
    }

    public List<g> a() {
        return this.f52135e;
    }

    public String b() {
        return this.f52133c;
    }

    public int c() {
        return this.f52131a;
    }

    public int d() {
        return this.f52132b;
    }

    public boolean e() {
        String str;
        try {
            JSONObject jSONObject = this.f52134d;
            this.f52131a = jSONObject.getInt("threshold");
            this.f52132b = jSONObject.getInt("timeup");
            JSONArray jSONArray = new JSONArray(jSONObject.getString("item"));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("ubcid");
                if (TextUtils.isEmpty(string) || !f52130f.containsKey(string)) {
                    str = string;
                } else {
                    String optString = jSONObject2.optString("bizid");
                    f52130f.get(string);
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
                        gVar.f52064g = Integer.parseInt(jSONObject2.getString("rate"));
                    }
                    if (jSONObject2.has("bizid")) {
                        jSONObject2.getString("bizid");
                    }
                    if (jSONObject2.has("c")) {
                        gVar.f52065h = jSONObject2.getString("c");
                    }
                    if (jSONObject2.has("limitUnit")) {
                        gVar.f52066i = Integer.parseInt(jSONObject2.getString("limitUnit"));
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
                    this.f52135e.add(gVar);
                }
            }
            return true;
        } catch (NumberFormatException | JSONException unused) {
            return false;
        }
    }
}
