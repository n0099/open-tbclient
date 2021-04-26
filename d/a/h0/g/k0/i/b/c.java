package d.a.h0.g.k0.i.b;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.h0.a.z1.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final String f46488b = null;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f46489a = new ArrayList();

    public final String a(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }

    public void b(int i2, String str, String str2, String str3) {
        String g2 = g(i2);
        String B = d.a.h0.a.r1.e.h() == null ? null : d.a.h0.a.r1.e.h().B();
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = PrefetchEvent.STATE_CLICK;
        eVar.f45416f = g2;
        eVar.f45414d = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", B);
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("location", str3);
        }
        h.i(eVar);
    }

    public void c(int i2, d.a.h0.g.k0.i.e.a aVar) {
        String g2 = g(i2);
        JSONArray f2 = f(aVar);
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "show";
        eVar.f45416f = g2;
        if (f2 != null) {
            eVar.a("game_list", f2);
        }
        h.i(eVar);
    }

    public void d(int i2, String str, String str2) {
        String g2 = g(i2);
        String a2 = a(g2, str, str2);
        if (this.f46489a.contains(a2)) {
            return;
        }
        String B = d.a.h0.a.r1.e.h() == null ? null : d.a.h0.a.r1.e.h().B();
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = PrefetchEvent.STATE_CLICK;
        eVar.f45416f = g2;
        eVar.f45414d = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", B);
        h.i(eVar);
        this.f46489a.add(a2);
    }

    public void e(int i2, d.a.h0.g.k0.i.e.a aVar) {
        String g2 = g(i2);
        JSONArray f2 = f(aVar);
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45412b = "show";
        eVar.f45416f = g2;
        if (f2 != null) {
            eVar.a("game_list", f2);
        }
        h.i(eVar);
        this.f46489a.clear();
    }

    public final JSONArray f(d.a.h0.g.k0.i.e.a aVar) {
        if (aVar == null || aVar.f46501b == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.f46501b) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    public final String g(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return "popview";
            }
            return "list";
        }
        return "carousel";
    }
}
