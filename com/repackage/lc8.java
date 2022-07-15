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
/* loaded from: classes6.dex */
public class lc8 extends b9<MsgRemindActivity> {
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

    /* loaded from: classes6.dex */
    public class a implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc8 a;

        public a(lc8 lc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc8Var;
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
                if (py4.d().m() != z) {
                    this.a.p.setSwitchStateNoCallback(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc8(MsgRemindActivity msgRemindActivity) {
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = null;
        this.m = true;
        this.n = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.obfuscated_res_0x7f0d0565);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.setSwitchStateNoCallback(py4.d().x());
            this.b.setSwitchStateNoCallback(py4.d().A());
            this.c.setSwitchStateNoCallback(py4.d().s());
            this.d.setSwitchStateNoCallback(py4.d().v());
            this.q.setSwitchStateNoCallback(py4.d().p());
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (py4.d().B()) {
                this.i.g();
            } else {
                this.i.e();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (py4.d().C()) {
                this.e.f();
                this.f.setVisibility(0);
                I();
                return;
            }
            this.e.d();
            this.f.setVisibility(8);
        }
    }

    public void D(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, msgRemindActivity) == null) {
            this.j = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0916ba);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092437);
            this.k = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f36));
            this.k.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.l = msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f090a8f);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091ae7);
            this.a = msgSettingItemView;
            msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f0fbd);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092564);
            this.b = msgSettingItemView2;
            msgSettingItemView2.setVisibility(0);
            this.b.setText(R.string.obfuscated_res_0x7f0f0089);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0902b2);
            this.c = msgSettingItemView3;
            msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f0ab5);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0915b8);
            this.d = msgSettingItemView4;
            msgSettingItemView4.setText(R.string.obfuscated_res_0x7f0f0c2f);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d8e);
            this.e = msgSettingItemView5;
            msgSettingItemView5.setText(R.string.obfuscated_res_0x7f0f1199);
            this.f = (LinearLayout) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d8c);
            this.g = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d8f);
            this.h = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091d91);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f0915fc);
            this.i = msgSettingItemView6;
            msgSettingItemView6.setText(R.string.obfuscated_res_0x7f0f0c47);
            this.i.setTipText(R.string.obfuscated_res_0x7f0f0c48);
            this.r = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f092243);
            this.s = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09228c);
            this.t = (TextView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f09221c);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.obfuscated_res_0x7f091508);
            this.q = msgSettingItemView7;
            msgSettingItemView7.setText(R.string.obfuscated_res_0x7f0f0b34);
            this.q.setTipText(R.string.obfuscated_res_0x7f0f0b35);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f090f7f);
            this.o = msgSettingItemView8;
            msgSettingItemView8.setText(R.string.obfuscated_res_0x7f0f0f66);
            this.o.setOnSwitchStateChangeListener(this.n);
            this.o.setLineVisibility(false);
            y();
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) this.n.findViewById(R.id.obfuscated_res_0x7f090f82);
            this.p = msgSettingItemView9;
            msgSettingItemView9.setText(R.string.obfuscated_res_0x7f0f0cc1);
            this.p.setOnSwitchStateChangeListener(this.n);
            this.p.setLineVisibility(false);
            E();
        }
    }

    public final void E() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (msgSettingItemView = this.p) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(py4.d().m());
        new OfficialAccountPushModel(new a(this)).B();
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
                SkinManager.setBackgroundResource(this.f, R.drawable.more_all);
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l.setVisibility((this.m && z) ? 0 : 8);
        }
    }

    public void H() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgRemindActivity = this.n) == null) {
            return;
        }
        sy4.c().k(this.n.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
    }

    public void I() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (py4.d().C()) {
                int j = py4.d().j();
                int k = py4.d().k();
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
                this.g.setText(this.n.getString(R.string.obfuscated_res_0x7f0f119a, new Object[]{str, str2}));
                this.f.setVisibility(0);
                if (this.e.b()) {
                    return;
                }
                this.e.g();
                return;
            }
            this.g.setText(R.string.obfuscated_res_0x7f0f03e8);
            this.f.setVisibility(8);
            if (this.e.b()) {
                this.e.e();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c.setOnSwitchStateChangeListener(null);
            this.c.setSwitchStateNoCallback(py4.d().s());
            this.c.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.setOnSwitchStateChangeListener(null);
            this.d.setSwitchStateNoCallback(py4.d().v());
            this.d.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.i.setOnSwitchStateChangeListener(null);
            this.i.setSwitchStateNoCallback(py4.d().B());
            this.i.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.a.setOnSwitchStateChangeListener(null);
            this.a.setSwitchStateNoCallback(py4.d().x());
            this.a.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.setOnSwitchStateChangeListener(null);
            this.b.setSwitchStateNoCallback(py4.d().A());
            this.b.setOnSwitchStateChangeListener(this.n);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q.setOnSwitchStateChangeListener(null);
            this.q.setSwitchStateNoCallback(py4.d().p());
            this.q.setOnSwitchStateChangeListener(this.n);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.i.setVisibility(8);
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            h();
        }
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.c.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.o.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.q.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.k.getCenterText() : (TextView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            this.k.onChangeSkinType(this.n.getPageContext(), i);
            ur4.d(this.r).v(R.color.CAM_X0109);
            ur4.d(this.s).v(R.color.CAM_X0109);
            ur4.d(this.t).v(R.color.CAM_X0109);
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
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091d8d), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public BdSwitchView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.i.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.p.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public BdSwitchView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? (this.g == null || TextUtils.equals(this.n.getString(R.string.obfuscated_res_0x7f0f03e8), this.g.getText().toString())) ? "" : this.g.getText().toString() : (String) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public BdSwitchView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.b.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void x(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, msgRemindActivity) == null) {
            D(msgRemindActivity);
            A();
            C();
            B();
            z(msgRemindActivity);
            j();
        }
    }

    public final void y() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (msgSettingItemView = this.o) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(py4.d().n());
    }

    public final void z(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, msgRemindActivity) == null) {
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
}
