package com.repackage;

import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.SettingTextImageView;
import com.baidu.tieba.setting.more.SettingTextNormalImageView;
import com.baidu.tieba.setting.more.SettingTextRedDotView;
import com.baidu.tieba.setting.more.SettingTextVersionView;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nr4;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class kc8 extends b9<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public RelativeLayout C;
    public BdSwitchView D;
    public RelativeLayout E;
    public BdSwitchView F;
    public MoreActivity a;
    public jc8 b;
    public NavigationBar c;
    public lr4 d;
    public nr4 e;
    public TextView f;
    public TextView g;
    public TextView h;
    public SettingTextNormalImageView i;
    public SettingTextImageView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public SettingTextRedDotView p;
    public SettingTextVersionView q;
    public TbSettingTextTipView r;
    public TbSettingTextNewDotView s;
    public TextView t;
    public RelativeLayout u;
    public View v;
    public View w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes6.dex */
    public class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jr4 a;
        public final /* synthetic */ kc8 b;

        public a(kc8 kc8Var, jr4 jr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var, jr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kc8Var;
            this.a = jr4Var;
        }

        @Override // com.repackage.nr4.e
        public void N(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) && i == this.a.f()) {
                this.b.x();
                this.b.b.a(12);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public b(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // com.repackage.nr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc8 a;

        public c(kc8 kc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.w) {
                    this.a.b.a(0);
                } else if (view2 == this.a.j) {
                    this.a.b.a(1);
                } else if (view2 == this.a.k) {
                    this.a.b.a(15);
                } else if (view2 == this.a.l) {
                    this.a.b.a(2);
                } else if (view2 == this.a.m) {
                    this.a.b.a(3);
                } else if (view2 == this.a.o) {
                    this.a.b.a(4);
                } else if (view2 != this.a.p) {
                    if (view2 == this.a.q) {
                        this.a.b.a(6);
                    } else if (view2 == this.a.r) {
                        this.a.b.a(7);
                    } else if (view2 == this.a.s) {
                        this.a.b.a(5);
                    } else if (view2 == this.a.t) {
                        this.a.b.a(10);
                    } else if (view2 == this.a.i) {
                        this.a.b.a(13);
                    } else if (view2 == this.a.n) {
                        this.a.b.a(16);
                    }
                } else {
                    xt4.k().w("setting_private_red_dot", 0);
                    this.a.p.i();
                    this.a.b.a(9);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kc8(MoreActivity moreActivity, jc8 jc8Var) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, jc8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.a = moreActivity;
        this.b = jc8Var;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d0556);
        D();
        O();
    }

    public final View.OnClickListener A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.F : (BdSwitchView) invokeV.objValue;
    }

    public final void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
            this.l.setOnClickListener(onClickListener);
            this.m.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.o.setOnClickListener(onClickListener);
            this.p.setOnClickListener(onClickListener);
            this.q.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.t.setOnClickListener(onClickListener);
            this.D.setOnSwitchStateChangeListener(this.a);
            this.F.setOnSwitchStateChangeListener(this.a);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View.OnClickListener A = A();
            this.u = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0916ba);
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f091c88);
            this.a.findViewById(R.id.obfuscated_res_0x7f090ce3).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f092437);
            this.c = navigationBar;
            this.w = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1138));
            this.c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09004e);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0917f1);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090eec);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09004d);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0903eb);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09007e);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091469);
            SettingTextRedDotView settingTextRedDotView = (SettingTextRedDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091cec);
            this.p = settingTextRedDotView;
            settingTextRedDotView.i();
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f092363);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09095e);
            this.s = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091eb7);
            this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091a44);
            if (!TbadkCoreApplication.isLogin()) {
                this.t.setVisibility(8);
            }
            this.C = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090923);
            this.D = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090f70);
            pi.b(this.a.getPageContext().getPageActivity(), this.D, 10, 10, 10, 10);
            this.E = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909df);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909e0);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f53);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909e2);
            this.F = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0909e1);
            pi.b(this.a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.x = this.a.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0907b2);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0907b4);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0907b5);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0907b6);
            H();
            N();
            this.j.b();
            M(TbadkCoreApplication.getInst().getSkinType());
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            C(A);
            if (!w()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0342));
                this.x.setVisibility(8);
                this.C.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.C.setVisibility(0);
            }
            this.E.setVisibility(y() ? 0 : 8);
            if (xt4.k().h("key_is_follow_system_mode", false)) {
                this.F.m();
            } else {
                this.F.j();
            }
        }
    }

    public void E(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) {
            if (str != null && str.length() > 0) {
                this.j.a();
                this.j.setIcon(str, z);
                return;
            }
            SettingTextImageView settingTextImageView = this.j;
            if (settingTextImageView != null) {
                settingTextImageView.b();
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTip(areNotificationsEnabled ? "" : this.a.getString(R.string.obfuscated_res_0x7f0f0a97));
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j.e();
            this.k.g();
            this.l.g();
            this.m.g();
            this.o.g();
            this.p.g();
            this.q.g();
            this.r.g();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SettingTextVersionView settingTextVersionView = this.q;
            if (settingTextVersionView != null) {
                settingTextVersionView.i();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.s;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.i();
            }
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || TbadkCoreApplication.getInst().getSkinType() == i) {
            return;
        }
        if (i == 1) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "1").param("obj_source", "0"));
        } else if (i == 0 || i == 4) {
            onChangeSkinType(i);
            TbadkCoreApplication.getInst().setSkinType(i);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", "0").param("obj_source", "0"));
        }
        BitmapHelper.clearCashBitmap();
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.d == null) {
                v();
            }
            this.d.m();
        }
    }

    public void L() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (textView = this.t) == null || textView.getVisibility() == 0) {
            return;
        }
        this.t.setVisibility(0);
    }

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            rm4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i != 1 && i != 4) {
                z = false;
            }
            layoutMode.k(z);
            this.a.getLayoutMode().j(this.u);
            this.c.onChangeSkinType(getPageContext(), i);
            H();
            this.D.b();
            this.F.b();
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            nr4 nr4Var = this.e;
            if (nr4Var != null) {
                nr4Var.i();
            }
            this.i.c(i);
            this.j.f(i);
            this.k.f(i);
            this.l.f(i);
            this.m.f(i);
            this.n.f(i);
            this.o.f(i);
            this.p.f(i);
            this.q.f(i);
            this.r.f(i);
            this.s.f(i);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.D.k();
            } else {
                this.D.h();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            M(i);
            if (this.e != null) {
                this.a.getLayoutMode().k(i == 1 || i == 4);
                this.a.getLayoutMode().j(this.e.f());
            }
            if (i == 1) {
                this.D.m();
            } else {
                this.D.j();
            }
            ur4.d(this.f).v(R.color.CAM_X0105);
            ur4.d(this.g).v(R.color.CAM_X0105);
            ur4.d(this.h).v(R.color.CAM_X0109);
            ur4 d = ur4.d(this.t);
            d.v(R.color.CAM_X0301);
            d.f(R.color.CAM_X0205);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            this.e = nr4Var;
            nr4Var.q(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f58));
            ArrayList arrayList = new ArrayList();
            jr4 jr4Var = new jr4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f5a), this.e);
            jr4Var.q(R.color.CAM_X0301);
            arrayList.add(jr4Var);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4);
            this.a.getLayoutMode().j(this.e.f());
            a aVar = new a(this, jr4Var);
            b bVar = new b(this);
            this.e.j(arrayList);
            this.e.n(aVar);
            this.e.m(bVar);
            lr4 lr4Var = new lr4(this.mContext);
            this.d = lr4Var;
            lr4Var.setCanceledOnTouchOutside(true);
            this.d.i(this.e);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (lr4Var = this.d) == null) {
            return;
        }
        lr4Var.dismiss();
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (w()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return xt4.k().h("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.D : (BdSwitchView) invokeV.objValue;
    }
}
