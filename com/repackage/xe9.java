package com.repackage;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.jf9;
import com.win.opensdk.PBError;
/* loaded from: classes7.dex */
public class xe9 extends se9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xl9 a;

    /* loaded from: classes7.dex */
    public class a implements yl9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cf9 a;

        public a(xe9 xe9Var, cf9 cf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe9Var, cf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cf9Var;
        }

        @Override // com.repackage.yl9
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jf9.a aVar = (jf9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdClose();
            }
        }

        @Override // com.repackage.yl9
        public void b(PBError pBError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pBError) == null) {
                cf9 cf9Var = this.a;
                String msg = pBError.getMsg();
                int code = pBError.getCode();
                jf9.a aVar = (jf9.a) cf9Var;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdError(code, msg);
            }
        }

        @Override // com.repackage.yl9
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                jf9.a aVar = (jf9.a) this.a;
                aVar.getClass();
                LogPrinter.d();
                aVar.d.onAdClose();
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                ((jf9.a) this.a).a();
            }
        }

        @Override // com.repackage.yl9
        public void onDisplayed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                jf9.a aVar = (jf9.a) this.a;
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
                ((jf9.a) this.a).b(pBError.getMsg(), pBError.getCode());
            }
        }

        @Override // com.win.opensdk.PBListener
        public void onLoaded() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ((jf9.a) this.a).c();
            }
        }
    }

    public xe9(Context context, String str) {
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
        this.a = new xl9(context.getApplicationContext(), str);
    }

    @Override // com.repackage.ne9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.j();
        }
    }

    @Override // com.repackage.ne9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.l();
        }
    }

    @Override // com.repackage.se9
    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.a.m(j);
        }
    }

    @Override // com.repackage.se9
    public void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            this.a.o(viewGroup);
        }
    }

    @Override // com.repackage.se9
    public void e(cf9 cf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cf9Var) == null) {
            this.a.n(new a(this, cf9Var));
        }
    }
}
