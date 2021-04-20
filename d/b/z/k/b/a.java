package d.b.z.k.b;

import com.baidu.poly.util.HttpSigner;
import d.b.z.k.a.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f65626a = 1;

    /* renamed from: d.b.z.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C1798a extends d.b.z.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.l.a f65627a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f65628b;

        public C1798a(d.b.z.l.a aVar, JSONObject jSONObject) {
            this.f65627a = aVar;
            this.f65628b = jSONObject;
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            d.b.z.l.a aVar = this.f65627a;
            if (aVar != null) {
                aVar.a(1, str);
            }
            d.b.z.k.c.a.e(this.f65628b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.z.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.b.z.l.a aVar = this.f65627a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends d.b.z.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.l.a f65629a;

        public b(d.b.z.l.a aVar) {
            this.f65629a = aVar;
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            d.b.z.l.a aVar = this.f65629a;
            if (aVar != null) {
                aVar.a(1, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.z.k.a.a
        /* renamed from: c */
        public void a(String str) {
            d.b.z.l.a aVar = this.f65629a;
            if (aVar != null) {
                aVar.a(0, "");
            }
        }
    }

    public static final void a(JSONArray jSONArray, d.b.z.l.a aVar) {
        if (jSONArray == null) {
            return;
        }
        d.b.z.k.a.c cVar = new d.b.z.k.a.c();
        c.a(cVar);
        d.b.z.k.a.b bVar = new d.b.z.k.a.b();
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "params.toString()");
        bVar.e("batchData", jSONArray2);
        HttpSigner.b(bVar);
        new f(false).a(d.b(), cVar, bVar, new b(aVar));
    }

    public static final void b(JSONObject jSONObject, d.b.z.l.a aVar) {
        if (jSONObject == null) {
            return;
        }
        d.b.z.k.a.c cVar = new d.b.z.k.a.c();
        c.a(cVar);
        d.b.z.k.a.b c2 = c.c(jSONObject);
        c.b(cVar, c2.b("bduss"));
        HttpSigner.b(c2);
        new f(false).a(d.e(), cVar, c2, new C1798a(aVar, jSONObject));
    }

    public static final void c(int i) {
        f65626a = i;
    }

    public static final int d() {
        return f65626a;
    }
}
