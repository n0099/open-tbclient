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
    public AboutActivity f66260a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f66261b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66262c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f66263d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66264e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f66265f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66266g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f66267h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66268i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.a.n0.w2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1756a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66269e;

        public View$OnClickListenerC1756a(d dVar) {
            this.f66269e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f66268i) {
                UrlManager.getInstance().dealOneLink(a.this.f66260a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f66260a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view != a.this.k) {
                if (view != a.this.f66265f) {
                    if (view != a.this.f66267h) {
                        if (view == a.this.f66266g) {
                            this.f66269e.a(4);
                            System.arraycopy(a.this.f66261b, 1, a.this.f66261b, 0, a.this.f66261b.length - 1);
                            a.this.f66261b[a.this.f66261b.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.f66261b[0] >= a.this.f66261b[a.this.f66261b.length - 1] - 2000) {
                                a.this.f66261b = new long[5];
                                this.f66269e.a(6);
                                a.this.s();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f66269e.a(2);
                    return;
                }
                this.f66269e.a(1);
            } else if (CurrencySwitchUtil.isYyIsConvert()) {
                UrlManager.getInstance().dealOneLink(a.this.f66260a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
            } else {
                UrlManager.getInstance().dealOneLink(a.this.f66260a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66271e;

        public b(d dVar) {
            this.f66271e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f66266g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f66271e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f66261b = new long[5];
        this.f66260a = aboutActivity;
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
        View$OnClickListenerC1756a view$OnClickListenerC1756a = new View$OnClickListenerC1756a(dVar);
        b bVar = new b(dVar);
        this.f66265f.setOnClickListener(view$OnClickListenerC1756a);
        this.f66267h.setOnClickListener(view$OnClickListenerC1756a);
        this.f66268i.setOnClickListener(view$OnClickListenerC1756a);
        this.j.setOnClickListener(view$OnClickListenerC1756a);
        this.k.setOnClickListener(view$OnClickListenerC1756a);
        this.f66266g.setOnClickListener(view$OnClickListenerC1756a);
        this.f66266g.setOnLongClickListener(bVar);
    }

    public final void r() {
        this.f66260a.setContentView(R.layout.about_activity);
        this.f66263d = (RelativeLayout) this.f66260a.findViewById(R.id.parent);
        this.f66266g = (ImageView) this.f66260a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f66260a.findViewById(R.id.view_navigation_bar);
        this.f66262c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66262c.setTitleText(this.f66260a.getPageContext().getString(R.string.version_info));
        this.f66264e = (TextView) this.f66260a.findViewById(R.id.text_versioninfo);
        this.f66265f = (SettingTextTestNewView) this.f66260a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66260a.findViewById(R.id.about_guide);
        this.f66267h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66260a.findViewById(R.id.tieba_protocol_text);
        this.f66268i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66260a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        this.k = (TbSettingTextTipView) this.f66260a.findViewById(R.id.tieba_tdou_use_introduce);
        if (CurrencySwitchUtil.isYyIsConvert()) {
            this.k.setText(R.string.ybean_use_introduce);
        } else {
            this.k.setText(R.string.tdou_use_introduce);
        }
        this.k.c();
        this.m = (ProgressBar) this.f66260a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f66264e.setText(this.f66260a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f66260a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f66260a.findViewById(R.id.text_version_protoco);
        v(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f66267h.setVisibility(8);
        }
        if (d.a.m0.r.d0.b.j().g("debug_plugin_switcher", false)) {
            u(0);
        }
    }

    public final void s() {
    }

    public void t() {
        SettingTextTestNewView settingTextTestNewView = this.f66265f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void u(int i2) {
        this.f66260a.findViewById(R.id.line0).setVisibility(i2);
    }

    public void v(int i2) {
        SkinManager.setBackgroundColor(this.f66263d, R.color.CAM_X0201);
        this.f66262c.onChangeSkinType(getPageContext(), i2);
        this.f66260a.getLayoutMode().k(i2 == 1);
        this.f66260a.getLayoutMode().j(this.f66263d);
        t();
    }
}
