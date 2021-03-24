package d.b.g0.a.e0.h.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.e0.p.d;
import d.b.g0.a.i2.m0;
import d.b.g0.a.k;
import d.b.g0.l.k.g;
import d.b.g0.l.l.j.a;
import d.b.g0.l.l.k.b;
import d.b.g0.l.l.k.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class a implements d.b.g0.a.j0.j.b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43899e = k.f45050a;

    /* renamed from: d.b.g0.a.e0.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0647a extends d.b.g0.a.e0.p.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f43900a;

        public C0647a(Map map) {
            this.f43900a = map;
        }

        @Override // d.b.g0.a.e0.p.a
        public void b(@NonNull a.C1019a c1019a) {
            super.b(c1019a);
            h(c1019a.f48977b);
            d.b.g0.a.e0.p.p.a.c(c1019a.f48977b);
        }

        @Override // d.b.g0.a.e0.p.a
        public void c() {
            g();
        }

        @Override // d.b.g0.a.e0.p.a
        public void e(@NonNull g gVar) {
            super.e(gVar);
            h(gVar.o);
        }

        public final void g() {
            for (String str : this.f43900a.keySet()) {
                h(str);
            }
        }

        public final void h(@NonNull String str) {
            if (this.f43900a.containsKey(str)) {
                Set<String> set = (Set) this.f43900a.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        d.b.g0.a.e0.p.p.a.d(str, str2);
                    }
                    return;
                }
                d.b.g0.a.e0.p.p.a.c(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.g0.a.e0.p.p.b {
        public final /* synthetic */ String I;
        public final /* synthetic */ int J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, c cVar, String str2, int i) {
            super(str, cVar);
            this.I = str2;
            this.J = i;
        }

        @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
        public void D() {
            this.t = this.I;
        }

        @Override // d.b.g0.a.e0.p.f
        public int h0() {
            return this.J;
        }

        @Override // d.b.g0.l.h.g, d.b.g0.l.h.d
        public void k(String str, String str2) {
            List<UbcFlowEvent> list;
            super.k(str, str2);
            if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.s) == null) {
                return;
            }
            list.add(new UbcFlowEvent(str2));
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i);

        void b();

        void c();
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str) {
        String[] h2;
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (f43899e) {
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
                    if (d.b.g0.a.e0.p.p.a.e(bVar.b())) {
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
                        if (d.b.g0.a.e0.p.p.a.f(bVar.b(), str2) && !z) {
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
            if (f43899e) {
                Log.i("SwanPreDownload", "preDownload list empty");
                return;
            }
            return;
        }
        e eVar = new e(arrayList, m0.b());
        eVar.e(str);
        eVar.d("1");
        boolean equals = "1".equals(str);
        d dVar = new d(new C0647a(hashMap));
        dVar.L(equals ? 6 : 7);
        d.b.g0.l.c.b(eVar, dVar);
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull d.b.g0.a.e0.p.a aVar) {
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            aVar.a(6);
            return;
        }
        List<b.a> i = d.b.g0.a.e0.p.p.a.i(list);
        if (i.isEmpty()) {
            aVar.c();
            return;
        }
        d.b.g0.l.l.k.b bVar = new d.b.g0.l.l.k.b((List<? extends b.a>) i, (d.b.g0.l.r.a) m0.b());
        bVar.d("1");
        bVar.e(str);
        d.b.g0.l.c.b(bVar, new d(aVar));
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
        if (f43899e) {
            Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
        }
        return z;
    }

    public static void d(boolean z, String str, int i, c cVar, String str2, String str3) {
        if (f43899e) {
            Log.d("SwanPreDownload", "AppId: " + str + ", scene: " + str2);
        }
        if (TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.c();
            }
        } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (cVar != null) {
                cVar.a(6);
            }
        } else if (!d.b.g0.a.e0.p.p.a.e(str)) {
            if (cVar != null) {
                cVar.a(2);
            }
        } else {
            d.b.g0.l.l.k.c cVar2 = new d.b.g0.l.l.k.c(str, TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str3) ? 1 : 0);
            cVar2.d("1");
            cVar2.e(str2);
            if (!z) {
                cVar2.r(0L);
            }
            d.b.g0.l.c.a(cVar2, new b(str, cVar, str2, i));
        }
    }
}
