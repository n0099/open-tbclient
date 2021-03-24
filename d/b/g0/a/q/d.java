package d.b.g0.a.q;

import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f45479a;

    /* renamed from: b  reason: collision with root package name */
    public String f45480b;

    /* renamed from: c  reason: collision with root package name */
    public String f45481c;

    /* renamed from: d  reason: collision with root package name */
    public int f45482d;

    /* renamed from: e  reason: collision with root package name */
    public int f45483e;

    /* renamed from: f  reason: collision with root package name */
    public int f45484f;

    static {
        boolean z = k.f45050a;
    }

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.f45479a = str;
        this.f45480b = str2;
        this.f45481c = str3;
        this.f45482d = i;
        this.f45483e = i2;
        this.f45484f = i3;
    }

    public d.b.g0.a.b1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.b.g0.a.b1.g.c cVar = new d.b.g0.a.b1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f43112f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = true;
            cVar.M = false;
            cVar.p = this.f45479a;
            cVar.C = this.f45480b;
            cVar.f43113g = this.f45481c;
            d.b.g0.a.e1.d.a.a aVar = new d.b.g0.a.e1.d.a.a(0, 0, this.f45482d, this.f45483e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f45484f;
            return d.b.g0.a.b1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
