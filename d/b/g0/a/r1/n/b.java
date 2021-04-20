package d.b.g0.a.r1.n;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46160a = k.f45443a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f46161a;

        /* renamed from: b  reason: collision with root package name */
        public int f46162b;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return b();
            }
            a aVar = new a();
            aVar.f46161a = optJSONObject.optInt("request", d.b.g0.a.w0.a.N().K());
            aVar.f46162b = optJSONObject.optInt("connectSocket", 60000);
            optJSONObject.optInt("uploadFile");
            optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (b.f46160a) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f46161a = 60000;
            aVar.f46162b = 60000;
            return aVar;
        }
    }
}
