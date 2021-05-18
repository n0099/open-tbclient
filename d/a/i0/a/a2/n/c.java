package d.a.i0.a.a2.n;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40608a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f40609e = new C0555a();

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f40610f = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f40611a;

        /* renamed from: b  reason: collision with root package name */
        public int f40612b;

        /* renamed from: c  reason: collision with root package name */
        public int f40613c;

        /* renamed from: d  reason: collision with root package name */
        public int f40614d;

        /* renamed from: d.a.i0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0555a extends f<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull d.a.i0.a.b1.d dVar) throws Exception {
                dVar.writeInt(aVar.f40611a);
                dVar.writeInt(aVar.f40612b);
                dVar.writeInt(aVar.f40613c);
                dVar.writeInt(aVar.f40614d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends e<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.a.a2.n.e
            /* renamed from: c */
            public a b(@NonNull d.a.i0.a.b1.c cVar) throws Exception {
                a aVar = new a();
                aVar.f40611a = cVar.readInt();
                aVar.f40612b = cVar.readInt();
                aVar.f40613c = cVar.readInt();
                aVar.f40614d = cVar.readInt();
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
            aVar.f40612b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f40611a = optJSONObject.optInt("request", c());
            aVar.f40612b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f40613c = optJSONObject.optInt("uploadFile");
            aVar.f40614d = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (c.f40608a) {
                Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
            }
            a aVar = new a();
            aVar.f40611a = 60000;
            aVar.f40612b = 60000;
            return aVar;
        }

        public static int c() {
            return d.a.i0.a.c1.a.Z().u();
        }

        public static int d(a aVar) {
            return aVar != null && aVar.f40611a > 0 ? aVar.f40611a : c();
        }
    }
}
