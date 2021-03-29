package d.b.i0.u2.c;

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
public class f extends d.b.b.a.d<MsgReceiveActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f61362a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61363b;

    /* renamed from: c  reason: collision with root package name */
    public View f61364c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f61365d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f61366e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f61367f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f61368g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f61369h;
    public MsgReceiveActivity i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f61368g) {
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
        return this.f61364c;
    }

    public BdSwitchView i() {
        return this.f61367f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f61362a = (ViewGroup) this.i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.navigation_bar_msg_receive);
        this.f61363b = navigationBar;
        navigationBar.setCenterTextTitle(this.i.getPageContext().getString(R.string.receive_message));
        this.f61363b.showBottomLine();
        this.f61364c = this.f61363b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.i.findViewById(R.id.item_view_friend_msg);
        this.f61365d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f61365d.setOnSwitchStateChangeListener(this.i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.i.findViewById(R.id.item_view_stranger_msg);
        this.f61366e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f61366e.setOnSwitchStateChangeListener(this.i);
        this.f61366e.setLineVisibility(false);
        q();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f61367f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f61367f.setOnSwitchStateChangeListener(this.i);
        this.f61367f.setLineVisibility(false);
        o();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f61368g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView k() {
        return this.f61365d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> l() {
        return this.f61369h;
    }

    public BdSwitchView m() {
        return this.f61366e.getSwitchView();
    }

    public void n() {
        if (this.i == null) {
            return;
        }
        initUI();
    }

    public final void o() {
        MsgSettingItemView msgSettingItemView = this.f61367f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.b.h0.s.d.d.d().l());
    }

    public void onChangeSkinType(int i) {
        SkinManager.setBackgroundColor(this.f61362a, R.color.CAM_X0204, i);
        this.f61363b.onChangeSkinType(this.i.getPageContext(), i);
        this.f61365d.c(this.i.getPageContext(), i);
        this.f61366e.c(this.i.getPageContext(), i);
        this.f61367f.c(this.i.getPageContext(), i);
        this.f61368g.f(i);
    }

    public final void q() {
        int i;
        MsgSettingItemView msgSettingItemView = this.f61365d;
        if (msgSettingItemView == null || this.f61366e == null || (i = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f61365d.setLineVisibility(false);
            this.f61366e.setVisibility(8);
            this.f61366e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f61365d.setLineVisibility(true);
        this.f61366e.getSwitchView().h();
    }

    public void r(boolean z) {
        this.f61365d.setLineVisibility(z);
    }

    public void s(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f61369h = arrayList;
    }

    public void u(boolean z) {
        if (z) {
            this.f61366e.setVisibility(0);
        } else {
            this.f61366e.setVisibility(8);
        }
    }
}
