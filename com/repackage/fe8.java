package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
import com.baidu.tieba.setting.more.MsgReceiveActivity;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushActivityConfig;
import com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class fe8 extends z8<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public NavigationBar b;
    public View c;
    public MsgSettingItemView d;
    public MsgSettingItemView e;
    public MsgSettingItemView f;
    public TbSettingTextTipView g;
    public ArrayList<OfficialAccountPushInfo> h;
    public MsgReceiveActivity i;
    public View.OnClickListener j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fe8 a;

        public a(fe8 fe8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fe8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.a.i, this.a.k())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe8(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgReceiveActivity};
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
        this.j = new a(this);
        this.i = msgReceiveActivity;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (ArrayList) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.i == null) {
            return;
        }
        p();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (msgSettingItemView = this.f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(zx4.d().m());
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.d) == null || this.e == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().i();
            this.d.setLineVisibility(false);
            this.e.setVisibility(8);
            this.e.getSwitchView().i();
            return;
        }
        msgSettingItemView.getSwitchView().l();
        this.d.setLineVisibility(true);
        this.e.getSwitchView().i();
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0204, i);
            this.b.onChangeSkinType(this.i.getPageContext(), i);
            this.d.c(this.i.getPageContext(), i);
            this.e.c(this.i.getPageContext(), i);
            this.f.c(this.i.getPageContext(), i);
            this.g.f(i);
        }
    }

    public final void p() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgReceiveActivity = this.i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.obfuscated_res_0x7f0d0564);
        this.a = (ViewGroup) this.i.findViewById(R.id.obfuscated_res_0x7f091457);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f091518);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.i.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f36));
        this.b.showBottomLine();
        this.c = this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fae);
        this.d = msgSettingItemView;
        msgSettingItemView.setText(R.string.obfuscated_res_0x7f0f06b5);
        this.d.setOnSwitchStateChangeListener(this.i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fb0);
        this.e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.obfuscated_res_0x7f0f11e7);
        this.e.setOnSwitchStateChangeListener(this.i);
        this.e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.i.findViewById(R.id.obfuscated_res_0x7f090fad);
        this.f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.obfuscated_res_0x7f0f0f35);
        this.f.setOnSwitchStateChangeListener(this.i);
        this.f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.i.findViewById(R.id.obfuscated_res_0x7f090faf);
        this.g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d.setLineVisibility(z);
        }
    }

    public void s(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            this.h = arrayList;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }
}
