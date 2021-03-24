package d.b.h.b.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f49472e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f49473f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f49474a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f49475b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f49476c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49477d;

    public final void a() {
        if (this.f49476c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f49476c.toString());
            this.f49476c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f49475b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49475b = jSONObject;
                jSONObject.put("type", f49472e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49475b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f49476c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f49476c = jSONObject;
                jSONObject.put("type", f49473f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f49476c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
