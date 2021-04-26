package d.a.j0.v2.c;

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
    public SystemHelpSettingActivity f61782a;

    /* renamed from: b  reason: collision with root package name */
    public View f61783b;

    /* renamed from: c  reason: collision with root package name */
    public TbSettingTextTipView f61784c;

    /* renamed from: d  reason: collision with root package name */
    public TbSettingTextTipView f61785d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f61786e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwitchView f61787f;

    /* renamed from: g  reason: collision with root package name */
    public TbSettingTextNewDotView f61788g;

    /* renamed from: h  reason: collision with root package name */
    public MsgSettingItemView f61789h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f61790i;
    public NavigationBar j;
    public BdSwitchView.b k;

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public a() {
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
            if (view == h.this.f61789h.getSwitchView()) {
                boolean z = BdSwitchView.SwitchState.ON == switchState;
                d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
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
        this.f61782a = null;
        this.f61783b = null;
        this.f61784c = null;
        this.f61785d = null;
        this.f61786e = null;
        this.f61787f = null;
        this.f61788g = null;
        this.f61790i = null;
        this.k = new a();
        new b(this, 2001303);
        this.f61782a = systemHelpSettingActivity;
        systemHelpSettingActivity.setContentView(R.layout.system_help_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61782a.findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.setTitleText(this.f61782a.getPageContext().getString(R.string.systemhelpsetting));
        this.j.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f61782a.findViewById(R.id.clear_cache);
        this.f61784c = tbSettingTextTipView;
        tbSettingTextTipView.c();
        this.f61784c.setOnClickListener(this.f61782a);
        this.f61784c.setBottomLineVisibility(true);
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f61782a.findViewById(R.id.clear_im);
        this.f61785d = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        this.f61785d.setBottomLineVisibility(true);
        this.f61785d.setOnClickListener(this.f61782a);
        this.f61786e = (BdSwitchView) this.f61782a.findViewById(R.id.item_switch);
        l.c(this.f61782a.getPageContext().getPageActivity(), this.f61786e, 10, 10, 10, 10);
        this.f61786e.setOnSwitchStateChangeListener(this.f61782a);
        this.f61787f = (BdSwitchView) this.f61782a.findViewById(R.id.setting_save_video_switch);
        l.c(this.f61782a.getPageContext().getPageActivity(), this.f61787f, 10, 10, 10, 10);
        this.f61787f.setOnSwitchStateChangeListener(this.f61782a);
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f61782a.findViewById(R.id.debug_tool_launch);
        this.f61790i = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        if (TbadkCoreApplication.getInst().isDebugMode()) {
            this.f61790i.setVisibility(0);
        } else {
            this.f61790i.setVisibility(8);
        }
        this.f61790i.setOnClickListener(this.f61782a);
        this.f61783b = this.f61782a.findViewById(R.id.parent);
        if (TbadkCoreApplication.isLogin()) {
            this.f61785d.setVisibility(0);
        } else {
            this.f61785d.setVisibility(8);
        }
        TbSettingTextNewDotView tbSettingTextNewDotView = (TbSettingTextNewDotView) systemHelpSettingActivity.findViewById(R.id.sv_plugin_center);
        this.f61788g = tbSettingTextNewDotView;
        tbSettingTextNewDotView.setOnClickListener(this.f61782a);
        this.f61788g.setVisibility(0);
        MsgSettingItemView msgSettingItemView = (MsgSettingItemView) this.f61782a.findViewById(R.id.recently_bar_switch);
        this.f61789h = msgSettingItemView;
        msgSettingItemView.setLineVisibility(false);
        this.f61789h.setSpaceView(8);
        this.f61789h.setText(R.string.privacy_hide_recently_bar_text);
        this.f61789h.setOnSwitchStateChangeListener(this.k);
        d.a.i0.r.d0.b j = d.a.i0.r.d0.b.j();
        l(j.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false));
    }

    public TbSettingTextTipView e() {
        return this.f61784c;
    }

    public TbSettingTextTipView f() {
        return this.f61785d;
    }

    public TbSettingTextTipView g() {
        return this.f61790i;
    }

    public BdSwitchView h() {
        return this.f61786e;
    }

    public TbSettingTextNewDotView j() {
        return this.f61788g;
    }

    public BdSwitchView k() {
        return this.f61787f;
    }

    public void l(boolean z) {
        if (!z) {
            this.f61789h.getSwitchView().k();
        } else {
            this.f61789h.getSwitchView().h();
        }
    }

    public void onChangeSkinType(int i2) {
        this.f61782a.getLayoutMode().k(i2 == 1);
        this.f61782a.getLayoutMode().j(this.f61783b);
        this.j.onChangeSkinType(getPageContext(), i2);
        this.f61786e.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f61787f.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
        this.f61789h.c(this.f61782a.getPageContext(), i2);
        SkinManager.setBackgroundResource(this.f61784c, R.drawable.more_all);
    }
}
