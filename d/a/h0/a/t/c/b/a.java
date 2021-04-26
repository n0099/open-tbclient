package d.a.h0.a.t.c.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.h0.a.r1.e;
import d.a.h0.a.t.b.d;
import d.a.h0.a.t1.k.p0.g;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.h0.a.t.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0768a implements d.b {
        public C0768a() {
        }

        @Override // d.a.h0.a.t.b.d.b
        public d.a.h0.a.t.e.b a(e eVar, JSONObject jSONObject, @Nullable String str) {
            String optString = jSONObject.optString("root");
            if (!TextUtils.isEmpty(optString)) {
                a.this.t(eVar, optString, str);
                return new d.a.h0.a.t.e.b(0);
            }
            d.a.h0.a.c0.c.b("Api-LoadSubPackage", "subPackage root is null");
            return new d.a.h0.a.t.e.b(202);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f44041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44043g;

        public b(e eVar, String str, String str2) {
            this.f44041e = eVar;
            this.f44042f = str;
            this.f44043g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f44041e.h0(this.f44042f) && this.f44041e.g0(this.f44042f)) {
                d.a.h0.a.c0.c.g("Api-LoadSubPackage", "subPackage have existed");
                a.this.c(this.f44043g, new d.a.h0.a.t.e.b(1001, "subPackage have existed"));
                return;
            }
            String E = this.f44041e.E(this.f44042f);
            if (!TextUtils.isEmpty(E)) {
                a.this.s(this.f44041e, this.f44042f, E, this.f44043g);
                return;
            }
            d.a.h0.a.c0.c.g("Api-LoadSubPackage", "subPackage cannot find aps key");
            a.this.c(this.f44043g, new d.a.h0.a.t.e.b(202));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44045a;

        public c(String str) {
            this.f44045a = str;
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void a(String str) {
            d.a.h0.a.c0.c.g("Api-LoadSubPackage", "preload subPackage success");
            a.this.c(this.f44045a, new d.a.h0.a.t.e.b(0, "preload subPackage success"));
        }

        @Override // d.a.h0.a.t1.k.p0.g.d
        public void b(int i2) {
            d.a.h0.a.c0.c.b("Api-LoadSubPackage", "preload subPackage failed");
            a.this.c(this.f44045a, new d.a.h0.a.t.e.b(202, "No SubPackage"));
        }
    }

    public a(@NonNull d.a.h0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void s(e eVar, String str, String str2, @Nullable String str3) {
        g.c(eVar.f43823f, eVar.W(), str, str2, null, new c(str3));
    }

    public final void t(e eVar, String str, @Nullable String str2) {
        ExecutorUtilsExt.postOnElastic(new b(eVar, str, str2), "doLoadSubPackageAsync", 2);
    }

    public d.a.h0.a.t.e.b u(String str) {
        if (d.f44021c) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return i(str, true, new C0768a());
    }
}
