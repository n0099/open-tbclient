package d.a.h0.a.z1.l;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.webkit.internal.ETAG;
import d.a.h0.a.k;
import d.a.h0.a.y0.e.e;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45430a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static d.a.h0.a.z1.l.a f45431b;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45432a;

        static {
            int[] iArr = new int[SearchFlowEvent.EventType.values().length];
            f45432a = iArr;
            try {
                iArr[SearchFlowEvent.EventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45432a[SearchFlowEvent.EventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45432a[SearchFlowEvent.EventType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static synchronized void a(SearchFlowEvent searchFlowEvent) {
        synchronized (b.class) {
            if (searchFlowEvent == null) {
                if (f45430a) {
                    Log.d("SwanAppSearchFlowUBC", "Event is null...");
                }
                return;
            }
            int i2 = a.f45432a[searchFlowEvent.f12196e.ordinal()];
            if (i2 == 1) {
                d();
                if (f45431b != null) {
                    f45431b.c(searchFlowEvent);
                }
            } else if (i2 != 2) {
                if (i2 == 3 && f45431b != null) {
                    f45431b.c(searchFlowEvent);
                }
            } else {
                if (f45431b != null) {
                    f45431b.c(searchFlowEvent);
                }
                b();
            }
            if (f45430a) {
                Log.d("SwanAppSearchFlowUBC", "Add SearchFlowEvent: " + searchFlowEvent.toString());
            }
        }
    }

    public static void b() {
        d.a.h0.a.z1.l.a aVar = f45431b;
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
            if (f45430a) {
                Log.d("SwanAppSearchFlowUBC", "search id is null, and source is not 1002");
                return;
            }
            return;
        }
        a(new SearchFlowEvent("dom_click", bundle.getLong("search_dom_click_timestamp"), "", "", SearchFlowEvent.EventType.START));
        d.a.h0.a.z1.l.a aVar = f45431b;
        if (aVar != null) {
            if (string == null) {
                string = "";
            }
            aVar.d(ETAG.KEY_SEARCH_ID, string);
            f45431b.d("url", bundle.getString("search_url"));
        }
    }

    public static void d() {
        d.a.h0.a.z1.l.a aVar = f45431b;
        if (aVar != null) {
            aVar.f();
            f45431b = null;
        }
        f45431b = new d.a.h0.a.z1.l.a("772");
    }

    public static synchronized void e(d.a.h0.a.y0.e.b bVar) {
        synchronized (b.class) {
            if (bVar == null) {
                return;
            }
            c(bVar.O(), bVar.S());
            if (f45431b != null) {
                f45431b.k(bVar.G());
                f45431b.l(bVar.S());
            }
        }
    }

    public static synchronized void f(e eVar) {
        synchronized (b.class) {
            if (eVar == null) {
                return;
            }
            c(eVar.n0(), eVar.S());
            if (f45431b != null) {
                f45431b.k(eVar.G());
                f45431b.l(eVar.S());
            }
        }
    }
}
