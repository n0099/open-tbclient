package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PrivacyMarkActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.data.UserData;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.im.more.SecretSettingActivity;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class wc8 extends z8<SecretSettingActivity> {
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
    public MsgSettingItemView v;
    public MsgSettingItemView w;
    public View.OnClickListener x;
    public b y;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wc8 a;

        public a(wc8 wc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.y == null) {
                return;
            }
            if (view2 == this.a.c) {
                this.a.y.onBackPressed();
            } else if (view2 == this.a.d) {
                this.a.y.i();
            } else if (view2 == this.a.e) {
                this.a.y.g();
            } else if (view2 == this.a.g) {
                this.a.y.c();
            } else if (view2 == this.a.h) {
                this.a.y.h();
            } else if (view2 == this.a.k) {
                this.a.y.e();
            } else if (view2 == this.a.j) {
                this.a.y.a();
            } else if (view2 == this.a.o) {
                this.a.y.f();
            } else if (view2 == this.a.p) {
                this.a.y.j();
            } else if (view2 == this.a.f) {
                this.a.y.d();
            } else if (view2 == this.a.q) {
                this.a.y.b();
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
    public wc8(SecretSettingActivity secretSettingActivity) {
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
        this.x = new a(this);
        this.l = secretSettingActivity;
        secretSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d0746);
        v(secretSettingActivity);
    }

    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (i2 == 3 && i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a96));
            } else if (i2 == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a95));
            } else if (i == 3) {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a97));
            } else {
                this.f.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0a94));
            }
        }
    }

    public void B(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
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
                    this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0269));
                } else {
                    this.j.setTip(this.n[i2]);
                }
            } else if (TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE) || TextUtils.equals(str, PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                A(iu4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0), iu4.k().l(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0));
            }
        }
    }

    public void C(uc8 uc8Var) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uc8Var) == null) || uc8Var == null || (strArr = this.n) == null) {
            return;
        }
        int length = strArr.length;
        int d = uc8Var.d() - 1;
        if (d < length && d >= 0) {
            this.k.setTip(this.n[d]);
        }
        int c = uc8Var.c() - 1;
        if (c < length && c >= 0) {
            this.e.setTip(this.n[c]);
        }
        int e = uc8Var.e() - 1;
        if (e < length && e >= 0) {
            this.g.setTip(this.n[e]);
        }
        int g = uc8Var.g() - 1;
        if (g < length && g >= 0) {
            if (g == 0) {
                this.j.setTip(this.l.getString(R.string.obfuscated_res_0x7f0f0269));
            } else {
                this.j.setTip(this.n[g]);
            }
        }
        A(uc8Var.a(), uc8Var.b());
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.l.getLayoutMode().k(i == 1);
            this.l.getLayoutMode().j(this.b);
            this.a.onChangeSkinType(this.l.getPageContext(), i);
            gs4.d(this.s).v(R.color.CAM_X0108);
            gs4.d(this.t).v(R.color.CAM_X0108);
            gs4.d(this.u).v(R.color.CAM_X0108);
            gs4.d(this.r).f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            this.v.c(this.l.getPageContext(), i);
            this.w.c(this.l.getPageContext(), i);
        }
    }

    public BdSwitchView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.w.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final void u() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (msgSettingItemView = this.v) == null || this.w == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().k();
            this.w.setVisibility(8);
            this.w.getSwitchView().k();
            return;
        }
        msgSettingItemView.getSwitchView().n();
        this.w.getSwitchView().k();
    }

    public final void v(SecretSettingActivity secretSettingActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, secretSettingActivity) == null) {
            this.b = (LinearLayout) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091669);
            NavigationBar navigationBar = (NavigationBar) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.a = navigationBar;
            this.c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(secretSettingActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c4));
            this.d = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f090381);
            this.e = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091939);
            this.f = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0913ae);
            this.k = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09193a);
            this.g = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09193b);
            this.h = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091941);
            this.j = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09200b);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f090fbe);
            this.v = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f06be);
            this.v.setOnSwitchStateChangeListener(this.l);
            this.v.setTextSize(0, mi.f(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView2 = this.v;
            msgSettingItemView2.setPadding(msgSettingItemView2.getPaddingLeft() + 10, this.v.getPaddingTop() + 10, this.v.getPaddingRight() + 10, this.v.getPaddingBottom() + 10);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.l.findViewById(R.id.obfuscated_res_0x7f090fbf);
            this.w = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f1204);
            this.w.setTextSize(0, mi.f(this.l, R.dimen.obfuscated_res_0x7f0702b7));
            MsgSettingItemView msgSettingItemView4 = this.w;
            msgSettingItemView4.setPadding(msgSettingItemView4.getPaddingLeft() + 10, this.w.getPaddingTop() + 10, this.w.getPaddingRight() + 10, this.w.getPaddingBottom() + 10);
            this.w.setOnSwitchStateChangeListener(this.l);
            this.i = secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f0906da);
            this.r = (ScrollView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091380);
            this.s = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091ca2);
            this.t = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091ca3);
            this.u = (TextView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091ca4);
            this.c.setOnClickListener(this.x);
            this.d.setOnClickListener(this.x);
            this.k.setOnClickListener(this.x);
            this.e.setOnClickListener(this.x);
            this.f.setOnClickListener(this.x);
            this.g.setOnClickListener(this.x);
            this.h.setOnClickListener(this.x);
            this.j.setOnClickListener(this.x);
            this.m = this.l.findViewById(R.id.obfuscated_res_0x7f091942);
            this.n = this.l.getResources().getStringArray(R.array.obfuscated_res_0x7f030013);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(PersonGroupActivityConfig.class)) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091940);
            this.o = tbSettingTextTipView;
            tbSettingTextTipView.setOnClickListener(this.x);
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f091938);
            this.p = tbSettingTextTipView2;
            tbSettingTextTipView2.setOnClickListener(this.x);
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) secretSettingActivity.findViewById(R.id.obfuscated_res_0x7f09193c);
            this.q = tbSettingTextTipView3;
            tbSettingTextTipView3.setOnClickListener(this.x);
            UserData e = s35.d().e();
            if (e != null && e.getBazhuGradeData() != null && !StringUtils.isNull(e.getBazhuGradeData().getDesc()) && !StringUtils.isNull(e.getBazhuGradeData().getLevel())) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            u();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.g();
        }
    }

    public void x(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.y = bVar;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
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
}
