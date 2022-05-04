package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qq7 implements pq7, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public String C;
    public LoginDialogActivity a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public ImageView f;
    public LinearLayout g;
    public LinearLayout h;
    public Animation i;
    public Vibrator j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq7 a;

        public a(qq7 qq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qq7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a2, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                } else {
                    this.a.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a1, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq7 a;

        public b(qq7 qq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qq7Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.a.closeLoadingDialog();
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f0cc2), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
                this.a.a.passLoginFail();
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                this.a.a.passLoginSucc();
                this.a.a.addLoginSuccessLog(DialogLoginHelper.DIALOG_TYPE_ONE_KEY);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ qq7 b;

        public c(qq7 qq7Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq7Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qq7Var;
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
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f1395), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r7.equals(com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public qq7(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        char c2 = 0;
        this.A = 0;
        this.B = str;
        this.C = str3;
        int hashCode = str2.hashCode();
        if (hashCode == 2154) {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC)) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 2161) {
            if (hashCode == 2162) {
            }
            c2 = 65535;
        } else {
            if (str2.equals(OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC)) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 == 0) {
            this.A = 1;
        } else if (c2 != 1) {
            this.A = 3;
        } else {
            this.A = 2;
        }
    }

    public static String j(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, activity, str)) == null) {
            if (TextUtils.isEmpty(str) || str.length() <= 7) {
                return null;
            }
            String substring = str.substring(0, 8);
            String substring2 = str.substring(8, str.length());
            String upperCase = SapiUtils.getClientId(activity).toUpperCase();
            return substring + MD5Util.toMd5((substring2 + MD5Util.toMd5(upperCase.getBytes(), false)).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.repackage.pq7
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d0645, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f09079a);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0907be);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f090673);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090674);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bf);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0907bd);
            this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0922a4);
            this.n = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09132b);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f091982);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f09243a);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f09243d);
            this.r = inflate.findViewById(R.id.obfuscated_res_0x7f0924aa);
            this.s = inflate.findViewById(R.id.obfuscated_res_0x7f091444);
            this.f = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09060f);
            this.h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09060a);
            this.t = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff2);
            this.u = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091608);
            this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff3);
            this.w = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09016f);
            this.x = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff4);
            this.y = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0918eb);
            this.z = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff5);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.j = (Vibrator) loginDialogActivity.getSystemService("vibrator");
            this.f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809a1, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
            this.h.setTag(Boolean.FALSE);
            this.h.setOnClickListener(new a(this));
            g();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cb9), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false).start();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.passLoginCancel();
            this.a.finish();
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (((Boolean) this.h.getTag()).booleanValue()) {
                return true;
            }
            this.j.vibrate(300L);
            Animation loadAnimation = AnimationUtils.loadAnimation(SelectorHelper.getContext(), R.anim.obfuscated_res_0x7f0100c2);
            this.i = loadAnimation;
            this.g.startAnimation(loadAnimation);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m.setText(this.B);
            h(this.A);
        }
    }

    @Override // com.repackage.pq7
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i == 1) {
                this.u.setText(R.string.obfuscated_res_0x7f0f0cba);
            } else if (i == 2) {
                this.u.setText(R.string.obfuscated_res_0x7f0f0cbb);
            } else if (i != 3) {
            } else {
                this.u.setText(R.string.obfuscated_res_0x7f0f0cbc);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.showLoading();
            PassportSDK passportSDK = PassportSDK.getInstance();
            LoginDialogActivity loginDialogActivity = this.a;
            passportSDK.loadOneKeyLogin(loginDialogActivity, j(loginDialogActivity, this.C), new b(this));
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i = this.A;
            if (i == 1) {
                LoginDialogActivity loginDialogActivity = this.a;
                new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cba), "https://ms.zzx9.cn/html/oauth/protocol2.html", false).start();
            } else if (i == 2) {
                LoginDialogActivity loginDialogActivity2 = this.a;
                new TbWebViewActivityConfig(loginDialogActivity2, loginDialogActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0cbb), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false).start();
            } else if (i != 3) {
            } else {
                LoginDialogActivity loginDialogActivity3 = this.a;
                new TbWebViewActivityConfig(loginDialogActivity3, loginDialogActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0cbc), "https://wap.cmpassport.com/resources/html/contract.html", false).start();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.getLoginListener());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("onkey_more");
            loginActivityConfig.start();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LoginDialogActivity loginDialogActivity = this.a;
            new TbWebViewActivityConfig(loginDialogActivity, loginDialogActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0cbd), "http://privacy.baidu.com/mdetail?id=288", false).start();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            o(SocialType.QQ_SSO);
        }
    }

    public final void o(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new c(this, socialType), socialType);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f09079a || id == R.id.obfuscated_res_0x7f090673 || id == R.id.obfuscated_res_0x7f090674) {
                e();
            } else if (id == R.id.obfuscated_res_0x7f09132b) {
                if (f()) {
                    i();
                }
            } else if (id == R.id.obfuscated_res_0x7f091982) {
                if (f()) {
                    n();
                }
            } else if (id == R.id.obfuscated_res_0x7f09243a) {
                if (f()) {
                    p();
                }
            } else if (id == R.id.obfuscated_res_0x7f09243d) {
                if (f()) {
                    r();
                }
            } else if (id == R.id.obfuscated_res_0x7f0924aa) {
                if (f()) {
                    s();
                }
            } else if (id == R.id.obfuscated_res_0x7f091444) {
                l();
            } else if (id == R.id.obfuscated_res_0x7f091608) {
                k();
            } else if (id == R.id.obfuscated_res_0x7f09016f) {
                d();
            } else if (id == R.id.obfuscated_res_0x7f0918eb) {
                m();
            }
        }
    }

    @Override // com.repackage.pq7
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setBackgroundResource(this.c, R.drawable.nav_bg_corner_shape, i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.obfuscated_res_0x7f0808fa, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            vr4 d = vr4.d(this.k);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X05);
            d.A(R.string.F_X02);
            vr4 d2 = vr4.d(this.l);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X08);
            d2.A(R.string.F_X01);
            vr4 d3 = vr4.d(this.m);
            d3.v(R.color.CAM_X0105);
            d3.z(R.dimen.T_X03);
            d3.A(R.string.F_X02);
            vr4 d4 = vr4.d(this.n);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X05);
            d4.A(R.string.F_X01);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0302);
            vr4 d5 = vr4.d(this.t);
            d5.v(R.color.CAM_X0108);
            d5.z(R.dimen.T_X08);
            d5.A(R.string.F_X01);
            vr4 d6 = vr4.d(this.v);
            d6.v(R.color.CAM_X0108);
            d6.z(R.dimen.T_X08);
            d6.A(R.string.F_X01);
            vr4 d7 = vr4.d(this.x);
            d7.v(R.color.CAM_X0108);
            d7.z(R.dimen.T_X08);
            d7.A(R.string.F_X01);
            vr4 d8 = vr4.d(this.z);
            d8.v(R.color.CAM_X0108);
            d8.z(R.dimen.T_X08);
            d8.A(R.string.F_X01);
            vr4 d9 = vr4.d(this.u);
            d9.v(R.color.CAM_X0108);
            d9.z(R.dimen.T_X08);
            d9.A(R.string.F_X02);
            vr4 d10 = vr4.d(this.w);
            d10.v(R.color.CAM_X0108);
            d10.z(R.dimen.T_X08);
            d10.A(R.string.F_X02);
            vr4 d11 = vr4.d(this.y);
            d11.v(R.color.CAM_X0108);
            d11.z(R.dimen.T_X08);
            d11.A(R.string.F_X02);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            o(SocialType.WEIXIN);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            o(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            o(SocialType.YY);
        }
    }
}
