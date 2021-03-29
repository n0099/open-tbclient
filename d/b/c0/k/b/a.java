package d.b.c0.k.b;

import com.baidu.poly.util.HttpSigner;
import d.b.c0.k.a.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f42558a = 1;

    /* renamed from: d.b.c0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0561a extends d.b.c0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.l.a f42559a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42560b;

        public C0561a(d.b.c0.l.a aVar, JSONObject jSONObject) {
            this.f42559a = aVar;
            this.f42560b = jSONObject;
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            d.b.c0.l.a aVar = this.f42559a;
            if (aVar != null) {
                aVar.a(1, str);
            }
            d.b.c0.k.c.a.e(this.f42560b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.b.c0.l.a aVar = this.f42559a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends d.b.c0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.l.a f42561a;

        public b(d.b.c0.l.a aVar) {
            this.f42561a = aVar;
        }

        @Override // d.b.c0.k.a.a
        public void b(Throwable th, String str) {
            d.b.c0.l.a aVar = this.f42561a;
            if (aVar != null) {
                aVar.a(1, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.b.c0.l.a aVar = this.f42561a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    public static final void a(JSONArray jSONArray, d.b.c0.l.a aVar) {
        if (jSONArray == null) {
            return;
        }
        d.b.c0.k.a.c cVar = new d.b.c0.k.a.c();
        c.a(cVar);
        d.b.c0.k.a.b bVar = new d.b.c0.k.a.b();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        bVar.e("batchData", jSONArray2);
        HttpSigner.b(bVar);
        new f(false).a(d.b(), cVar, bVar, new b(aVar));
    }

    public static final void b(JSONObject jSONObject, d.b.c0.l.a aVar) {
        if (jSONObject == null) {
            return;
        }
        d.b.c0.k.a.c cVar = new d.b.c0.k.a.c();
        c.a(cVar);
        d.b.c0.k.a.b c2 = c.c(jSONObject);
        c.b(cVar, c2.b("bduss"));
        HttpSigner.b(c2);
        new f(false).a(d.e(), cVar, c2, new C0561a(aVar, jSONObject));
    }

    public static final void c(int i) {
        f42558a = i;
    }

    public static final int d() {
        return f42558a;
    }
}
