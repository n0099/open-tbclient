package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.widget.uitemplate.SimpleFeedAdInfoView;
import com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zz0;
/* loaded from: classes6.dex */
public class j41 extends l41 {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleFeedAdInfoView j;

    /* loaded from: classes6.dex */
    public class a implements SimpleAdInfoView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ j41 b;

        public a(j41 j41Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j41Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j41Var;
            this.a = adBaseModel;
        }

        @Override // com.baidu.nadcore.widget.uiwidget.SimpleAdInfoView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                j41 j41Var = this.b;
                j41Var.q(ClogBuilder.LogType.FREE_CLICK.type, j41Var.c, str, this.a.f.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ j41 b;

        public b(j41 j41Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j41Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j41Var;
            this.a = adBaseModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z31 z31Var = this.b.d;
                if (z31Var != null) {
                    z31Var.a(this.a);
                }
                rx0.c(new ClogBuilder().w(ClogBuilder.LogType.CLOSE).n(this.a.f.d));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755638742, "Lcom/repackage/j41;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755638742, "Lcom/repackage/j41;");
                return;
            }
        }
        k = zz0.c.a(xg0.b(), 15.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j41(int i, View view2) {
        super(i, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = (SimpleFeedAdInfoView) view2.findViewById(R.id.obfuscated_res_0x7f09096a);
        m();
    }

    private void m() {
        SimpleFeedAdInfoView simpleFeedAdInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (simpleFeedAdInfoView = this.j) == null) {
            return;
        }
        simpleFeedAdInfoView.c();
    }

    public final void q(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.x(str);
            clogBuilder.t(str2);
            clogBuilder.n(str4);
            clogBuilder.h(str3);
            rx0.c(clogBuilder);
        }
    }

    public final void r(AdBaseModel adBaseModel) {
        SimpleFeedAdInfoView simpleFeedAdInfoView;
        View findViewById;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) || adBaseModel == null || (simpleFeedAdInfoView = this.j) == null || (findViewById = simpleFeedAdInfoView.findViewById(R.id.obfuscated_res_0x7f091479)) == null) {
            return;
        }
        z21.a(this.j, findViewById, k);
        findViewById.setOnClickListener(new b(this, adBaseModel));
    }

    @Override // com.repackage.l41, com.repackage.h41
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            m();
            SimpleFeedAdInfoView simpleFeedAdInfoView = this.j;
            if (simpleFeedAdInfoView != null) {
                simpleFeedAdInfoView.update(adBaseModel);
                ym0 ym0Var = adBaseModel.p;
                if (ym0Var == null || ym0Var.k) {
                    this.j.setBackground(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080dfd));
                }
                this.j.setAfterListener(new a(this, adBaseModel));
            }
            r(adBaseModel);
        }
    }
}
