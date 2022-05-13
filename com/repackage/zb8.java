package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zb8 extends bc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public CountDownTextView n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(zb8 zb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zb8Var};
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb8 a;

        public b(zb8 zb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zb8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (onClickListener = this.a.g) == null) {
                return;
            }
            onClickListener.onClick(view2);
            this.a.n.c();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb8 a;
        public final /* synthetic */ zb8 b;

        public c(zb8 zb8Var, mb8 mb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zb8Var, mb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zb8Var;
            this.a = mb8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                mb8 mb8Var = this.a;
                String str = mb8Var.d;
                if (!hi0.n(mb8Var.j) ? gi0.b(this.b.e.getPageActivity(), this.b.c.p) : false) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.b.c;
                    i = ka8.b(this.b.e, str, advertAppInfo.i() ? this.b.c.getDownloadId() : this.b.c.a, advertAppInfo.g, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.w(ClogBuilder.LogType.CLICK).t("VIDEO_FLOW_TAIL").o(String.valueOf(this.b.c.position + 1)).n(this.b.c.g);
                ez0.c(clogBuilder);
                kd7.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zb8(View view2, String str) {
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
        l();
    }

    @Override // com.repackage.bc8
    public void c(mb8 mb8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mb8Var) == null) {
            super.c(mb8Var);
            if (mb8Var == null) {
                return;
            }
            this.i.K(mb8Var.c, 30, false);
            this.j.setText(mb8Var.b);
            this.k.setText(mb8Var.i);
            this.l.setText(mb8Var.e);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00b7));
            this.h.setOnClickListener(new c(this, mb8Var));
        }
    }

    @Override // com.repackage.bc8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.update(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).t("VIDEO_FLOW_TAIL").o(String.valueOf(this.c.position + 1)).n(this.c.g);
            ez0.c(clogBuilder);
        }
    }

    @Override // com.repackage.bc8
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f090095);
            this.i = (RoundTbImageView) a(R.id.obfuscated_res_0x7f0922dc);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f0922f3);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f0922d8);
            this.l = (TextView) a(R.id.obfuscated_res_0x7f092180);
            this.m = (TextView) a(R.id.obfuscated_res_0x7f091a86);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f090700);
        }
    }
}
