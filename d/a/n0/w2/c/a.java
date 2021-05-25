package d.a.n0.w2.c;

import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import d.a.c.e.p.k;
/* loaded from: classes5.dex */
public class a extends d.a.c.a.d<AboutActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f62545a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f62546b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62547c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f62548d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62549e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f62550f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62551g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f62552h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f62553i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.a.n0.w2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1699a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62554e;

        public View$OnClickListenerC1699a(d dVar) {
            this.f62554e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f62553i) {
                UrlManager.getInstance().dealOneLink(a.this.f62545a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f62545a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view != a.this.k) {
                if (view != a.this.f62550f) {
                    if (view != a.this.f62552h) {
                        if (view == a.this.f62551g) {
                            this.f62554e.a(4);
                            System.arraycopy(a.this.f62546b, 1, a.this.f62546b, 0, a.this.f62546b.length - 1);
                            a.this.f62546b[a.this.f62546b.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.f62546b[0] >= a.this.f62546b[a.this.f62546b.length - 1] - 2000) {
                                a.this.f62546b = new long[5];
                                this.f62554e.a(6);
                                a.this.s();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f62554e.a(2);
                    return;
                }
                this.f62554e.a(1);
            } else if (CurrencySwitchUtil.isYyIsConvert()) {
                UrlManager.getInstance().dealOneLink(a.this.f62545a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
            } else {
                UrlManager.getInstance().dealOneLink(a.this.f62545a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f62556e;

        public b(d dVar) {
            this.f62556e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f62551g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f62556e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f62546b = new long[5];
        this.f62545a = aboutActivity;
        r();
        q(dVar);
    }

    public void o() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void p() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void q(d dVar) {
        View$OnClickListenerC1699a view$OnClickListenerC1699a = new View$OnClickListenerC1699a(dVar);
        b bVar = new b(dVar);
        this.f62550f.setOnClickListener(view$OnClickListenerC1699a);
        this.f62552h.setOnClickListener(view$OnClickListenerC1699a);
        this.f62553i.setOnClickListener(view$OnClickListenerC1699a);
        this.j.setOnClickListener(view$OnClickListenerC1699a);
        this.k.setOnClickListener(view$OnClickListenerC1699a);
        this.f62551g.setOnClickListener(view$OnClickListenerC1699a);
        this.f62551g.setOnLongClickListener(bVar);
    }

    public final void r() {
        this.f62545a.setContentView(R.layout.about_activity);
        this.f62548d = (RelativeLayout) this.f62545a.findViewById(R.id.parent);
        this.f62551g = (ImageView) this.f62545a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f62545a.findViewById(R.id.view_navigation_bar);
        this.f62547c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62547c.setTitleText(this.f62545a.getPageContext().getString(R.string.version_info));
        this.f62549e = (TextView) this.f62545a.findViewById(R.id.text_versioninfo);
        this.f62550f = (SettingTextTestNewView) this.f62545a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f62545a.findViewById(R.id.about_guide);
        this.f62552h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f62545a.findViewById(R.id.tieba_protocol_text);
        this.f62553i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f62545a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        this.k = (TbSettingTextTipView) this.f62545a.findViewById(R.id.tieba_tdou_use_introduce);
        if (CurrencySwitchUtil.isYyIsConvert()) {
            this.k.setText(R.string.ybean_use_introduce);
        } else {
            this.k.setText(R.string.tdou_use_introduce);
        }
        this.k.c();
        this.m = (ProgressBar) this.f62545a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f62549e.setText(this.f62545a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f62545a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f62545a.findViewById(R.id.text_version_protoco);
        v(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f62552h.setVisibility(8);
        }
        if (d.a.m0.r.d0.b.j().g("debug_plugin_switcher", false)) {
            u(0);
        }
    }

    public final void s() {
    }

    public void t() {
        SettingTextTestNewView settingTextTestNewView = this.f62550f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void u(int i2) {
        this.f62545a.findViewById(R.id.line0).setVisibility(i2);
    }

    public void v(int i2) {
        SkinManager.setBackgroundColor(this.f62548d, R.color.CAM_X0201);
        this.f62547c.onChangeSkinType(getPageContext(), i2);
        this.f62545a.getLayoutMode().k(i2 == 1);
        this.f62545a.getLayoutMode().j(this.f62548d);
        t();
    }
}
