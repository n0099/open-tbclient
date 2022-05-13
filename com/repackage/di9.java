package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.pi9;
import com.win.opensdk.PBError;
/* loaded from: classes5.dex */
public class di9 extends yh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dp9 a;

    /* loaded from: classes5.dex */
    public class a implements ep9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii9 a;

        public a(di9 di9Var, ii9 ii9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di9Var, ii9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii9Var;
        }

        @Override // com.repackage.ep9
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pi9.a aVar = (pi9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdClose();
            }
        }

        @Override // com.repackage.ep9
        public void b(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                ii9 ii9Var = this.a;
                String msg = pBError.getMsg();
                int code = pBError.getCode();
                pi9.a aVar = (pi9.a) ii9Var;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdError(code, msg);
            }
        }

        @Override // com.repackage.ep9
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                pi9.a aVar = (pi9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdClose();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((pi9.a) this.a).a();
            }
        }

        @Override // com.repackage.ep9
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                pi9.a aVar = (pi9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdShow(aVar.c, aVar.a, new String[0]);
                aVar.a = true;
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onFail(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, pBError) == null) {
                ((pi9.a) this.a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ((pi9.a) this.a).c();
            }
        }
    }

    public di9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new dp9(context.getApplicationContext(), str);
    }

    @Override // com.repackage.th9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.j();
        }
    }

    @Override // com.repackage.th9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.l();
        }
    }

    @Override // com.repackage.yh9
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.a.m(j);
        }
    }

    @Override // com.repackage.yh9
    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.a.o(viewGroup);
        }
    }

    @Override // com.repackage.yh9
    public void e(ii9 ii9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ii9Var) == null) {
            this.a.n(new a(this, ii9Var));
        }
    }
}
