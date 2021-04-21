package d.b.h0.a.z1.l;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.webkit.internal.ETAG;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.e;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47990a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static d.b.h0.a.z1.l.a f47991b;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47992a;

        static {
            int[] iArr = new int[SearchFlowEvent.EventType.values().length];
            f47992a = iArr;
            try {
                iArr[SearchFlowEvent.EventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47992a[SearchFlowEvent.EventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47992a[SearchFlowEvent.EventType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (f47990a) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
                return;
            }
            int i = a.f47992a[searchFlowEvent.f12324e.ordinal()];
            if (i == 1) {
                d();
                if (f47991b != null) {
                    f47991b.c(searchFlowEvent);
                }
            } else if (i != 2) {
                if (i == 3 && f47991b != null) {
                    f47991b.c(searchFlowEvent);
                }
            } else {
                if (f47991b != null) {
                    f47991b.c(searchFlowEvent);
                }
                b();
            }
            if (f47990a) {
                Log.d("SwanAppSearchFlowUBC", "Add SearchFlowEvent: " + searchFlowEvent.toString());
            }
        }
    }

    public static void b() {
        d.b.h0.a.z1.l.a aVar = f47991b;
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
            if (f47990a) {
                Log.d("SwanAppSearchFlowUBC", "search id is null, and source is not 1002");
                return;
            }
            return;
        }
        a(new SearchFlowEvent("dom_click", bundle.getLong("search_dom_click_timestamp"), "", "", SearchFlowEvent.EventType.START));
        d.b.h0.a.z1.l.a aVar = f47991b;
        if (aVar != null) {
            if (string == null) {
                string = "";
            }
            aVar.d(ETAG.KEY_SEARCH_ID, string);
            f47991b.d("url", bundle.getString("search_url"));
        }
    }

    public static void d() {
        d.b.h0.a.z1.l.a aVar = f47991b;
        if (aVar != null) {
            aVar.f();
            f47991b = null;
        }
        f47991b = new d.b.h0.a.z1.l.a("772");
    }

    public static synchronized void e(d.b.h0.a.y0.e.b bVar) {
        synchronized (b.class) {
            if (bVar == null) {
                return;
            }
            c(bVar.O(), bVar.S());
            if (f47991b != null) {
                f47991b.k(bVar.G());
                f47991b.l(bVar.S());
            }
        }
    }

    public static synchronized void f(e eVar) {
        synchronized (b.class) {
            if (eVar == null) {
                return;
            }
            c(eVar.n0(), eVar.S());
            if (f47991b != null) {
                f47991b.k(eVar.G());
                f47991b.l(eVar.S());
            }
        }
    }
}
