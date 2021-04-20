package d.b.i0.v2.c;

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
import d.b.c.e.p.l;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class h extends d.b.c.a.d<SystemHelpSettingActivity> {

    /* renamed from: a  reason: collision with root package name */
    public SystemHelpSettingActivity f63118a;

    /* renamed from: b  reason: collision with root package name */
    public View f63119b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f63120c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f63121d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f63122e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f63123f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f63124g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f63125h;
    public TbSettingTextTipView i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes4.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f63125h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
                j.t("recnbar" + TbadkCoreApplication.getCurrentAccount(), !z);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921347, Boolean.valueOf(z)));
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f63118a = null;
        this.f63119b = null;
        this.f63120c = null;
        this.f63121d = null;
        this.f63122e = null;
        this.f63123f = null;
        this.f63124g = null;
        this.i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f63118a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f63118a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f63118a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f63118a.findViewById(R.id.clear_cache);
        this.f63120c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f63120c.setOnClickListener(this.f63118a);
        this.f63120c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f63118a.findViewById(R.id.clear_im);
        this.f63121d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f63121d.setBottomLineVisibility(true);
        this.f63121d.setOnClickListener(this.f63118a);
        this.f63122e = (BdSwitchView) this.f63118a.findViewById(R.id.item_switch);
        l.c(this.f63118a.getPageContext().getPageActivity(), this.f63122e, 10, 10, 10, 10);
        this.f63122e.setOnSwitchStateChangeListener(this.f63118a);
        this.f63123f = (BdSwitchView) this.f63118a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f63118a.getPageContext().getPageActivity(), this.f63123f, 10, 10, 10, 10);
        this.f63123f.setOnSwitchStateChangeListener(this.f63118a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f63118a.findViewById(R.id.debug_tool_launch);
        this.i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        this.i.setOnClickListener(this.f63118a);
        this.f63119b = this.f63118a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f63121d.setVisibility(0);
        } else {
            this.f63121d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f63124g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f63118a);
        this.f63124g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f63118a.findViewById(R.id.recently_bar_switch);
        this.f63125h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f63125h.setSpaceView(8);
        this.f63125h.setText(R.string.privacy_hide_recently_bar_text);
        this.f63125h.setOnSwitchStateChangeListener(this.k);
        d.b.h0.r.d0.b j = d.b.h0.r.d0.b.j();
        m(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f63120c;
    }

    public TbSettingTextTipView f() {
        return this.f63121d;
    }

    public TbSettingTextTipView h() {
        return this.i;
    }

    public BdSwitchView i() {
        return this.f63122e;
    }

    public TbSettingTextNewDotView k() {
        return this.f63124g;
    }

    public BdSwitchView l() {
        return this.f63123f;
    }

    public void m(boolean z) {
        if (!z) {
            this.f63125h.getSwitchView().k();
        } else {
            this.f63125h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i) {
        this.f63118a.getLayoutMode().k(i == 1);
        this.f63118a.getLayoutMode().j(this.f63119b);
        this.j.onChangeSkinType(getPageContext(), i);
        this.f63122e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f63123f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f63125h.c(this.f63118a.getPageContext(), i);
        SkinManager.setBackgroundResource(this.f63120c, R.drawable.more_all);
    }
}
