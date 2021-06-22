package d.a.h.b.b.b;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f43719e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f43720f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f43721a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f43722b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f43723c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43724d;

    public final void a() {
        if (this.f43723c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f43723c.toString());
            this.f43723c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f43722b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43722b = jSONObject;
                jSONObject.put("type", f43719e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43722b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f43723c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f43723c = jSONObject;
                jSONObject.put("type", f43720f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f43723c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
