package d.b.g0.g.k0.i.b;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.b.g0.a.z1.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final String f48289b = null;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f48290a = new ArrayList();

    public final String a(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }

    public void b(int i, String str, String str2, String str3) {
        String g2 = g(i);
        String B = d.b.g0.a.r1.e.y() == null ? null : d.b.g0.a.r1.e.y().B();
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = PrefetchEvent.STATE_CLICK;
        eVar.f47255f = g2;
        eVar.f47253d = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", B);
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("location", str3);
        }
        h.i(eVar);
    }

    public void c(int i, d.b.g0.g.k0.i.e.a aVar) {
        String g2 = g(i);
        JSONArray f2 = f(aVar);
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = "show";
        eVar.f47255f = g2;
        if (f2 != null) {
            eVar.a("game_list", f2);
        }
        h.i(eVar);
    }

    public void d(int i, String str, String str2) {
        String g2 = g(i);
        String a2 = a(g2, str, str2);
        if (this.f48290a.contains(a2)) {
            return;
        }
        String B = d.b.g0.a.r1.e.y() == null ? null : d.b.g0.a.r1.e.y().B();
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = PrefetchEvent.STATE_CLICK;
        eVar.f47255f = g2;
        eVar.f47253d = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", B);
        h.i(eVar);
        this.f48290a.add(a2);
    }

    public void e(int i, d.b.g0.g.k0.i.e.a aVar) {
        String g2 = g(i);
        JSONArray f2 = f(aVar);
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251b = "show";
        eVar.f47255f = g2;
        if (f2 != null) {
            eVar.a("game_list", f2);
        }
        h.i(eVar);
        this.f48290a.clear();
    }

    public final JSONArray f(d.b.g0.g.k0.i.e.a aVar) {
        if (aVar == null || aVar.f48302b == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.f48302b) {
            jSONArray.put(recommendItemModel.appKey);
        }
        return jSONArray;
    }

    public final String g(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return "popview";
            }
            return "list";
        }
        return "carousel";
    }
}
