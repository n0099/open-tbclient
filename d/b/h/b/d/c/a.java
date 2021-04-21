package d.b.h.b.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f43792e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f43793f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f43794a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43795b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f43796c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43797d;

    public final void a() {
        if (this.f43796c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f43796c.toString());
            this.f43796c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f43795b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43795b = jSONObject;
                jSONObject.put("type", f43792e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43795b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f43796c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43796c = jSONObject;
                jSONObject.put("type", f43793f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43796c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
