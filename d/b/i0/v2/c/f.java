package d.b.i0.v2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
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
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f extends d.b.c.a.d<MsgReceiveActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f63100a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f63101b;

    /* renamed from: c  reason: collision with root package name */
    public View f63102c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f63103d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f63104e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f63105f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f63106g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f63107h;
    public MsgReceiveActivity i;
    public View.OnClickListener j;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f63106g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.i, f.this.l())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.i = msgReceiveActivity;
    }

    public View h() {
        return this.f63102c;
    }

    public BdSwitchView i() {
        return this.f63105f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f63100a = (ViewGroup) this.i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.navigation_bar_msg_receive);
        this.f63101b = navigationBar;
        navigationBar.setCenterTextTitle(this.i.getPageContext().getString(R.string.receive_message));
        this.f63101b.showBottomLine();
        this.f63102c = this.f63101b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.i.findViewById(R.id.item_view_friend_msg);
        this.f63103d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f63103d.setOnSwitchStateChangeListener(this.i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.i.findViewById(R.id.item_view_stranger_msg);
        this.f63104e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f63104e.setOnSwitchStateChangeListener(this.i);
        this.f63104e.setLineVisibility(false);
        q();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f63105f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f63105f.setOnSwitchStateChangeListener(this.i);
        this.f63105f.setLineVisibility(false);
        o();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f63106g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView k() {
        return this.f63103d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> l() {
        return this.f63107h;
    }

    public BdSwitchView m() {
        return this.f63104e.getSwitchView();
    }

    public void n() {
        if (this.i == null) {
            return;
        }
        initUI();
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView = this.f63105f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.b.h0.s.d.d.d().l());
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundColor(this.f63100a, R.color.CAM_X0204, i);
        this.f63101b.onChangeSkinType(this.i.getPageContext(), i);
        this.f63103d.c(this.i.getPageContext(), i);
        this.f63104e.c(this.i.getPageContext(), i);
        this.f63105f.c(this.i.getPageContext(), i);
        this.f63106g.f(i);
    }

    public final void q() {
        int i;
        MsgSettingItemView msgSettingItemView = this.f63103d;
        if (msgSettingItemView == null || this.f63104e == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f63103d.setLineVisibility(false);
            this.f63104e.setVisibility(8);
            this.f63104e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f63103d.setLineVisibility(true);
        this.f63104e.getSwitchView().h();
    }

    public void r(boolean z) {
        this.f63103d.setLineVisibility(z);
    }

    public void s(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f63107h = arrayList;
    }

    public void u(boolean z) {
        if (z) {
            this.f63104e.setVisibility(0);
        } else {
            this.f63104e.setVisibility(8);
        }
    }
}
