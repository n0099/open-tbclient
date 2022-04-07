package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bd8 extends ed8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public RoundTbImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public CountDownTextView o;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(bd8 bd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bd8 a;

        public b(bd8 bd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.a.h) == null) {
                return;
            }
            onClickListener.onClick(view2);
            this.a.o.c();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc8 a;
        public final /* synthetic */ bd8 b;

        public c(bd8 bd8Var, gc8 gc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bd8Var, gc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bd8Var;
            this.a = gc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = this.a.d;
                if (ga8.C(this.b.d, str)) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.b.d;
                    i = ga8.e(this.b.f, str, advertAppInfo.i() ? this.b.d.getDownloadId() : this.b.d.a, advertAppInfo.h, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.b.d;
                sc8 b = wc8.b(advertAppInfo2, 2, advertAppInfo2.position);
                b.h("VIDEO_FLOW_TAIL");
                uc8.b().d(b);
                bd7.h(bd7.e(this.b.d));
                this.b.o.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd8(View view2, String str) {
        super(view2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        o();
    }

    @Override // com.repackage.ed8
    public void d(gc8 gc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gc8Var) == null) {
            super.d(gc8Var);
            if (gc8Var == null) {
                return;
            }
            this.j.K(gc8Var.c, 30, false);
            this.k.setText(gc8Var.b);
            this.l.setText(gc8Var.i);
            this.m.setText(gc8Var.e);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f.getResources().getString(R.string.obfuscated_res_0x7f0f00b5));
            this.i.setOnClickListener(new c(this, gc8Var));
        }
    }

    @Override // com.repackage.ed8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.e();
            AdvertAppInfo advertAppInfo = this.d;
            uc8.b().d(wc8.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // com.repackage.ed8
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.m(cVar);
            this.o.setTimeoutListener(cVar);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.i = (RelativeLayout) b(R.id.obfuscated_res_0x7f090098);
            this.j = (RoundTbImageView) b(R.id.obfuscated_res_0x7f092285);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f09229c);
            this.l = (TextView) b(R.id.obfuscated_res_0x7f092281);
            this.m = (TextView) b(R.id.obfuscated_res_0x7f092124);
            this.n = (TextView) b(R.id.obfuscated_res_0x7f091a37);
            this.o = (CountDownTextView) b(R.id.obfuscated_res_0x7f090703);
        }
    }
}
