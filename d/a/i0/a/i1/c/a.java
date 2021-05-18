package d.a.i0.a.i1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.a.a2.e;
import d.a.i0.a.h0.u.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.d0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean v = k.f43025a;
    public int n;
    public int o;
    public String p;
    public boolean r;
    public String s;
    public String t;
    public String u;

    /* renamed from: a  reason: collision with root package name */
    public String f42536a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f42537b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f42538c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f42539d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f42540e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f42541f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f42542g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f42543h = "";

    /* renamed from: i  reason: collision with root package name */
    public boolean f42544i = false;
    public String j = "";
    public int k = 0;
    public int l = 0;
    public String m = "";
    public boolean q = false;

    public static a b(JSONObject jSONObject, a aVar) {
        a aVar2 = new a();
        if (jSONObject != null) {
            aVar2.f42536a = jSONObject.optString("audioId", aVar.f42536a);
            aVar2.f42537b = jSONObject.optString("slaveId", aVar.f42537b);
            aVar2.f42538c = jSONObject.optString(UserAccountActionItem.KEY_SRC, aVar.f42538c);
            aVar2.q = e.i() != null && d.a.i0.a.k2.b.E(aVar2.f42538c);
            aVar2.f42539d = jSONObject.optString("title", aVar.f42539d);
            aVar2.f42540e = jSONObject.optString("epname", aVar.f42540e);
            aVar2.f42541f = jSONObject.optString("singer", aVar.f42541f);
            aVar2.f42542g = jSONObject.optString("coverImgUrl", aVar.f42542g);
            aVar2.f42543h = jSONObject.optString("lrcURL", aVar.f42543h);
            aVar2.f42544i = jSONObject.optBoolean("showFloatView", aVar.f42544i);
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
            if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f42538c)) {
                aVar2.t = b2;
            }
            String j = d.a.i0.a.l2.b.l().j(aVar2.f42538c);
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
            jSONObject.putOpt("title", this.f42539d);
            jSONObject.putOpt("epname", this.f42540e);
            jSONObject.putOpt("singer", this.f42541f);
            jSONObject.putOpt("coverImgUrl", this.f42542g);
            jSONObject.putOpt("lrcURL", this.f42543h);
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
        return "playerId : " + this.f42536a + "; slaveId : " + this.f42537b + "; url : " + this.f42538c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
    }
}
