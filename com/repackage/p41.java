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
public class p41 extends l41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView f;
    public final RelativeLayout g;
    public final yi0<?> h;
    public ti0 i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p41 a;

        public a(p41 p41Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p41Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p41Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null) {
                return;
            }
            this.a.i.l();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zi0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ p41 b;

        public b(p41 p41Var, AdBaseModel adBaseModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p41Var, adBaseModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p41Var;
            this.a = adBaseModel;
        }

        @Override // com.repackage.zi0
        public void a(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.e(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void b(ii0 ii0Var, AdDownloadCode adDownloadCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ii0Var, adDownloadCode) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.c(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void c(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.a(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void d(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.c(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void e(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.a(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void f(ii0 ii0Var, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, ii0Var, f) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.g(this.a, f);
            }
        }

        @Override // com.repackage.zi0
        public void g(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.b(this.a);
            }
        }

        @Override // com.repackage.zi0
        public void h(ii0 ii0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ii0Var) == null) {
                p41 p41Var = this.b;
                if (p41Var.e == null || !p41Var.n(ii0Var, this.a)) {
                    return;
                }
                this.b.e.f(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p41(int i, View view2) {
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
        this.f = (TextView) a(R.id.obfuscated_res_0x7f09095a);
        this.g = (RelativeLayout) a(R.id.obfuscated_res_0x7f091485);
        view2.setBackgroundColor(0);
        this.h = lj0.a(this.g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.g.setOnClickListener(new a(this));
        m();
    }

    @Override // com.repackage.l41
    public void e() {
        ti0 ti0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ti0Var = this.i) == null) {
            return;
        }
        ti0Var.j();
        this.i = null;
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f) == null) {
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060251));
    }

    public final boolean n(ii0 ii0Var, AdBaseModel adBaseModel) {
        InterceptResult invokeLL;
        km0 km0Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ii0Var, adBaseModel)) == null) ? (ii0Var == null || adBaseModel == null || (km0Var = adBaseModel.l) == null || !TextUtils.equals(ii0Var.g, km0Var.c) || !TextUtils.equals(ii0Var.d(), km0Var.d)) ? false : true : invokeLL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, adBaseModel) == null) || this.f == null) {
            return;
        }
        this.f.setTextColor(getResources().getColor(adBaseModel.b ? R.color.obfuscated_res_0x7f060281 : R.color.obfuscated_res_0x7f060251));
    }

    @Override // com.repackage.l41
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (l41.c(adBaseModel) && adBaseModel.h != null) {
                m();
                String str = adBaseModel.h.b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f.d)) {
                    return;
                }
                this.i = new ti0(ii0.b(adBaseModel), this.h);
                c41 c41Var = this.e;
                if (c41Var != null) {
                    c41Var.d(adBaseModel);
                }
                this.i.n(new b(this, adBaseModel));
                return;
            }
            i(8);
        }
    }
}
