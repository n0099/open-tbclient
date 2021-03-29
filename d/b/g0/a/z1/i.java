package d.b.g0.a.z1;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.p.c.w;
import d.b.g0.a.y0.e.b;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47246a = k.f45051a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f47247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f47248f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47249g;

        public a(HashMap hashMap, File file, String str) {
            this.f47247e = hashMap;
            this.f47248f = file;
            this.f47249g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            w q = d.b.g0.a.w0.a.q();
            if (q != null) {
                q.a(this.f47247e, this.f47248f, null, "error_js");
                if (i.f47246a) {
                    Log.d("V8StabilityHelper", "extraData :" + this.f47247e.toString());
                    Log.d("V8StabilityHelper", "filePath :" + this.f47249g);
                }
            }
        }
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            if (f47246a) {
                Log.d("V8StabilityHelper", "empty exceptionInfo");
                return;
            }
            return;
        }
        c(v8ExceptionInfo);
        d(v8ExceptionInfo);
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.b.g0.a.w0.a.N().s()) {
            if (f47246a) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        b.a L = y != null ? y.L() : null;
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(5L);
        aVar.h(37L);
        d.b.g0.a.z1.k.d dVar = new d.b.g0.a.z1.k.d();
        dVar.p(aVar);
        dVar.r(L);
        dVar.q(h.n(d.b.g0.a.r1.d.e().h()));
        dVar.m(d.b.g0.a.r1.e.T());
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
            if (f47246a) {
                e2.printStackTrace();
            }
        }
        h.H(dVar);
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.b.g0.a.w0.a.N().M()) {
            if (f47246a) {
                Log.d("V8StabilityHelper", "upload js switch off");
            }
        } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
        } else {
            String str = v8ExceptionInfo.filePath;
            if (str.startsWith("script:")) {
                if (f47246a) {
                    Log.d("V8StabilityHelper", "file path start with js code prefix");
                    return;
                }
                return;
            }
            SwanCoreVersion d2 = d.b.g0.a.b2.b.d(d.b.g0.a.r1.d.e().h());
            if (d2 == null || TextUtils.isEmpty(d2.swanCorePath)) {
                return;
            }
            if (!str.startsWith(d2.swanCorePath)) {
                if (f47246a) {
                    Log.d("V8StabilityHelper", "file path is not swan core path");
                    return;
                }
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                HashMap hashMap = new HashMap();
                d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
                if (!TextUtils.isEmpty(d.b.g0.a.r1.e.T())) {
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.b.g0.a.r1.e.T());
                }
                if (y != null && !TextUtils.isEmpty(y.W())) {
                    hashMap.put("appVersion", y.W());
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
