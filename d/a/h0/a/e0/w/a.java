package d.a.h0.a.e0.w;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.i2.i0;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.k.p0.j;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f42336a;

    /* renamed from: b  reason: collision with root package name */
    public String f42337b;

    /* renamed from: c  reason: collision with root package name */
    public String f42338c;

    /* renamed from: d  reason: collision with root package name */
    public String f42339d;

    /* renamed from: e  reason: collision with root package name */
    public String f42340e;

    /* renamed from: f  reason: collision with root package name */
    public String f42341f;

    /* renamed from: g  reason: collision with root package name */
    public String f42342g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42343h;

    /* renamed from: i  reason: collision with root package name */
    public String f42344i;
    public boolean j;
    public String k;

    public static d.a.h0.a.k0.b.b a(a aVar) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, aVar.f42336a);
        treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, aVar.f42337b);
        treeMap.put("wvID", aVar.f42338c);
        treeMap.put("pageUrl", aVar.f42339d);
        treeMap.put("devhook", aVar.f42341f);
        treeMap.put("root", aVar.f42342g);
        if (!TextUtils.isEmpty(aVar.f42340e)) {
            treeMap.put("extraData", aVar.f42340e);
        }
        treeMap.put("showPerformancePanel", String.valueOf(aVar.f42343h));
        treeMap.put("pageType", aVar.f42344i);
        treeMap.put("isT7Available", String.valueOf(aVar.j));
        if (!TextUtils.isEmpty(aVar.k)) {
            treeMap.put("masterPreload", aVar.k);
        }
        d.a.h0.a.l1.g.b.a(treeMap, "app ready event");
        j.a(aVar.f42339d, treeMap);
        return new d.a.h0.a.k0.b.b("AppReady", treeMap);
    }

    public static String b(e eVar, String str) {
        String P = eVar != null ? eVar.P(i0.d(str)) : null;
        return P == null ? "" : P;
    }
}
