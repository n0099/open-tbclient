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
import com.repackage.oq4;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ia8 extends z8<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public RelativeLayout C;
    public BdSwitchView D;
    public RelativeLayout E;
    public BdSwitchView F;
    public MoreActivity a;
    public ha8 b;
    public NavigationBar c;
    public mq4 d;
    public oq4 e;
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
    public class a implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq4 a;
        public final /* synthetic */ ia8 b;

        public a(ia8 ia8Var, kq4 kq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia8Var, kq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia8Var;
            this.a = kq4Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) && i == this.a.f()) {
                this.b.v();
                this.b.b.a(12);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oq4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia8 a;

        public b(ia8 ia8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia8Var;
        }

        @Override // com.repackage.oq4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia8 a;

        public c(ia8 ia8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia8Var;
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
                    ys4.k().w("setting_private_red_dot", 0);
                    this.a.p.i();
                    this.a.b.a(9);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia8(MoreActivity moreActivity, ha8 ha8Var) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, ha8Var};
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
        this.b = ha8Var;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d053f);
        B();
        M();
    }

    public final void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
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

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View.OnClickListener y = y();
            this.u = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09161e);
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f091bf1);
            this.a.findViewById(R.id.obfuscated_res_0x7f090ce6).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.c = navigationBar;
            this.w = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1136));
            this.c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09004e);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09174b);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090ee9);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09004d);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0903ef);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09007e);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0913cb);
            SettingTextRedDotView settingTextRedDotView = (SettingTextRedDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091c4f);
            this.p = settingTextRedDotView;
            settingTextRedDotView.i();
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f0922ce);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090969);
            this.s = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091e1e);
            this.t = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0919a5);
            if (!TbadkCoreApplication.isLogin()) {
                this.t.setVisibility(8);
            }
            this.C = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09092e);
            this.D = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090f70);
            li.b(this.a.getPageContext().getPageActivity(), this.D, 10, 10, 10, 10);
            this.E = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0909e8);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909e9);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f53);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0909eb);
            this.F = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f0909ea);
            li.b(this.a.getPageContext().getPageActivity(), this.F, 10, 10, 10, 10);
            this.x = this.a.findViewById(R.id.obfuscated_res_0x7f0907c1);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0907c0);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0907c2);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0907c3);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0907c4);
            F();
            L();
            this.j.b();
            K(TbadkCoreApplication.getInst().getSkinType());
            this.y.setVisibility(0);
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            A(y);
            if (!u()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0340));
                this.x.setVisibility(8);
                this.C.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.C.setVisibility(0);
            }
            this.E.setVisibility(w() ? 0 : 8);
            if (ys4.k().h("key_is_follow_system_mode", false)) {
                this.F.n();
            } else {
                this.F.k();
            }
        }
    }

    public void C(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
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

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTip(areNotificationsEnabled ? "" : this.a.getString(R.string.obfuscated_res_0x7f0f0aa5));
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || TbadkCoreApplication.getInst().getSkinType() == i) {
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

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.d == null) {
                t();
            }
            this.d.m();
        }
    }

    public void I() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (textView = this.t) == null || textView.getVisibility() == 0) {
            return;
        }
        this.t.setVisibility(0);
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            sl4 layoutMode = this.a.getLayoutMode();
            boolean z = true;
            if (i != 1 && i != 4) {
                z = false;
            }
            layoutMode.k(z);
            this.a.getLayoutMode().j(this.u);
            this.c.onChangeSkinType(getPageContext(), i);
            F();
            this.D.b();
            this.F.b();
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.i.setLocalIcon(SkinManager.getResourceId(R.drawable.icon_mine_list_baidu));
            oq4 oq4Var = this.e;
            if (oq4Var != null) {
                oq4Var.i();
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

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.D.l();
            } else {
                this.D.i();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            K(i);
            if (this.e != null) {
                this.a.getLayoutMode().k(i == 1 || i == 4);
                this.a.getLayoutMode().j(this.e.f());
            }
            if (i == 1) {
                this.D.n();
            } else {
                this.D.k();
            }
            wq4.d(this.f).v(R.color.CAM_X0105);
            wq4.d(this.g).v(R.color.CAM_X0105);
            wq4.d(this.h).v(R.color.CAM_X0109);
            wq4 d = wq4.d(this.t);
            d.v(R.color.CAM_X0301);
            d.f(R.color.CAM_X0205);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            oq4 oq4Var = new oq4(getPageContext().getPageActivity());
            this.e = oq4Var;
            oq4Var.q(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f52));
            ArrayList arrayList = new ArrayList();
            kq4 kq4Var = new kq4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f54), this.e);
            kq4Var.q(R.color.CAM_X0301);
            arrayList.add(kq4Var);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4);
            this.a.getLayoutMode().j(this.e.f());
            a aVar = new a(this, kq4Var);
            b bVar = new b(this);
            this.e.j(arrayList);
            this.e.n(aVar);
            this.e.m(bVar);
            mq4 mq4Var = new mq4(this.mContext);
            this.d = mq4Var;
            mq4Var.setCanceledOnTouchOutside(true);
            this.d.i(this.e);
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        mq4 mq4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (mq4Var = this.d) == null) {
            return;
        }
        mq4Var.dismiss();
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (u()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return ys4.k().h("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.D : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.F : (BdSwitchView) invokeV.objValue;
    }
}
