package d.b.h0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.h0.a.e0.w.d;
import d.b.h0.a.i2.b0;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final boolean q = k.f45772a;
    public String l;
    public boolean n;
    public String o;
    public String p;

    /* renamed from: a  reason: collision with root package name */
    public String f43999a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f44000b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f44001c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f44002d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f44003e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f44004f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f44005g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f44006h = "";
    public int i = 0;
    public int j = 0;
    public String k = "";
    public boolean m = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f43999a = jSONObject.optString("audioId", aVar.f43999a);
            aVar2.f44000b = jSONObject.optString("slaveId", aVar.f44000b);
            aVar2.f44001c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f44001c);
            aVar2.m = e.y() != null && d.b.h0.a.a2.b.m(aVar2.f44001c);
            aVar2.f44002d = jSONObject.optString("title", aVar.f44002d);
            aVar2.f44003e = jSONObject.optString("epname", aVar.f44003e);
            aVar2.f44004f = jSONObject.optString("singer", aVar.f44004f);
            aVar2.f44005g = jSONObject.optString("coverImgUrl", aVar.f44005g);
            aVar2.f44006h = jSONObject.optString("lrcURL", aVar.f44006h);
            aVar2.i = jSONObject.optInt("startTime", aVar.i);
            aVar2.j = jSONObject.optInt("position", aVar.j);
            aVar2.l = jSONObject.optString("cb", aVar.l);
            aVar2.k = jSONObject.optString("param", aVar.k);
            aVar2.n = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String W = d.L().W();
            if (!TextUtils.isEmpty(W)) {
                aVar2.o = W;
            }
            String b2 = b0.b();
            if (!TextUtils.isEmpty(b2) && b0.c(aVar2.f44001c)) {
                aVar2.p = b2;
            }
        }
        return aVar2;
    }

    public boolean a() {
        return this.n;
    }

    public String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.f44002d);
            jSONObject.putOpt("epname", this.f44003e);
            jSONObject.putOpt("singer", this.f44004f);
            jSONObject.putOpt("coverImgUrl", this.f44005g);
            jSONObject.putOpt("lrcURL", this.f44006h);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.m));
            jSONObject.putOpt("appid", e.T());
            jSONObject.putOpt("user-agent", this.o);
            jSONObject.putOpt("refer", this.p);
        } catch (JSONException e2) {
            if (q) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.f43999a + "; slaveId : " + this.f44000b + "; url : " + this.f44001c + "; startTime : " + this.i + "; pos : " + this.j + "; canPlay : " + this.n;
    }
}
