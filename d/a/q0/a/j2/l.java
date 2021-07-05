package d.a.q0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.p.d.e0;
import d.a.q0.a.v2.q;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49103a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f49104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f49105f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f49106g;

        public a(HashMap hashMap, File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hashMap, file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49104e = hashMap;
            this.f49105f = file;
            this.f49106g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t = d.a.q0.a.c1.a.t()) == null) {
                return;
            }
            t.a(this.f49104e, this.f49105f, null, "error_js");
            if (l.f49103a) {
                Log.d("V8StabilityHelper", "extraData :" + this.f49104e.toString());
                Log.d("V8StabilityHelper", "filePath :" + this.f49106g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(118841821, "Ld/a/q0/a/j2/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(118841821, "Ld/a/q0/a/j2/l;");
                return;
            }
        }
        f49103a = d.a.q0.a.k.f49133a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                if (f49103a) {
                    Log.d("V8StabilityHelper", "empty exceptionInfo");
                    return;
                }
                return;
            }
            c(v8ExceptionInfo);
            d(v8ExceptionInfo);
        }
    }

    public static void c(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, v8ExceptionInfo) == null) {
            if (!d.a.q0.a.c1.a.Z().C()) {
                if (f49103a) {
                    Log.d("V8StabilityHelper", "stability switch off");
                    return;
                }
                return;
            }
            d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
            b.a N = i2 != null ? i2.N() : null;
            d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
            aVar.j(5L);
            aVar.h(37L);
            d.a.q0.a.j2.p.d dVar = new d.a.q0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(N);
            dVar.q(k.m(d.a.q0.a.a2.d.g().l()));
            dVar.m(d.a.q0.a.a2.e.V());
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
                if (f49103a) {
                    e2.printStackTrace();
                }
            }
            k.L(dVar);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, v8ExceptionInfo) == null) {
            if (!d.a.q0.a.c1.a.Z().J()) {
                if (f49103a) {
                    Log.d("V8StabilityHelper", "upload js switch off");
                }
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    if (f49103a) {
                        Log.d("V8StabilityHelper", "file path start with js code prefix");
                        return;
                    }
                    return;
                }
                SwanCoreVersion e2 = d.a.q0.a.m2.b.e(d.a.q0.a.a2.d.g().l());
                if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                    return;
                }
                if (!str.startsWith(e2.swanCorePath)) {
                    if (f49103a) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
                    if (!TextUtils.isEmpty(d.a.q0.a.a2.e.V())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.q0.a.a2.e.V());
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
}
