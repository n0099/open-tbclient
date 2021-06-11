package d.a.l0.a.a2.n;

import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44458a = k.f46875a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: e  reason: collision with root package name */
        public static final f<a> f44459e = new C0622a();

        /* renamed from: f  reason: collision with root package name */
        public static final e<a> f44460f = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f44461a;

        /* renamed from: b  reason: collision with root package name */
        public int f44462b;

        /* renamed from: c  reason: collision with root package name */
        public int f44463c;

        /* renamed from: d  reason: collision with root package name */
        public int f44464d;

        /* renamed from: d.a.l0.a.a2.n.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0622a extends f<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.a2.n.f
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull d.a.l0.a.b1.d dVar) throws Exception {
                dVar.writeInt(aVar.f44461a);
                dVar.writeInt(aVar.f44462b);
                dVar.writeInt(aVar.f44463c);
                dVar.writeInt(aVar.f44464d);
            }
        }

        /* loaded from: classes3.dex */
        public static class b extends e<a> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.a2.n.e
            /* renamed from: c */
            public a b(@NonNull d.a.l0.a.b1.c cVar) throws Exception {
                a aVar = new a();
                aVar.f44461a = cVar.readInt();
                aVar.f44462b = cVar.readInt();
                aVar.f44463c = cVar.readInt();
                aVar.f44464d = cVar.readInt();
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
            aVar.f44462b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f44461a = optJSONObject.optInt("request", c());
            aVar.f44462b = optJSONObject.optInt("connectSocket", 60000);
            aVar.f44463c = optJSONObject.optInt("uploadFile");
            aVar.f44464d = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (c.f44458a) {
                Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
            }
            a aVar = new a();
            aVar.f44461a = 60000;
            aVar.f44462b = 60000;
            return aVar;
        }

        public static int c() {
            return d.a.l0.a.c1.a.Z().u();
        }

        public static int d(a aVar) {
            return aVar != null && aVar.f44461a > 0 ? aVar.f44461a : c();
        }
    }
}
