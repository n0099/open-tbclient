package d.a.h0.a.z1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.p.c.w;
import d.a.h0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45405a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f45406e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f45407f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45408g;

        public a(HashMap hashMap, File file, String str) {
            this.f45406e = hashMap;
            this.f45407f = file;
            this.f45408g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            w q = d.a.h0.a.w0.a.q();
            if (q != null) {
                q.a(this.f45406e, this.f45407f, null, "error_js");
                if (i.f45405a) {
                    Log.d("V8StabilityHelper", "extraData :" + this.f45406e.toString());
                    Log.d("V8StabilityHelper", "filePath :" + this.f45408g);
                }
            }
        }
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            if (f45405a) {
                Log.d("V8StabilityHelper", "empty exceptionInfo");
                return;
            }
            return;
        }
        c(v8ExceptionInfo);
        d(v8ExceptionInfo);
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.h0.a.w0.a.N().F()) {
            if (f45405a) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        b.a L = h2 != null ? h2.L() : null;
        d.a.h0.a.f2.a aVar = new d.a.h0.a.f2.a();
        aVar.j(5L);
        aVar.h(37L);
        d.a.h0.a.z1.k.d dVar = new d.a.h0.a.z1.k.d();
        dVar.p(aVar);
        dVar.r(L);
        dVar.q(h.n(d.a.h0.a.r1.d.e().j()));
        dVar.m(d.a.h0.a.r1.e.T());
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                jSONObject.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
            }
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                jSONObject.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
            }
            if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                jSONObject.put("exceptionType", v8ExceptionInfo.exceptionType);
            }
            dVar.e(jSONObject);
        } catch (JSONException e2) {
            if (f45405a) {
                e2.printStackTrace();
            }
        }
        h.H(dVar);
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.h0.a.w0.a.N().M()) {
            if (f45405a) {
                Log.d("V8StabilityHelper", "upload js switch off");
            }
        } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
        } else {
            String str = v8ExceptionInfo.filePath;
            if (str.startsWith("script:")) {
                if (f45405a) {
                    Log.d("V8StabilityHelper", "file path start with js code prefix");
                    return;
                }
                return;
            }
            SwanCoreVersion d2 = d.a.h0.a.b2.b.d(d.a.h0.a.r1.d.e().j());
            if (d2 == null || TextUtils.isEmpty(d2.swanCorePath)) {
                return;
            }
            if (!str.startsWith(d2.swanCorePath)) {
                if (f45405a) {
                    Log.d("V8StabilityHelper", "file path is not swan core path");
                    return;
                }
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                HashMap hashMap = new HashMap();
                d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
                if (!TextUtils.isEmpty(d.a.h0.a.r1.e.T())) {
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.h0.a.r1.e.T());
                }
                if (h2 != null && !TextUtils.isEmpty(h2.W())) {
                    hashMap.put("appVersion", h2.W());
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg)) {
                    hashMap.put("exceptionMsg", v8ExceptionInfo.exceptionMsg);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace)) {
                    hashMap.put("exceptionTrace", v8ExceptionInfo.exceptionTrace);
                }
                if (!TextUtils.isEmpty(v8ExceptionInfo.exceptionType)) {
                    hashMap.put("exceptionType", v8ExceptionInfo.exceptionType);
                }
                p.k(new a(hashMap, file, str), "error_js");
            }
        }
    }
}
