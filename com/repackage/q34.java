package com.repackage;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes6.dex */
public class q34 implements r34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public y34 b;
    public b c;
    public Handler d;
    public ViewGroup e;
    public int f;
    public boolean g;
    public ObjectAnimator h;
    public t34 i;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q34 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q34 q34Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q34Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q34Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int f = this.a.f();
                if (f > 0 && this.a.g) {
                    this.a.d.sendEmptyMessageDelayed(1, f);
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void c();

        void p();

        void v(int i);
    }

    public q34(@NonNull Context context, @NonNull t34 t34Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, t34Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.i = t34Var;
        j(i());
        h();
        b();
    }

    @NonNull
    public static q34 c(int i, @NonNull Context context, @NonNull t34 t34Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, context, t34Var)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return new v34(context, t34Var);
                }
                return new x34(context, t34Var);
            }
            return new v34(context, t34Var);
        }
        return (q34) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setVisibility(8);
            d34.a(this.e, g());
        }
    }

    public final ObjectAnimator d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    @Override // com.repackage.p34
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = false;
            this.d.removeCallbacksAndMessages(null);
            d34.d(this.e);
        }
    }

    @Override // com.repackage.r34
    public void e(y34 y34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, y34Var) == null) {
            this.b = y34Var;
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    public final pq2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            pq2 pq2Var = new pq2();
            pq2Var.l(z24.a(this.i.left) - this.f);
            pq2Var.m(z24.a(this.i.top) - this.f);
            pq2Var.n(-2);
            pq2Var.j(-2);
            return pq2Var;
        }
        return (pq2) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = d();
            this.d = new a(this, Looper.getMainLooper());
        }
    }

    @Override // com.repackage.p34
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = false;
            this.d.removeMessages(1);
            this.e.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07e5, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void j(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.f = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0706c8);
            this.e = new FrameLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z24.a(this.i.width), z24.a(this.i.height));
            int i = this.f;
            layoutParams.setMargins(i, i, i, i);
            this.e.setBackgroundColor(0);
            this.e.addView(view2, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.start();
        }
    }

    @Override // com.repackage.r34
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.g) {
            this.d.removeMessages(1);
            if (z) {
                this.d.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.repackage.p34
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = true;
            this.e.setVisibility(0);
            this.d.removeMessages(1);
            this.d.sendEmptyMessage(1);
        }
    }

    @Override // com.repackage.r34
    public void u(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @Override // com.repackage.r34
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d34.f(this.e, g());
        }
    }
}
