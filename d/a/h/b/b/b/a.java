package d.a.h.b.b.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f43654e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f43655f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f43656a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43657b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f43658c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43659d;

    public final void a() {
        if (this.f43658c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f43658c.toString());
            this.f43658c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f43657b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43657b = jSONObject;
                jSONObject.put("type", f43654e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43657b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f43658c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43658c = jSONObject;
                jSONObject.put("type", f43655f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43658c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
