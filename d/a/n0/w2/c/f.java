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
    public ViewGroup f66308a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f66309b;

    /* renamed from: c  reason: collision with root package name */
    public View f66310c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66311d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f66312e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f66313f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66314g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f66315h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f66316i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f66314g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.f66316i, f.this.l())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.f66316i = msgReceiveActivity;
    }

    public View h() {
        return this.f66310c;
    }

    public BdSwitchView i() {
        return this.f66313f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.f66316i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f66308a = (ViewGroup) this.f66316i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66316i.findViewById(R.id.navigation_bar_msg_receive);
        this.f66309b = navigationBar;
        navigationBar.setCenterTextTitle(this.f66316i.getPageContext().getString(R.string.receive_message));
        this.f66309b.showBottomLine();
        this.f66310c = this.f66309b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66316i.findViewById(R.id.item_view_friend_msg);
        this.f66311d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f66311d.setOnSwitchStateChangeListener(this.f66316i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f66316i.findViewById(R.id.item_view_stranger_msg);
        this.f66312e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f66312e.setOnSwitchStateChangeListener(this.f66316i);
        this.f66312e.setLineVisibility(false);
        p();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f66316i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f66313f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f66313f.setOnSwitchStateChangeListener(this.f66316i);
        this.f66313f.setLineVisibility(false);
        o();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66316i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f66314g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView k() {
        return this.f66311d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> l() {
        return this.f66315h;
    }

    public BdSwitchView m() {
        return this.f66312e.getSwitchView();
    }

    public void n() {
        if (this.f66316i == null) {
            return;
        }
        initUI();
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView = this.f66313f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.m0.s.d.d.d().l());
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.f66308a, R.color.CAM_X0204, i2);
        this.f66309b.onChangeSkinType(this.f66316i.getPageContext(), i2);
        this.f66311d.c(this.f66316i.getPageContext(), i2);
        this.f66312e.c(this.f66316i.getPageContext(), i2);
        this.f66313f.c(this.f66316i.getPageContext(), i2);
        this.f66314g.f(i2);
    }

    public final void p() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.f66311d;
        if (msgSettingItemView == null || this.f66312e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f66311d.setLineVisibility(false);
            this.f66312e.setVisibility(8);
            this.f66312e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f66311d.setLineVisibility(true);
        this.f66312e.getSwitchView().h();
    }

    public void q(boolean z) {
        this.f66311d.setLineVisibility(z);
    }

    public void r(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f66315h = arrayList;
    }

    public void s(boolean z) {
        if (z) {
            this.f66312e.setVisibility(0);
        } else {
            this.f66312e.setVisibility(8);
        }
    }
}
