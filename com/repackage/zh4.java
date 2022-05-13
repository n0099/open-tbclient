package com.repackage;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.repackage.bi4;
import com.repackage.fj2;
import com.repackage.z53;
/* loaded from: classes7.dex */
public class zh4 extends yh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public bi4 z;

    /* loaded from: classes7.dex */
    public class a implements bi4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh4 a;

        public a(zh4 zh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh4Var;
        }

        @Override // com.repackage.bi4.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.z0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nf3<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh4 a;

        public b(zh4 zh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 2) {
                    if (yh4.x) {
                        Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " authorize deny => onError 0");
                    }
                    fj2.a aVar = this.a.i;
                    if (aVar != null) {
                        aVar.onError(0);
                        return;
                    }
                    return;
                }
                if (yh4.x) {
                    Log.d("SwanInlineLiveWidget", this.a.f + "-" + hashCode() + " real do prepareAsync");
                }
                zh4.super.prepareAsync();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;
        public final /* synthetic */ zh4 b;

        public c(zh4 zh4Var, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh4Var, nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zh4Var;
            this.a = nf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                boolean h = s53.h(x53Var);
                if (yh4.x) {
                    Log.d("SwanInlineLiveWidget", this.b.f + "-" + hashCode() + " authorize: " + h);
                }
                this.b.A = h ? 1 : 2;
                this.a.onCallback(Integer.valueOf(this.b.A));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zh4(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ZeusPluginFactory.Invoker) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 0;
        bi4 bi4Var = new bi4();
        this.z = bi4Var;
        bi4Var.e(this.c);
        this.z.f(new a(this));
    }

    @Override // com.repackage.yh4
    public void C0(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, str) == null) {
        }
    }

    @Override // com.repackage.yh4
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void M0(@NonNull Context context, @NonNull nf3<Integer> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, nf3Var) == null) {
            if (yh4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start authorize");
            }
            u03 a0 = u03.a0();
            if (a0 == null) {
                if (!yh4.x) {
                    nf3Var.onCallback(0);
                    return;
                }
                throw new RuntimeException("inline live authorize: swan app is null");
            } else if (tw2.r()) {
                this.A = 1;
                if (yh4.x) {
                    Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " authorize debug: true");
                }
                nf3Var.onCallback(Integer.valueOf(this.A));
            } else {
                a0.d0().g(context, "mapp_i_live_player", new c(this, nf3Var));
            }
        }
    }

    @Override // com.repackage.fj2
    public void N(ZeusPluginFactory.Invoker invoker) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, invoker) == null) {
        }
    }

    @Override // com.repackage.yh4, com.repackage.fj2
    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.repackage.yh4, com.repackage.fj2
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // com.repackage.yh4, com.repackage.fj2
    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // com.repackage.fj2
    public ZeusPluginFactory.Invoker f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ZeusPluginFactory.Invoker) invokeV.objValue;
    }

    @Override // com.repackage.yh4, com.repackage.fj2
    public boolean prepareAsync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (yh4.x) {
                Log.d("SwanInlineLiveWidget", this.f + "-" + hashCode() + " start prepareAsync");
            }
            M0(this.c, new b(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.yh4, com.repackage.fj2
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.release();
            bi4 bi4Var = this.z;
            if (bi4Var != null) {
                bi4Var.g();
                this.z = null;
            }
        }
    }
}
