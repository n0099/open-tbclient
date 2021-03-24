package d.b.g0.a.z1.l;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.a.k;
import d.b.g0.a.y0.e.e;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47268a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.g0.a.z1.l.a f47269b;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47270a;

        static {
            int[] iArr = new int[SearchFlowEvent.EventType.values().length];
            f47270a = iArr;
            try {
                iArr[SearchFlowEvent.EventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47270a[SearchFlowEvent.EventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47270a[SearchFlowEvent.EventType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (f47268a) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
                return;
            }
            int i = a.f47270a[searchFlowEvent.f12654e.ordinal()];
            if (i == 1) {
                d();
                if (f47269b != null) {
                    f47269b.c(searchFlowEvent);
                }
            } else if (i != 2) {
                if (i == 3 && f47269b != null) {
                    f47269b.c(searchFlowEvent);
                }
            } else {
                if (f47269b != null) {
                    f47269b.c(searchFlowEvent);
                }
                b();
            }
            if (f47268a) {
                Log.d("SwanAppSearchFlowUBC", "Add SearchFlowEvent: " + searchFlowEvent.toString());
            }
        }
    }

    public static void b() {
        d.b.g0.a.z1.l.a aVar = f47269b;
        if (aVar != null) {
            aVar.h();
        }
    }

    public static void c(Bundle bundle, String str) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("search_id");
        if (TextUtils.isEmpty(string) && !TextUtils.equals("1002", str)) {
            if (f47268a) {
                Log.d("SwanAppSearchFlowUBC", "search id is null, and source is not 1002");
                return;
            }
            return;
        }
        a(new SearchFlowEvent("dom_click", bundle.getLong("search_dom_click_timestamp"), "", "", SearchFlowEvent.EventType.START));
        d.b.g0.a.z1.l.a aVar = f47269b;
        if (aVar != null) {
            if (string == null) {
                string = "";
            }
            aVar.d(ETAG.KEY_SEARCH_ID, string);
            f47269b.d("url", bundle.getString("search_url"));
        }
    }

    public static void d() {
        d.b.g0.a.z1.l.a aVar = f47269b;
        if (aVar != null) {
            aVar.f();
            f47269b = null;
        }
        f47269b = new d.b.g0.a.z1.l.a("772");
    }

    public static synchronized void e(d.b.g0.a.y0.e.b bVar) {
        synchronized (b.class) {
            if (bVar == null) {
                return;
            }
            c(bVar.O(), bVar.S());
            if (f47269b != null) {
                f47269b.k(bVar.G());
                f47269b.l(bVar.S());
            }
        }
    }

    public static synchronized void f(e eVar) {
        synchronized (b.class) {
            if (eVar == null) {
                return;
            }
            c(eVar.n0(), eVar.S());
            if (f47269b != null) {
                f47269b.k(eVar.G());
                f47269b.l(eVar.S());
            }
        }
    }
}
