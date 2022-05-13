package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class cd8 extends z8<MsgRemindActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgSettingItemView a;
    public MsgSettingItemView b;
    public MsgSettingItemView c;
    public MsgSettingItemView d;
    public MsgSettingItemView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public MsgSettingItemView i;
    public View j;
    public NavigationBar k;
    public View l;
    public boolean m;
    public final MsgRemindActivity n;
    public MsgSettingItemView o;
    public MsgSettingItemView p;
    public MsgSettingItemView q;
    public TextView r;
    public TextView s;
    public TextView t;

    /* loaded from: classes5.dex */
    public class a implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cd8 a;

        public a(cd8 cd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cd8Var;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i, str) == null) {
                Iterator<OfficialAccountPushInfo> it = arrayList.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    OfficialAccountPushInfo next = it.next();
                    if (next.uid == 1501754229) {
                        if (next.is_on == 1) {
                            z = true;
                        }
                    }
                }
                if (my4.d().m() != z) {
                    this.a.p.setSwitchStateNoCallback(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd8(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgRemindActivity};
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
        this.j = null;
        this.k = null;
        this.m = true;
        this.n = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.obfuscated_res_0x7f0d0558);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (my4.d().B()) {
                this.i.g();
            } else {
                this.i.e();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (my4.d().C()) {
                this.e.f();
                this.f.setVisibility(0);
                H();
                return;
            }
            this.e.d();
            this.f.setVisibility(8);
        }
    }

    public void C(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgRemindActivity) == null) {
            this.j = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091669);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.k = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f2c));
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f090aab);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091a98);
            this.a = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0fa6);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092500);
            this.b = msgSettingItemView2;
            msgSettingItemView2.setVisibility(0);
            this.b.setText(R.string.obfuscated_res_0x7f0f0089);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0902b3);
            this.c = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f0abc);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09155f);
            this.d = msgSettingItemView4;
            msgSettingItemView4.setText(R.string.obfuscated_res_0x7f0f0c31);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d49);
            this.e = msgSettingItemView5;
            msgSettingItemView5.setText(R.string.obfuscated_res_0x7f0f1183);
            this.f = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d47);
            this.g = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d4a);
            this.h = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d4c);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0915a1);
            this.i = msgSettingItemView6;
            msgSettingItemView6.setText(R.string.obfuscated_res_0x7f0f0c48);
            this.i.setTipText(R.string.obfuscated_res_0x7f0f0c49);
            this.r = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0921ff);
            this.s = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092245);
            this.t = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0921d7);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0914ae);
            this.q = msgSettingItemView7;
            msgSettingItemView7.setText(R.string.obfuscated_res_0x7f0f0b3b);
            this.q.setTipText(R.string.obfuscated_res_0x7f0f0b3c);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f090fbd);
            this.o = msgSettingItemView8;
            msgSettingItemView8.setText(R.string.obfuscated_res_0x7f0f0f51);
            this.o.setOnSwitchStateChangeListener(this.n);
            this.o.setLineVisibility(false);
            x();
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f090fc0);
            this.p = msgSettingItemView9;
            msgSettingItemView9.setText(R.string.obfuscated_res_0x7f0f0cc4);
            this.p.setOnSwitchStateChangeListener(this.n);
            this.p.setLineVisibility(false);
            D();
        }
    }

    public final void D() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (msgSettingItemView = this.p) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(my4.d().m());
        new OfficialAccountPushModel(new a(this)).z();
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                SkinManager.setBackgroundResource(this.f, R.drawable.more_all);
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.l.setVisibility((this.m && z) ? 0 : 8);
        }
    }

    public void G() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (msgRemindActivity = this.n) == null) {
            return;
        }
        oy4.c().k(this.n.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
    }

    public void H() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (my4.d().C()) {
                int j = my4.d().j();
                int k = my4.d().k();
                if (j > 9) {
                    str = String.valueOf(j);
                } else {
                    str = "0" + j;
                }
                if (k > 9) {
                    str2 = String.valueOf(k);
                } else {
                    str2 = "0" + k;
                }
                this.g.setText(this.n.getString(R.string.obfuscated_res_0x7f0f1184, new Object[]{str, str2}));
                this.f.setVisibility(0);
                if (this.e.b()) {
                    return;
                }
                this.e.g();
                return;
            }
            this.g.setText(R.string.obfuscated_res_0x7f0f03ed);
            this.f.setVisibility(8);
            if (this.e.b()) {
                this.e.e();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.c.setOnSwitchStateChangeListener(null);
            this.c.setSwitchStateNoCallback(my4.d().s());
            this.c.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setOnSwitchStateChangeListener(null);
            this.d.setSwitchStateNoCallback(my4.d().v());
            this.d.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.i.setOnSwitchStateChangeListener(null);
            this.i.setSwitchStateNoCallback(my4.d().B());
            this.i.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.setOnSwitchStateChangeListener(null);
            this.a.setSwitchStateNoCallback(my4.d().x());
            this.a.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.setOnSwitchStateChangeListener(null);
            this.b.setSwitchStateNoCallback(my4.d().A());
            this.b.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.q.setOnSwitchStateChangeListener(null);
            this.q.setSwitchStateNoCallback(my4.d().p());
            this.q.setOnSwitchStateChangeListener(this.n);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.i.setVisibility(8);
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            g();
        }
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.c.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.o.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.k.getCenterText() : (TextView) invokeV.objValue;
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.i.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            this.k.onChangeSkinType(this.n.getPageContext(), i);
            gs4.d(this.r).v(R.color.CAM_X0109);
            gs4.d(this.s).v(R.color.CAM_X0109);
            gs4.d(this.t).v(R.color.CAM_X0109);
            this.a.c(this.n.getPageContext(), i);
            this.b.c(this.n.getPageContext(), i);
            this.c.c(this.n.getPageContext(), i);
            this.d.c(this.n.getPageContext(), i);
            this.e.c(this.n.getPageContext(), i);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            this.o.c(this.n.getPageContext(), i);
            this.p.c(this.n.getPageContext(), i);
            this.q.c(this.n.getPageContext(), i);
            this.i.c(this.n.getPageContext(), i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(null, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091d48), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public BdSwitchView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.a.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public BdSwitchView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? (this.g == null || TextUtils.equals(this.n.getString(R.string.obfuscated_res_0x7f0f03ed), this.g.getText().toString())) ? "" : this.g.getText().toString() : (String) invokeV.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public BdSwitchView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.b.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void w(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, msgRemindActivity) == null) {
            C(msgRemindActivity);
            z();
            B();
            A();
            y(msgRemindActivity);
            h();
        }
    }

    public final void x() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (msgSettingItemView = this.o) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(my4.d().n());
    }

    public final void y(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, msgRemindActivity) == null) {
            this.a.setOnSwitchStateChangeListener(msgRemindActivity);
            this.c.setOnSwitchStateChangeListener(msgRemindActivity);
            this.q.setOnSwitchStateChangeListener(msgRemindActivity);
            this.b.setOnSwitchStateChangeListener(msgRemindActivity);
            this.d.setOnSwitchStateChangeListener(msgRemindActivity);
            this.e.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f.setOnClickListener(msgRemindActivity);
            this.i.setOnSwitchStateChangeListener(msgRemindActivity);
            this.k.getCenterText().setOnClickListener(msgRemindActivity);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.a.setSwitchStateNoCallback(my4.d().x());
            this.b.setSwitchStateNoCallback(my4.d().A());
            this.c.setSwitchStateNoCallback(my4.d().s());
            this.d.setSwitchStateNoCallback(my4.d().v());
            this.q.setSwitchStateNoCallback(my4.d().p());
        }
    }
}
