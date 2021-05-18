package d.a.h.b.b.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f40289e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f40290f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f40291a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f40292b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f40293c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40294d;

    public final void a() {
        if (this.f40293c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f40293c.toString());
            this.f40293c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f40292b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f40292b = jSONObject;
                jSONObject.put("type", f40289e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f40292b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f40293c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f40293c = jSONObject;
                jSONObject.put("type", f40290f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f40293c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
