package d.b.g0.a.q;

import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f45872a;

    /* renamed from: b  reason: collision with root package name */
    public String f45873b;

    /* renamed from: c  reason: collision with root package name */
    public String f45874c;

    /* renamed from: d  reason: collision with root package name */
    public int f45875d;

    /* renamed from: e  reason: collision with root package name */
    public int f45876e;

    /* renamed from: f  reason: collision with root package name */
    public int f45877f;

    static {
        boolean z = k.f45443a;
    }

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.f45872a = str;
        this.f45873b = str2;
        this.f45874c = str3;
        this.f45875d = i;
        this.f45876e = i2;
        this.f45877f = i3;
    }

    public d.b.g0.a.b1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.b.g0.a.b1.g.c cVar = new d.b.g0.a.b1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f43505f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = true;
            cVar.M = false;
            cVar.p = this.f45872a;
            cVar.C = this.f45873b;
            cVar.f43506g = this.f45874c;
            d.b.g0.a.e1.d.a.a aVar = new d.b.g0.a.e1.d.a.a(0, 0, this.f45875d, this.f45876e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f45877f;
            return d.b.g0.a.b1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
