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
import com.repackage.or2;
/* loaded from: classes6.dex */
public final class i12 extends d12<h12> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final or2 a;
    public final pr2 b;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h12 a;
        public final /* synthetic */ i12 b;

        public a(i12 i12Var, h12 h12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i12Var, h12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i12Var;
            this.a = h12Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = le3.p()) == null) {
                return;
            }
            Message.obtain(this.b, 2, h12.a(this.a.b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755671385, "Lcom/repackage/i12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755671385, "Lcom/repackage/i12;");
                return;
            }
        }
        c = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i12(Looper looper) {
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
        this.a = or2.a.a("simple_parser");
        this.b = (pr2) or2.a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d12
    /* renamed from: c */
    public void a(h12 h12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, h12Var) == null) || h12Var == null) {
            return;
        }
        if (!e(h12Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + h12Var.b);
                return;
            }
            return;
        }
        f(h12Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.d12
    /* renamed from: d */
    public void b(h12 h12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, h12Var) == null) || h12Var == null) {
            return;
        }
        if (!e(h12Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + h12Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = h12Var.d;
        c02 f = dr2.f();
        View B = hm2.U().B(h12Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = dr2.b(bitmap, f, B);
            this.a.c(dr2.d(f));
            if (!dr2.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                u12 u12Var = new u12();
                u12Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                u12Var.d(h12Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            u12 u12Var2 = new u12();
            if (dr2.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                u12Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                u12Var2.d(h12Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                u12Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                u12Var2.d(h12Var.b);
            } else {
                j12.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? TextUtils.equals(oe3.B(), str) : invokeL.booleanValue;
    }

    public final void f(h12 h12Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, h12Var) == null) || h12Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        oe3.e0(new a(this, h12Var));
    }
}
