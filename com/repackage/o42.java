package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o42 extends z32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b D;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ sc3 b;
        public final /* synthetic */ o42 c;

        public a(o42 o42Var, int i, sc3 sc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o42Var, Integer.valueOf(i), sc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o42Var;
            this.a = i;
            this.b = sc3Var;
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

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b(sc3 sc3Var);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o42(String str, b bVar) {
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

    @Override // com.repackage.z32, com.repackage.s84
    public void C(r94 r94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r94Var) == null) {
            super.C(r94Var);
            sc3 sc3Var = new sc3();
            sc3Var.k(10L);
            sc3Var.c(r94Var);
            J0(-1, sc3Var);
        }
    }

    @Override // com.repackage.s84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            I0(0);
        }
    }

    public final void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            J0(i, null);
        }
    }

    public final void J0(int i, sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, sc3Var) == null) {
            te3.a0(new a(this, i, sc3Var));
        }
    }

    @Override // com.repackage.d42
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.z32
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // com.repackage.z32
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.v0();
            sc3 F0 = F0();
            if (F0 == null) {
                I0(1);
                A0("page_route_download", "0");
                return;
            }
            J0(-1, F0);
        }
    }

    @Override // com.repackage.z32
    public void w0(Throwable th) {
        sc3 sc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                sc3Var = ((PkgDownloadError) th).getErrCode();
            } else {
                sc3Var = new sc3();
                sc3Var.k(10L);
                sc3Var.i(0L);
            }
            J0(-1, sc3Var);
        }
    }
}
