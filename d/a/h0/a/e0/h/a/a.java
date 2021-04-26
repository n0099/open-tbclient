package d.a.h0.a.e0.h.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.e0.p.d;
import d.a.h0.a.i2.m0;
import d.a.h0.a.k;
import d.a.h0.l.k.g;
import d.a.h0.l.l.j.a;
import d.a.h0.l.l.k.b;
import d.a.h0.l.l.k.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class a implements d.a.h0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41918e = k.f43101a;

    /* renamed from: d.a.h0.a.e0.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0619a extends d.a.h0.a.e0.p.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f41919a;

        public C0619a(Map map) {
            this.f41919a = map;
        }

        @Override // d.a.h0.a.e0.p.a
        public void b(@NonNull a.C0991a c0991a) {
            super.b(c0991a);
            h(c0991a.f47211b);
            d.a.h0.a.e0.p.p.a.c(c0991a.f47211b);
        }

        @Override // d.a.h0.a.e0.p.a
        public void c() {
            g();
        }

        @Override // d.a.h0.a.e0.p.a
        public void e(@NonNull g gVar) {
            super.e(gVar);
            h(gVar.o);
        }

        public final void g() {
            for (String str : this.f41919a.keySet()) {
                h(str);
            }
        }

        public final void h(@NonNull String str) {
            if (this.f41919a.containsKey(str)) {
                Set<String> set = (Set) this.f41919a.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        d.a.h0.a.e0.p.p.a.d(str, str2);
                    }
                    return;
                }
                d.a.h0.a.e0.p.p.a.c(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d.a.h0.a.e0.p.p.b {
        public final /* synthetic */ String I;
        public final /* synthetic */ int J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, c cVar, String str2, int i2) {
            super(str, cVar);
            this.I = str2;
            this.J = i2;
        }

        @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
        public void C() {
            this.t = this.I;
        }

        @Override // d.a.h0.a.e0.p.f
        public int g0() {
            return this.J;
        }

        @Override // d.a.h0.l.h.g, d.a.h0.l.h.d
        public void n(String str, String str2) {
            List<UbcFlowEvent> list;
            super.n(str, str2);
            if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.s) == null) {
                return;
            }
            list.add(new UbcFlowEvent(str2));
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();

        void b(int i2);

        void c();
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str) {
        String[] h2;
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (f41918e) {
                Log.e("SwanPreDownload", "pre download net invalid");
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (e.b bVar : list) {
            if (bVar != null) {
                if (bVar.h() == null) {
                    if (d.a.h0.a.e0.p.p.a.e(bVar.b())) {
                        arrayList.add(bVar);
                        hashMap.put(bVar.b(), null);
                    }
                } else {
                    Set set = (Set) hashMap.get(bVar.b());
                    if (set == null) {
                        set = new HashSet();
                    }
                    boolean z = false;
                    for (String str2 : bVar.h()) {
                        if (d.a.h0.a.e0.p.p.a.f(bVar.b(), str2) && !z) {
                            arrayList.add(bVar);
                            z = true;
                        }
                        set.add(str2);
                    }
                    hashMap.put(bVar.b(), set);
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (f41918e) {
                Log.i("SwanPreDownload", "preDownload list empty");
                return;
            }
            return;
        }
        e eVar = new e(arrayList, m0.b());
        eVar.e(str);
        eVar.d("1");
        boolean equals = "1".equals(str);
        d dVar = new d(new C0619a(hashMap));
        dVar.K(equals ? 6 : 7);
        d.a.h0.l.c.b(eVar, dVar);
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull d.a.h0.a.e0.p.a aVar) {
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            aVar.a(6);
            return;
        }
        List<b.a> i2 = d.a.h0.a.e0.p.p.a.i(list);
        if (i2.isEmpty()) {
            aVar.c();
            return;
        }
        d.a.h0.l.l.k.b bVar = new d.a.h0.l.l.k.b((List<? extends b.a>) i2, (d.a.h0.l.r.a) m0.b());
        bVar.d("1");
        bVar.e(str);
        d.a.h0.l.c.b(bVar, new d(aVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.i(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(String str) {
        boolean z = true;
        if (!TextUtils.equals(str, "0")) {
            if (!TextUtils.equals(str, "1")) {
                TextUtils.equals(str, "2");
                z = false;
            }
        }
        if (f41918e) {
            Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
        }
        return z;
    }

    public static void d(boolean z, String str, int i2, c cVar, String str2, String str3) {
        if (f41918e) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.c();
            }
        } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (cVar != null) {
                cVar.b(6);
            }
        } else if (!d.a.h0.a.e0.p.p.a.e(str)) {
            if (cVar != null) {
                cVar.b(2);
            }
        } else {
            d.a.h0.l.l.k.c cVar2 = new d.a.h0.l.l.k.c(str, TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str3) ? 1 : 0);
            cVar2.d("1");
            cVar2.e(str2);
            if (!z) {
                cVar2.r(0L);
            }
            d.a.h0.l.c.a(cVar2, new b(str, cVar, str2, i2));
        }
    }
}
