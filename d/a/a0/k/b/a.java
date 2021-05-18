package d.a.a0.k.b;

import com.baidu.poly.util.HttpSigner;
import d.a.a0.k.a.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f38351a = 1;

    /* renamed from: d.a.a0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0476a extends d.a.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.l.a f38352a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f38353b;

        public C0476a(d.a.a0.l.a aVar, JSONObject jSONObject) {
            this.f38352a = aVar;
            this.f38353b = jSONObject;
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            d.a.a0.l.a aVar = this.f38352a;
            if (aVar != null) {
                aVar.a(1, str);
            }
            d.a.a0.k.c.a.e(this.f38353b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.a.a0.l.a aVar = this.f38352a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends d.a.a0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.a0.l.a f38354a;

        public b(d.a.a0.l.a aVar) {
            this.f38354a = aVar;
        }

        @Override // d.a.a0.k.a.a
        public void b(Throwable th, String str) {
            d.a.a0.l.a aVar = this.f38354a;
            if (aVar != null) {
                aVar.a(1, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.a.a0.l.a aVar = this.f38354a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    public static final void a(JSONArray jSONArray, d.a.a0.l.a aVar) {
        if (jSONArray == null) {
            return;
        }
        d.a.a0.k.a.c cVar = new d.a.a0.k.a.c();
        c.a(cVar);
        d.a.a0.k.a.b bVar = new d.a.a0.k.a.b();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        bVar.e("batchData", jSONArray2);
        HttpSigner.b(bVar);
        new f(false).a(d.b(), cVar, bVar, new b(aVar));
    }

    public static final void b(JSONObject jSONObject, d.a.a0.l.a aVar) {
        if (jSONObject == null) {
            return;
        }
        d.a.a0.k.a.c cVar = new d.a.a0.k.a.c();
        c.a(cVar);
        d.a.a0.k.a.b c2 = c.c(jSONObject);
        c.b(cVar, c2.b("bduss"));
        HttpSigner.b(c2);
        new f(false).a(d.e(), cVar, c2, new C0476a(aVar, jSONObject));
    }

    public static final void c(int i2) {
        f38351a = i2;
    }

    public static final int d() {
        return f38351a;
    }
}
