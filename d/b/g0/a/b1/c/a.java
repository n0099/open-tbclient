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
    public static final boolean q = k.f45051a;
    public String l;
    public boolean n;
    public String o;
    public String p;

    /* renamed from: a  reason: collision with root package name */
    public String f43278a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f43279b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f43280c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f43281d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f43282e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f43283f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f43284g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f43285h = "";
    public int i = 0;
    public int j = 0;
    public String k = "";
    public boolean m = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f43278a = jSONObject.optString("audioId", aVar.f43278a);
            aVar2.f43279b = jSONObject.optString("slaveId", aVar.f43279b);
            aVar2.f43280c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f43280c);
            aVar2.m = e.y() != null && d.b.g0.a.a2.b.m(aVar2.f43280c);
            aVar2.f43281d = jSONObject.optString("title", aVar.f43281d);
            aVar2.f43282e = jSONObject.optString("epname", aVar.f43282e);
            aVar2.f43283f = jSONObject.optString("singer", aVar.f43283f);
            aVar2.f43284g = jSONObject.optString("coverImgUrl", aVar.f43284g);
            aVar2.f43285h = jSONObject.optString("lrcURL", aVar.f43285h);
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
            if (!TextUtils.isEmpty(b2) && b0.c(aVar2.f43280c)) {
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
            jSONObject.putOpt("title", this.f43281d);
            jSONObject.putOpt("epname", this.f43282e);
            jSONObject.putOpt("singer", this.f43283f);
            jSONObject.putOpt("coverImgUrl", this.f43284g);
            jSONObject.putOpt("lrcURL", this.f43285h);
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
        return "playerId : " + this.f43278a + "; slaveId : " + this.f43279b + "; url : " + this.f43280c + "; startTime : " + this.i + "; pos : " + this.j + "; canPlay : " + this.n;
    }
}
