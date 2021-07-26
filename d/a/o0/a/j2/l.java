package d.a.o0.a.j2;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
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
import d.a.o0.a.f1.e.b;
import d.a.o0.a.p.d.e0;
import d.a.o0.a.v2.q;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46305a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HashMap f46306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f46307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46308g;

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
            this.f46306e = hashMap;
            this.f46307f = file;
            this.f46308g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0 t;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t = d.a.o0.a.c1.a.t()) == null) {
                return;
            }
            t.a(this.f46306e, this.f46307f, null, "error_js");
            if (l.f46305a) {
                Log.d("V8StabilityHelper", "extraData :" + this.f46306e.toString());
                Log.d("V8StabilityHelper", "filePath :" + this.f46308g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(511868831, "Ld/a/o0/a/j2/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(511868831, "Ld/a/o0/a/j2/l;");
                return;
            }
        }
        f46305a = d.a.o0.a.k.f46335a;
    }

    public static void b(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v8ExceptionInfo) == null) {
            if (v8ExceptionInfo == null) {
                if (f46305a) {
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
            if (!d.a.o0.a.c1.a.Z().C()) {
                if (f46305a) {
                    Log.d("V8StabilityHelper", "stability switch off");
                    return;
                }
                return;
            }
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            b.a N = i2 != null ? i2.N() : null;
            d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
            aVar.j(5L);
            aVar.h(37L);
            d.a.o0.a.j2.p.d dVar = new d.a.o0.a.j2.p.d();
            dVar.p(aVar);
            dVar.r(N);
            dVar.q(k.m(d.a.o0.a.a2.d.g().l()));
            dVar.m(d.a.o0.a.a2.e.V());
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
                if (f46305a) {
                    e2.printStackTrace();
                }
            }
            k.L(dVar);
        }
    }

    public static void d(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8ExceptionInfo) == null) {
            if (!d.a.o0.a.c1.a.Z().J()) {
                if (f46305a) {
                    Log.d("V8StabilityHelper", "upload js switch off");
                }
            } else if (TextUtils.isEmpty(v8ExceptionInfo.filePath)) {
            } else {
                String str = v8ExceptionInfo.filePath;
                if (str.startsWith("script:")) {
                    if (f46305a) {
                        Log.d("V8StabilityHelper", "file path start with js code prefix");
                        return;
                    }
                    return;
                }
                SwanCoreVersion e2 = d.a.o0.a.m2.b.e(d.a.o0.a.a2.d.g().l());
                if (e2 == null || TextUtils.isEmpty(e2.swanCorePath)) {
                    return;
                }
                if (!str.startsWith(e2.swanCorePath)) {
                    if (f46305a) {
                        Log.d("V8StabilityHelper", "file path is not swan core path");
                        return;
                    }
                    return;
                }
                File file = new File(str);
                if (file.exists()) {
                    HashMap hashMap = new HashMap();
                    d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
                    if (!TextUtils.isEmpty(d.a.o0.a.a2.e.V())) {
                        hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, d.a.o0.a.a2.e.V());
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
