package d.b.i0.u2.c;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.MsgSettingItemView;
import com.baidu.tieba.setting.more.SystemHelpSettingActivity;
import com.baidu.tieba.setting.more.TbSettingTextNewDotView;
import d.b.b.e.p.l;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class h extends d.b.b.a.d<SystemHelpSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f61379a;

    /* renamed from: b  reason: collision with root package name */
    public View f61380b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f61381c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f61382d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f61383e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f61384f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f61385g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f61386h;
    public TbSettingTextTipView i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f61386h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
                i.s("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(h hVar, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() != 2001303) {
            }
        }
    }

    public h(SystemHelpSettingActivity systemHelpSettingActivity) {
        super(systemHelpSettingActivity.getPageContext());
        this.f61379a = null;
        this.f61380b = null;
        this.f61381c = null;
        this.f61382d = null;
        this.f61383e = null;
        this.f61384f = null;
        this.f61385g = null;
        this.i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f61379a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61379a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f61379a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f61379a.findViewById(R.id.clear_cache);
        this.f61381c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f61381c.setOnClickListener(this.f61379a);
        this.f61381c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f61379a.findViewById(R.id.clear_im);
        this.f61382d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f61382d.setBottomLineVisibility(true);
        this.f61382d.setOnClickListener(this.f61379a);
        this.f61383e = (BdSwitchView) this.f61379a.findViewById(R.id.item_switch);
        l.c(this.f61379a.getPageContext().getPageActivity(), this.f61383e, 10, 10, 10, 10);
        this.f61383e.setOnSwitchStateChangeListener(this.f61379a);
        this.f61384f = (BdSwitchView) this.f61379a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f61379a.getPageContext().getPageActivity(), this.f61384f, 10, 10, 10, 10);
        this.f61384f.setOnSwitchStateChangeListener(this.f61379a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f61379a.findViewById(R.id.debug_tool_launch);
        this.i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.setOnClickListener(this.f61379a);
        this.f61380b = this.f61379a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f61382d.setVisibility(0);
        } else {
            this.f61382d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f61385g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f61379a);
        this.f61385g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61379a.findViewById(R.id.recently_bar_switch);
        this.f61386h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f61386h.setSpaceView(8);
        this.f61386h.setText(R.string.privacy_hide_recently_bar_text);
        this.f61386h.setOnSwitchStateChangeListener(this.k);
        d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
        m(i.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f61381c;
    }

    public TbSettingTextTipView f() {
        return this.f61382d;
    }

    public TbSettingTextTipView h() {
        return this.i;
    }

    public BdSwitchView i() {
        return this.f61383e;
    }

    public TbSettingTextNewDotView k() {
        return this.f61385g;
    }

    public BdSwitchView l() {
        return this.f61384f;
    }

    public void m(boolean z) {
        if (!z) {
            this.f61386h.getSwitchView().k();
        } else {
            this.f61386h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i) {
        this.f61379a.getLayoutMode().k(i == 1);
        this.f61379a.getLayoutMode().j(this.f61380b);
        this.j.onChangeSkinType(getPageContext(), i);
        this.f61383e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f61384f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f61386h.c(this.f61379a.getPageContext(), i);
        SkinManager.setBackgroundResource(this.f61381c, R.drawable.more_all);
    }
}
