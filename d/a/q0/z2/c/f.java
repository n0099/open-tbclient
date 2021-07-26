package d.a.q0.z2.c;

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
/* loaded from: classes8.dex */
public class f extends d.a.d.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f67310a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f67311b;

    /* renamed from: c  reason: collision with root package name */
    public View f67312c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f67313d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f67314e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f67315f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f67316g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f67317h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f67318i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67319e;

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
            this.f67319e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f67319e.f67316g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f67319e.f67318i, this.f67319e.k())));
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.f67318i = msgReceiveActivity;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67312c : (View) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f67315f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (msgReceiveActivity = this.f67318i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f67310a = (ViewGroup) this.f67318i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f67318i.findViewById(R.id.navigation_bar_msg_receive);
        this.f67311b = navigationBar;
        navigationBar.setCenterTextTitle(this.f67318i.getPageContext().getString(R.string.receive_message));
        this.f67311b.showBottomLine();
        this.f67312c = this.f67311b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f67318i.findViewById(R.id.item_view_friend_msg);
        this.f67313d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f67313d.setOnSwitchStateChangeListener(this.f67318i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f67318i.findViewById(R.id.item_view_stranger_msg);
        this.f67314e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f67314e.setOnSwitchStateChangeListener(this.f67318i);
        this.f67314e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f67318i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f67315f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f67315f.setOnSwitchStateChangeListener(this.f67318i);
        this.f67315f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f67318i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f67316g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f67313d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67317h : (ArrayList) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67314e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f67318i == null) {
            return;
        }
        initUI();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f67315f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.p0.t.d.d.d().l());
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f67313d) == null || this.f67314e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f67313d.setLineVisibility(false);
            this.f67314e.setVisibility(8);
            this.f67314e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f67313d.setLineVisibility(true);
        this.f67314e.getSwitchView().h();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f67310a, R.color.CAM_X0204, i2);
            this.f67311b.onChangeSkinType(this.f67318i.getPageContext(), i2);
            this.f67313d.c(this.f67318i.getPageContext(), i2);
            this.f67314e.c(this.f67318i.getPageContext(), i2);
            this.f67315f.c(this.f67318i.getPageContext(), i2);
            this.f67316g.f(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f67313d.setLineVisibility(z);
        }
    }

    public void q(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            this.f67317h = arrayList;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f67314e.setVisibility(0);
            } else {
                this.f67314e.setVisibility(8);
            }
        }
    }
}
