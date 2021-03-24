package d.b.g0.a.e0.w;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.i2.i0;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.k.p0.j;
import java.util.TreeMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f44308a;

    /* renamed from: b  reason: collision with root package name */
    public String f44309b;

    /* renamed from: c  reason: collision with root package name */
    public String f44310c;

    /* renamed from: d  reason: collision with root package name */
    public String f44311d;

    /* renamed from: e  reason: collision with root package name */
    public String f44312e;

    /* renamed from: f  reason: collision with root package name */
    public String f44313f;

    /* renamed from: g  reason: collision with root package name */
    public String f44314g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44315h;
    public String i;
    public boolean j;
    public String k;

    public static d.b.g0.a.k0.b.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f44308a);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f44309b);
        treeMap.put("wvID", aVar.f44310c);
        treeMap.put("pageUrl", aVar.f44311d);
        treeMap.put("devhook", aVar.f44313f);
        treeMap.put("root", aVar.f44314g);
        if (!TextUtils.isEmpty(aVar.f44312e)) {
            treeMap.put("extraData", aVar.f44312e);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.f44315h));
        treeMap.put("pageType", aVar.i);
        treeMap.put("isT7Available", String.valueOf(aVar.j));
        if (!TextUtils.isEmpty(aVar.k)) {
            treeMap.put("masterPreload", aVar.k);
        }
        d.b.g0.a.l1.g.b.a(treeMap, "app ready event");
        j.a(aVar.f44311d, treeMap);
        return new d.b.g0.a.k0.b.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String P = eVar != null ? eVar.P(i0.d(str)) : null;
        return P == null ? "" : P;
    }
}
