package d.b.h0.a.t.c.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.b.d;
import d.b.h0.a.t1.k.p0.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.h0.a.t.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0829a implements d.b {
        public C0829a() {
        }

        @Override // d.b.h0.a.t.b.d.b
        public d.b.h0.a.t.e.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("root");
            if (!TextUtils.isEmpty(optString)) {
                a.this.t(eVar, optString, str);
                return new d.b.h0.a.t.e.b(0);
            }
            d.b.h0.a.c0.c.b("Api-LoadSubPackage", "subPackage root is null");
            return new d.b.h0.a.t.e.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46670f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46671g;

        public b(e eVar, String str, String str2) {
            this.f46669e = eVar;
            this.f46670f = str;
            this.f46671g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f46669e.h0(this.f46670f) && this.f46669e.g0(this.f46670f)) {
                d.b.h0.a.c0.c.g("Api-LoadSubPackage", "subPackage have existed");
                a.this.c(this.f46671g, new d.b.h0.a.t.e.b(1001, "subPackage have existed"));
                return;
            }
            String E = this.f46669e.E(this.f46670f);
            if (!TextUtils.isEmpty(E)) {
                a.this.s(this.f46669e, this.f46670f, E, this.f46671g);
                return;
            }
            d.b.h0.a.c0.c.g("Api-LoadSubPackage", "subPackage cannot find aps key");
            a.this.c(this.f46671g, new d.b.h0.a.t.e.b(202));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46673a;

        public c(String str) {
            this.f46673a = str;
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.h0.a.c0.c.g("Api-LoadSubPackage", "preload subPackage success");
            a.this.c(this.f46673a, new d.b.h0.a.t.e.b(0, "preload subPackage success"));
        }

        @Override // d.b.h0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.h0.a.c0.c.b("Api-LoadSubPackage", "preload subPackage failed");
            a.this.c(this.f46673a, new d.b.h0.a.t.e.b(202, "No SubPackage"));
        }
    }

    public a(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void s(e eVar, String str, String str2, @Nullable String str3) {
        g.c(eVar.f46461f, eVar.W(), str, str2, null, new c(str3));
    }

    public final void t(e eVar, String str, @Nullable String str2) {
        ExecutorUtilsExt.postOnElastic(new b(eVar, str, str2), "doLoadSubPackageAsync", 2);
    }

    public d.b.h0.a.t.e.b u(String str) {
        if (d.f46650c) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return i(str, true, new C0829a());
    }
}
