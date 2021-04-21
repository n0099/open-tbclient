package d.b.h0.a.q;

import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f46201a;

    /* renamed from: b  reason: collision with root package name */
    public String f46202b;

    /* renamed from: c  reason: collision with root package name */
    public String f46203c;

    /* renamed from: d  reason: collision with root package name */
    public int f46204d;

    /* renamed from: e  reason: collision with root package name */
    public int f46205e;

    /* renamed from: f  reason: collision with root package name */
    public int f46206f;

    static {
        boolean z = k.f45772a;
    }

    public d(String str, String str2, String str3, int i, int i2, int i3) {
        this.f46201a = str;
        this.f46202b = str2;
        this.f46203c = str3;
        this.f46204d = i;
        this.f46205e = i2;
        this.f46206f = i3;
    }

    public d.b.h0.a.b1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.b.h0.a.b1.g.c cVar = new d.b.h0.a.b1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f43834f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = true;
            cVar.M = false;
            cVar.p = this.f46201a;
            cVar.C = this.f46202b;
            cVar.f43835g = this.f46203c;
            d.b.h0.a.e1.d.a.a aVar = new d.b.h0.a.e1.d.a.a(0, 0, this.f46204d, this.f46205e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f46206f;
            return d.b.h0.a.b1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
