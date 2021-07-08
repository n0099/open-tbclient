package d.a.p0.z2.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.friendAndStrangerSwitch.GetFriendAndStrangerSwitchModel;
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
/* loaded from: classes8.dex */
public class g extends d.a.c.a.d<MsgRemindActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public boolean B;
    public MsgRemindActivity C;
    public TbSettingTextTipView D;
    public View E;
    public BdSwitchView F;
    public View G;
    public MsgSettingItemView H;
    public MsgSettingItemView I;
    public MsgSettingItemView J;
    public MsgSettingItemView K;

    /* renamed from: a  reason: collision with root package name */
    public MsgSettingItemView f66642a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f66643b;

    /* renamed from: c  reason: collision with root package name */
    public MsgSettingItemView f66644c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66645d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f66646e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f66647f;

    /* renamed from: g  reason: collision with root package name */
    public MsgSettingItemView f66648g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66649h;

    /* renamed from: i  reason: collision with root package name */
    public MsgSettingItemView f66650i;
    public MsgSettingItemView j;
    public MsgSettingItemView k;
    public MsgSettingItemView l;
    public MsgSettingItemView m;
    public LinearLayout n;
    public TextView o;
    public MsgSettingItemView p;
    public LinearLayout q;
    public TextView r;
    public LinearLayout s;
    public NavigationBar t;
    public View u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public TextView y;
    public LinearLayout z;

    /* loaded from: classes8.dex */
    public class a implements OfficialAccountPushModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f66651a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66651a = gVar;
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i2, str) == null) {
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
                if (d.a.o0.s.d.d.d().k() != z) {
                    this.f66651a.K.setSwitchStateNoCallback(z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgRemindActivity};
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
        this.s = null;
        this.t = null;
        this.B = true;
        this.C = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public BdSwitchView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66650i.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f66644c.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (View) invokeV.objValue;
    }

    public BdSwitchView I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66645d.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void L(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, msgRemindActivity) == null) {
            X(msgRemindActivity);
            Q();
            S();
            U();
            T();
            R();
            P(msgRemindActivity);
            j();
        }
    }

    public final void N() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (msgSettingItemView = this.J) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.o0.s.d.d.d().l());
    }

    public final void O() {
        MsgSettingItemView msgSettingItemView;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (msgSettingItemView = this.H) == null || this.I == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.H.setLineVisibility(false);
            this.I.setVisibility(8);
            this.I.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.H.setLineVisibility(true);
        this.I.getSwitchView().h();
    }

    public final void P(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, msgRemindActivity) == null) {
            this.u.setOnClickListener(msgRemindActivity);
            this.f66644c.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66646e.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66645d.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66647f.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66648g.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66649h.setOnSwitchStateChangeListener(msgRemindActivity);
            this.f66650i.setOnSwitchStateChangeListener(msgRemindActivity);
            this.j.setOnSwitchStateChangeListener(msgRemindActivity);
            this.k.setOnSwitchStateChangeListener(msgRemindActivity);
            this.l.setOnSwitchStateChangeListener(msgRemindActivity);
            this.m.setOnSwitchStateChangeListener(msgRemindActivity);
            this.n.setOnClickListener(msgRemindActivity);
            this.p.setOnSwitchStateChangeListener(msgRemindActivity);
            this.q.setOnClickListener(msgRemindActivity);
            this.x.setOnClickListener(msgRemindActivity);
            this.z.setOnClickListener(msgRemindActivity);
            this.D.setOnClickListener(msgRemindActivity);
            this.t.getCenterText().setOnClickListener(msgRemindActivity);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f66644c.setSwitchStateNoCallback(d.a.o0.s.d.d.d().t());
            this.f66645d.setSwitchStateNoCallback(d.a.o0.s.d.d.d().w());
            this.f66646e.setSwitchStateNoCallback(d.a.o0.s.d.d.d().o());
            this.f66647f.setSwitchStateNoCallback(d.a.o0.s.d.d.d().r());
            this.f66648g.setSwitchStateNoCallback(d.a.o0.s.d.d.d().p());
            this.f66649h.setSwitchStateNoCallback(d.a.o0.s.d.d.d().n());
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (d.a.o0.s.d.d.d().x()) {
                this.p.g();
                this.q.setVisibility(0);
                k0();
                return;
            }
            this.p.e();
            this.q.setVisibility(8);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d.a.o0.s.d.d.d().y()) {
                this.m.f();
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                l0();
                return;
            }
            this.m.d();
            this.m.setLineVisibility(false);
            this.n.setVisibility(8);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (d.a.o0.s.d.d.d().u()) {
                this.j.g();
            } else {
                this.j.e();
            }
            if (d.a.o0.s.d.d.d().v()) {
                this.k.g();
            } else {
                this.k.e();
            }
            if (d.a.o0.s.d.d.d().q()) {
                this.l.g();
            } else {
                this.l.e();
            }
        }
    }

    public void X(MsgRemindActivity msgRemindActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, msgRemindActivity) == null) {
            this.s = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
            NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
            this.t = navigationBar;
            navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
            this.t.showBottomLine();
            this.u = this.t.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.v = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
            this.w = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
            MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
            this.f66642a = msgSettingItemView;
            msgSettingItemView.setText(R.string.receive_msg_text);
            this.f66642a.setLineVisibility(false);
            this.f66643b = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
            MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
            this.f66644c = msgSettingItemView2;
            msgSettingItemView2.setText(R.string.reply);
            MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
            this.f66645d = msgSettingItemView3;
            msgSettingItemView3.setVisibility(0);
            this.f66645d.setText(R.string.action_praise_default);
            MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
            this.f66646e = msgSettingItemView4;
            msgSettingItemView4.setText(R.string.mention_atme);
            MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
            this.f66647f = msgSettingItemView5;
            msgSettingItemView5.setText(R.string.new_fans);
            MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
            this.f66648g = msgSettingItemView6;
            msgSettingItemView6.setText(R.string.chat_msg_text);
            MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
            this.f66649h = msgSettingItemView7;
            msgSettingItemView7.setLineVisibility(false);
            this.f66649h.setText(R.string.group_chat_text);
            MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
            this.f66650i = msgSettingItemView8;
            msgSettingItemView8.setText(R.string.remind_screen_lock);
            this.f66650i.setLineVisibility(false);
            MsgSettingItemView msgSettingItemView9 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.tone_remind_swtich);
            this.j = msgSettingItemView9;
            msgSettingItemView9.setText(R.string.remind_tone);
            MsgSettingItemView msgSettingItemView10 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.vibrate_remind_swtich);
            this.k = msgSettingItemView10;
            msgSettingItemView10.setText(R.string.remind_vibrate);
            MsgSettingItemView msgSettingItemView11 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.light_remind_swtich);
            this.l = msgSettingItemView11;
            msgSettingItemView11.setLineVisibility(true);
            this.l.setText(R.string.remind_light);
            MsgSettingItemView msgSettingItemView12 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.sign_remind_swtich);
            this.m = msgSettingItemView12;
            msgSettingItemView12.setText(R.string.sign_remind_outline);
            this.n = (LinearLayout) msgRemindActivity.findViewById(R.id.sign_remind);
            this.o = (TextView) msgRemindActivity.findViewById(R.id.sign_remind_time);
            MsgSettingItemView msgSettingItemView13 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.no_disturb_swtich);
            this.p = msgSettingItemView13;
            msgSettingItemView13.setText(R.string.no_disturb_mode);
            this.p.setLineVisibility(false);
            this.q = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_container);
            this.r = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_mode_time_value);
            this.x = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_start_time);
            this.y = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_start_time_value);
            this.z = (LinearLayout) msgRemindActivity.findViewById(R.id.no_disturb_end_time);
            this.A = (TextView) msgRemindActivity.findViewById(R.id.no_disturb_end_time_value);
            this.D = (TbSettingTextTipView) msgRemindActivity.findViewById(R.id.msg_receive_item_view);
            this.E = msgRemindActivity.findViewById(R.id.layout_system_msg_permission);
            boolean areNotificationsEnabled = NotificationManagerCompat.from(msgRemindActivity).areNotificationsEnabled();
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            TiebaStatic.log(new StatisticItem("c13890").param("obj_type", areNotificationsEnabled ? 1 : 2));
            this.F = (BdSwitchView) msgRemindActivity.findViewById(R.id.system_msg_permission_switch);
            View findViewById = msgRemindActivity.findViewById(R.id.system_msg_permission_switch_cover);
            this.G = findViewById;
            findViewById.setOnClickListener(msgRemindActivity);
            MsgSettingItemView msgSettingItemView14 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_friend_msg);
            this.H = msgSettingItemView14;
            msgSettingItemView14.setText(R.string.friend_msg_switch);
            this.H.setOnSwitchStateChangeListener(this.C);
            MsgSettingItemView msgSettingItemView15 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_stranger_msg);
            this.I = msgSettingItemView15;
            msgSettingItemView15.setText(R.string.stranger_msg_switch);
            this.I.setOnSwitchStateChangeListener(this.C);
            this.I.setLineVisibility(false);
            O();
            MsgSettingItemView msgSettingItemView16 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_forum_broadcast_msg);
            this.J = msgSettingItemView16;
            msgSettingItemView16.setText(R.string.receive_forum_broadcast_message);
            this.J.setOnSwitchStateChangeListener(this.C);
            this.J.setLineVisibility(false);
            N();
            MsgSettingItemView msgSettingItemView17 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_tb_selection_msg);
            this.K = msgSettingItemView17;
            msgSettingItemView17.setText(R.string.official_push_message_switch_text);
            this.K.setOnSwitchStateChangeListener(this.C);
            this.K.setLineVisibility(false);
            Y();
        }
    }

    public final void Y() {
        MsgSettingItemView msgSettingItemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (msgSettingItemView = this.K) == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.o0.s.d.d.d().k());
        new OfficialAccountPushModel(new a(this)).x();
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void a0() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.C).areNotificationsEnabled();
            if (areNotificationsEnabled) {
                this.F.i();
                i2 = 1;
            } else {
                this.F.f();
                i2 = 2;
            }
            this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
            b0(areNotificationsEnabled);
            TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", i2).param("obj_source", 8));
        }
    }

    public final void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                this.f66644c.getSwitchView().setEnabled(true);
                this.f66645d.getSwitchView().setEnabled(true);
                this.f66647f.getSwitchView().setEnabled(true);
                this.f66646e.getSwitchView().setEnabled(true);
                this.H.getSwitchView().setEnabled(true);
                this.I.getSwitchView().setEnabled(true);
                this.J.getSwitchView().setEnabled(true);
                this.K.getSwitchView().setEnabled(true);
                this.m.getSwitchView().setEnabled(true);
                this.p.getSwitchView().setEnabled(true);
                this.f66644c.getSwitchView().setAlpha(1.0f);
                this.f66645d.getSwitchView().setAlpha(1.0f);
                this.f66647f.getSwitchView().setAlpha(1.0f);
                this.f66646e.getSwitchView().setAlpha(1.0f);
                this.H.getSwitchView().setAlpha(1.0f);
                this.I.getSwitchView().setAlpha(1.0f);
                this.J.getSwitchView().setAlpha(1.0f);
                this.K.getSwitchView().setAlpha(1.0f);
                this.m.getSwitchView().setAlpha(1.0f);
                this.p.getSwitchView().setAlpha(1.0f);
                return;
            }
            this.f66644c.getSwitchView().setEnabled(false);
            this.f66645d.getSwitchView().setEnabled(false);
            this.f66647f.getSwitchView().setEnabled(false);
            this.f66646e.getSwitchView().setEnabled(false);
            this.H.getSwitchView().setEnabled(false);
            this.I.getSwitchView().setEnabled(false);
            this.J.getSwitchView().setEnabled(false);
            this.K.getSwitchView().setEnabled(false);
            this.m.getSwitchView().setEnabled(false);
            this.p.getSwitchView().setEnabled(false);
            this.f66644c.getSwitchView().setAlpha(0.3f);
            this.f66645d.getSwitchView().setAlpha(0.3f);
            this.f66647f.getSwitchView().setAlpha(0.3f);
            this.f66646e.getSwitchView().setAlpha(0.3f);
            this.H.getSwitchView().setAlpha(0.3f);
            this.I.getSwitchView().setAlpha(0.3f);
            this.J.getSwitchView().setAlpha(0.3f);
            this.K.getSwitchView().setAlpha(0.3f);
            this.m.getSwitchView().setAlpha(0.3f);
            this.p.getSwitchView().setAlpha(0.3f);
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.H.setLineVisibility(z);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || this.B == z) {
            return;
        }
        this.B = z;
        if (z) {
            this.t.setCenterTextTitle(this.C.getString(R.string.msg_remind));
            this.v.setVisibility(0);
            this.w.setVisibility(8);
            return;
        }
        this.t.setCenterTextTitle(this.C.getString(R.string.no_disturb_mode_time));
        this.w.setVisibility(0);
        this.v.setVisibility(8);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                this.f66642a.setVisibility(8);
                this.f66643b.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.f66650i.setVisibility(8);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f66648g.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.p.setLineVisibility(z);
            if (z) {
                this.q.setVisibility(0);
                k0();
                SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
                return;
            }
            this.q.setVisibility(8);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!TbadkCoreApplication.getInst().isMIUIRom()) {
                this.f66650i.setLineVisibility(true);
            } else {
                this.f66650i.setLineVisibility(false);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (z) {
                this.n.setVisibility(0);
                this.m.setLineVisibility(true);
                SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
                return;
            }
            this.n.setVisibility(8);
            this.m.setLineVisibility(false);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (z) {
                this.I.setVisibility(0);
            } else {
                this.I.setVisibility(8);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            e();
            h();
            f();
            g();
        }
    }

    public void j0() {
        MsgRemindActivity msgRemindActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (msgRemindActivity = this.C) == null) {
            return;
        }
        d.a.o0.s.d.f.c().k(this.C.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
    }

    public BdSwitchView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f66646e.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            String g2 = d.a.o0.s.d.d.d().g();
            String f2 = d.a.o0.s.d.d.d().f();
            TextView textView = this.r;
            textView.setText(g2 + "-" + f2);
            this.y.setText(g2);
            this.A.setText(f2);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.u : (View) invokeV.objValue;
    }

    public void l0() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (d.a.o0.s.d.d.d().y()) {
                int i2 = d.a.o0.s.d.d.d().i();
                int j = d.a.o0.s.d.d.d().j();
                if (i2 > 9) {
                    str = String.valueOf(i2);
                } else {
                    str = "0" + i2;
                }
                if (j > 9) {
                    str2 = String.valueOf(j);
                } else {
                    str2 = "0" + j;
                }
                this.o.setText(this.C.getString(R.string.sign_remind_time, new Object[]{str, str2}));
                this.n.setVisibility(0);
                if (this.m.b()) {
                    return;
                }
                this.m.g();
                return;
            }
            this.o.setText(R.string.close);
            this.n.setVisibility(8);
            if (this.m.b()) {
                this.m.e();
            }
        }
    }

    public BdSwitchView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f66648g.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.f66646e.setOnSwitchStateChangeListener(null);
            this.f66646e.setSwitchStateNoCallback(d.a.o0.s.d.d.d().o());
            this.f66646e.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.J.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.H.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.C.getLayoutMode().k(i2 == 1);
            this.C.getLayoutMode().j(this.s);
            this.t.onChangeSkinType(this.C.getPageContext(), i2);
            this.f66642a.c(this.C.getPageContext(), i2);
            this.f66644c.c(this.C.getPageContext(), i2);
            this.f66645d.c(this.C.getPageContext(), i2);
            this.f66646e.c(this.C.getPageContext(), i2);
            this.f66647f.c(this.C.getPageContext(), i2);
            this.f66648g.c(this.C.getPageContext(), i2);
            this.f66649h.c(this.C.getPageContext(), i2);
            this.f66650i.c(this.C.getPageContext(), i2);
            this.j.c(this.C.getPageContext(), i2);
            this.k.c(this.C.getPageContext(), i2);
            this.l.c(this.C.getPageContext(), i2);
            this.m.c(this.C.getPageContext(), i2);
            this.p.c(this.C.getPageContext(), i2);
            this.H.c(this.C.getPageContext(), i2);
            this.I.c(this.C.getPageContext(), i2);
            this.J.c(this.C.getPageContext(), i2);
            this.K.c(this.C.getPageContext(), i2);
            SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.x, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.z, R.drawable.more_all);
            SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.q.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.n.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.x.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.z.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public BdSwitchView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f66649h.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f66648g.setOnSwitchStateChangeListener(null);
            this.f66648g.setSwitchStateNoCallback(d.a.o0.s.d.d.d().p());
            this.f66648g.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f66642a.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.f66649h.setOnSwitchStateChangeListener(null);
            this.f66649h.setSwitchStateNoCallback(d.a.o0.s.d.d.d().n());
            this.f66649h.setOnSwitchStateChangeListener(this.C);
        }
    }

    public TbSettingTextTipView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.D : (TbSettingTextTipView) invokeV.objValue;
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.t.getCenterText() : (TextView) invokeV.objValue;
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f66647f.setOnSwitchStateChangeListener(null);
            this.f66647f.setSwitchStateNoCallback(d.a.o0.s.d.d.d().r());
            this.f66647f.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f66647f.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f66644c.setOnSwitchStateChangeListener(null);
            this.f66644c.setSwitchStateNoCallback(d.a.o0.s.d.d.d().t());
            this.f66644c.setOnSwitchStateChangeListener(this.C);
        }
    }

    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.z : (LinearLayout) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.q : (View) invokeV.objValue;
    }

    public LinearLayout w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.x : (LinearLayout) invokeV.objValue;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.f66645d.setOnSwitchStateChangeListener(null);
            this.f66645d.setSwitchStateNoCallback(d.a.o0.s.d.d.d().w());
            this.f66645d.setOnSwitchStateChangeListener(this.C);
        }
    }

    public BdSwitchView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.p.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.K.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }

    public BdSwitchView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.l.getSwitchView() : (BdSwitchView) invokeV.objValue;
    }
}
