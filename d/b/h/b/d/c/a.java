package d.b.h.b.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f49473e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f49474f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f49475a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f49476b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f49477c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49478d;

    public final void a() {
        if (this.f49477c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f49477c.toString());
            this.f49477c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f49476b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49476b = jSONObject;
                jSONObject.put("type", f49473e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49476b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f49477c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49477c = jSONObject;
                jSONObject.put("type", f49474f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49477c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
