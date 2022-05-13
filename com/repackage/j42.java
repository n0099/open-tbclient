package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j42 extends u32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b D;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nc3 b;
        public final /* synthetic */ j42 c;

        public a(j42 j42Var, int i, nc3 nc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j42Var, Integer.valueOf(i), nc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j42Var;
            this.a = i;
            this.b = nc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c.D == null) {
                return;
            }
            int i = this.a;
            if (i == -1) {
                this.c.D.b(this.b);
            } else if (i == 0) {
                this.c.D.a();
            } else if (i != 1) {
            } else {
                this.c.D.onSuccess();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b(nc3 nc3Var);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j42(String str, b bVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = bVar;
    }

    @Override // com.repackage.u32, com.repackage.n84
    public void D(m94 m94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, m94Var) == null) {
            super.D(m94Var);
            nc3 nc3Var = new nc3();
            nc3Var.k(10L);
            nc3Var.c(m94Var);
            K0(-1, nc3Var);
        }
    }

    @Override // com.repackage.n84
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.G();
            J0(0);
        }
    }

    public final void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            K0(i, null);
        }
    }

    public final void K0(int i, nc3 nc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, nc3Var) == null) {
            oe3.a0(new a(this, i, nc3Var));
        }
    }

    @Override // com.repackage.y32
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.u32
    public PMSDownloadType l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.u32
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.w0();
            nc3 G0 = G0();
            if (G0 == null) {
                J0(1);
                B0("page_route_download", "0");
                return;
            }
            K0(-1, G0);
        }
    }

    @Override // com.repackage.u32
    public void x0(Throwable th) {
        nc3 nc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                nc3Var = ((PkgDownloadError) th).getErrCode();
            } else {
                nc3Var = new nc3();
                nc3Var.k(10L);
                nc3Var.i(0L);
            }
            K0(-1, nc3Var);
        }
    }
}
