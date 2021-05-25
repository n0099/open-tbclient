package d.a.l0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.l0.a.f1.e.b;
import d.a.l0.a.p.d.e0;
import d.a.l0.a.v2.q;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43169a = d.a.l0.a.k.f43199a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f43170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f43171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43172g;

        public a(HashMap hashMap, File file, String str) {
            this.f43170e = hashMap;
            this.f43171f = file;
            this.f43172g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 t = d.a.l0.a.c1.a.t();
            if (t != null) {
                t.a(this.f43170e, this.f43171f, null, "error_js");
                if (l.f43169a) {
                    Log.d("V8StabilityHelper", "extraData :" + this.f43170e.toString());
                    Log.d("V8StabilityHelper", "filePath :" + this.f43172g);
                }
            }
        }
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        if (v8ExceptionInfo == null) {
            if (f43169a) {
                Log.d("V8StabilityHelper", "empty exceptionInfo");
                return;
            }
            return;
        }
        c(v8ExceptionInfo);
        d(v8ExceptionInfo);
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.l0.a.c1.a.Z().C()) {
            if (f43169a) {
                Log.d("V8StabilityHelper", "stability switch off");
                return;
            }
            return;
        }
        d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
        b.a N = i2 != null ? i2.N() : null;
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(37L);
        d.a.l0.a.j2.p.d dVar = new d.a.l0.a.j2.p.d();
        dVar.p(aVar);
        dVar.r(N);
        dVar.q(k.m(d.a.l0.a.a2.d.g().l()));
        dVar.m(d.a.l0.a.a2.e.V());
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
            if (f43169a) {
                e2.printStackTrace();
            }
        }
        k.L(dVar);
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        if (!d.a.l0.a.c1.a.Z().J()) {
            if (f43169a) {
                Log.d("V8StabilityHelper", "upload js switch off");
            }
        } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
        } else {
            String str = v8ExceptionInfo.filePath;
            if (str.startsWith("script:")) {
                if (f43169a) {
                    Log.d("V8StabilityHelper", "file path start with js code prefix");
                    return;
                }
                return;
            }
            SwanCoreVersion e2 = d.a.l0.a.m2.b.e(d.a.l0.a.a2.d.g().l());
            if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                return;
            }
            if (!str.startsWith(e2.swanCorePath)) {
                if (f43169a) {
                    Log.d("V8StabilityHelper", "file path is not swan core path");
                    return;
                }
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                HashMap hashMap = new HashMap();
                d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
                if (!TextUtils.isEmpty(d.a.l0.a.a2.e.V())) {
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.l0.a.a2.e.V());
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
