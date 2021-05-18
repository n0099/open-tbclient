package d.a.i0.a.q;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f43964a;

    /* renamed from: b  reason: collision with root package name */
    public String f43965b;

    /* renamed from: c  reason: collision with root package name */
    public String f43966c;

    /* renamed from: d  reason: collision with root package name */
    public int f43967d;

    /* renamed from: e  reason: collision with root package name */
    public int f43968e;

    /* renamed from: f  reason: collision with root package name */
    public int f43969f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43970g;

    static {
        boolean z = k.f43025a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        this.f43964a = str;
        this.f43965b = str2;
        this.f43966c = str3;
        this.f43967d = i2;
        this.f43968e = i3;
        this.f43969f = i4;
        this.f43970g = z;
    }

    public d.a.i0.a.i1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.a.i0.a.i1.g.c cVar = new d.a.i0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f40671f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = !this.f43970g;
            cVar.M = false;
            cVar.p = this.f43964a;
            cVar.C = this.f43965b;
            cVar.f40672g = this.f43966c;
            d.a.i0.a.l1.e.a.a aVar = new d.a.i0.a.l1.e.a.a(0, 0, this.f43967d, this.f43968e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f43969f;
            if (this.f43970g) {
                cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            return d.a.i0.a.i1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
