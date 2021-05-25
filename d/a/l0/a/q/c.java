package d.a.l0.a.q;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f44140a;

    /* renamed from: b  reason: collision with root package name */
    public String f44141b;

    /* renamed from: c  reason: collision with root package name */
    public String f44142c;

    /* renamed from: d  reason: collision with root package name */
    public int f44143d;

    /* renamed from: e  reason: collision with root package name */
    public int f44144e;

    /* renamed from: f  reason: collision with root package name */
    public int f44145f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44146g;

    static {
        boolean z = k.f43199a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        this.f44140a = str;
        this.f44141b = str2;
        this.f44142c = str3;
        this.f44143d = i2;
        this.f44144e = i3;
        this.f44145f = i4;
        this.f44146g = z;
    }

    public d.a.l0.a.i1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.a.l0.a.i1.g.c cVar = new d.a.l0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f40845f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = !this.f44146g;
            cVar.M = false;
            cVar.p = this.f44140a;
            cVar.C = this.f44141b;
            cVar.f40846g = this.f44142c;
            d.a.l0.a.l1.e.a.a aVar = new d.a.l0.a.l1.e.a.a(0, 0, this.f44143d, this.f44144e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f44145f;
            if (this.f44146g) {
                cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            return d.a.l0.a.i1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
