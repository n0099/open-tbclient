package d.a.k0.v2.c;

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
    public SystemHelpSettingActivity f62506a;

    /* renamed from: b  reason: collision with root package name */
    public View f62507b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f62508c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f62509d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f62510e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f62511f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f62512g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f62513h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f62514i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f62513h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
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
        this.f62506a = null;
        this.f62507b = null;
        this.f62508c = null;
        this.f62509d = null;
        this.f62510e = null;
        this.f62511f = null;
        this.f62512g = null;
        this.f62514i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f62506a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62506a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f62506a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62506a.findViewById(R.id.clear_cache);
        this.f62508c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f62508c.setOnClickListener(this.f62506a);
        this.f62508c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f62506a.findViewById(R.id.clear_im);
        this.f62509d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f62509d.setBottomLineVisibility(true);
        this.f62509d.setOnClickListener(this.f62506a);
        this.f62510e = (BdSwitchView) this.f62506a.findViewById(R.id.item_switch);
        l.c(this.f62506a.getPageContext().getPageActivity(), this.f62510e, 10, 10, 10, 10);
        this.f62510e.setOnSwitchStateChangeListener(this.f62506a);
        this.f62511f = (BdSwitchView) this.f62506a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f62506a.getPageContext().getPageActivity(), this.f62511f, 10, 10, 10, 10);
        this.f62511f.setOnSwitchStateChangeListener(this.f62506a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f62506a.findViewById(R.id.debug_tool_launch);
        this.f62514i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.f62514i.setVisibility(0);
        } else {
            this.f62514i.setVisibility(8);
        }
        this.f62514i.setOnClickListener(this.f62506a);
        this.f62507b = this.f62506a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f62509d.setVisibility(0);
        } else {
            this.f62509d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f62512g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f62506a);
        this.f62512g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f62506a.findViewById(R.id.recently_bar_switch);
        this.f62513h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f62513h.setSpaceView(8);
        this.f62513h.setText(R.string.privacy_hide_recently_bar_text);
        this.f62513h.setOnSwitchStateChangeListener(this.k);
        d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
        l(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f62508c;
    }

    public TbSettingTextTipView f() {
        return this.f62509d;
    }

    public TbSettingTextTipView g() {
        return this.f62514i;
    }

    public BdSwitchView h() {
        return this.f62510e;
    }

    public TbSettingTextNewDotView j() {
        return this.f62512g;
    }

    public BdSwitchView k() {
        return this.f62511f;
    }

    public void l(boolean z) {
        if (!z) {
            this.f62513h.getSwitchView().k();
        } else {
            this.f62513h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i2) {
        this.f62506a.getLayoutMode().k(i2 == 1);
        this.f62506a.getLayoutMode().j(this.f62507b);
        this.j.onChangeSkinType(getPageContext(), i2);
        this.f62510e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f62511f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f62513h.c(this.f62506a.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f62508c, R.drawable.more_all);
    }
}
