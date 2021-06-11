package d.a.l0.a.u.e.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.f.p0.g;
import d.a.l0.a.u.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.u.c.d {

    /* renamed from: d.a.l0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0889a implements d.b {
        public C0889a() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            if (!TextUtils.isEmpty(optString)) {
                a.this.x(eVar, optString, str);
                return new d.a.l0.a.u.h.b(0);
            }
            d.a.l0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
            return new d.a.l0.a.u.h.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.a.l0.a.u.c.d.b
        public d.a.l0.a.u.h.b a(d.a.l0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            JSONArray optJSONArray = jSONObject.optJSONArray("roots");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                a.this.v(eVar, str, optJSONArray);
                return new d.a.l0.a.u.h.b(0);
            }
            return new d.a.l0.a.u.h.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48516f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48517g;

        /* renamed from: d.a.l0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0890a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f48519a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f48520b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f48521c;

            public C0890a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                this.f48519a = countDownLatch;
                this.f48520b = list;
                this.f48521c = str;
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void a(String str) {
                this.f48519a.countDown();
                this.f48520b.add(this.f48521c);
            }

            @Override // d.a.l0.a.c2.f.p0.g.d
            public void b(int i2) {
                this.f48519a.countDown();
                d.a.l0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
            }
        }

        public c(d.a.l0.a.a2.e eVar, String str, JSONArray jSONArray) {
            this.f48515e = eVar;
            this.f48516f = str;
            this.f48517g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            String Z = this.f48515e.Z();
            if (!TextUtils.isDigitsOnly(Z)) {
                a aVar = a.this;
                String str = this.f48516f;
                aVar.d(str, new d.a.l0.a.u.h.b(202, "current version error:" + Z));
                return;
            }
            List<d.a.l0.n.h.g> j = d.a.l0.n.g.a.h().j(this.f48515e.f44425f, Integer.parseInt(Z));
            ArraySet<String> arraySet = new ArraySet();
            List synchronizedList = Collections.synchronizedList(new ArrayList());
            for (int i2 = 0; i2 < this.f48517g.length(); i2++) {
                String optString = this.f48517g.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    if (a.y(optString, j) && this.f48515e.k0(optString)) {
                        synchronizedList.add(optString);
                    } else {
                        arraySet.add(optString);
                    }
                }
            }
            if (!arraySet.isEmpty()) {
                CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                for (String str2 : arraySet) {
                    String G = this.f48515e.G(str2);
                    if (TextUtils.isEmpty(G)) {
                        countDownLatch.countDown();
                    } else {
                        d.a.l0.a.a2.e eVar = this.f48515e;
                        g.k(eVar.f44425f, eVar.Z(), "1", str2, G, null, new C0890a(this, countDownLatch, synchronizedList, str2));
                    }
                }
                try {
                    countDownLatch.await(1L, TimeUnit.MINUTES);
                } catch (InterruptedException e2) {
                    d.a.l0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < this.f48517g.length(); i3++) {
                try {
                    jSONObject.put(this.f48517g.optString(i3), synchronizedList.contains(this.f48517g.optString(i3)) ? 0 : 1001);
                } catch (Exception e3) {
                    if (d.a.l0.a.u.c.d.f48486c) {
                        e3.printStackTrace();
                    }
                }
            }
            a.this.d(this.f48516f, new d.a.l0.a.u.h.b(0, jSONObject));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f48522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48523f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48524g;

        public d(d.a.l0.a.a2.e eVar, String str, String str2) {
            this.f48522e = eVar;
            this.f48523f = str;
            this.f48524g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f48522e.l0(this.f48523f) && this.f48522e.k0(this.f48523f)) {
                d.a.l0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                a.this.d(this.f48524g, new d.a.l0.a.u.h.b(1001, "subPackage have existed"));
                return;
            }
            String G = this.f48522e.G(this.f48523f);
            if (!TextUtils.isEmpty(G)) {
                a.this.w(this.f48522e, this.f48523f, G, this.f48524g);
                return;
            }
            d.a.l0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
            a.this.d(this.f48524g, new d.a.l0.a.u.h.b(202));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48526a;

        public e(String str) {
            this.f48526a = str;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.l0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
            a.this.d(this.f48526a, new d.a.l0.a.u.h.b(0, "preload subPackage success"));
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.l0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
            a.this.d(this.f48526a, new d.a.l0.a.u.h.b(202, "No SubPackage"));
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public static boolean y(@Nullable String str, @Nullable List<d.a.l0.n.h.g> list) {
        if (str != null && list != null && !list.isEmpty()) {
            for (d.a.l0.n.h.g gVar : list) {
                if (gVar != null && TextUtils.equals(gVar.p, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public d.a.l0.a.u.h.b A(String str) {
        return j(str, true, new b());
    }

    public final void v(d.a.l0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        ExecutorUtilsExt.postOnElastic(new c(eVar, str, jSONArray), "Api-LoadSubPackage", 2);
    }

    public final void w(d.a.l0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        g.k(eVar.f44425f, eVar.Z(), "1", str, str2, null, new e(str3));
    }

    public final void x(d.a.l0.a.a2.e eVar, String str, @Nullable String str2) {
        ExecutorUtilsExt.postOnElastic(new d(eVar, str, str2), "doLoadSubPackageAsync", 2);
    }

    public d.a.l0.a.u.h.b z(String str) {
        if (d.a.l0.a.u.c.d.f48486c) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return j(str, true, new C0889a());
    }
}
