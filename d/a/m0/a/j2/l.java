package d.a.m0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.p.d.e0;
import d.a.m0.a.v2.q;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46953a = d.a.m0.a.k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f46954e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f46955f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46956g;

        public a(HashMap hashMap, File file, String str) {
            this.f46954e = hashMap;
            this.f46955f = file;
            this.f46956g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 t = d.a.m0.a.c1.a.t();
            if (t != null) {
                t.a(this.f46954e, this.f46955f, null, "error_js");
                if (l.f46953a) {
                    Log.d("V8StabilityHelper", "extraData :" + this.f46954e.toString());
                    Log.d("V8StabilityHelper", "filePath :" + this.f46956g);
                }
            }
        }
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            if (f46953a) {
                Log.d("V8StabilityHelper", "empty exceptionInfo");
                return;
            }
            return;
        }
        c(v8ExceptionInfo);
        d(v8ExceptionInfo);
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.m0.a.c1.a.Z().C()) {
            if (f46953a) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        b.a N = i2 != null ? i2.N() : null;
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(5L);
        aVar.h(37L);
        d.a.m0.a.j2.p.d dVar = new d.a.m0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(N);
        dVar.q(k.m(d.a.m0.a.a2.d.g().l()));
        dVar.m(d.a.m0.a.a2.e.V());
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
            if (f46953a) {
                e2.printStackTrace();
            }
        }
        k.L(dVar);
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.m0.a.c1.a.Z().J()) {
            if (f46953a) {
                Log.d("V8StabilityHelper", "upload js switch off");
            }
        } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
        } else {
            String str = v8ExceptionInfo.filePath;
            if (str.startsWith("script:")) {
                if (f46953a) {
                    Log.d("V8StabilityHelper", "file path start with js code prefix");
                    return;
                }
                return;
            }
            SwanCoreVersion e2 = d.a.m0.a.m2.b.e(d.a.m0.a.a2.d.g().l());
            if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                return;
            }
            if (!str.startsWith(e2.swanCorePath)) {
                if (f46953a) {
                    Log.d("V8StabilityHelper", "file path is not swan core path");
                    return;
                }
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                HashMap hashMap = new HashMap();
                d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
                if (!TextUtils.isEmpty(d.a.m0.a.a2.e.V())) {
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.m0.a.a2.e.V());
                }
                if (i2 != null && !TextUtils.isEmpty(i2.Z())) {
                    hashMap.put("appVersion", i2.Z());
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
                q.j(new a(hashMap, file, str), "error_js");
            }
        }
    }
}
