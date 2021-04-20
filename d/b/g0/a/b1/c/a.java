package d.b.g0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.b.g0.a.e0.w.d;
import d.b.g0.a.i2.b0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final boolean q = k.f45443a;
    public String l;
    public boolean n;
    public String o;
    public String p;

    /* renamed from: a  reason: collision with root package name */
    public String f43670a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43671b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43672c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f43673d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f43674e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f43675f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f43676g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f43677h = "";
    public int i = 0;
    public int j = 0;
    public String k = "";
    public boolean m = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f43670a = jSONObject.optString("audioId", aVar.f43670a);
            aVar2.f43671b = jSONObject.optString("slaveId", aVar.f43671b);
            aVar2.f43672c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f43672c);
            aVar2.m = e.y() != null && d.b.g0.a.a2.b.m(aVar2.f43672c);
            aVar2.f43673d = jSONObject.optString("title", aVar.f43673d);
            aVar2.f43674e = jSONObject.optString("epname", aVar.f43674e);
            aVar2.f43675f = jSONObject.optString("singer", aVar.f43675f);
            aVar2.f43676g = jSONObject.optString("coverImgUrl", aVar.f43676g);
            aVar2.f43677h = jSONObject.optString("lrcURL", aVar.f43677h);
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
            if (!TextUtils.isEmpty(b2) && b0.c(aVar2.f43672c)) {
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
            jSONObject.putOpt("title", this.f43673d);
            jSONObject.putOpt("epname", this.f43674e);
            jSONObject.putOpt("singer", this.f43675f);
            jSONObject.putOpt("coverImgUrl", this.f43676g);
            jSONObject.putOpt("lrcURL", this.f43677h);
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
        return "playerId : " + this.f43670a + "; slaveId : " + this.f43671b + "; url : " + this.f43672c + "; startTime : " + this.i + "; pos : " + this.j + "; canPlay : " + this.n;
    }
}
