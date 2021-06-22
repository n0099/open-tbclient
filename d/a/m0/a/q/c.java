package d.a.m0.a.q;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f47922a;

    /* renamed from: b  reason: collision with root package name */
    public String f47923b;

    /* renamed from: c  reason: collision with root package name */
    public String f47924c;

    /* renamed from: d  reason: collision with root package name */
    public int f47925d;

    /* renamed from: e  reason: collision with root package name */
    public int f47926e;

    /* renamed from: f  reason: collision with root package name */
    public int f47927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47928g;

    static {
        boolean z = k.f46983a;
    }

    public c(String str, String str2, String str3, int i2, int i3, int i4, boolean z) {
        this.f47922a = str;
        this.f47923b = str2;
        this.f47924c = str3;
        this.f47925d = i2;
        this.f47926e = i3;
        this.f47927f = i4;
        this.f47928g = z;
    }

    public d.a.m0.a.i1.g.c a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showMuteBtn", true);
            jSONObject.put("showCenterPlayBtn", true);
            d.a.m0.a.i1.g.c cVar = new d.a.m0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f44629f = "SwanAdPlayer";
            cVar.s = true;
            cVar.o = false;
            cVar.B = !this.f47928g;
            cVar.M = false;
            cVar.p = this.f47922a;
            cVar.C = this.f47923b;
            cVar.f44630g = this.f47924c;
            d.a.m0.a.l1.e.a.a aVar = new d.a.m0.a.l1.e.a.a(0, 0, this.f47925d, this.f47926e);
            cVar.l = aVar;
            aVar.j(true);
            cVar.q = this.f47927f;
            if (this.f47928g) {
                cVar.u = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            return d.a.m0.a.i1.g.c.h(jSONObject, cVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
