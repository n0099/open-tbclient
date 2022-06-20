package com.repackage;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class sb8 extends b9<SystemHelpSettingActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SystemHelpSettingActivity a;
    public View b;
    public TbSettingTextTipView c;
    public TbSettingTextTipView d;
    public BdSwitchView e;
    public BdSwitchView f;
    public TbSettingTextNewDotView g;
    public MsgSettingItemView h;
    public TbSettingTextTipView i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public NavigationBar p;
    public BdSwitchView.b q;

    /* loaded from: classes7.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public a(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void j0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) && view2 == this.a.h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                ht4 k = ht4.k();
                k.u("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
                this.a.a.C1("recnbar", z ^ true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sb8 sb8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001303) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sb8(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {systemHelpSettingActivity};
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.q = new a(this);
        new b(this, 2001303);
        this.a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.obfuscated_res_0x7f0d07d3);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f09238f);
        this.p = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f135b));
        this.p.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090613);
        this.c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.c.setOnClickListener(this.a);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090614);
        this.d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.d.setOnClickListener(this.a);
        this.e = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f090f5f);
        pi.b(this.a.getPageContext().getPageActivity(), this.e, 10, 10, 10, 10);
        this.e.setOnSwitchStateChangeListener(this.a);
        this.f = (BdSwitchView) this.a.findViewById(R.id.obfuscated_res_0x7f091c82);
        pi.b(this.a.getPageContext().getPageActivity(), this.f, 10, 10, 10, 10);
        this.f.setOnSwitchStateChangeListener(this.a);
        this.i = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090734);
        this.j = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e10);
        this.k = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091e12);
        this.l = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e11);
        this.o = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f42);
        this.m = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090f43);
        this.n = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091e0f);
        if (em4.h()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.c();
        this.i.setOnClickListener(this.a);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f091611);
        if (TbadkCoreApplication.isLogin()) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.obfuscated_res_0x7f091dcc);
        this.g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.a);
        this.g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.a.findViewById(R.id.obfuscated_res_0x7f0919d2);
        this.h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.h.setText(R.string.obfuscated_res_0x7f0f0ee5);
        this.h.setOnSwitchStateChangeListener(this.q);
        ht4 k = ht4.k();
        p(k.h("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (TbSettingTextTipView) invokeV.objValue;
    }

    public TbSettingTextTipView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (TbSettingTextTipView) invokeV.objValue;
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (BdSwitchView) invokeV.objValue;
    }

    public TbSettingTextNewDotView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (TbSettingTextNewDotView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.b);
            this.p.onChangeSkinType(getPageContext(), i);
            this.e.b();
            this.f.b();
            this.h.c(this.a.getPageContext(), i);
            SkinManager.setBackgroundResource(this.c, R.drawable.more_all);
            fr4.d(this.j).v(R.color.CAM_X0205);
            fr4.d(this.k).v(R.color.CAM_X0205);
            fr4.d(this.l).v(R.color.CAM_X0105);
            fr4.d(this.m).v(R.color.CAM_X0109);
            fr4.d(this.n).v(R.color.CAM_X0108);
            fr4.d(this.o).v(R.color.CAM_X0105);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                this.h.getSwitchView().m();
            } else {
                this.h.getSwitchView().j();
            }
        }
    }
}
