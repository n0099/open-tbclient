package d.a.h.b.d.c;

import android.text.TextUtils;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static int f41049e = 12323;

    /* renamed from: f  reason: collision with root package name */
    public static int f41050f = 12324;

    /* renamed from: a  reason: collision with root package name */
    public b f41051a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f41052b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f41053c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41054d;

    public final void a() {
        if (this.f41053c != null) {
            SessionMonitorEngine.getInstance().recordImmediately(ZeusPerformanceTiming.SERVER_TYPE_T7_INIT, this.f41053c.toString());
            this.f41053c = null;
        }
    }

    public final void b(String str, String str2) {
        try {
            if (this.f41052b == null) {
                JSONObject jSONObject = new JSONObject();
                this.f41052b = jSONObject;
                jSONObject.put("type", f41049e);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f41052b.put(str, str2);
        } catch (Exception unused) {
            Log.e("staticWebkitInit JSON error");
        }
    }

    public final void c(String str, String str2) {
        try {
            if (this.f41053c == null) {
                JSONObject jSONObject = new JSONObject();
                this.f41053c = jSONObject;
                jSONObject.put("type", f41050f);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.f41053c.put(str, str2);
        } catch (Exception unused) {
            Log.e("mWebkitDownloadStatics JSON error");
        }
    }
}
