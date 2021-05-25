package d.a.l0.a.i1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.l0.a.a2.e;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean v = k.f43199a;
    public int n;
    public int o;
    public String p;
    public boolean r;
    public String s;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public String f42710a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f42711b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f42712c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f42713d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42714e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f42715f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f42716g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f42717h = "";

    /* renamed from: i  reason: collision with root package name */
    public boolean f42718i = false;
    public String j = "";
    public int k = 0;
    public int l = 0;
    public String m = "";
    public boolean q = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f42710a = jSONObject.optString("audioId", aVar.f42710a);
            aVar2.f42711b = jSONObject.optString("slaveId", aVar.f42711b);
            aVar2.f42712c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f42712c);
            aVar2.q = e.i() != null && d.a.l0.a.k2.b.E(aVar2.f42712c);
            aVar2.f42713d = jSONObject.optString("title", aVar.f42713d);
            aVar2.f42714e = jSONObject.optString("epname", aVar.f42714e);
            aVar2.f42715f = jSONObject.optString("singer", aVar.f42715f);
            aVar2.f42716g = jSONObject.optString("coverImgUrl", aVar.f42716g);
            aVar2.f42717h = jSONObject.optString("lrcURL", aVar.f42717h);
            aVar2.f42718i = jSONObject.optBoolean("showFloatView", aVar.f42718i);
            aVar2.j = jSONObject.optString("floatPosition", aVar.j);
            aVar2.k = jSONObject.optInt("startTime", aVar.k);
            aVar2.l = jSONObject.optInt("position", aVar.l);
            aVar2.p = jSONObject.optString("cb", aVar.p);
            aVar2.m = jSONObject.optString("param", aVar.m);
            aVar2.r = TextUtils.isEmpty(jSONObject.optString(UserAccountActionItem.KEY_SRC));
            String Y = g.N().Y();
            if (!TextUtils.isEmpty(Y)) {
                aVar2.s = Y;
            }
            String b2 = d0.b();
            if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f42712c)) {
                aVar2.t = b2;
            }
            String j = d.a.l0.a.l2.b.l().j(aVar2.f42712c);
            if (!TextUtils.isEmpty(j)) {
                aVar2.u = j;
                if (v) {
                    Log.d("AudioPlayerParams", "addCookiesToHeader cookie: " + j);
                }
            }
        }
        return aVar2;
    }

    public boolean a() {
        return this.r;
    }

    public String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(UserAccountActionItem.KEY_SRC, str);
            jSONObject.putOpt("title", this.f42713d);
            jSONObject.putOpt("epname", this.f42714e);
            jSONObject.putOpt("singer", this.f42715f);
            jSONObject.putOpt("coverImgUrl", this.f42716g);
            jSONObject.putOpt("lrcURL", this.f42717h);
            jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
            jSONObject.putOpt("appid", e.V());
            jSONObject.putOpt("user-agent", this.s);
            jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
            jSONObject.putOpt("Cookie", this.u);
        } catch (JSONException e2) {
            if (v) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "playerId : " + this.f42710a + "; slaveId : " + this.f42711b + "; url : " + this.f42712c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
    }
}
