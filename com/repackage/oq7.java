package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes6.dex */
public class oq7 implements mq7, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginDialogActivity a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public View h;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public final ShareStorage.StorageModel r;

    /* loaded from: classes6.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        public a(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1122), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.a.a.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.a.passLoginSucc();
                this.a.a.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ oq7 b;

        public b(oq7 oq7Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oq7Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.a.showLoading();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.a.closeLoadingDialog();
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f1396), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.b.a.passLoginFail();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.a.passLoginSucc();
                this.b.a.addLoginSuccessLog(this.a.name().toLowerCase());
            }
        }
    }

    public oq7(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    @Override // com.repackage.mq7
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d076b, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f09079a);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f090673);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090674);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bf);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bd);
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f092293);
            this.i = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09227a);
            this.j = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09229c);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922b7);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09132a);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091981);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f092438);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f09243b);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f0924a8);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f091443);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.i.setIsRound(true);
            this.i.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.passLoginCancel();
            this.a.finish();
        }
    }

    public final void d() {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (storageModel = this.r) == null) {
            return;
        }
        this.i.K(storageModel.url, 10, false);
        this.j.setText(this.r.displayname);
        this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1121, this.r.app));
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.r == null) {
            return;
        }
        PassportSDK.getInstance().invokeV2ShareLogin(this.a, new a(this), this.r);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.getLoginListener());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("share_more");
            loginActivityConfig.start();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(SocialType.QQ_SSO);
        }
    }

    @Override // com.repackage.mq7
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(SocialType.WEIXIN);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h(SocialType.YY);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09079a || id == R.id.obfuscated_res_0x7f090673 || id == R.id.obfuscated_res_0x7f090674) {
                c();
            } else if (id == R.id.obfuscated_res_0x7f09132a) {
                e();
            } else if (id == R.id.obfuscated_res_0x7f091981) {
                g();
            } else if (id == R.id.obfuscated_res_0x7f092438) {
                i();
            } else if (id == R.id.obfuscated_res_0x7f09243b) {
                j();
            } else if (id == R.id.obfuscated_res_0x7f0924a8) {
                k();
            } else if (id == R.id.obfuscated_res_0x7f091443) {
                f();
            }
        }
    }

    @Override // com.repackage.mq7
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setBackgroundResource(this.c, R.drawable.nav_bg_corner_shape, i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f0808f6, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            wr4 d = wr4.d(this.f);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X05);
            d.A(R.string.F_X02);
            wr4 d2 = wr4.d(this.g);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
            d2.A(R.string.F_X01);
            wr4 d3 = wr4.d(this.h);
            d3.n(R.string.J_X05);
            d3.f(R.color.CAM_X0204);
            wr4 d4 = wr4.d(this.j);
            d4.v(R.color.CAM_X0105);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X02);
            wr4 d5 = wr4.d(this.k);
            d5.v(R.color.CAM_X0108);
            d5.z(R.dimen.T_X08);
            d5.A(R.string.F_X01);
            wr4 d6 = wr4.d(this.l);
            d6.v(R.color.CAM_X0101);
            d6.z(R.dimen.T_X05);
            d6.A(R.string.F_X01);
            d6.n(R.string.J_X01);
            d6.f(R.color.CAM_X0302);
        }
    }
}
