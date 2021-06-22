package d.a.o0.w2.c;

import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes5.dex */
public class g extends d.a.c.a.d<MsgRemindActivity> {
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
    public MsgSettingItemView f66443a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f66444b;

    /* renamed from: c  reason: collision with root package name */
    public MsgSettingItemView f66445c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66446d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f66447e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f66448f;

    /* renamed from: g  reason: collision with root package name */
    public MsgSettingItemView f66449g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66450h;

    /* renamed from: i  reason: collision with root package name */
    public MsgSettingItemView f66451i;
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

    /* loaded from: classes5.dex */
    public class a implements OfficialAccountPushModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.setting.officialAccountPush.OfficialAccountPushModel.b
        public void a(ArrayList<OfficialAccountPushInfo> arrayList, int i2, String str) {
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
            if (d.a.n0.s.d.d.d().k() != z) {
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
        return this.l.getSwitchView();
    }

    public BdSwitchView B() {
        return this.f66451i.getSwitchView();
    }

    public BdSwitchView F() {
        return this.j.getSwitchView();
    }

    public BdSwitchView G() {
        return this.k.getSwitchView();
    }

    public BdSwitchView H() {
        return this.f66445c.getSwitchView();
    }

    public View I() {
        return this.n;
    }

    public BdSwitchView J() {
        return this.m.getSwitchView();
    }

    public BdSwitchView K() {
        return this.I.getSwitchView();
    }

    public BdSwitchView L() {
        return this.f66446d.getSwitchView();
    }

    public void M(MsgRemindActivity msgRemindActivity) {
        Y(msgRemindActivity);
        R();
        T();
        V();
        U();
        S();
        Q(msgRemindActivity);
        k();
    }

    public final void O() {
        MsgSettingItemView msgSettingItemView = this.J;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.n0.s.d.d.d().l());
    }

