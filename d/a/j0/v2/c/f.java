package d.a.j0.v2.c;

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
    public ViewGroup f61762a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f61763b;

    /* renamed from: c  reason: collision with root package name */
    public View f61764c;

    /* renamed from: d  reason: collision with root package name */
    public MsgSettingItemView f61765d;

    /* renamed from: e  reason: collision with root package name */
    public MsgSettingItemView f61766e;

    /* renamed from: f  reason: collision with root package name */
    public MsgSettingItemView f61767f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextTipView f61768g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<OfficialAccountPushInfo> f61769h;

    /* renamed from: i  reason: collision with root package name */
    public MsgReceiveActivity f61770i;
    public View.OnClickListener j;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null && view == f.this.f61768g) {
                TiebaStatic.log(new StatisticItem("c13287").param("uid", TbadkCoreApplication.getCurrentAccount()));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialAccountPushActivityConfig(f.this.f61770i, f.this.k())));
            }
        }
    }

    public f(MsgReceiveActivity msgReceiveActivity) {
        super(msgReceiveActivity.getPageContext());
        this.j = new a();
        this.f61770i = msgReceiveActivity;
    }

    public View g() {
        return this.f61764c;
    }

    public BdSwitchView h() {
        return this.f61767f.getSwitchView();
    }

    public final void initUI() {
        MsgReceiveActivity msgReceiveActivity = this.f61770i;
        if (msgReceiveActivity == null) {
            return;
        }
        msgReceiveActivity.setContentView(R.layout.msg_receive_activity);
        this.f61762a = (ViewGroup) this.f61770i.findViewById(R.id.msg_receive_root_view);
        NavigationBar navigationBar = (NavigationBar) this.f61770i.findViewById(R.id.navigation_bar_msg_receive);
        this.f61763b = navigationBar;
        navigationBar.setCenterTextTitle(this.f61770i.getPageContext().getString(R.string.receive_message));
        this.f61763b.showBottomLine();
        this.f61764c = this.f61763b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61770i.findViewById(R.id.item_view_friend_msg);
        this.f61765d = msgSettingItemView;
        msgSettingItemView.setText(R.string.friend_msg_switch);
        this.f61765d.setOnSwitchStateChangeListener(this.f61770i);
        MsgSettingItemView msgSettingItemView2 = (MsgSettingItemView) this.f61770i.findViewById(R.id.item_view_stranger_msg);
        this.f61766e = msgSettingItemView2;
        msgSettingItemView2.setText(R.string.stranger_msg_switch);
        this.f61766e.setOnSwitchStateChangeListener(this.f61770i);
        this.f61766e.setLineVisibility(false);
        o();
        MsgSettingItemView msgSettingItemView3 = (MsgSettingItemView) this.f61770i.findViewById(R.id.item_view_forum_broadcast_msg);
        this.f61767f = msgSettingItemView3;
        msgSettingItemView3.setText(R.string.receive_forum_broadcast_message);
        this.f61767f.setOnSwitchStateChangeListener(this.f61770i);
        this.f61767f.setLineVisibility(false);
        n();
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f61770i.findViewById(R.id.item_view_offical_account_push_msg);
        this.f61768g = tbSettingTextTipView;
        tbSettingTextTipView.setOnClickListener(this.j);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public BdSwitchView j() {
        return this.f61765d.getSwitchView();
    }

    public final ArrayList<OfficialAccountPushInfo> k() {
        return this.f61769h;
    }

    public BdSwitchView l() {
        return this.f61766e.getSwitchView();
    }

    public void m() {
        if (this.f61770i == null) {
            return;
        }
        initUI();
    }

    public final void n() {
        MsgSettingItemView msgSettingItemView = this.f61767f;
        if (msgSettingItemView == null) {
            return;
        }
        msgSettingItemView.setSwitchStateNoCallback(d.a.i0.s.d.d.d().l());
    }

    public final void o() {
        int i2;
        MsgSettingItemView msgSettingItemView = this.f61765d;
        if (msgSettingItemView == null || this.f61766e == null || (i2 = GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE) == 0) {
            return;
        }
        if (i2 != 1) {
            msgSettingItemView.getSwitchView().h();
            this.f61765d.setLineVisibility(false);
            this.f61766e.setVisibility(8);
            this.f61766e.getSwitchView().h();
            return;
        }
        msgSettingItemView.getSwitchView().k();
        this.f61765d.setLineVisibility(true);
        this.f61766e.getSwitchView().h();
    }

    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundColor(this.f61762a, R.color.CAM_X0204, i2);
        this.f61763b.onChangeSkinType(this.f61770i.getPageContext(), i2);
        this.f61765d.c(this.f61770i.getPageContext(), i2);
        this.f61766e.c(this.f61770i.getPageContext(), i2);
        this.f61767f.c(this.f61770i.getPageContext(), i2);
        this.f61768g.f(i2);
    }

    public void p(boolean z) {
        this.f61765d.setLineVisibility(z);
    }

    public void q(ArrayList<OfficialAccountPushInfo> arrayList) {
        this.f61769h = arrayList;
    }

    public void r(boolean z) {
        if (z) {
            this.f61766e.setVisibility(0);
        } else {
            this.f61766e.setVisibility(8);
        }
    }
}
