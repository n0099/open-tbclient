package d.a.n0.w2.c;

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
/* loaded from: classes5.dex */
public class f extends d.a.c.a.d<MsgReceiveActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f62593a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f62594b;

    /* renamed from: c  reason: collision with root package name */
    public View f62595c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f62596d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f62597e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f62598f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f62599g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f62600h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f62601i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f62599g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.f62601i, f.this.k())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.f62601i = msgReceiveActivity;
    }

    public View g() {
        return this.f62595c;
    }

    public BdSwitchView h() {
        return this.f62598f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.f62601i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f62593a = (ViewGroup) this.f62601i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62601i.findViewById(R.id.navigation_bar_msg_receive);
        this.f62594b = navigationBar;
        navigationBar.setCenterTextTitle(this.f62601i.getPageContext().getString(R.string.receive_message));
        this.f62594b.showBottomLine();
        this.f62595c = this.f62594b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62601i.findViewById(R.id.item_view_friend_msg);
        this.f62596d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f62596d.setOnSwitchStateChangeListener(this.f62601i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f62601i.findViewById(R.id.item_view_stranger_msg);
        this.f62597e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f62597e.setOnSwitchStateChangeListener(this.f62601i);
        this.f62597e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f62601i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f62598f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f62598f.setOnSwitchStateChangeListener(this.f62601i);
        this.f62598f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62601i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f62599g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        return this.f62596d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        return this.f62600h;
    }

    public BdSwitchView l() {
        return this.f62597e.getSwitchView();
    }

    public void m() {
        if (this.f62601i == null) {
            return;
        }
        initUI();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView = this.f62598f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.m0.s.d.d.d().l());
    }

    public final void o() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.f62596d;
        if (msgSettingItemView == null || this.f62597e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f62596d.setLineVisibility(false);
            this.f62597e.setVisibility(8);
            this.f62597e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f62596d.setLineVisibility(true);
        this.f62597e.getSwitchView().h();
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.f62593a, R.color.CAM_X0204, i2);
        this.f62594b.onChangeSkinType(this.f62601i.getPageContext(), i2);
        this.f62596d.c(this.f62601i.getPageContext(), i2);
        this.f62597e.c(this.f62601i.getPageContext(), i2);
        this.f62598f.c(this.f62601i.getPageContext(), i2);
        this.f62599g.f(i2);
    }

    public void p(boolean z) {
        this.f62596d.setLineVisibility(z);
    }

    public void q(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f62600h = arrayList;
    }

    public void r(boolean z) {
        if (z) {
            this.f62597e.setVisibility(0);
        } else {
            this.f62597e.setVisibility(8);
        }
    }
}
