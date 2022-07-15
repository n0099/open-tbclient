package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zz2;
/* loaded from: classes7.dex */
public class xz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Context b;
    public WindowManager c;
    public volatile int d;
    public View e;
    public View f;
    public WindowManager.LayoutParams g;
    public Handler h;
    public Runnable i;
    public Runnable j;
    public zz2.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz2 a;

        public a(xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    if (this.a.e.getParent() != null) {
                        this.a.c.removeView(this.a.e);
                        if (this.a.k != null) {
                            this.a.k.onDismiss();
                            this.a.k = null;
                        }
                    }
                    this.a.e = null;
                }
                if (this.a.m != null) {
                    if (this.a.m.getParent() != null) {
                        this.a.c.removeView(this.a.m);
                    }
                    this.a.m = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz2 a;

        public b(xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.a.l) {
                    if (this.a.m != null && (this.a.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.m.getParent()).removeView(this.a.m);
                    }
                    WindowManager.LayoutParams t = this.a.t();
                    this.a.n = new FrameLayout(this.a.b);
                    this.a.n.setClickable(true);
                    this.a.c.addView(this.a.n, t);
                    this.a.m = this.a.n;
                }
                if (this.a.f != null && (this.a.f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.a.f.getParent()).removeView(this.a.f);
                }
                this.a.c.addView(this.a.f, this.a.g);
                this.a.e = this.a.f;
                this.a.h.postDelayed(this.a.j, this.a.d * 1000);
                if (this.a.a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz2 a;

        public c(xz2 xz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.a.e != null) {
                    if (this.a.e.getParent() != null) {
                        this.a.c.removeViewImmediate(this.a.e);
                    }
                    if (this.a.k != null) {
                        this.a.k.onDismiss();
                        this.a.k = null;
                    }
                    if (this.a.a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    this.a.e = null;
                }
                if (this.a.m != null) {
                    if (this.a.m.getParent() != null) {
                        this.a.c.removeViewImmediate(this.a.m);
                    }
                    if (this.a.a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    this.a.m = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public xz2(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = (WindowManager) context.getSystemService("window");
        this.h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.obfuscated_res_0x7f100413;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (layoutParams = this.g) == null) {
            return;
        }
        layoutParams.windowAnimations = i;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.i;
            if (runnable != null) {
                this.h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.i = bVar;
            this.h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.h) == null) {
            return;
        }
        handler.post(new c(this));
        this.h.removeCallbacks(this.j);
        if (this.a) {
            Log.d("ToastCustom", "cancel");
        }
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = zz2.c(this.b);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.e;
            return (view2 == null || view2.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i <= 0) {
                i = 2;
            }
            this.d = i;
        }
    }

    public void w(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) || (layoutParams = this.g) == null) {
            return;
        }
        layoutParams.gravity = i;
        layoutParams.x = i2;
        layoutParams.y = i3;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void y(zz2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void z(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.f = view2;
            view2.setClickable(true);
        }
    }
}
