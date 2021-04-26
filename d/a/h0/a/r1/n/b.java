package d.a.h0.a.r1.n;

import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43853a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f43854a;

        /* renamed from: b  reason: collision with root package name */
        public int f43855b;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return b();
            }
            a aVar = new a();
            aVar.f43854a = optJSONObject.optInt("request", d.a.h0.a.w0.a.N().w());
            aVar.f43855b = optJSONObject.optInt("connectSocket", 60000);
            optJSONObject.optInt("uploadFile");
            optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (b.f43853a) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f43854a = 60000;
            aVar.f43855b = 60000;
            return aVar;
        }
    }
}
