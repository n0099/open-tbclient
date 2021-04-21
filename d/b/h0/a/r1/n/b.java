package d.b.h0.a.r1.n;

import android.util.Log;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46489a = k.f45772a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f46490a;

        /* renamed from: b  reason: collision with root package name */
        public int f46491b;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return b();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return b();
            }
            a aVar = new a();
            aVar.f46490a = optJSONObject.optInt("request", d.b.h0.a.w0.a.N().K());
            aVar.f46491b = optJSONObject.optInt("connectSocket", 60000);
            optJSONObject.optInt("uploadFile");
            optJSONObject.optInt("downloadFile");
            return aVar;
        }

        public static a b() {
            if (b.f46489a) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.f46490a = 60000;
            aVar.f46491b = 60000;
            return aVar;
        }
    }
}
