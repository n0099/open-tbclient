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
import com.repackage.bq2;
/* loaded from: classes7.dex */
public final class vz1 extends qz1<uz1> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final bq2 a;
    public final cq2 b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz1 a;
        public final /* synthetic */ vz1 b;

        public a(vz1 vz1Var, uz1 uz1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz1Var, uz1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vz1Var;
            this.a = uz1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap p;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (p = yc3.p()) == null) {
                return;
            }
            Message.obtain(this.b, 2, uz1.a(this.a.b, p)).sendToTarget();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755213980, "Lcom/repackage/vz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755213980, "Lcom/repackage/vz1;");
                return;
            }
        }
        c = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vz1(Looper looper) {
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
        this.a = bq2.a.a("simple_parser");
        this.b = (cq2) bq2.a.a("hsv_parser");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qz1
    /* renamed from: c */
    public void a(uz1 uz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uz1Var) == null) || uz1Var == null) {
            return;
        }
        if (!e(uz1Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to capture, page is not top, webViewId =" + uz1Var.b);
                return;
            }
            return;
        }
        f(uz1Var);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.qz1
    /* renamed from: d */
    public void b(uz1 uz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, uz1Var) == null) || uz1Var == null) {
            return;
        }
        if (!e(uz1Var.b)) {
            if (c) {
                Log.d("WhitePageHandler", ">> stop to parse capture, page is not top, webViewId = " + uz1Var.b);
                return;
            }
            return;
        }
        Bitmap bitmap = uz1Var.d;
        py1 f = qp2.f();
        View B = uk2.U().B(uz1Var.b);
        if (bitmap != null && f != null && B != null) {
            if (c) {
                Log.d("WhitePageHandler", ">> start parsing capture");
            }
            Rect b = qp2.b(bitmap, f, B);
            this.a.c(qp2.d(f));
            if (!qp2.h() && this.a.a(bitmap, b)) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is full white screen.");
                }
                h02 h02Var = new h02();
                h02Var.e(SceneType.SCENE_WHITE_SCREEN_L1);
                h02Var.d(uz1Var.b);
                return;
            }
            double d = this.b.d(bitmap, b);
            h02 h02Var2 = new h02();
            if (qp2.g() && d >= 0.5d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                h02Var2.e(SceneType.SCENE_WHITE_SCREEN_L3);
                h02Var2.d(uz1Var.b);
            } else if (d >= 0.7d) {
                if (c) {
                    Log.d("WhitePageHandler", ">> capture is part white screen ratio: " + d);
                }
                h02Var2.e(SceneType.SCENE_WHITE_SCREEN_L2);
                h02Var2.d(uz1Var.b);
            } else {
                wz1.b().a();
            }
        } else if (c) {
            Log.d("WhitePageHandler", ">> stop to parse capture, capture or fragment or webView is null.");
        }
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? TextUtils.equals(bd3.B(), str) : invokeL.booleanValue;
    }

    public final void f(uz1 uz1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, uz1Var) == null) || uz1Var == null) {
            return;
        }
        if (c) {
            Log.d("WhitePageHandler", ">> start to get capture.");
        }
        bd3.e0(new a(this, uz1Var));
    }
}
