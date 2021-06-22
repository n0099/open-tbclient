package d.a.o0.w2.c;

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
    public AboutActivity f66385a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f66386b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66387c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f66388d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66389e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f66390f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66391g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f66392h;

    /* renamed from: i  reason: collision with root package name */
    public TbSettingTextTipView f66393i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.a.o0.w2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1760a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66394e;

        public View$OnClickListenerC1760a(d dVar) {
            this.f66394e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.f66393i) {
                UrlManager.getInstance().dealOneLink(a.this.f66385a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f66385a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view != a.this.k) {
                if (view != a.this.f66390f) {
                    if (view != a.this.f66392h) {
                        if (view == a.this.f66391g) {
                            this.f66394e.a(4);
                            System.arraycopy(a.this.f66386b, 1, a.this.f66386b, 0, a.this.f66386b.length - 1);
                            a.this.f66386b[a.this.f66386b.length - 1] = SystemClock.uptimeMillis();
                            if (a.this.f66386b[0] >= a.this.f66386b[a.this.f66386b.length - 1] - 2000) {
                                a.this.f66386b = new long[5];
                                this.f66394e.a(6);
                                a.this.s();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f66394e.a(2);
                    return;
                }
                this.f66394e.a(1);
            } else if (CurrencySwitchUtil.isYyIsConvert()) {
                UrlManager.getInstance().dealOneLink(a.this.f66385a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/yy/agreement.html"});
            } else {
                UrlManager.getInstance().dealOneLink(a.this.f66385a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f66396e;

        public b(d dVar) {
            this.f66396e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f66391g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f66396e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f66386b = new long[5];
        this.f66385a = aboutActivity;
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
        View$OnClickListenerC1760a view$OnClickListenerC1760a = new View$OnClickListenerC1760a(dVar);
        b bVar = new b(dVar);
        this.f66390f.setOnClickListener(view$OnClickListenerC1760a);
        this.f66392h.setOnClickListener(view$OnClickListenerC1760a);
        this.f66393i.setOnClickListener(view$OnClickListenerC1760a);
        this.j.setOnClickListener(view$OnClickListenerC1760a);
        this.k.setOnClickListener(view$OnClickListenerC1760a);
        this.f66391g.setOnClickListener(view$OnClickListenerC1760a);
        this.f66391g.setOnLongClickListener(bVar);
    }

    public final void r() {
        this.f66385a.setContentView(R.layout.about_activity);
        this.f66388d = (RelativeLayout) this.f66385a.findViewById(R.id.parent);
        this.f66391g = (ImageView) this.f66385a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f66385a.findViewById(R.id.view_navigation_bar);
        this.f66387c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66387c.setTitleText(this.f66385a.getPageContext().getString(R.string.version_info));
        this.f66389e = (TextView) this.f66385a.findViewById(R.id.text_versioninfo);
        this.f66390f = (SettingTextTestNewView) this.f66385a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f66385a.findViewById(R.id.about_guide);
        this.f66392h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f66385a.findViewById(R.id.tieba_protocol_text);
        this.f66393i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f66385a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        this.k = (TbSettingTextTipView) this.f66385a.findViewById(R.id.tieba_tdou_use_introduce);
        if (CurrencySwitchUtil.isYyIsConvert()) {
            this.k.setText(R.string.ybean_use_introduce);
        } else {
            this.k.setText(R.string.tdou_use_introduce);
        }
        this.k.c();
        this.m = (ProgressBar) this.f66385a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f66389e.setText(this.f66385a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f66385a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f66385a.findViewById(R.id.text_version_protoco);
        v(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f66392h.setVisibility(8);
        }
        if (d.a.n0.r.d0.b.j().g("debug_plugin_switcher", false)) {
            u(0);
        }
    }

    public final void s() {
    }

    public void t() {
        SettingTextTestNewView settingTextTestNewView = this.f66390f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void u(int i2) {
        this.f66385a.findViewById(R.id.line0).setVisibility(i2);
    }

    public void v(int i2) {
        SkinManager.setBackgroundColor(this.f66388d, R.color.CAM_X0201);
        this.f66387c.onChangeSkinType(getPageContext(), i2);
        this.f66385a.getLayoutMode().k(i2 == 1);
        this.f66385a.getLayoutMode().j(this.f66388d);
        t();
    }
}
