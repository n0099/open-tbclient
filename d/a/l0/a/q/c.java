package d.a.l0.a.q;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f47814a;

    /* renamed from: b  reason: collision with root package name */
    public String f47815b;

    /* renamed from: c  reason: collision with root package name */
    public String f47816c;

    /* renamed from: d  reason: collision with root package name */
    public int f47817d;

    /* renamed from: e  reason: collision with root package name */
    public int f47818e;

    /* renamed from: f  reason: collision with root package name */
    public int f47819f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47820g;

    static {
        boolean z = k.f46875a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        this.f47814a = str;
        this.f47815b = str2;
        this.f47816c = str3;
        this.f47817d = i2;
        this.f47818e = i3;
        this.f47819f = i4;
        this.f47820g = z;
    }

    public d.a.l0.a.i1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.a.l0.a.i1.g.c cVar = new d.a.l0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f44521f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = !this.f47820g;
            cVar.M = false;
            cVar.p = this.f47814a;
            cVar.C = this.f47815b;
            cVar.f44522g = this.f47816c;
            d.a.l0.a.l1.e.a.a aVar = new d.a.l0.a.l1.e.a.a(0, 0, this.f47817d, this.f47818e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f47819f;
            if (this.f47820g) {
                cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            return d.a.l0.a.i1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