    public final void P() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.H;
        if (msgSettingItemView == null || this.I == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
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

    public final void Q(MsgRemindActivity msgRemindActivity) {
        this.u.setOnClickListener(msgRemindActivity);
        this.f66445c.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66447e.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66446d.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66448f.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66449g.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66450h.setOnSwitchStateChangeListener(msgRemindActivity);
        this.f66451i.setOnSwitchStateChangeListener(msgRemindActivity);
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

    public final void R() {
        this.f66445c.setSwitchStateNoCallback(d.a.n0.s.d.d.d().t());
        this.f66446d.setSwitchStateNoCallback(d.a.n0.s.d.d.d().w());
        this.f66447e.setSwitchStateNoCallback(d.a.n0.s.d.d.d().o());
        this.f66448f.setSwitchStateNoCallback(d.a.n0.s.d.d.d().r());
        this.f66449g.setSwitchStateNoCallback(d.a.n0.s.d.d.d().p());
        this.f66450h.setSwitchStateNoCallback(d.a.n0.s.d.d.d().n());
    }

    public final void S() {
        if (d.a.n0.s.d.d.d().x()) {
            this.p.g();
            this.q.setVisibility(0);
            l0();
            return;
        }
        this.p.e();
        this.q.setVisibility(8);
    }

    public final void T() {
    }

    public final void U() {
        if (d.a.n0.s.d.d.d().y()) {
            this.m.f();
            this.n.setVisibility(0);
            this.m.setLineVisibility(true);
            m0();
            return;
        }
        this.m.d();
        this.m.setLineVisibility(false);
        this.n.setVisibility(8);
    }

    public final void V() {
        if (d.a.n0.s.d.d.d().u()) {
            this.j.g();
        } else {
            this.j.e();
        }
        if (d.a.n0.s.d.d.d().v()) {
            this.k.g();
        } else {
            this.k.e();
        }
        if (d.a.n0.s.d.d.d().q()) {
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
        this.f66443a = msgSettingItemView;
        msgSettingItemView.setText(R.string.receive_msg_text);
        this.f66443a.setLineVisibility(false);
        this.f66444b = (LinearLayout) msgRemindActivity.findViewById(R.id.receive_message_container);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.reply_check_box);
        this.f66445c = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.reply);
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.zan_check_box);
        this.f66446d = msgSettingItemView3;
        msgSettingItemView3.setVisibility(0);
        this.f66446d.setText(R.string.action_praise_default);
        MsgSettingItemView msgSettingItemView4 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.at_me_check_box);
        this.f66447e = msgSettingItemView4;
        msgSettingItemView4.setText(R.string.mention_atme);
        MsgSettingItemView msgSettingItemView5 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.new_fans_swtich);
        this.f66448f = msgSettingItemView5;
        msgSettingItemView5.setText(R.string.new_fans);
        MsgSettingItemView msgSettingItemView6 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.chat_msg_swtich);
        this.f66449g = msgSettingItemView6;
        msgSettingItemView6.setText(R.string.chat_msg_text);
        MsgSettingItemView msgSettingItemView7 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.group_chat_swtich);
        this.f66450h = msgSettingItemView7;
        msgSettingItemView7.setLineVisibility(false);
        this.f66450h.setText(R.string.group_chat_text);
        MsgSettingItemView msgSettingItemView8 = (MsgSettingItemView) msgRemindActivity.findViewById(R.id.screen_lock_swtich);
        this.f66451i = msgSettingItemView8;
        msgSettingItemView8.setText(R.string.remind_screen_lock);
        this.f66451i.setLineVisibility(false);
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
        P();
        MsgSettingItemView msgSettingItemView16 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_forum_broadcast_msg);
        this.J = msgSettingItemView16;
        msgSettingItemView16.setText(R.string.receive_forum_broadcast_message);
        this.J.setOnSwitchStateChangeListener(this.C);
        this.J.setLineVisibility(false);
        O();
        MsgSettingItemView msgSettingItemView17 = (MsgSettingItemView) this.C.findViewById(R.id.item_view_tb_selection_msg);
        this.K = msgSettingItemView17;
        msgSettingItemView17.setText(R.string.official_push_message_switch_text);
        this.K.setOnSwitchStateChangeListener(this.C);
        this.K.setLineVisibility(false);
        Z();
    }

    public final void Z() {
        MsgSettingItemView msgSettingItemView = this.K;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.n0.s.d.d.d().k());
        new OfficialAccountPushModel(new a()).x();
    }

    public void a0() {
    }

    public void b0() {
        int i2;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.C).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            this.F.i();
            i2 = 1;
        } else {
            this.F.f();
            i2 = 2;
        }
        this.E.setVisibility(areNotificationsEnabled ? 8 : 0);
        c0(areNotificationsEnabled);
        TiebaStatic.log(new StatisticItem("c13889").param("obj_locate", i2).param("obj_source", 8));
    }

    public final void c0(boolean z) {
        if (z) {
            this.f66445c.getSwitchView().setEnabled(true);
            this.f66446d.getSwitchView().setEnabled(true);
            this.f66448f.getSwitchView().setEnabled(true);
            this.f66447e.getSwitchView().setEnabled(true);
            this.H.getSwitchView().setEnabled(true);
            this.I.getSwitchView().setEnabled(true);
            this.J.getSwitchView().setEnabled(true);
            this.K.getSwitchView().setEnabled(true);
            this.m.getSwitchView().setEnabled(true);
            this.p.getSwitchView().setEnabled(true);
            this.f66445c.getSwitchView().setAlpha(1.0f);
            this.f66446d.getSwitchView().setAlpha(1.0f);
            this.f66448f.getSwitchView().setAlpha(1.0f);
            this.f66447e.getSwitchView().setAlpha(1.0f);
            this.H.getSwitchView().setAlpha(1.0f);
            this.I.getSwitchView().setAlpha(1.0f);
            this.J.getSwitchView().setAlpha(1.0f);
            this.K.getSwitchView().setAlpha(1.0f);
            this.m.getSwitchView().setAlpha(1.0f);
            this.p.getSwitchView().setAlpha(1.0f);
            return;
        }
        this.f66445c.getSwitchView().setEnabled(false);
        this.f66446d.getSwitchView().setEnabled(false);
        this.f66448f.getSwitchView().setEnabled(false);
        this.f66447e.getSwitchView().setEnabled(false);
        this.H.getSwitchView().setEnabled(false);
        this.I.getSwitchView().setEnabled(false);
        this.J.getSwitchView().setEnabled(false);
        this.K.getSwitchView().setEnabled(false);
        this.m.getSwitchView().setEnabled(false);
        this.p.getSwitchView().setEnabled(false);
        this.f66445c.getSwitchView().setAlpha(0.3f);
        this.f66446d.getSwitchView().setAlpha(0.3f);
        this.f66448f.getSwitchView().setAlpha(0.3f);
        this.f66447e.getSwitchView().setAlpha(0.3f);
        this.H.getSwitchView().setAlpha(0.3f);
        this.I.getSwitchView().setAlpha(0.3f);
        this.J.getSwitchView().setAlpha(0.3f);
        this.K.getSwitchView().setAlpha(0.3f);
        this.m.getSwitchView().setAlpha(0.3f);
        this.p.getSwitchView().setAlpha(0.3f);
    }

    public void d0(boolean z) {
        this.H.setLineVisibility(z);
    }

    public final void e() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.f66443a.setVisibility(8);
            this.f66444b.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.f66451i.setVisibility(8);
        }
    }

    public void e0(boolean z) {
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

    public final void f() {
        this.f66449g.setLineVisibility(TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class));
    }

    public void g0(boolean z) {
    }

    public final void h() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(ScreenLockActivityConfig.class);
    }

    public void h0(boolean z) {
        this.p.setLineVisibility(z);
        if (z) {
            this.q.setVisibility(0);
            l0();
            SkinManager.setBackgroundResource(this.q, R.drawable.more_all);
            return;
        }
        this.q.setVisibility(8);
    }

    public final void i() {
        if (!TbadkCoreApplication.getInst().isMIUIRom()) {
            this.f66451i.setLineVisibility(true);
        } else {
            this.f66451i.setLineVisibility(false);
        }
    }

    public void i0(boolean z) {
        if (z) {
            this.n.setVisibility(0);
            this.m.setLineVisibility(true);
            SkinManager.setBackgroundResource(this.n, R.drawable.more_all);
            return;
        }
        this.n.setVisibility(8);
        this.m.setLineVisibility(false);
    }

    public void j0(boolean z) {
        if (z) {
            this.I.setVisibility(0);
        } else {
            this.I.setVisibility(8);
        }
    }

    public final void k() {
        e();
        i();
        f();
        h();
    }

    public void k0() {
        MsgRemindActivity msgRemindActivity = this.C;
        if (msgRemindActivity != null) {
            d.a.n0.s.d.f.c().k(this.C.getActivity(), (ViewGroup) msgRemindActivity.findViewById(16908290));
        }
    }

    public BdSwitchView l() {
        return this.f66447e.getSwitchView();
    }

    public void l0() {
        String g2 = d.a.n0.s.d.d.d().g();
        String f2 = d.a.n0.s.d.d.d().f();
        TextView textView = this.r;
        textView.setText(g2 + "-" + f2);
        this.y.setText(g2);
        this.A.setText(f2);
    }

    public View m() {
        return this.u;
    }

    public void m0() {
        String str;
        String str2;
        if (d.a.n0.s.d.d.d().y()) {
            int i2 = d.a.n0.s.d.d.d().i();
            int j = d.a.n0.s.d.d.d().j();
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

    public BdSwitchView n() {
        return this.f66449g.getSwitchView();
    }

    public BdSwitchView o() {
        return this.J.getSwitchView();
    }

    public void onChangeSkinType(int i2) {
        this.C.getLayoutMode().k(i2 == 1);
        this.C.getLayoutMode().j(this.s);
        this.t.onChangeSkinType(this.C.getPageContext(), i2);
        this.f66443a.c(this.C.getPageContext(), i2);
        this.f66445c.c(this.C.getPageContext(), i2);
        this.f66446d.c(this.C.getPageContext(), i2);
        this.f66447e.c(this.C.getPageContext(), i2);
        this.f66448f.c(this.C.getPageContext(), i2);
        this.f66449g.c(this.C.getPageContext(), i2);
        this.f66450h.c(this.C.getPageContext(), i2);
        this.f66451i.c(this.C.getPageContext(), i2);
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

    public BdSwitchView p() {
        return this.H.getSwitchView();
    }

    public void p0() {
        this.f66447e.setOnSwitchStateChangeListener(null);
        this.f66447e.setSwitchStateNoCallback(d.a.n0.s.d.d.d().o());
        this.f66447e.setOnSwitchStateChangeListener(this.C);
    }

    public BdSwitchView q() {
        return this.f66450h.getSwitchView();
    }

    public void q0() {
        this.f66449g.setOnSwitchStateChangeListener(null);
        this.f66449g.setSwitchStateNoCallback(d.a.n0.s.d.d.d().p());
        this.f66449g.setOnSwitchStateChangeListener(this.C);
    }

    public BdSwitchView r() {
        return this.f66443a.getSwitchView();
    }

    public TbSettingTextTipView s() {
        return this.D;
    }

    public void s0() {
        this.f66450h.setOnSwitchStateChangeListener(null);
        this.f66450h.setSwitchStateNoCallback(d.a.n0.s.d.d.d().n());
        this.f66450h.setOnSwitchStateChangeListener(this.C);
    }

    public TextView t() {
        return this.t.getCenterText();
    }

    public void t0() {
        this.f66448f.setOnSwitchStateChangeListener(null);
        this.f66448f.setSwitchStateNoCallback(d.a.n0.s.d.d.d().r());
        this.f66448f.setOnSwitchStateChangeListener(this.C);
    }

    public BdSwitchView u() {
        return this.f66448f.getSwitchView();
    }

    public LinearLayout v() {
        return this.z;
    }

    public View w() {
        return this.q;
    }

    public void w0() {
        this.f66445c.setOnSwitchStateChangeListener(null);
        this.f66445c.setSwitchStateNoCallback(d.a.n0.s.d.d.d().t());
        this.f66445c.setOnSwitchStateChangeListener(this.C);
    }

    public LinearLayout x() {
        return this.x;
    }

    public void x0() {
        this.f66446d.setOnSwitchStateChangeListener(null);
        this.f66446d.setSwitchStateNoCallback(d.a.n0.s.d.d.d().w());
        this.f66446d.setOnSwitchStateChangeListener(this.C);
    }

    public BdSwitchView y() {
        return this.p.getSwitchView();
    }

    public BdSwitchView z() {
        return this.K.getSwitchView();
    }
}
