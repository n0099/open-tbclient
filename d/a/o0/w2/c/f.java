package d.a.o0.w2.c;

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
    public ViewGroup f66433a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f66434b;

    /* renamed from: c  reason: collision with root package name */
    public View f66435c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f66436d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f66437e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f66438f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f66439g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f66440h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f66441i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f66439g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.f66441i, f.this.l())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.f66441i = msgReceiveActivity;
    }

    public View h() {
        return this.f66435c;
    }

    public BdSwitchView i() {
        return this.f66438f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.f66441i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f66433a = (ViewGroup) this.f66441i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f66441i.findViewById(R.id.navigation_bar_msg_receive);
        this.f66434b = navigationBar;
        navigationBar.setCenterTextTitle(this.f66441i.getPageContext().getString(R.string.receive_message));
        this.f66434b.showBottomLine();
        this.f66435c = this.f66434b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66441i.findViewById(R.id.item_view_friend_msg);
        this.f66436d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f66436d.setOnSwitchStateChangeListener(this.f66441i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f66441i.findViewById(R.id.item_view_stranger_msg);
        this.f66437e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f66437e.setOnSwitchStateChangeListener(this.f66441i);
        this.f66437e.setLineVisibility(false);
        p();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f66441i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f66438f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f66438f.setOnSwitchStateChangeListener(this.f66441i);
        this.f66438f.setLineVisibility(false);
        o();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66441i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f66439g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView k() {
        return this.f66436d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> l() {
        return this.f66440h;
    }

    public BdSwitchView m() {
        return this.f66437e.getSwitchView();
    }

    public void n() {
        if (this.f66441i == null) {
            return;
        }
        initUI();
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView = this.f66438f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.n0.s.d.d.d().l());
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.f66433a, R.color.CAM_X0204, i2);
        this.f66434b.onChangeSkinType(this.f66441i.getPageContext(), i2);
        this.f66436d.c(this.f66441i.getPageContext(), i2);
        this.f66437e.c(this.f66441i.getPageContext(), i2);
        this.f66438f.c(this.f66441i.getPageContext(), i2);
        this.f66439g.f(i2);
    }

    public final void p() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.f66436d;
        if (msgSettingItemView == null || this.f66437e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f66436d.setLineVisibility(false);
            this.f66437e.setVisibility(8);
            this.f66437e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f66436d.setLineVisibility(true);
        this.f66437e.getSwitchView().h();
    }

    public void q(boolean z) {
        this.f66436d.setLineVisibility(z);
    }

    public void r(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f66440h = arrayList;
    }

    public void s(boolean z) {
        if (z) {
            this.f66437e.setVisibility(0);
        } else {
            this.f66437e.setVisibility(8);
        }
    }
}
