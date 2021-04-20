package d.b.h.b.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f49865e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f49866f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f49867a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f49868b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f49869c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49870d;

    public final void a() {
        if (this.f49869c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f49869c.toString());
            this.f49869c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f49868b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49868b = jSONObject;
                jSONObject.put("type", f49865e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49868b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f49869c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49869c = jSONObject;
                jSONObject.put("type", f49866f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49869c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
