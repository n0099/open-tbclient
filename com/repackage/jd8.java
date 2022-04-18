package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jd8 extends ld8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public CountDownTextView l;
    public boolean m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc8 a;
        public final /* synthetic */ jd8 b;

        public a(jd8 jd8Var, nc8 nc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var, nc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jd8Var;
            this.a = nc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Context context = this.b.b.getContext();
                String str = this.a.d;
                AdvertAppInfo advertAppInfo = this.b.d;
                na8.d(context, str, null, advertAppInfo != null ? advertAppInfo.h : "", this.a.j);
                zc8 zc8Var = this.b.c;
                if (zc8Var != null) {
                    zc8Var.i(302);
                    bd8.b().d(this.b.c);
                }
                dd7 dd7Var = this.b.e;
                if (dd7Var != null) {
                    ed7.h(dd7Var);
                }
                this.b.a(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd8(View view2, String str) {
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
        n();
    }

    @Override // com.repackage.ld8
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.m = z;
            CountDownTextView countDownTextView = this.l;
            if (countDownTextView != null) {
                countDownTextView.setEnableTimeoutListener(z);
            }
        }
    }

    @Override // com.repackage.ld8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0811cf, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.ld8
    public void d(nc8 nc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nc8Var) == null) {
            super.d(nc8Var);
            this.i.K(nc8Var.c, 10, false);
            this.j.setText(nc8Var.b);
            this.k.setText(nc8Var.e);
            this.b.setOnClickListener(new a(this, nc8Var));
            this.l.update(nc8Var.h);
            c();
        }
    }

    @Override // com.repackage.ld8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            this.l.e();
        }
    }

    @Override // com.repackage.ld8
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            super.m(cVar);
            this.l.setTimeoutListener(cVar);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.obfuscated_res_0x7f0922aa);
            this.i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.i.setDefaultBgResource(R.color.CAM_X0205);
            this.i.setIsRound(true);
            this.j = (TextView) b(R.id.obfuscated_res_0x7f09229d);
            this.l = (CountDownTextView) b(R.id.obfuscated_res_0x7f090702);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f090054);
        }
    }
}
