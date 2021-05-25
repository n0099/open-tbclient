package d.a.n0.w2.c;

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
    public SystemHelpSettingActivity f62613a;

    /* renamed from: b  reason: collision with root package name */
    public View f62614b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f62615c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f62616d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f62617e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f62618f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f62619g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f62620h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f62621i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f62620h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
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
        this.f62613a = null;
        this.f62614b = null;
        this.f62615c = null;
        this.f62616d = null;
        this.f62617e = null;
        this.f62618f = null;
        this.f62619g = null;
        this.f62621i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f62613a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62613a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f62613a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62613a.findViewById(R.id.clear_cache);
        this.f62615c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f62615c.setOnClickListener(this.f62613a);
        this.f62615c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f62613a.findViewById(R.id.clear_im);
        this.f62616d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f62616d.setBottomLineVisibility(true);
        this.f62616d.setOnClickListener(this.f62613a);
        this.f62617e = (BdSwitchView) this.f62613a.findViewById(R.id.item_switch);
        l.c(this.f62613a.getPageContext().getPageActivity(), this.f62617e, 10, 10, 10, 10);
        this.f62617e.setOnSwitchStateChangeListener(this.f62613a);
        this.f62618f = (BdSwitchView) this.f62613a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f62613a.getPageContext().getPageActivity(), this.f62618f, 10, 10, 10, 10);
        this.f62618f.setOnSwitchStateChangeListener(this.f62613a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f62613a.findViewById(R.id.debug_tool_launch);
        this.f62621i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.f62621i.setVisibility(0);
        } else {
            this.f62621i.setVisibility(8);
        }
        this.f62621i.setOnClickListener(this.f62613a);
        this.f62614b = this.f62613a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f62616d.setVisibility(0);
        } else {
            this.f62616d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f62619g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f62613a);
        this.f62619g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62613a.findViewById(R.id.recently_bar_switch);
        this.f62620h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f62620h.setSpaceView(8);
        this.f62620h.setText(R.string.privacy_hide_recently_bar_text);
        this.f62620h.setOnSwitchStateChangeListener(this.k);
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        l(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f62615c;
    }

    public TbSettingTextTipView f() {
        return this.f62616d;
    }

    public TbSettingTextTipView g() {
        return this.f62621i;
    }

    public BdSwitchView h() {
        return this.f62617e;
    }

    public TbSettingTextNewDotView j() {
        return this.f62619g;
    }

    public BdSwitchView k() {
        return this.f62618f;
    }

    public void l(boolean z) {
        if (!z) {
            this.f62620h.getSwitchView().k();
        } else {
            this.f62620h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i2) {
        this.f62613a.getLayoutMode().k(i2 == 1);
        this.f62613a.getLayoutMode().j(this.f62614b);
        this.j.onChangeSkinType(getPageContext(), i2);
        this.f62617e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f62618f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f62620h.c(this.f62613a.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f62615c, R.drawable.more_all);
    }
}
