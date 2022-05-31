package com.repackage;

import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ij0;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class gj0<VIEW extends ij0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CountDownTimer a;
    public long b;
    public long c;
    public WeakReference<VIEW> d;

    /* loaded from: classes6.dex */
    public static class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<gj0> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NonNull gj0 gj0Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gj0Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(gj0Var);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            gj0 gj0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gj0Var = this.a.get()) == null) {
                return;
            }
            gj0Var.f(gj0Var.j());
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            gj0 gj0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (gj0Var = this.a.get()) == null) {
                return;
            }
            gj0Var.c = gj0Var.b - j;
            gj0Var.g(gj0Var.e(), gj0Var.j());
        }
    }

    public gj0(@NonNull VIEW view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new WeakReference<>(view2);
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.longValue;
    }

    public final void f(long j) {
        VIEW k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || (k = k()) == null) {
            return;
        }
        k.a(j);
    }

    public final void g(long j, long j2) {
        VIEW k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (k = k()) == null) {
            return;
        }
        k.onProgress(j, j2);
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            i();
            this.b = j;
            this.c = 0L;
            a aVar = new a(this, this.b, 1000L);
            this.a = aVar;
            aVar.start();
            VIEW k = k();
            if (k != null) {
                long j2 = this.b;
                k.b(j2, j2);
            }
        }
    }

    public void i() {
        CountDownTimer countDownTimer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (countDownTimer = this.a) == null) {
            return;
        }
        countDownTimer.cancel();
        VIEW k = k();
        if (k != null) {
            k.c(this.c, this.b);
        }
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b : invokeV.longValue;
    }

    public final VIEW k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d.get() : (VIEW) invokeV.objValue;
    }
}
