package d.a.s0.z2.c;

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
/* loaded from: classes9.dex */
public class f extends d.a.c.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f69829a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f69830b;

    /* renamed from: c  reason: collision with root package name */
    public View f69831c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f69832d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f69833e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f69834f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f69835g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f69836h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f69837i;
    public View.OnClickListener j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f69838e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69838e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f69838e.f69835g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f69838e.f69837i, this.f69838e.l())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgReceiveActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.f69837i = msgReceiveActivity;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69831c : (View) invokeV.objValue;
    }

    public BdSwitchView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69834f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (msgReceiveActivity = this.f69837i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f69829a = (ViewGroup) this.f69837i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f69837i.findViewById(R.id.navigation_bar_msg_receive);
        this.f69830b = navigationBar;
        navigationBar.setCenterTextTitle(this.f69837i.getPageContext().getString(R.string.receive_message));
        this.f69830b.showBottomLine();
        this.f69831c = this.f69830b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f69837i.findViewById(R.id.item_view_friend_msg);
        this.f69832d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f69832d.setOnSwitchStateChangeListener(this.f69837i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f69837i.findViewById(R.id.item_view_stranger_msg);
        this.f69833e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f69833e.setOnSwitchStateChangeListener(this.f69837i);
        this.f69833e.setLineVisibility(false);
        p();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f69837i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f69834f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f69834f.setOnSwitchStateChangeListener(this.f69837i);
        this.f69834f.setLineVisibility(false);
        o();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f69837i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f69835g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69832d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f69836h : (ArrayList) invokeV.objValue;
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f69833e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f69837i == null) {
            return;
        }
        initUI();
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f69834f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.r0.s.d.d.d().l());
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f69829a, R.color.CAM_X0204, i2);
            this.f69830b.onChangeSkinType(this.f69837i.getPageContext(), i2);
            this.f69832d.c(this.f69837i.getPageContext(), i2);
            this.f69833e.c(this.f69837i.getPageContext(), i2);
            this.f69834f.c(this.f69837i.getPageContext(), i2);
            this.f69835g.f(i2);
        }
    }

    public final void p() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgSettingItemView = this.f69832d) == null || this.f69833e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f69832d.setLineVisibility(false);
            this.f69833e.setVisibility(8);
            this.f69833e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f69832d.setLineVisibility(true);
        this.f69833e.getSwitchView().h();
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f69832d.setLineVisibility(z);
        }
    }

    public void r(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            this.f69836h = arrayList;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f69833e.setVisibility(0);
            } else {
                this.f69833e.setVisibility(8);
            }
        }
    }
}
