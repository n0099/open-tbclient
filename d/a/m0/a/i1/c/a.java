package d.a.m0.a.i1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.a.a2.e;
import d.a.m0.a.h0.u.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean v = k.f46983a;
    public int n;
    public int o;
    public String p;
    public boolean r;
    public String s;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public String f46494a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f46495b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f46496c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f46497d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f46498e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f46499f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f46500g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f46501h = "";

    /* renamed from: i  reason: collision with root package name */
    public boolean f46502i = false;
    public String j = "";
    public int k = 0;
    public int l = 0;
    public String m = "";
    public boolean q = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f46494a = jSONObject.optString("audioId", aVar.f46494a);
            aVar2.f46495b = jSONObject.optString("slaveId", aVar.f46495b);
            aVar2.f46496c = jSONObject.optString("src", aVar.f46496c);
            aVar2.q = e.i() != null && d.a.m0.a.k2.b.E(aVar2.f46496c);
            aVar2.f46497d = jSONObject.optString("title", aVar.f46497d);
            aVar2.f46498e = jSONObject.optString("epname", aVar.f46498e);
            aVar2.f46499f = jSONObject.optString("singer", aVar.f46499f);
            aVar2.f46500g = jSONObject.optString("coverImgUrl", aVar.f46500g);
            aVar2.f46501h = jSONObject.optString("lrcURL", aVar.f46501h);
            aVar2.f46502i = jSONObject.optBoolean("showFloatView", aVar.f46502i);
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
            if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f46496c)) {
                aVar2.t = b2;
            }
            String j = d.a.m0.a.l2.b.l().j(aVar2.f46496c);
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
            jSONObject.putOpt("title", this.f46497d);
            jSONObject.putOpt("epname", this.f46498e);
            jSONObject.putOpt("singer", this.f46499f);
            jSONObject.putOpt("coverImgUrl", this.f46500g);
            jSONObject.putOpt("lrcURL", this.f46501h);
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
        return "playerId : " + this.f46494a + "; slaveId : " + this.f46495b + "; url : " + this.f46496c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
    }
}
