package d.a.p0;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class x {
    public static final boolean j = AppConfig.isDebug();

    /* renamed from: a  reason: collision with root package name */
    public int f67733a;

    /* renamed from: b  reason: collision with root package name */
    public int f67734b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f67735c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67736d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f67737e;

    /* renamed from: f  reason: collision with root package name */
    public String f67738f;

    /* renamed from: g  reason: collision with root package name */
    public int f67739g;

    /* renamed from: h  reason: collision with root package name */
    public int f67740h;

    /* renamed from: i  reason: collision with root package name */
    public List<k> f67741i = new ArrayList();

    public x(String str, JSONObject jSONObject) {
        this.f67735c = jSONObject;
    }

    public JSONObject a() {
        return this.f67737e;
    }

    public List<k> b() {
        return this.f67741i;
    }

    public int c() {
        return this.f67739g;
    }

    public int d() {
        return this.f67740h;
    }

    public String e() {
        return this.f67738f;
    }

    public int f() {
        return this.f67733a;
    }

    public int g() {
        return this.f67734b;
    }

    public boolean h() {
        JSONObject optJSONObject;
        try {
            if (this.f67735c != null && this.f67735c.length() != 0) {
                JSONObject jSONObject = this.f67735c;
                this.f67736d = jSONObject.optJSONObject("set");
                this.f67733a = jSONObject.optInt("threshold", 10000);
                this.f67734b = jSONObject.optInt("timeup", 604800000);
                this.f67738f = jSONObject.optString("step");
                jSONObject.optString("replace");
                this.f67737e = jSONObject.optJSONObject("del");
                this.f67739g = jSONObject.optInt("all_size", 614400);
                this.f67740h = jSONObject.optInt("single_size", 153600);
                jSONObject.optInt("real_size", 614400);
                jSONObject.optInt("non_real_size", 614400);
                int i2 = 1;
                if (this.f67736d != null) {
                    Iterator<String> keys = this.f67736d.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (optJSONObject = this.f67736d.optJSONObject(next)) != null && optJSONObject.length() != 0) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                            String optString = optJSONObject.optString("version");
                            if (optJSONObject2 != null && !TextUtils.isEmpty(optString)) {
                                Iterator<String> it = keys;
                                k kVar = new k(next, optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, i2) != 0, optJSONObject2.optInt(Constant.IS_REAL, 0) == 1, optJSONObject2.optInt("timeout", 60), optJSONObject2.optInt("type", 0), optJSONObject2.optInt("isAbtest", 0) == 1);
                                if (n.a(next)) {
                                    kVar.m(optJSONObject2.optInt("isSend", 1) == 1);
                                }
                                if (optJSONObject2.has("rate")) {
                                    kVar.r(optJSONObject2.getInt("rate"));
                                }
                                if (optJSONObject2.has("c")) {
                                    kVar.i(optJSONObject2.getString("c"));
                                }
                                if (optJSONObject2.has("limitUnit")) {
                                    kVar.o(optJSONObject2.getInt("limitUnit"));
                                }
                                if (optJSONObject2.has("limitCnt")) {
                                    kVar.n(optJSONObject2.getInt("limitCnt"));
                                }
                                if (optJSONObject2.has(Constant.ID_TYPE)) {
                                    kVar.k(optJSONObject2.getInt(Constant.ID_TYPE));
                                }
                                kVar.q(optJSONObject2.optInt("ch", 0) == 1);
                                if (optJSONObject2.has("dfc")) {
                                    kVar.l(optJSONObject2.getInt("dfc") == 1);
                                }
                                if (optJSONObject2.has("reallog")) {
                                    kVar.s(optJSONObject2.getInt("reallog") == 1);
                                }
                                if (optJSONObject2.has("gflow")) {
                                    kVar.j(optJSONObject2.getInt("gflow"));
                                }
                                if (optJSONObject2.has("uploadType")) {
                                    kVar.t(optJSONObject2.optInt("uploadType", -1));
                                }
                                int optInt = optJSONObject2.optInt("lcache", 2);
                                if (optInt == 1 || optInt == 0) {
                                    kVar.p(optInt);
                                }
                                kVar.u(optString);
                                this.f67741i.add(kVar);
                                keys = it;
                                i2 = 1;
                            }
                        }
                    }
                    return true;
                }
                return true;
            }
            return false;
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public void i(List<k> list) {
        this.f67741i = list;
    }
}
