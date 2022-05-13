package com.repackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c53;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static a53 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements a53 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.a53
        public void a(c53.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                b53.e(dVar);
                if (!y43.c()) {
                    b53.i(dVar);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements nf3<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c53.d a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap decodeFile;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (bd3.a()) {
                        decodeFile = sd3.e(this.a.a.b);
                    } else {
                        decodeFile = BitmapFactory.decodeFile(this.a.a.a);
                    }
                    File k = sd3.k("screenshot.jpg");
                    if (decodeFile != null) {
                        sd3.o(decodeFile, k.getAbsolutePath(), 20);
                    }
                    String h = hm2.U().G().h(k.getAbsolutePath());
                    if (!k.exists()) {
                        h = "";
                    }
                    b53.f(h);
                    if (b53.a) {
                        Log.d("SwanAppScreenshot", "saveScreenshot:" + TextUtils.isEmpty(h) + ",path:" + k.getAbsolutePath());
                    }
                }
            }
        }

        public b(c53.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (!bool.booleanValue()) {
                    b53.f("");
                } else {
                    od3.k(new a(this), "dispatchCaptureScreenEvent");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755876047, "Lcom/repackage/b53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755876047, "Lcom/repackage/b53;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void e(c53.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, dVar) == null) {
            y43.b(new b(dVar));
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                ud3.f(jSONObject, "imagePath", str);
            }
            hashMap.put("data", jSONObject.toString());
            hm2.U().u(new va2("onUserCaptureScreen", hashMap));
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            c53.s(bk2.c());
            if (a) {
                Log.d("SwanAppScreenshot", "registerScreenshotEvent.");
            }
            if (b == null) {
                b = new a();
            }
            c53.r(b);
        }
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            y43.d();
        }
    }

    public static void i(c53.d dVar) {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, dVar) == null) || (activity = hm2.U().getActivity()) == null) {
            return;
        }
        bk2.f0().b(activity, dVar.a, dVar.b);
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            if (a) {
                Log.d("SwanAppScreenshot", "unRegisterScreenshotEvent.");
            }
            a53 a53Var = b;
            if (a53Var != null) {
                c53.u(a53Var);
                b = null;
            }
        }
    }
}
