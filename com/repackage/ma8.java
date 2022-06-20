package com.repackage;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pj5;
/* loaded from: classes6.dex */
public class ma8 extends pa8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public ApkDownloadView l;
    public TextView m;
    public CountDownTextView n;
    public AdAppInfoView o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ma8 ma8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var};
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma8 a;

        public b(ma8 ma8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma8Var;
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

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aa8 a;
        public final /* synthetic */ ma8 b;

        public c(ma8 ma8Var, aa8 aa8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var, aa8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ma8Var;
            this.a = aa8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                aa8 aa8Var = this.a;
                String str = aa8Var.d;
                if (!yg0.n(aa8Var.j) ? xg0.b(this.b.e.getPageActivity(), this.b.c.p) : false) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.b.c;
                    i = y88.b(this.b.e, str, advertAppInfo.h() ? this.b.c.getDownloadId() : this.b.c.a, advertAppInfo.g, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.w(ClogBuilder.LogType.CLICK).t("VIDEO_FLOW_TAIL").o(String.valueOf(this.b.c.position + 1)).n(this.b.c.g);
                vx0.c(clogBuilder);
                jc7.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements pj5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma8 a;

        public d(ma8 ma8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma8Var;
        }

        @Override // com.repackage.pj5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ej5.a(this.a.f.getButtonCmdScheme());
                jc7.c(this.a.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ma8(View view2, String str) {
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

    @Override // com.repackage.pa8
    public void c(aa8 aa8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aa8Var) == null) {
            super.c(aa8Var);
            if (aa8Var == null) {
                return;
            }
            this.i.J(aa8Var.c, 30, false);
            this.j.setText(aa8Var.b);
            this.k.setText(aa8Var.i);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00b7));
            this.h.setOnClickListener(new c(this, aa8Var));
            AdvertAppInfo advertAppInfo = this.c;
            if (advertAppInfo == null || this.f == null || !advertAppInfo.h()) {
                return;
            }
            this.o.setAd(this.c);
            this.o.setAppInfo(this.c.h.getAppInfoModel());
            m();
        }
    }

    @Override // com.repackage.pa8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.update(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.w(ClogBuilder.LogType.FREE_SHOW).t("VIDEO_FLOW_TAIL").o(String.valueOf(this.c.position + 1)).n(this.c.g);
            vx0.c(clogBuilder);
        }
    }

    @Override // com.repackage.pa8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e();
        }
    }

    @Override // com.repackage.pa8
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f090094);
            this.i = (RoundTbImageView) a(R.id.obfuscated_res_0x7f09226e);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f092285);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f09226b);
            this.l = (ApkDownloadView) a(R.id.obfuscated_res_0x7f0907e6);
            this.m = (TextView) a(R.id.obfuscated_res_0x7f091a2d);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f0906ce);
            this.o = (AdAppInfoView) a(R.id.obfuscated_res_0x7f0900ae);
            this.l.setTextColorInitSkin(R.color.CAM_X0101);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setTextSize(R.dimen.T_X06);
            this.l.setForegroundSkin(R.color.black_alpha15);
            this.l.setBackgroundSkin(R.drawable.obfuscated_res_0x7f08124f);
            this.l.setRatio(0);
            this.l.c();
        }
    }

    public final void m() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCard = this.f) == null || adCard.downloadInfo == null) {
            return;
        }
        this.l.setInitText(adCard.operate.a);
        this.l.setOnClickInterceptListener(new d(this));
        new oj5(this.l, ba8.d(this.f));
    }
}
