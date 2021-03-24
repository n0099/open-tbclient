package d.b.g0.a.t.c.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.t1.k.p0.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0796a implements d.b {
        public C0796a() {
        }

        @Override // d.b.g0.a.t.b.d.b
        public d.b.g0.a.t.e.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("root");
            if (!TextUtils.isEmpty(optString)) {
                a.this.t(eVar, optString, str);
                return new d.b.g0.a.t.e.b(0);
            }
            d.b.g0.a.c0.c.b("Api-LoadSubPackage", "subPackage root is null");
            return new d.b.g0.a.t.e.b(202);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f45947e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45949g;

        public b(e eVar, String str, String str2) {
            this.f45947e = eVar;
            this.f45948f = str;
            this.f45949g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f45947e.h0(this.f45948f) && this.f45947e.g0(this.f45948f)) {
                d.b.g0.a.c0.c.g("Api-LoadSubPackage", "subPackage have existed");
                a.this.c(this.f45949g, new d.b.g0.a.t.e.b(1001, "subPackage have existed"));
                return;
            }
            String E = this.f45947e.E(this.f45948f);
            if (!TextUtils.isEmpty(E)) {
                a.this.s(this.f45947e, this.f45948f, E, this.f45949g);
                return;
            }
            d.b.g0.a.c0.c.g("Api-LoadSubPackage", "subPackage cannot find aps key");
            a.this.c(this.f45949g, new d.b.g0.a.t.e.b(202));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45951a;

        public c(String str) {
            this.f45951a = str;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.c0.c.g("Api-LoadSubPackage", "preload subPackage success");
            a.this.c(this.f45951a, new d.b.g0.a.t.e.b(0, "preload subPackage success"));
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("Api-LoadSubPackage", "preload subPackage failed");
            a.this.c(this.f45951a, new d.b.g0.a.t.e.b(202, "No SubPackage"));
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void s(e eVar, String str, String str2, @Nullable String str3) {
        g.c(eVar.f45739f, eVar.W(), str, str2, null, new c(str3));
    }

    public final void t(e eVar, String str, @Nullable String str2) {
        ExecutorUtilsExt.postOnElastic(new b(eVar, str, str2), "doLoadSubPackageAsync", 2);
    }

    public d.b.g0.a.t.e.b u(String str) {
        if (d.f45928c) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return i(str, true, new C0796a());
    }
}
