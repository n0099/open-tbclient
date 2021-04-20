package d.b.i0.v2.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class g extends d.b.c.a.d<MsgRemindActivity> {
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
    public MsgSettingItemView f63109a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f63110b;

    /* renamed from: c  reason: collision with root package name */
    public MsgSettingItemView f63111c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f63112d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f63113e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f63114f;

    /* renamed from: g  reason: collision with root package name */
    public MsgSettingItemView f63115g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f63116h;
    public MsgSettingItemView i;
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

    /* loaded from: classes4.dex */
    public class a implements OfficialAccountPushModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str) {
            boolean z;
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
            if (d.b.h0.s.d.d.d().k() != z) {
                g.this.K.setSwitchStateNoCallback(z);
            }
        }
    }

    public g(MsgRemindActivity msgRemindActivity) {
        super(msgRemindActivity.getPageContext());
        this.s = null;
        this.t = null;
        this.B = true;
        this.C = msgRemindActivity;
        msgRemindActivity.setContentView(R.layout.msg_remind_activity);
    }

    public BdSwitchView A() {
        return this.p.getSwitchView();
    }

    public BdSwitchView B() {
        return this.K.getSwitchView();
    }

    public BdSwitchView E() {
        return this.l.getSwitchView();
    }

    public BdSwitchView F() {
        return this.i.getSwitchView();
    }

    public BdSwitchView G() {
        return this.j.getSwitchView();
    }

    public BdSwitchView I() {
        return this.k.getSwitchView();
    }

    public BdSwitchView J() {
        return this.f63111c.getSwitchView();
    }

    public View K() {
        return this.n;
    }

    public BdSwitchView L() {
        return this.m.getSwitchView();
    }

    public BdSwitchView M() {
        return this.I.getSwitchView();
    }

    public BdSwitchView O() {
        return this.f63112d.getSwitchView();
    }

    public void P(MsgRemindActivity msgRemindActivity) {
        Y(msgRemindActivity);
        T();
        V();
        X();
        W();
        U();
        S(msgRemindActivity);
        k();
    }

    public final void Q() {
        MsgSettingItemView msgSettingItemView = this.J;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.b.h0.s.d.d.d().l());
    }

    public final void R() {
        int i;
        MsgSettingItemView msgSettingItemView = this.H;
        if (msgSettingItemView == null || this.I == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
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

    public final void S(MsgRemindActivity msgRemindActivity) {
        this.u.setOnClickListener(msgRemindActivity);
        this.f63111c.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f63113e.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f63112d.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f63114f.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f63115g.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f63116h.setOnSwitchStateChangeListener(msgRemindActivity);
        this.i.setOnSwitchStateChangeListener(msgRemindActivity);
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

    public final void T() {
        this.f63111c.setSwitchStateNoCallback(d.b.h0.s.d.d.d().t());
        this.f63112d.setSwitchStateNoCallback(d.b.h0.s.d.d.d().w());
        this.f63113e.setSwitchStateNoCallback(d.b.h0.s.d.d.d().o());
        this.f63114f.setSwitchStateNoCallback(d.b.h0.s.d.d.d().r());
        this.f63115g.setSwitchStateNoCallback(d.b.h0.s.d.d.d().p());
        this.f63116h.setSwitchStateNoCallback(d.b.h0.s.d.d.d().n());
    }

    public final void U() {
        if (d.b.h0.s.d.d.d().x()) {
            this.p.g();
            this.q.setVisibility(0);
            p0();
            return;
        }
        this.p.e();
        this.q.setVisibility(8);
    }

    public final void V() {
    }

    public final void W() {
        if (d.b.h0.s.d.d.d().y()) {
            this.m.f();
            this.n.setVisibility(0);
            this.m.setLineVisibility(true);
            r0();
            return;
        }
        this.m.d();
        this.m.setLineVisibility(false);
        this.n.setVisibility(8);
    }

    public final void X() {
        if (d.b.h0.s.d.d.d().u()) {
            this.j.g();
        } else {
            this.j.e();
        }
        if (d.b.h0.s.d.d.d().v()) {
            this.k.g();
        } else {
            this.k.e();
        }
        if (d.b.h0.s.d.d.d().q()) {
            this.l.g();
        } else {
            this.l.e();
        }
    }

    public void Y(MsgRemindActivity msgRemindActivity) {
        this.s = (LinearLayout) msgRemindActivity.findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) msgRemindActivity.findViewById(R.id.view_navigation_bar);
        this.t = navigationBar;
        navigationBar.setCenterTextTitle(msgRemindActivity.getPageContext().getString(R.string.msg_remind));
        this.t.showBottomLine();
        this.u = this.t.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.v = (LinearLayout) msgRemindActivity.findViewById(R.id.front_container);
        this.w = (LinearLayout) msgRemindActivity.findViewById(R.id.back_container);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.receive_message_swtich);
        this.f63109a = msgSettingItemView;
        msgSettingItemView.setText(R.string.receive_msg_text);
        this.f63109a.setLineVisibility(false);
        this.f63110b = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.f63111c = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.reply);
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.f63112d = msgSettingItemView3;
        msgSettingItemView3.setVisibility(0);
        this.f63112d.setText(R.string.action_praise_default);
        MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.f63113e = msgSettingItemView4;
        msgSettingItemView4.setText(R.string.mention_atme);
        MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.f63114f = msgSettingItemView5;
        msgSettingItemView5.setText(R.string.new_fans);
        MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.f63115g = msgSettingItemView6;
        msgSettingItemView6.setText(R.string.chat_msg_text);
        MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.f63116h = msgSettingItemView7;
        msgSettingItemView7.setLineVisibility(false);
        this.f63116h.setText(R.string.group_chat_text);
        MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.i = msgSettingItemView8;
        msgSettingItemView8.setText(R.string.remind_screen_lock);
        this.i.setLineVisibility(false);
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
        R();
        MsgSettingItemView msgSettingItemView16 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_forum_broadcast_msg);
        this.J = msgSettingItemView16;
        msgSettingItemView16.setText(R.string.receive_forum_broadcast_message);
        this.J.setOnSwitchStateChangeListener(this.C);
        this.J.setLineVisibility(false);
        Q();
        MsgSettingItemView msgSettingItemView17 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_tb_selection_msg);
        this.K = msgSettingItemView17;
        msgSettingItemView17.setText(R.string.official_push_message_switch_text);
        this.K.setOnSwitchStateChangeListener(this.C);
        this.K.setLineVisibility(false);
        b0();
    }

    public final void b0() {
        MsgSettingItemView msgSettingItemView = this.K;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.b.h0.s.d.d.d().k());
        new OfficialAccountPushModel(new a()).t();
    }

    public void c0() {
    }

    public void d0() {
        int i;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.C).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.F.i();
            i = 1;
        } else {
            this.F.f();
            i = 2;
        }
        this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
        f0(areNotificationsEnabled);
        TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", i).param("obj_source", 8));
    }

    public final void e() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.f63109a.setVisibility(8);
            this.f63110b.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void f() {
        this.f63115g.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    public final void f0(boolean z) {
        if (z) {
            this.f63111c.getSwitchView().setEnabled(true);
            this.f63112d.getSwitchView().setEnabled(true);
            this.f63114f.getSwitchView().setEnabled(true);
            this.f63113e.getSwitchView().setEnabled(true);
            this.H.getSwitchView().setEnabled(true);
            this.I.getSwitchView().setEnabled(true);
            this.J.getSwitchView().setEnabled(true);
            this.K.getSwitchView().setEnabled(true);
            this.m.getSwitchView().setEnabled(true);
            this.p.getSwitchView().setEnabled(true);
            this.f63111c.getSwitchView().setAlpha(1.0f);
            this.f63112d.getSwitchView().setAlpha(1.0f);
            this.f63114f.getSwitchView().setAlpha(1.0f);
            this.f63113e.getSwitchView().setAlpha(1.0f);
            this.H.getSwitchView().setAlpha(1.0f);
            this.I.getSwitchView().setAlpha(1.0f);
            this.J.getSwitchView().setAlpha(1.0f);
            this.K.getSwitchView().setAlpha(1.0f);
            this.m.getSwitchView().setAlpha(1.0f);
            this.p.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.f63111c.getSwitchView().setEnabled(false);
        this.f63112d.getSwitchView().setEnabled(false);
        this.f63114f.getSwitchView().setEnabled(false);
        this.f63113e.getSwitchView().setEnabled(false);
        this.H.getSwitchView().setEnabled(false);
        this.I.getSwitchView().setEnabled(false);
        this.J.getSwitchView().setEnabled(false);
        this.K.getSwitchView().setEnabled(false);
        this.m.getSwitchView().setEnabled(false);
        this.p.getSwitchView().setEnabled(false);
        this.f63111c.getSwitchView().setAlpha(0.3f);
        this.f63112d.getSwitchView().setAlpha(0.3f);
        this.f63114f.getSwitchView().setAlpha(0.3f);
        this.f63113e.getSwitchView().setAlpha(0.3f);
        this.H.getSwitchView().setAlpha(0.3f);
        this.I.getSwitchView().setAlpha(0.3f);
        this.J.getSwitchView().setAlpha(0.3f);
        this.K.getSwitchView().setAlpha(0.3f);
        this.m.getSwitchView().setAlpha(0.3f);
        this.p.getSwitchView().setAlpha(0.3f);
    }

    public void g0(boolean z) {
        this.H.setLineVisibility(z);
    }

    public final void h() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public void h0(boolean z) {
        if (this.B == z) {
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

    public final void i() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.i.setLineVisibility(true);
        } else {
            this.i.setLineVisibility(false);
        }
    }

    public void i0(boolean z) {
    }

    public void j0(boolean z) {
        this.p.setLineVisibility(z);
        if (z) {
            this.q.setVisibility(0);
            p0();
            SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
            return;
        }
        this.q.setVisibility(8);
    }

    public final void k() {
        e();
        i();
        f();
        h();
    }

    public BdSwitchView l() {
        return this.f63113e.getSwitchView();
    }

    public View m() {
        return this.u;
    }

    public void m0(boolean z) {
        if (z) {
            this.n.setVisibility(0);
            this.m.setLineVisibility(true);
            SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
            return;
        }
        this.n.setVisibility(8);
        this.m.setLineVisibility(false);
    }

    public BdSwitchView n() {
        return this.f63115g.getSwitchView();
    }

    public void n0(boolean z) {
        if (z) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
    }

    public BdSwitchView o() {
        return this.J.getSwitchView();
    }

    public void o0() {
        d.b.h0.s.d.f.c().k(this.C.getActivity(), this.s);
    }

    public void onChangeSkinType(int i) {
        this.C.getLayoutMode().k(i == 1);
        this.C.getLayoutMode().j(this.s);
        this.t.onChangeSkinType(this.C.getPageContext(), i);
        this.f63109a.c(this.C.getPageContext(), i);
        this.f63111c.c(this.C.getPageContext(), i);
        this.f63112d.c(this.C.getPageContext(), i);
        this.f63113e.c(this.C.getPageContext(), i);
        this.f63114f.c(this.C.getPageContext(), i);
        this.f63115g.c(this.C.getPageContext(), i);
        this.f63116h.c(this.C.getPageContext(), i);
        this.i.c(this.C.getPageContext(), i);
        this.j.c(this.C.getPageContext(), i);
        this.k.c(this.C.getPageContext(), i);
        this.l.c(this.C.getPageContext(), i);
        this.m.c(this.C.getPageContext(), i);
        this.p.c(this.C.getPageContext(), i);
        this.H.c(this.C.getPageContext(), i);
        this.I.c(this.C.getPageContext(), i);
        this.J.c(this.C.getPageContext(), i);
        this.K.c(this.C.getPageContext(), i);
        SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.x, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.z, R.drawable.more_all);
        SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.q.findViewById(R.id.no_disturb_mode_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.n.findViewById(R.id.sign_remind_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.x.findViewById(R.id.no_disturb_start_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange((ImageView) this.z.findViewById(R.id.no_disturb_end_time_arrow), R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void p0() {
        String g2 = d.b.h0.s.d.d.d().g();
        String f2 = d.b.h0.s.d.d.d().f();
        TextView textView = this.r;
        textView.setText(g2 + "-" + f2);
        this.y.setText(g2);
        this.A.setText(f2);
    }

    public BdSwitchView q() {
        return this.H.getSwitchView();
    }

    public BdSwitchView r() {
        return this.f63116h.getSwitchView();
    }

    public void r0() {
        String str;
        String str2;
        if (d.b.h0.s.d.d.d().y()) {
            int i = d.b.h0.s.d.d.d().i();
            int j = d.b.h0.s.d.d.d().j();
            if (i > 9) {
                str = String.valueOf(i);
            } else {
                str = "0" + i;
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

    public BdSwitchView s() {
        return this.f63109a.getSwitchView();
    }

    public void s0() {
        this.f63113e.setOnSwitchStateChangeListener(null);
        this.f63113e.setSwitchStateNoCallback(d.b.h0.s.d.d.d().o());
        this.f63113e.setOnSwitchStateChangeListener(this.C);
    }

    public void t0() {
        this.f63115g.setOnSwitchStateChangeListener(null);
        this.f63115g.setSwitchStateNoCallback(d.b.h0.s.d.d.d().p());
        this.f63115g.setOnSwitchStateChangeListener(this.C);
    }

    public TbSettingTextTipView u() {
        return this.D;
    }

    public void u0() {
        this.f63116h.setOnSwitchStateChangeListener(null);
        this.f63116h.setSwitchStateNoCallback(d.b.h0.s.d.d.d().n());
        this.f63116h.setOnSwitchStateChangeListener(this.C);
    }

    public TextView v() {
        return this.t.getCenterText();
    }

    public void v0() {
        this.f63114f.setOnSwitchStateChangeListener(null);
        this.f63114f.setSwitchStateNoCallback(d.b.h0.s.d.d.d().r());
        this.f63114f.setOnSwitchStateChangeListener(this.C);
    }

    public BdSwitchView w() {
        return this.f63114f.getSwitchView();
    }

    public void w0() {
        this.f63111c.setOnSwitchStateChangeListener(null);
        this.f63111c.setSwitchStateNoCallback(d.b.h0.s.d.d.d().t());
        this.f63111c.setOnSwitchStateChangeListener(this.C);
    }

    public LinearLayout x() {
        return this.z;
    }

    public void x0() {
        this.f63112d.setOnSwitchStateChangeListener(null);
        this.f63112d.setSwitchStateNoCallback(d.b.h0.s.d.d.d().w());
        this.f63112d.setOnSwitchStateChangeListener(this.C);
    }

    public View y() {
        return this.q;
    }

    public LinearLayout z() {
        return this.x;
    }
}
