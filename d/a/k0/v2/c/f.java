package d.a.k0.v2.c;

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
    public ViewGroup f62486a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f62487b;

    /* renamed from: c  reason: collision with root package name */
    public View f62488c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f62489d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f62490e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f62491f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f62492g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f62493h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f62494i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f62492g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.f62494i, f.this.k())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.f62494i = msgReceiveActivity;
    }

    public View g() {
        return this.f62488c;
    }

    public BdSwitchView h() {
        return this.f62491f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.f62494i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f62486a = (ViewGroup) this.f62494i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f62494i.findViewById(R.id.navigation_bar_msg_receive);
        this.f62487b = navigationBar;
        navigationBar.setCenterTextTitle(this.f62494i.getPageContext().getString(R.string.receive_message));
        this.f62487b.showBottomLine();
        this.f62488c = this.f62487b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62494i.findViewById(R.id.item_view_friend_msg);
        this.f62489d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f62489d.setOnSwitchStateChangeListener(this.f62494i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f62494i.findViewById(R.id.item_view_stranger_msg);
        this.f62490e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f62490e.setOnSwitchStateChangeListener(this.f62494i);
        this.f62490e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f62494i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f62491f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f62491f.setOnSwitchStateChangeListener(this.f62494i);
        this.f62491f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62494i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f62492g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        return this.f62489d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        return this.f62493h;
    }

    public BdSwitchView l() {
        return this.f62490e.getSwitchView();
    }

    public void m() {
        if (this.f62494i == null) {
            return;
        }
        initUI();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView = this.f62491f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.j0.s.d.d.d().l());
    }

    public final void o() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.f62489d;
        if (msgSettingItemView == null || this.f62490e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f62489d.setLineVisibility(false);
            this.f62490e.setVisibility(8);
            this.f62490e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f62489d.setLineVisibility(true);
        this.f62490e.getSwitchView().h();
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.f62486a, R.color.CAM_X0204, i2);
        this.f62487b.onChangeSkinType(this.f62494i.getPageContext(), i2);
        this.f62489d.c(this.f62494i.getPageContext(), i2);
        this.f62490e.c(this.f62494i.getPageContext(), i2);
        this.f62491f.c(this.f62494i.getPageContext(), i2);
        this.f62492g.f(i2);
    }

    public void p(boolean z) {
        this.f62489d.setLineVisibility(z);
    }

    public void q(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f62493h = arrayList;
    }

    public void r(boolean z) {
        if (z) {
            this.f62490e.setVisibility(0);
        } else {
            this.f62490e.setVisibility(8);
        }
    }
}
