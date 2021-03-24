package d.b.g0.a.r1.n;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45767a = k.f45050a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f45768a;

        /* renamed from: b  reason: collision with root package name */
        public int f45769b;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return b();
            }
            a aVar = new a();
            aVar.f45768a = optJSONObject.optInt("request", d.b.g0.a.w0.a.N().K());
            aVar.f45769b = optJSONObject.optInt("connectSocket", 60000);
            optJSONObject.optInt("uploadFile");
            optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (b.f45767a) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f45768a = 60000;
            aVar.f45769b = 60000;
            return aVar;
        }
    }
}
