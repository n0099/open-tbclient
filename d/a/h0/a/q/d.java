package d.a.h0.a.q;

import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f43549a;

    /* renamed from: b  reason: collision with root package name */
    public String f43550b;

    /* renamed from: c  reason: collision with root package name */
    public String f43551c;

    /* renamed from: d  reason: collision with root package name */
    public int f43552d;

    /* renamed from: e  reason: collision with root package name */
    public int f43553e;

    /* renamed from: f  reason: collision with root package name */
    public int f43554f;

    static {
        boolean z = k.f43101a;
    }

    public d(String str, String str2, String str3, int i2, int i3, int i4) {
        this.f43549a = str;
        this.f43550b = str2;
        this.f43551c = str3;
        this.f43552d = i2;
        this.f43553e = i3;
        this.f43554f = i4;
    }

    public d.a.h0.a.b1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.a.h0.a.b1.g.c cVar = new d.a.h0.a.b1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f41092f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = true;
            cVar.M = false;
            cVar.p = this.f43549a;
            cVar.C = this.f43550b;
            cVar.f41093g = this.f43551c;
            d.a.h0.a.e1.d.a.a aVar = new d.a.h0.a.e1.d.a.a(0, 0, this.f43552d, this.f43553e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f43554f;
            return d.a.h0.a.b1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
