package d.a.h0.a.b1.c;

import android.text.TextUtils;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import d.a.h0.a.e0.w.d;
import d.a.h0.a.i2.b0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean q = k.f43101a;
    public String l;
    public boolean n;
    public String o;
    public String p;

    /* renamed from: a  reason: collision with root package name */
    public String f41269a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f41270b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f41271c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f41272d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f41273e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41274f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41275g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f41276h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f41277i = 0;
    public int j = 0;
    public String k = "";
    public boolean m = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f41269a = jSONObject.optString("audioId", aVar.f41269a);
            aVar2.f41270b = jSONObject.optString("slaveId", aVar.f41270b);
            aVar2.f41271c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f41271c);
            aVar2.m = e.h() != null && d.a.h0.a.a2.b.m(aVar2.f41271c);
            aVar2.f41272d = jSONObject.optString("title", aVar.f41272d);
            aVar2.f41273e = jSONObject.optString("epname", aVar.f41273e);
            aVar2.f41274f = jSONObject.optString("singer", aVar.f41274f);
            aVar2.f41275g = jSONObject.optString("coverImgUrl", aVar.f41275g);
            aVar2.f41276h = jSONObject.optString("lrcURL", aVar.f41276h);
            aVar2.f41277i = jSONObject.optInt("startTime", aVar.f41277i);
            aVar2.j = jSONObject.optInt("position", aVar.j);
            aVar2.l = jSONObject.optString("cb", aVar.l);
            aVar2.k = jSONObject.optString("param", aVar.k);
            aVar2.n = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String W = d.L().W();
            if (!TextUtils.isEmpty(W)) {
                aVar2.o = W;
            }
            String b2 = b0.b();
            if (!TextUtils.isEmpty(b2) && b0.c(aVar2.f41271c)) {
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
            jSONObject.putOpt("title", this.f41272d);
            jSONObject.putOpt("epname", this.f41273e);
            jSONObject.putOpt("singer", this.f41274f);
            jSONObject.putOpt("coverImgUrl", this.f41275g);
            jSONObject.putOpt("lrcURL", this.f41276h);
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
        return "playerId : " + this.f41269a + "; slaveId : " + this.f41270b + "; url : " + this.f41271c + "; startTime : " + this.f41277i + "; pos : " + this.j + "; canPlay : " + this.n;
    }
}
