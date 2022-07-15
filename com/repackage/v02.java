package com.repackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br2;
/* loaded from: classes7.dex */
public final class v02 extends q02<u02> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final br2 a;
    public final cr2 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u02 a;
        public final /* synthetic */ v02 b;

        public a(v02 v02Var, u02 u02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v02Var, u02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v02Var;
            this.a = u02Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = yd3.p()) == null) {
                return;
            }
            Message.obtain(this.b, 2, u02.a(this.a.b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755285063, "Lcom/repackage/v02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755285063, "Lcom/repackage/v02;");
                return;
            }
        }
        c = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v02(Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = br2.a.a("simple_parser");
        this.b = (cr2) br2.a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.q02
    /* renamed from: c */
    public void a(u02 u02Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u02Var) == null) || u02Var == null) {
            return;
        }
        if (!e(u02Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + u02Var.b);
                return;
            }
            return;
        }
        f(u02Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.q02
    /* renamed from: d */
    public void b(u02 u02Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, u02Var) == null) || u02Var == null) {
            return;
        }
        if (!e(u02Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + u02Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = u02Var.d;
        pz1 f = qq2.f();
        View B = ul2.U().B(u02Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = qq2.b(bitmap, f, B);
            this.a.c(qq2.d(f));
            if (!qq2.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                h12 h12Var = new h12();
                h12Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                h12Var.d(u02Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            h12 h12Var2 = new h12();
            if (qq2.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                h12Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                h12Var2.d(u02Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                h12Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                h12Var2.d(u02Var.b);
            } else {
                w02.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? TextUtils.equals(be3.B(), str) : invokeL.booleanValue;
    }

    public final void f(u02 u02Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, u02Var) == null) || u02Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        be3.e0(new a(this, u02Var));
    }
}
