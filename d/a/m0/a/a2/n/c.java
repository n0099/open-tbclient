package d.a.m0.a.a2.n;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44566a = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f44567e = new C0625a();

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f44568f = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f44569a;

        /* renamed from: b  reason: collision with root package name */
        public int f44570b;

        /* renamed from: c  reason: collision with root package name */
        public int f44571c;

        /* renamed from: d  reason: collision with root package name */
        public int f44572d;

        /* renamed from: d.a.m0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0625a extends f<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull d.a.m0.a.b1.d dVar) throws Exception {
                dVar.writeInt(aVar.f44569a);
                dVar.writeInt(aVar.f44570b);
                dVar.writeInt(aVar.f44571c);
                dVar.writeInt(aVar.f44572d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends e<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.a.a2.n.e
            /* renamed from: c */
            public a b(@NonNull d.a.m0.a.b1.c cVar) throws Exception {
                a aVar = new a();
                aVar.f44569a = cVar.readInt();
                aVar.f44570b = cVar.readInt();
                aVar.f44571c = cVar.readInt();
                aVar.f44572d = cVar.readInt();
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
            aVar.f44570b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f44569a = optJSONObject.optInt("request", c());
            aVar.f44570b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f44571c = optJSONObject.optInt("uploadFile");
            aVar.f44572d = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (c.f44566a) {
                Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
            }
            a aVar = new a();
            aVar.f44569a = 60000;
            aVar.f44570b = 60000;
            return aVar;
        }

        public static int c() {
            return d.a.m0.a.c1.a.Z().u();
        }

        public static int d(a aVar) {
            return aVar != null && aVar.f44569a > 0 ? aVar.f44569a : c();
        }
    }
}
