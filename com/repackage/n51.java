package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n51 extends j51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView f;
    public final RelativeLayout g;
    public final hk0<?> h;
    public ck0 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n51 a;

        public a(n51 n51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n51Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            this.a.i.p();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ik0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ n51 b;

        public b(n51 n51Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n51Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n51Var;
            this.a = adBaseModel;
        }

        @Override // com.repackage.ik0
        public void a(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.e(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void b(rj0 rj0Var, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rj0Var, adDownloadCode) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.c(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void c(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.a(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void d(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.c(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void e(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.a(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void f(rj0 rj0Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, rj0Var, f) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.g(this.a, f);
            }
        }

        @Override // com.repackage.ik0
        public void g(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.b(this.a);
            }
        }

        @Override // com.repackage.ik0
        public void h(rj0 rj0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, rj0Var) == null) {
                n51 n51Var = this.b;
                if (n51Var.e == null || !n51Var.n(rj0Var, this.a)) {
                    return;
                }
                this.b.e.f(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n51(int i, View view2) {
        super(i, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = (TextView) a(R.id.obfuscated_res_0x7f090989);
        this.g = (RelativeLayout) a(R.id.obfuscated_res_0x7f0914b6);
        view2.setBackgroundColor(0);
        this.h = uk0.a(this.g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.g.setOnClickListener(new a(this));
        m();
    }

    @Override // com.repackage.j51
    public void e() {
        ck0 ck0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ck0Var = this.i) == null) {
            return;
        }
        ck0Var.n();
        this.i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06024e));
    }

    public final boolean n(rj0 rj0Var, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        tn0 tn0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rj0Var, adBaseModel)) == null) ? (rj0Var == null || adBaseModel == null || (tn0Var = adBaseModel.l) == null || !TextUtils.equals(rj0Var.g, tn0Var.c) || !TextUtils.equals(rj0Var.d(), tn0Var.d)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f == null) {
            return;
        }
        this.f.setTextColor(getResources().getColor(adBaseModel.b ? R.color.obfuscated_res_0x7f06027e : R.color.obfuscated_res_0x7f06024e));
    }

    @Override // com.repackage.j51
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (j51.c(adBaseModel) && adBaseModel.h != null) {
                m();
                String str = adBaseModel.h.b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f.d)) {
                    return;
                }
                this.i = new ck0(rj0.b(adBaseModel), this.h);
                a51 a51Var = this.e;
                if (a51Var != null) {
                    a51Var.d(adBaseModel);
                }
                this.i.s(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
