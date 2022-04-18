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
public class le8 extends z8<MoreActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public View B;
    public View C;
    public RelativeLayout D;
    public BdSwitchView E;
    public RelativeLayout F;
    public BdSwitchView G;
    public MoreActivity a;
    public ke8 b;
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
    public TbSettingTextTipView p;
    public SettingTextVersionView q;
    public TbSettingTextTipView r;
    public TbSettingTextTipView s;
    public TbSettingTextNewDotView t;
    public TextView u;
    public RelativeLayout v;
    public View w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes6.dex */
    public class a implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jr4 a;
        public final /* synthetic */ le8 b;

        public a(le8 le8Var, jr4 jr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le8Var, jr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = le8Var;
            this.a = jr4Var;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) && i == this.a.f()) {
                this.b.w();
                this.b.b.a(12);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nr4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le8 a;

        public b(le8 le8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le8Var;
        }

        @Override // com.repackage.nr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le8 a;

        public c(le8 le8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = le8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.x) {
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
                } else if (view2 == this.a.p) {
                    this.a.b.a(9);
                } else if (view2 == this.a.q) {
                    this.a.b.a(6);
                } else if (view2 == this.a.r) {
                    this.a.b.a(7);
                } else if (view2 == this.a.s) {
                    this.a.b.a(8);
                } else if (view2 == this.a.t) {
                    this.a.b.a(5);
                } else if (view2 == this.a.u) {
                    this.a.b.a(10);
                } else if (view2 == this.a.i) {
                    this.a.b.a(13);
                } else if (view2 == this.a.n) {
                    this.a.b.a(16);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public le8(MoreActivity moreActivity, ke8 ke8Var) {
        super(moreActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {moreActivity, ke8Var};
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
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.a = moreActivity;
        this.b = ke8Var;
        moreActivity.setContentView(R.layout.obfuscated_res_0x7f0d0556);
        C();
        N();
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.G : (BdSwitchView) invokeV.objValue;
    }

    public final void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
            this.x.setOnClickListener(onClickListener);
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
            this.u.setOnClickListener(onClickListener);
            this.E.setOnSwitchStateChangeListener(this.a);
            this.G.setOnSwitchStateChangeListener(this.a);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View.OnClickListener z = z();
            this.v = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091642);
            this.w = this.a.findViewById(R.id.obfuscated_res_0x7f091bf6);
            this.a.findViewById(R.id.obfuscated_res_0x7f090d35).getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.c = navigationBar;
            this.x = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f110a));
            this.c.showBottomLine();
            this.i = (SettingTextNormalImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09004e);
            this.j = (SettingTextImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09176e);
            this.k = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090f17);
            this.l = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09004d);
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0903f9);
            this.n = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090080);
            this.o = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0913f6);
            this.p = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091c54);
            this.q = (SettingTextVersionView) this.a.findViewById(R.id.obfuscated_res_0x7f0922d3);
            this.r = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090986);
            this.s = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0919dd);
            if (!TbadkCoreApplication.getInst().getIsAppOn()) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
            }
            this.t = (TbSettingTextNewDotView) this.a.findViewById(R.id.obfuscated_res_0x7f091e1f);
            this.u = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091999);
            if (!TbadkCoreApplication.isLogin()) {
                this.u.setVisibility(8);
            }
            this.D = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090951);
            this.E = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090f9f);
            oi.b(this.a.getPageContext().getPageActivity(), this.E, 10, 10, 10, 10);
            this.F = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090a05);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a06);
            this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f82);
            this.h = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090a08);
            this.G = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090a07);
            oi.b(this.a.getPageContext().getPageActivity(), this.G, 10, 10, 10, 10);
            this.y = this.a.findViewById(R.id.obfuscated_res_0x7f0907e6);
            this.z = this.a.findViewById(R.id.obfuscated_res_0x7f0907e5);
            this.A = this.a.findViewById(R.id.obfuscated_res_0x7f0907e7);
            this.B = this.a.findViewById(R.id.obfuscated_res_0x7f0907e8);
            this.C = this.a.findViewById(R.id.obfuscated_res_0x7f0907e9);
            G();
            M();
            this.j.b();
            L(TbadkCoreApplication.getInst().getSkinType());
            this.z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            this.C.setVisibility(0);
            B(z);
            if (!v()) {
                this.m.setTip(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0338));
                this.y.setVisibility(8);
                this.D.setVisibility(8);
            } else {
                this.y.setVisibility(0);
                this.D.setVisibility(0);
            }
            this.F.setVisibility(x() ? 0 : 8);
            if (vt4.k().h("key_is_follow_system_mode", false)) {
                this.G.l();
            } else {
                this.G.i();
            }
        }
    }

    public void D(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
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

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a).areNotificationsEnabled();
            TbSettingTextTipView tbSettingTextTipView = this.o;
            if (tbSettingTextTipView != null) {
                tbSettingTextTipView.setTipViewColor(R.color.CAM_X0105);
                this.o.setTip(areNotificationsEnabled ? "" : this.a.getString(R.string.obfuscated_res_0x7f0f0a97));
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j.e();
            this.k.g();
            this.l.g();
            this.m.g();
            this.o.g();
            this.p.g();
            this.q.g();
            this.r.g();
            this.s.g();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SettingTextVersionView settingTextVersionView = this.q;
            if (settingTextVersionView != null) {
                settingTextVersionView.i();
            }
            TbSettingTextNewDotView tbSettingTextNewDotView = this.t;
            if (tbSettingTextNewDotView != null) {
                tbSettingTextNewDotView.i();
            }
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || TbadkCoreApplication.getInst().getSkinType() == i) {
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.d == null) {
                u();
            }
            this.d.m();
        }
    }

    public void K() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (textView = this.u) == null || textView.getVisibility() == 0) {
            return;
        }
        this.u.setVisibility(0);
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.v);
            this.c.onChangeSkinType(getPageContext(), i);
            G();
            this.E.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e5), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e4), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            this.G.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e5), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e4), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
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
            this.t.f(i);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                this.j.setVisibility(0);
            } else {
                this.j.setVisibility(8);
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.E.j();
            } else {
                this.E.f();
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            L(i);
            if (this.e != null) {
                this.a.getLayoutMode().k(i == 1);
                this.a.getLayoutMode().j(this.e.f());
            }
            if (i == 1) {
                this.E.l();
            } else {
                this.E.i();
            }
            vr4.d(this.f).v(R.color.CAM_X0105);
            vr4.d(this.g).v(R.color.CAM_X0105);
            vr4.d(this.h).v(R.color.CAM_X0109);
            vr4 d = vr4.d(this.u);
            d.v(R.color.CAM_X0301);
            d.f(R.color.CAM_X0205);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            nr4 nr4Var = new nr4(getPageContext().getPageActivity());
            this.e = nr4Var;
            nr4Var.q(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f26));
            ArrayList arrayList = new ArrayList();
            jr4 jr4Var = new jr4(getPageContext().getString(R.string.obfuscated_res_0x7f0f0f28), this.e);
            jr4Var.q(R.color.CAM_X0301);
            arrayList.add(jr4Var);
            this.a.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
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

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            return (runTask == null || StringUtils.isNull((String) runTask.getData())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void w() {
        lr4 lr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (lr4Var = this.d) == null) {
            return;
        }
        lr4Var.dismiss();
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (v()) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return true;
                }
                return vt4.k().h("key_is_dark_mode_notify_shown", false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.E : (BdSwitchView) invokeV.objValue;
    }

    public final View.OnClickListener z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }
}
