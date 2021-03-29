package d.b.k0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class w {
    public static final boolean j = AppConfig.isDebug();

    /* renamed from: a  reason: collision with root package name */
    public int f63990a;

    /* renamed from: b  reason: collision with root package name */
    public int f63991b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f63992c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63993d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f63994e;

    /* renamed from: f  reason: collision with root package name */
    public String f63995f;

    /* renamed from: g  reason: collision with root package name */
    public int f63996g;

    /* renamed from: h  reason: collision with root package name */
    public int f63997h;
    public List<k> i = new ArrayList();

    public w(String str, JSONObject jSONObject) {
        this.f63992c = jSONObject;
    }

    public JSONObject a() {
        return this.f63994e;
    }

    public List<k> b() {
        return this.i;
    }

    public int c() {
        return this.f63996g;
    }

    public int d() {
        return this.f63997h;
    }

    public String e() {
        return this.f63995f;
    }

    public int f() {
        return this.f63990a;
    }

    public int g() {
        return this.f63991b;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x016f A[Catch: JSONException -> 0x019d, TryCatch #0 {JSONException -> 0x019d, blocks: (B:3:0x0017, B:6:0x001c, B:8:0x006a, B:9:0x0070, B:11:0x0076, B:14:0x0085, B:16:0x0093, B:19:0x009b, B:21:0x00bf, B:23:0x00c5, B:25:0x00cb, B:27:0x00d1, B:29:0x00e2, B:31:0x00ee, B:33:0x00f4, B:34:0x00fb, B:36:0x0101, B:37:0x0108, B:39:0x010e, B:40:0x0115, B:42:0x011b, B:43:0x0122, B:45:0x0128, B:46:0x012f, B:48:0x0135, B:49:0x013c, B:51:0x0142, B:52:0x0149, B:54:0x014f, B:56:0x0159, B:58:0x0163, B:60:0x0169, B:62:0x016f, B:64:0x0179, B:65:0x017c, B:69:0x018b, B:68:0x0188), top: B:82:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h() {
        String str;
        k kVar;
        int optInt;
        String str2 = "gflow";
        try {
            if (this.f63992c == null) {
                return false;
            }
            JSONObject jSONObject = this.f63992c;
            this.f63993d = jSONObject.optJSONObject("set");
            this.f63990a = jSONObject.optInt("threshold", 10000);
            this.f63991b = jSONObject.optInt("timeup", 604800000);
            this.f63995f = jSONObject.optString("step");
            jSONObject.optString("replace");
            this.f63994e = jSONObject.optJSONObject("del");
            this.f63996g = jSONObject.optInt("all_size", 614400);
            this.f63997h = jSONObject.optInt("single_size", 153600);
            if (this.f63993d != null) {
                Iterator<String> keys = this.f63993d.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = this.f63993d.getJSONObject(next);
                    if (jSONObject2 != null) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                        String string = jSONObject2.getString("version");
                        if (jSONObject3 != null && !TextUtils.isEmpty(string)) {
                            String string2 = jSONObject3.getString(SetImageWatermarkTypeReqMsg.SWITCH);
                            String string3 = jSONObject3.getString(Constant.IS_REAL);
                            String string4 = jSONObject3.getString("isAbtest");
                            int i = jSONObject3.getInt(com.alipay.sdk.data.a.i);
                            String string5 = jSONObject3.getString("type");
                            if (TextUtils.isEmpty(next) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || TextUtils.isEmpty(string5)) {
                                str = str2;
                            } else {
                                k kVar2 = new k(next, string2, string3, i, string5, string4);
                                if (jSONObject3.has("rate")) {
                                    kVar = kVar2;
                                    kVar.A(jSONObject3.getInt("rate"));
                                } else {
                                    kVar = kVar2;
                                }
                                if (jSONObject3.has("c")) {
                                    kVar.s(jSONObject3.getString("c"));
                                }
                                if (jSONObject3.has("limitUnit")) {
                                    kVar.x(jSONObject3.getInt("limitUnit"));
                                }
                                if (jSONObject3.has("limitCnt")) {
                                    kVar.w(jSONObject3.getInt("limitCnt"));
                                }
                                if (jSONObject3.has(Constant.ID_TYPE)) {
                                    kVar.u(jSONObject3.getString(Constant.ID_TYPE));
                                }
                                if (jSONObject3.has("ch")) {
                                    kVar.z(jSONObject3.getString("ch"));
                                }
                                if (jSONObject3.has("dfc")) {
                                    kVar.v(jSONObject3.getString("dfc"));
                                }
                                if (jSONObject3.has("reallog")) {
                                    kVar.B(jSONObject3.getString("reallog"));
                                }
                                if (jSONObject3.has(str2)) {
                                    String string6 = jSONObject3.getString(str2);
                                    if (!TextUtils.isEmpty(string6)) {
                                        str = str2;
                                        if (!TextUtils.equals(string6, "0")) {
                                            kVar.t(string6);
                                        }
                                        if (jSONObject3.has("uploadType")) {
                                            String string7 = jSONObject3.getString("uploadType");
                                            if (!TextUtils.isEmpty(string7)) {
                                                kVar.C(string7);
                                            }
                                        }
                                        optInt = jSONObject3.optInt("lcache", 2);
                                        if (optInt != 1 || optInt == 0) {
                                            kVar.y(optInt);
                                        }
                                        kVar.D(string);
                                        this.i.add(kVar);
                                    }
                                }
                                str = str2;
                                if (jSONObject3.has("uploadType")) {
                                }
                                optInt = jSONObject3.optInt("lcache", 2);
                                if (optInt != 1) {
                                }
                                kVar.y(optInt);
                                kVar.D(string);
                                this.i.add(kVar);
                            }
                            str2 = str;
                        }
                    }
                }
                return true;
            }
            return true;
        } catch (JSONException e2) {
            if (j) {
                Log.d("OriginalConfigData", e2.getMessage());
                return false;
            }
            return false;
        }
    }

    public void i(List<k> list) {
        this.i = list;
    }
}
