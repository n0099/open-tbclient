package d.a.o0.w2.c;

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
import d.a.c.e.p.l;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class h extends d.a.c.a.d<SystemHelpSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f66453a;

    /* renamed from: b  reason: collision with root package name */
    public View f66454b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f66455c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f66456d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f66457e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f66458f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f66459g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f66460h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66461i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f66460h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
                j.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(h hVar, int i2) {
            super(i2);
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
        this.f66453a = null;
        this.f66454b = null;
        this.f66455c = null;
        this.f66456d = null;
        this.f66457e = null;
        this.f66458f = null;
        this.f66459g = null;
        this.f66461i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f66453a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f66453a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f66453a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66453a.findViewById(R.id.clear_cache);
        this.f66455c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f66455c.setOnClickListener(this.f66453a);
        this.f66455c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66453a.findViewById(R.id.clear_im);
        this.f66456d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f66456d.setBottomLineVisibility(true);
        this.f66456d.setOnClickListener(this.f66453a);
        this.f66457e = (BdSwitchView) this.f66453a.findViewById(R.id.item_switch);
        l.c(this.f66453a.getPageContext().getPageActivity(), this.f66457e, 10, 10, 10, 10);
        this.f66457e.setOnSwitchStateChangeListener(this.f66453a);
        this.f66458f = (BdSwitchView) this.f66453a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f66453a.getPageContext().getPageActivity(), this.f66458f, 10, 10, 10, 10);
        this.f66458f.setOnSwitchStateChangeListener(this.f66453a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66453a.findViewById(R.id.debug_tool_launch);
        this.f66461i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.f66461i.setVisibility(0);
        } else {
            this.f66461i.setVisibility(8);
        }
        this.f66461i.setOnClickListener(this.f66453a);
        this.f66454b = this.f66453a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f66456d.setVisibility(0);
        } else {
            this.f66456d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f66459g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f66453a);
        this.f66459g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f66453a.findViewById(R.id.recently_bar_switch);
        this.f66460h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f66460h.setSpaceView(8);
        this.f66460h.setText(R.string.privacy_hide_recently_bar_text);
        this.f66460h.setOnSwitchStateChangeListener(this.k);
        d.a.n0.r.d0.b j = d.a.n0.r.d0.b.j();
        m(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f66455c;
    }

    public TbSettingTextTipView f() {
        return this.f66456d;
    }

    public TbSettingTextTipView h() {
        return this.f66461i;
    }

    public BdSwitchView i() {
        return this.f66457e;
    }

    public TbSettingTextNewDotView k() {
        return this.f66459g;
    }

    public BdSwitchView l() {
        return this.f66458f;
    }

    public void m(boolean z) {
        if (!z) {
            this.f66460h.getSwitchView().k();
        } else {
            this.f66460h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i2) {
        this.f66453a.getLayoutMode().k(i2 == 1);
        this.f66453a.getLayoutMode().j(this.f66454b);
        this.j.onChangeSkinType(getPageContext(), i2);
        this.f66457e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f66458f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f66460h.c(this.f66453a.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f66455c, R.drawable.more_all);
    }
}
