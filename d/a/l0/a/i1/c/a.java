package d.a.l0.a.i1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.l0.a.a2.e;
import d.a.l0.a.h0.u.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean v = k.f46875a;
    public int n;
    public int o;
    public String p;
    public boolean r;
    public String s;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public String f46386a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f46387b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f46388c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f46389d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f46390e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f46391f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f46392g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f46393h = "";

    /* renamed from: i  reason: collision with root package name */
    public boolean f46394i = false;
    public String j = "";
    public int k = 0;
    public int l = 0;
    public String m = "";
    public boolean q = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f46386a = jSONObject.optString("audioId", aVar.f46386a);
            aVar2.f46387b = jSONObject.optString("slaveId", aVar.f46387b);
            aVar2.f46388c = jSONObject.optString("src", aVar.f46388c);
            aVar2.q = e.i() != null && d.a.l0.a.k2.b.E(aVar2.f46388c);
            aVar2.f46389d = jSONObject.optString("title", aVar.f46389d);
            aVar2.f46390e = jSONObject.optString("epname", aVar.f46390e);
            aVar2.f46391f = jSONObject.optString("singer", aVar.f46391f);
            aVar2.f46392g = jSONObject.optString("coverImgUrl", aVar.f46392g);
            aVar2.f46393h = jSONObject.optString("lrcURL", aVar.f46393h);
            aVar2.f46394i = jSONObject.optBoolean("showFloatView", aVar.f46394i);
            aVar2.j = jSONObject.optString("floatPosition", aVar.j);
            aVar2.k = jSONObject.optInt("startTime", aVar.k);
            aVar2.l = jSONObject.optInt("position", aVar.l);
            aVar2.p = jSONObject.optString("cb", aVar.p);
            aVar2.m = jSONObject.optString("param", aVar.m);
            aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
            String Y = g.N().Y();
            if (!TextUtils.isEmpty(Y)) {
                aVar2.s = Y;
            }
            String b2 = d0.b();
            if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f46388c)) {
                aVar2.t = b2;
            }
            String j = d.a.l0.a.l2.b.l().j(aVar2.f46388c);
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
            jSONObject.putOpt("src", str);
            jSONObject.putOpt("title", this.f46389d);
            jSONObject.putOpt("epname", this.f46390e);
            jSONObject.putOpt("singer", this.f46391f);
            jSONObject.putOpt("coverImgUrl", this.f46392g);
            jSONObject.putOpt("lrcURL", this.f46393h);
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
        return "playerId : " + this.f46386a + "; slaveId : " + this.f46387b + "; url : " + this.f46388c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
    }
}
