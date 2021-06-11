package d.a.l0.a.h0.c.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import d.a.l0.a.h0.m.d;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.t0;
import d.a.l0.n.h.g;
import d.a.l0.n.i.l.a;
import d.a.l0.n.i.m.b;
import d.a.l0.n.i.m.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class b implements d.a.l0.a.n0.l.b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45626e = k.f46875a;

    /* loaded from: classes2.dex */
    public static class a extends d.a.l0.a.h0.m.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f45627a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0700b f45628b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Map f45629c;

        public a(InterfaceC0700b interfaceC0700b, Map map) {
            this.f45628b = interfaceC0700b;
            this.f45629c = map;
        }

        @Override // d.a.l0.a.h0.m.a
        public void a() {
            super.a();
            InterfaceC0700b interfaceC0700b = this.f45628b;
            if (interfaceC0700b != null) {
                interfaceC0700b.a();
            }
        }

        @Override // d.a.l0.a.h0.m.a
        public void b(int i2) {
            super.b(i2);
            InterfaceC0700b interfaceC0700b = this.f45628b;
            if (interfaceC0700b != null) {
                if (i2 == 1010) {
                    interfaceC0700b.a();
                } else {
                    interfaceC0700b.b(3);
                }
            }
        }

        @Override // d.a.l0.a.h0.m.a
        public void c(@NonNull a.C1134a c1134a) {
            super.c(c1134a);
            i(c1134a.f51756b);
            d.a.l0.a.h0.m.p.a.c(c1134a.f51756b);
        }

        @Override // d.a.l0.a.h0.m.a
        public void d() {
            h();
            InterfaceC0700b interfaceC0700b = this.f45628b;
            if (interfaceC0700b == null || this.f45627a) {
                return;
            }
            interfaceC0700b.a();
        }

        @Override // d.a.l0.a.h0.m.a
        public void e(d.a.l0.n.h.a aVar) {
            super.e(aVar);
            if (aVar.f51676a != 1010) {
                this.f45627a = true;
                InterfaceC0700b interfaceC0700b = this.f45628b;
                if (interfaceC0700b != null) {
                    interfaceC0700b.b(3);
                }
            }
        }

        @Override // d.a.l0.a.h0.m.a
        public void f(@NonNull g gVar) {
            super.f(gVar);
            i(gVar.o);
        }

        public final void h() {
            for (String str : this.f45629c.keySet()) {
                i(str);
            }
        }

        public final void i(@NonNull String str) {
            if (this.f45629c.containsKey(str)) {
                Set<String> set = (Set) this.f45629c.get(str);
                if (set != null && !set.isEmpty()) {
                    for (String str2 : set) {
                        d.a.l0.a.h0.m.p.a.d(str, str2);
                    }
                    return;
                }
                d.a.l0.a.h0.m.p.a.c(str);
            }
        }
    }

    /* renamed from: d.a.l0.a.h0.c.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0700b {
        void a();

        void b(int i2);

        void c();
    }

    public static void a(@NonNull List<e.b> list, @Nullable String str, InterfaceC0700b interfaceC0700b) {
        String[] h2;
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (f45626e) {
                Log.e("SwanPreDownload", "pre download net invalid");
            }
            if (interfaceC0700b != null) {
                interfaceC0700b.b(6);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (e.b bVar : list) {
            if (bVar != null) {
                if (bVar.h() == null) {
                    if (d.a.l0.a.h0.m.p.a.e(bVar.b())) {
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
                        if (d.a.l0.a.h0.m.p.a.f(bVar.b(), str2) && !z) {
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
            if (f45626e) {
                Log.i("SwanPreDownload", "preDownload list empty");
            }
            if (interfaceC0700b != null) {
                interfaceC0700b.a();
                return;
            }
            return;
        }
        e eVar = new e(arrayList, t0.b());
        eVar.e(str);
        eVar.d("1");
        boolean equals = "1".equals(str);
        d dVar = new d(new a(interfaceC0700b, hashMap));
        dVar.K(equals ? 6 : 7);
        d.a.l0.n.b.d(eVar, dVar);
    }

    public static void b(@NonNull List<b.a> list, @NonNull String str, @NonNull d.a.l0.a.h0.m.a aVar) {
        if (!c(h.a().getString("predownload_network_switch", "1"))) {
            aVar.b(6);
            return;
        }
        List<b.a> i2 = d.a.l0.a.h0.m.p.a.i(list);
        if (i2.isEmpty()) {
            aVar.d();
            return;
        }
        d.a.l0.n.i.m.b bVar = new d.a.l0.n.i.m.b((List<? extends b.a>) i2, (d.a.l0.n.o.a) t0.b());
        bVar.d("1");
        bVar.e(str);
        d.a.l0.n.b.d(bVar, new d(aVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (com.baidu.swan.apps.network.SwanAppNetworkUtils.j(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) != false) goto L6;
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
        if (f45626e) {
            Log.d("SwanPreDownload", "SwanPredownload: current net suits for net config = " + z);
        }
        return z;
    }

    public static boolean d(String str) {
        if (TextUtils.equals(SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME, str)) {
            d.a.l0.a.c1.a.Z().getSwitch("swan_game_feed_predownload", 0);
            return false;
        }
        return true;
    }

    public static void e(@NonNull String str, @Nullable String str2, @Nullable String str3, InterfaceC0700b interfaceC0700b) {
        e.b bVar = new e.b(str);
        if (!TextUtils.isEmpty(str2)) {
            bVar.j(new String[]{str2});
        }
        a(Collections.singletonList(bVar), str3, interfaceC0700b);
    }

    public static void f(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            if (f45626e) {
                Log.e("SwanPreDownload", "pre download swanAppId invalid");
            }
        } else if (!c(h.a().getString("predownload_network_switch", "1"))) {
            if (f45626e) {
                Log.e("SwanPreDownload", "pre download net invalid");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new b.a(str));
            List<b.a> i2 = d.a.l0.a.h0.m.p.a.i(arrayList);
            if (i2.isEmpty()) {
                if (f45626e) {
                    Log.e("SwanPreDownload", "pre download has record");
                    return;
                }
                return;
            }
            d.a.l0.n.i.m.b bVar = new d.a.l0.n.i.m.b((List<? extends b.a>) i2, (d.a.l0.n.o.a) t0.b());
            bVar.e(str2);
            bVar.d("1");
            boolean equals = "1".equals(str2);
            d dVar = new d();
            dVar.K(equals ? 6 : 7);
            d.a.l0.n.b.d(bVar, dVar);
        }
    }

    public static void g(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, InterfaceC0700b interfaceC0700b) {
        if (f45626e) {
            Log.d("SwanPreDownload", "preDownloadSwanAppByFeed appId: " + str + " ,appType: " + str2 + " ,isClick: " + z + ", scheme=" + str4);
        }
        if (z) {
            if (interfaceC0700b != null) {
                interfaceC0700b.a();
            }
        } else if (TextUtils.isEmpty(str)) {
            if (interfaceC0700b != null) {
                interfaceC0700b.c();
            }
        } else if (!d(str2)) {
            if (interfaceC0700b != null) {
                interfaceC0700b.b(6);
            }
        } else {
            String str5 = null;
            if (!TextUtils.isEmpty(str4)) {
                try {
                    Uri parse = Uri.parse(str4);
                    if (parse != null) {
                        str5 = o0.n(str, parse, false);
                    }
                } catch (Exception e2) {
                    if (f45626e) {
                        e2.printStackTrace();
                    }
                }
            }
            e(str, str5, str3, interfaceC0700b);
        }
    }
}
