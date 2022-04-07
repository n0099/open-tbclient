package com.repackage;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public b i;
    public Runnable j;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dc5 a;

        public a(dc5 dc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dc5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.g > this.a.f) {
                    dc5 dc5Var = this.a;
                    dc5Var.f = currentTimeMillis - dc5Var.d;
                    dc5 dc5Var2 = this.a;
                    dc5Var2.g = dc5Var2.f;
                }
                long j = currentTimeMillis - this.a.f;
                this.a.c += this.a.d;
                if (this.a.c < this.a.b) {
                    this.a.a.postDelayed(this.a.j, (this.a.d * 2) - j);
                    if (this.a.i != null) {
                        this.a.i.onCountDown(this.a.b, this.a.b - this.a.c);
                    }
                } else {
                    dc5 dc5Var3 = this.a;
                    dc5Var3.c = dc5Var3.b;
                    this.a.m();
                }
                this.a.f = currentTimeMillis;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onCountDown(long j, long j2);

        void onCountDownFinish(long j);
    }

    public dc5(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.h = false;
        this.j = new a(this);
        this.b = j;
        this.d = j2;
    }

    public final void m() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.i) == null) {
            return;
        }
        bVar.onCountDownFinish(this.b);
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.longValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h) {
            return;
        }
        this.h = true;
        this.g = System.currentTimeMillis();
        this.a.removeCallbacks(this.j);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.h) {
            this.h = false;
            this.a.postDelayed(this.j, this.d - (this.g - this.f));
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.e = currentTimeMillis;
            this.f = currentTimeMillis;
            b bVar = this.i;
            if (bVar != null) {
                long j = this.b;
                bVar.onCountDown(j, j - this.c);
            }
            this.a.postDelayed(this.j, this.d);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = false;
            long j = this.e;
            this.f = j;
            this.g = j;
            this.a.removeCallbacks(this.j);
        }
    }
}
