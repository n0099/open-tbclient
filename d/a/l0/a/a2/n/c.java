package d.a.l0.a.a2.n;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40782a = k.f43199a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f40783e = new C0566a();

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f40784f = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f40785a;

        /* renamed from: b  reason: collision with root package name */
        public int f40786b;

        /* renamed from: c  reason: collision with root package name */
        public int f40787c;

        /* renamed from: d  reason: collision with root package name */
        public int f40788d;

        /* renamed from: d.a.l0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0566a extends f<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull d.a.l0.a.b1.d dVar) throws Exception {
                dVar.writeInt(aVar.f40785a);
                dVar.writeInt(aVar.f40786b);
                dVar.writeInt(aVar.f40787c);
                dVar.writeInt(aVar.f40788d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends e<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.a2.n.e
            /* renamed from: c */
            public a b(@NonNull d.a.l0.a.b1.c cVar) throws Exception {
                a aVar = new a();
                aVar.f40785a = cVar.readInt();
                aVar.f40786b = cVar.readInt();
                aVar.f40787c = cVar.readInt();
                aVar.f40788d = cVar.readInt();
                return aVar;
            }
        }

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return b();
            }
            a aVar = new a();
            aVar.f40786b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f40785a = optJSONObject.optInt("request", c());
            aVar.f40786b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f40787c = optJSONObject.optInt("uploadFile");
            aVar.f40788d = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (c.f40782a) {
                Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
            }
            a aVar = new a();
            aVar.f40785a = 60000;
            aVar.f40786b = 60000;
            return aVar;
        }

        public static int c() {
            return d.a.l0.a.c1.a.Z().u();
        }

        public static int d(a aVar) {
            return aVar != null && aVar.f40785a > 0 ? aVar.f40785a : c();
        }
    }
}
