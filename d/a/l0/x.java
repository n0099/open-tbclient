package d.a.l0;

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
    public int f63278a;

    /* renamed from: b  reason: collision with root package name */
    public int f63279b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f63280c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63281d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63282e;

    /* renamed from: f  reason: collision with root package name */
    public String f63283f;

    /* renamed from: g  reason: collision with root package name */
    public int f63284g;

    /* renamed from: h  reason: collision with root package name */
    public int f63285h;

    /* renamed from: i  reason: collision with root package name */
    public List<k> f63286i = new ArrayList();

    public x(String str, JSONObject jSONObject) {
        this.f63280c = jSONObject;
    }

    public JSONObject a() {
        return this.f63282e;
    }

    public List<k> b() {
        return this.f63286i;
    }

    public int c() {
        return this.f63284g;
    }

    public int d() {
        return this.f63285h;
    }

    public String e() {
        return this.f63283f;
    }

    public int f() {
        return this.f63278a;
    }

    public int g() {
        return this.f63279b;
    }

    public boolean h() {
        JSONObject optJSONObject;
        try {
            if (this.f63280c != null && this.f63280c.length() != 0) {
                JSONObject jSONObject = this.f63280c;
                this.f63281d = jSONObject.optJSONObject("set");
                this.f63278a = jSONObject.optInt("threshold", 10000);
                this.f63279b = jSONObject.optInt("timeup", 604800000);
                this.f63283f = jSONObject.optString("step");
                jSONObject.optString("replace");
                this.f63282e = jSONObject.optJSONObject("del");
                this.f63284g = jSONObject.optInt("all_size", 614400);
                this.f63285h = jSONObject.optInt("single_size", 153600);
                jSONObject.optInt("real_size", 614400);
                jSONObject.optInt("non_real_size", 614400);
                int i2 = 1;
                if (this.f63281d != null) {
                    Iterator<String> keys = this.f63281d.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (optJSONObject = this.f63281d.optJSONObject(next)) != null && optJSONObject.length() != 0) {
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
                                this.f63286i.add(kVar);
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
        this.f63286i = list;
    }
}
