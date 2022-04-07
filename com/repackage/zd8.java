package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zd8 extends z8<SecretSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public LinearLayout b;
    public View c;
    public TbSettingTextTipView d;
    public TbSettingTextTipView e;
    public TbSettingTextTipView f;
    public TbSettingTextTipView g;
    public TbSettingTextTipView h;
    public View i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public SecretSettingActivity l;
    public View m;
    public String[] n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public TbSettingTextTipView q;
    public ScrollView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View.OnClickListener w;
    public b x;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd8 a;

        public a(zd8 zd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zd8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x == null) {
                return;
            }
            if (view2 == this.a.c) {
                this.a.x.onBackPressed();
            } else if (view2 == this.a.d) {
                this.a.x.i();
            } else if (view2 == this.a.e) {
                this.a.x.g();
            } else if (view2 == this.a.g) {
                this.a.x.c();
            } else if (view2 == this.a.h) {
                this.a.x.h();
            } else if (view2 == this.a.k) {
                this.a.x.e();
            } else if (view2 == this.a.j) {
                this.a.x.a();
            } else if (view2 == this.a.o) {
                this.a.x.f();
            } else if (view2 == this.a.p) {
                this.a.x.j();
            } else if (view2 == this.a.f) {
                this.a.x.d();
            } else if (view2 == this.a.q) {
                this.a.x.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();

        void j();

        void onBackPressed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zd8(SecretSettingActivity secretSettingActivity) {
        super(secretSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {secretSettingActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.w = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d0753);
        r(secretSettingActivity);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.l.getLayoutMode().k(i == 1);
            this.l.getLayoutMode().j(this.b);
            this.a.onChangeSkinType(this.l.getPageContext(), i);
            wr4.d(this.s).v(R.color.CAM_X0108);
            wr4.d(this.t).v(R.color.CAM_X0108);
            wr4.d(this.u).v(R.color.CAM_X0108);
            wr4.d(this.v).v(R.color.CAM_X0108);
            wr4.d(this.r).f(R.color.CAM_X0204);
        }
    }

    public final void r(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, secretSettingActivity) == null) {
            this.b = (LinearLayout) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091641);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.a = navigationBar;
            this.c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ac));
            this.d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f090389);
            this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e0);
            this.f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091399);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e1);
            this.g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e2);
            this.h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e8);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091fae);
            this.i = secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0906df);
            this.r = (ScrollView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09136c);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c54);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c55);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c56);
            this.v = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091c57);
            this.c.setOnClickListener(this.w);
            this.d.setOnClickListener(this.w);
            this.k.setOnClickListener(this.w);
            this.e.setOnClickListener(this.w);
            this.f.setOnClickListener(this.w);
            this.g.setOnClickListener(this.w);
            this.h.setOnClickListener(this.w);
            this.j.setOnClickListener(this.w);
            this.m = this.l.findViewById(R.id.obfuscated_res_0x7f0918e9);
            this.n = this.l.getResources().getStringArray(R.array.obfuscated_res_0x7f030013);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e7);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918df);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.w);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0918e3);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.w);
            UserData e = c35.d().e();
            if (e != null && e.getBazhuGradeData() != null && !StringUtils.isNull(e.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e.getBazhuGradeData().getLevel())) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.g();
        }
    }

    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.x = bVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            if (SwitchManager.getInstance().findType("reply_private_setting_switch") == 1) {
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                return;
            }
            this.i.setVisibility(8);
            this.j.setVisibility(8);
        }
    }

    public void v(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (i2 == 3 && i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8f));
            } else if (i2 == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8e));
            } else if (i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a90));
            } else {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a8d));
            }
        }
    }

    public void w(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            int i2 = i - 1;
            String[] strArr = this.n;
            if (strArr == null || i2 >= strArr.length || i2 < 0) {
                return;
            }
            if (TextUtils.equals(str, "like")) {
                this.e.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "group")) {
                this.k.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "live")) {
                this.g.setTip(this.n[i2]);
            } else if (TextUtils.equals(str, "reply")) {
                if (i2 == 0) {
                    this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0267));
                } else {
                    this.j.setTip(this.n[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                v(wt4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), wt4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void x(xd8 xd8Var) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, xd8Var) == null) || xd8Var == null || (strArr = this.n) == null) {
            return;
        }
        int length = strArr.length;
        int d = xd8Var.d() - 1;
        if (d < length && d >= 0) {
            this.k.setTip(this.n[d]);
        }
        int c = xd8Var.c() - 1;
        if (c < length && c >= 0) {
            this.e.setTip(this.n[c]);
        }
        int e = xd8Var.e() - 1;
        if (e < length && e >= 0) {
            this.g.setTip(this.n[e]);
        }
        int g = xd8Var.g() - 1;
        if (g < length && g >= 0) {
            if (g == 0) {
                this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0267));
            } else {
                this.j.setTip(this.n[g]);
            }
        }
        v(xd8Var.a(), xd8Var.b());
    }
}
