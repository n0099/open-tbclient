package d.a.l0.h.o0.g.b;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.l0.a.j2.k;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final String f47594b = null;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f47595a = new ArrayList();

    public final String a(String str, String str2, String str3) {
        return String.format("%s_%s:%s", str, str2, str3);
    }

    public void b(int i2, String str, String str2, String str3) {
        String g2 = g(i2);
        String D = d.a.l0.a.a2.e.i() == null ? null : d.a.l0.a.a2.e.i().D();
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43186b = PrefetchEvent.STATE_CLICK;
        eVar.f43191g = g2;
        eVar.f43189e = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", D);
        if (!TextUtils.isEmpty(str3)) {
            eVar.a("location", str3);
        }
        k.g(eVar);
    }

    public void c(int i2, d.a.l0.h.o0.g.e.a aVar) {
        String g2 = g(i2);
        JSONArray f2 = f(aVar);
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43186b = "show";
        eVar.f43191g = g2;
        if (f2 != null) {
            eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
        }
        k.g(eVar);
    }

    public void d(int i2, String str, String str2) {
        String g2 = g(i2);
        String a2 = a(g2, str, str2);
        if (this.f47595a.contains(a2)) {
            return;
        }
        String D = d.a.l0.a.a2.e.i() == null ? null : d.a.l0.a.a2.e.i().D();
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43186b = PrefetchEvent.STATE_CLICK;
        eVar.f43191g = g2;
        eVar.f43189e = str;
        if (str2 != null) {
            eVar.a("target_appkey", str2);
        }
        eVar.a("current_appkey", D);
        k.g(eVar);
        this.f47595a.add(a2);
    }

    public void e(int i2, d.a.l0.h.o0.g.e.a aVar) {
        String g2 = g(i2);
        JSONArray f2 = f(aVar);
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f43186b = "show";
        eVar.f43191g = g2;
        if (f2 != null) {
            eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
        }
        k.g(eVar);
        this.f47595a.clear();
    }

    public final JSONArray f(d.a.l0.h.o0.g.e.a aVar) {
        if (aVar == null || aVar.f47607b == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (RecommendItemModel recommendItemModel : aVar.f47607b) {
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
