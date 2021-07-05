package d.a.q0.a.d2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.d2.e;
import d.a.q0.a.g1.f;
import d.a.q0.a.k;
import d.a.q0.a.v2.q;
import d.a.q0.a.v2.u;
import d.a.q0.a.v2.w;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47257a;

    /* renamed from: b  reason: collision with root package name */
    public static c f47258b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.q0.a.d2.c
        public void a(e.C0714e c0714e) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0714e) == null) {
                d.e(c0714e);
                if (!d.a.q0.a.d2.a.c()) {
                    d.i(c0714e);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d.a.q0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e.C0714e f47259e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f47260e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47260e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (d.a.q0.a.v2.d.a()) {
                        decodeFile = u.e(this.f47260e.f47259e.f47279b);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(this.f47260e.f47259e.f47278a);
                    }
                    File k = u.k("screenshot.jpg");
                    if (decodeFile != null) {
                        u.o(decodeFile, k.getAbsolutePath(), 20);
                    }
                    String h2 = f.V().I().h(k.getAbsolutePath());
                    if (!k.exists()) {
                        h2 = "";
                    }
                    d.f(h2);
                    if (d.f47257a) {
                        Log.d("SwanAppScreenshot", "saveScreenshot:" + TextUtils.isEmpty(h2) + ",path:" + k.getAbsolutePath());
                    }
                }
            }
        }

        public b(e.C0714e c0714e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0714e};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47259e = c0714e;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (!bool.booleanValue()) {
                    d.f("");
                } else {
                    q.j(new a(this), "dispatchCaptureScreenEvent");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113300447, "Ld/a/q0/a/d2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(113300447, "Ld/a/q0/a/d2/d;");
                return;
            }
        }
        f47257a = k.f49133a;
    }

    public static void e(e.C0714e c0714e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, c0714e) == null) {
            d.a.q0.a.d2.a.b(new b(c0714e));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                w.f(jSONObject, "imagePath", str);
            }
            hashMap.put("data", jSONObject.toString());
            f.V().v(new d.a.q0.a.o0.d.b("onUserCaptureScreen", hashMap));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            e.s(d.a.q0.a.c1.a.b());
            if (f47257a) {
                Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
            }
            if (f47258b == null) {
                f47258b = new a();
            }
            e.r(f47258b);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            d.a.q0.a.d2.a.d();
        }
    }

    public static void i(e.C0714e c0714e) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, c0714e) == null) || (activity = f.V().getActivity()) == null) {
            return;
        }
        d.a.q0.a.c1.a.Y().b(activity, c0714e.f47278a, c0714e.f47279b);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (f47257a) {
                Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
            }
            c cVar = f47258b;
            if (cVar != null) {
                e.u(cVar);
                f47258b = null;
            }
        }
    }
}
