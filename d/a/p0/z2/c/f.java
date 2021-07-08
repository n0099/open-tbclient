package d.a.p0.z2.c;

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
public class f extends d.a.c.a.d<MsgReceiveActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f66632a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f66633b;

    /* renamed from: c  reason: collision with root package name */
    public View f66634c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66635d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f66636e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f66637f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66638g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f66639h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f66640i;
    public View.OnClickListener j;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f66641e;

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
            this.f66641e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f66641e.f66638g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(this.f66641e.f66640i, this.f66641e.k())));
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
        this.f66640i = msgReceiveActivity;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66634c : (View) invokeV.objValue;
    }

    public BdSwitchView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66637f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (msgReceiveActivity = this.f66640i) == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f66632a = (ViewGroup) this.f66640i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66640i.findViewById(R.id.navigation_bar_msg_receive);
        this.f66633b = navigationBar;
        navigationBar.setCenterTextTitle(this.f66640i.getPageContext().getString(R.string.receive_message));
        this.f66633b.showBottomLine();
        this.f66634c = this.f66633b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66640i.findViewById(R.id.item_view_friend_msg);
        this.f66635d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f66635d.setOnSwitchStateChangeListener(this.f66640i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f66640i.findViewById(R.id.item_view_stranger_msg);
        this.f66636e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f66636e.setOnSwitchStateChangeListener(this.f66640i);
        this.f66636e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f66640i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f66637f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f66637f.setOnSwitchStateChangeListener(this.f66640i);
        this.f66637f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66640i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f66638g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66635d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66639h : (ArrayList) invokeV.objValue;
    }

    public BdSwitchView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66636e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f66640i == null) {
            return;
        }
        initUI();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (msgSettingItemView = this.f66637f) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.o0.s.d.d.d().l());
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (msgSettingItemView = this.f66635d) == null || this.f66636e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f66635d.setLineVisibility(false);
            this.f66636e.setVisibility(8);
            this.f66636e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f66635d.setLineVisibility(true);
        this.f66636e.getSwitchView().h();
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f66632a, R.color.CAM_X0204, i2);
            this.f66633b.onChangeSkinType(this.f66640i.getPageContext(), i2);
            this.f66635d.c(this.f66640i.getPageContext(), i2);
            this.f66636e.c(this.f66640i.getPageContext(), i2);
            this.f66637f.c(this.f66640i.getPageContext(), i2);
            this.f66638g.f(i2);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f66635d.setLineVisibility(z);
        }
    }

    public void q(ArrayList<OfficialAccountPushInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, arrayList) == null) {
            this.f66639h = arrayList;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                this.f66636e.setVisibility(0);
            } else {
                this.f66636e.setVisibility(8);
            }
        }
    }
}
