package d.a.j0.v2.c;

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
    public AboutActivity f61714a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f61715b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61716c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61717d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61718e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f61719f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61720g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f61721h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f61722i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.a.j0.v2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1621a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f61723e;

        public View$OnClickListenerC1621a(d dVar) {
            this.f61723e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f61722i) {
                UrlManager.getInstance().dealOneLink(a.this.f61714a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f61714a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view != a.this.k) {
                if (view != a.this.f61719f) {
                    if (view != a.this.f61721h) {
                        if (view == a.this.f61720g) {
                            this.f61723e.a(4);
                            System.arraycopy(a.this.f61715b, 1, a.this.f61715b, 0, a.this.f61715b.length - 1);
                            a.this.f61715b[a.this.f61715b.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.f61715b[0] >= a.this.f61715b[a.this.f61715b.length - 1] - 2000) {
                                a.this.f61715b = new long[5];
                                this.f61723e.a(6);
                                a.this.s();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f61723e.a(2);
                    return;
                }
                this.f61723e.a(1);
            } else if (CurrencySwitchUtil.isYyIsConvert()) {
                UrlManager.getInstance().dealOneLink(a.this.f61714a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
            } else {
                UrlManager.getInstance().dealOneLink(a.this.f61714a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f61725e;

        public b(d dVar) {
            this.f61725e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f61720g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f61725e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f61715b = new long[5];
        this.f61714a = aboutActivity;
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
        View$OnClickListenerC1621a view$OnClickListenerC1621a = new View$OnClickListenerC1621a(dVar);
        b bVar = new b(dVar);
        this.f61719f.setOnClickListener(view$OnClickListenerC1621a);
        this.f61721h.setOnClickListener(view$OnClickListenerC1621a);
        this.f61722i.setOnClickListener(view$OnClickListenerC1621a);
        this.j.setOnClickListener(view$OnClickListenerC1621a);
        this.k.setOnClickListener(view$OnClickListenerC1621a);
        this.f61720g.setOnClickListener(view$OnClickListenerC1621a);
        this.f61720g.setOnLongClickListener(bVar);
    }

    public final void r() {
        this.f61714a.setContentView(R.layout.about_activity);
        this.f61717d = (RelativeLayout) this.f61714a.findViewById(R.id.parent);
        this.f61720g = (ImageView) this.f61714a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f61714a.findViewById(R.id.view_navigation_bar);
        this.f61716c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61716c.setTitleText(this.f61714a.getPageContext().getString(R.string.version_info));
        this.f61718e = (TextView) this.f61714a.findViewById(R.id.text_versioninfo);
        this.f61719f = (SettingTextTestNewView) this.f61714a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f61714a.findViewById(R.id.about_guide);
        this.f61721h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f61714a.findViewById(R.id.tieba_protocol_text);
        this.f61722i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f61714a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        this.k = (TbSettingTextTipView) this.f61714a.findViewById(R.id.tieba_tdou_use_introduce);
        if (CurrencySwitchUtil.isYyIsConvert()) {
            this.k.setText(R.string.ybean_use_introduce);
        } else {
            this.k.setText(R.string.tdou_use_introduce);
        }
        this.k.c();
        this.m = (ProgressBar) this.f61714a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f61718e.setText(this.f61714a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f61714a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f61714a.findViewById(R.id.text_version_protoco);
        v(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f61721h.setVisibility(8);
        }
        if (d.a.i0.r.d0.b.j().g("debug_plugin_switcher", false)) {
            u(0);
        }
    }

    public final void s() {
    }

    public void t() {
        SettingTextTestNewView settingTextTestNewView = this.f61719f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void u(int i2) {
        this.f61714a.findViewById(R.id.line0).setVisibility(i2);
    }

    public void v(int i2) {
        SkinManager.setBackgroundColor(this.f61717d, R.color.CAM_X0201);
        this.f61716c.onChangeSkinType(getPageContext(), i2);
        this.f61714a.getLayoutMode().k(i2 == 1);
        this.f61714a.getLayoutMode().j(this.f61717d);
        t();
    }
}
