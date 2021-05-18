package d.a.i0.a.u.e.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.c2.f.p0.g;
import d.a.i0.a.u.c.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.i0.a.u.c.d {

    /* renamed from: d.a.i0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0822a implements d.b {
        public C0822a() {
        }

        @Override // d.a.i0.a.u.c.d.b
        public d.a.i0.a.u.h.b a(d.a.i0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            if (!TextUtils.isEmpty(optString)) {
                a.this.x(eVar, optString, str);
                return new d.a.i0.a.u.h.b(0);
            }
            d.a.i0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
            return new d.a.i0.a.u.h.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b {
        public b() {
        }

        @Override // d.a.i0.a.u.c.d.b
        public d.a.i0.a.u.h.b a(d.a.i0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            JSONArray optJSONArray = jSONObject.optJSONArray("roots");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                a.this.v(eVar, str, optJSONArray);
                return new d.a.i0.a.u.h.b(0);
            }
            return new d.a.i0.a.u.h.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44666f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44667g;

        /* renamed from: d.a.i0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0823a implements g.d {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f44669a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f44670b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f44671c;

            public C0823a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                this.f44669a = countDownLatch;
                this.f44670b = list;
                this.f44671c = str;
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void a(String str) {
                this.f44669a.countDown();
                this.f44670b.add(this.f44671c);
            }

            @Override // d.a.i0.a.c2.f.p0.g.d
            public void b(int i2) {
                this.f44669a.countDown();
                d.a.i0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
            }
        }

        public c(d.a.i0.a.a2.e eVar, String str, JSONArray jSONArray) {
            this.f44665e = eVar;
            this.f44666f = str;
            this.f44667g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            String Z = this.f44665e.Z();
            if (!TextUtils.isDigitsOnly(Z)) {
                a aVar = a.this;
                String str = this.f44666f;
                aVar.d(str, new d.a.i0.a.u.h.b(202, "current version error:" + Z));
                return;
            }
            List<d.a.i0.n.h.g> j = d.a.i0.n.g.a.h().j(this.f44665e.f40575f, Integer.parseInt(Z));
            ArraySet<String> arraySet = new ArraySet();
            List synchronizedList = Collections.synchronizedList(new ArrayList());
            for (int i2 = 0; i2 < this.f44667g.length(); i2++) {
                String optString = this.f44667g.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    if (a.y(optString, j) && this.f44665e.k0(optString)) {
                        synchronizedList.add(optString);
                    } else {
                        arraySet.add(optString);
                    }
                }
            }
            if (!arraySet.isEmpty()) {
                CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                for (String str2 : arraySet) {
                    String G = this.f44665e.G(str2);
                    if (TextUtils.isEmpty(G)) {
                        countDownLatch.countDown();
                    } else {
                        d.a.i0.a.a2.e eVar = this.f44665e;
                        g.k(eVar.f40575f, eVar.Z(), "1", str2, G, null, new C0823a(this, countDownLatch, synchronizedList, str2));
                    }
                }
                try {
                    countDownLatch.await(1L, TimeUnit.MINUTES);
                } catch (InterruptedException e2) {
                    d.a.i0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (int i3 = 0; i3 < this.f44667g.length(); i3++) {
                try {
                    jSONObject.put(this.f44667g.optString(i3), synchronizedList.contains(this.f44667g.optString(i3)) ? 0 : 1001);
                } catch (Exception e3) {
                    if (d.a.i0.a.u.c.d.f44636c) {
                        e3.printStackTrace();
                    }
                }
            }
            a.this.d(this.f44666f, new d.a.i0.a.u.h.b(0, jSONObject));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44674g;

        public d(d.a.i0.a.a2.e eVar, String str, String str2) {
            this.f44672e = eVar;
            this.f44673f = str;
            this.f44674g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44672e.l0(this.f44673f) && this.f44672e.k0(this.f44673f)) {
                d.a.i0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                a.this.d(this.f44674g, new d.a.i0.a.u.h.b(1001, "subPackage have existed"));
                return;
            }
            String G = this.f44672e.G(this.f44673f);
            if (!TextUtils.isEmpty(G)) {
                a.this.w(this.f44672e, this.f44673f, G, this.f44674g);
                return;
            }
            d.a.i0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
            a.this.d(this.f44674g, new d.a.i0.a.u.h.b(202));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44676a;

        public e(String str) {
            this.f44676a = str;
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.i0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
            a.this.d(this.f44676a, new d.a.i0.a.u.h.b(0, "preload subPackage success"));
        }

        @Override // d.a.i0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.i0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
            a.this.d(this.f44676a, new d.a.i0.a.u.h.b(202, "No SubPackage"));
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public static boolean y(@Nullable String str, @Nullable List<d.a.i0.n.h.g> list) {
        if (str != null && list != null && !list.isEmpty()) {
            for (d.a.i0.n.h.g gVar : list) {
                if (gVar != null && TextUtils.equals(gVar.p, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public d.a.i0.a.u.h.b A(String str) {
        return j(str, true, new b());
    }

    public final void v(d.a.i0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        ExecutorUtilsExt.postOnElastic(new c(eVar, str, jSONArray), "Api-LoadSubPackage", 2);
    }

    public final void w(d.a.i0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        g.k(eVar.f40575f, eVar.Z(), "1", str, str2, null, new e(str3));
    }

    public final void x(d.a.i0.a.a2.e eVar, String str, @Nullable String str2) {
        ExecutorUtilsExt.postOnElastic(new d(eVar, str, str2), "doLoadSubPackageAsync", 2);
    }

    public d.a.i0.a.u.h.b z(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return j(str, true, new C0822a());
    }
}
