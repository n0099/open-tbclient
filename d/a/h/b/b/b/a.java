package d.a.h.b.b.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f39973e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f39974f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f39975a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f39976b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f39977c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39978d;

    public final void a() {
        if (this.f39977c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f39977c.toString());
            this.f39977c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f39976b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f39976b = jSONObject;
                jSONObject.put("type", f39973e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f39976b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f39977c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f39977c = jSONObject;
                jSONObject.put("type", f39974f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f39977c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
