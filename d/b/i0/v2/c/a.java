package d.b.i0.v2.c;

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
import d.b.c.e.p.k;
/* loaded from: classes4.dex */
public class a extends d.b.c.a.d<AboutActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f63056a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f63057b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63058c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f63059d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63060e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f63061f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f63062g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f63063h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.b.i0.v2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1658a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63064e;

        public View$OnClickListenerC1658a(d dVar) {
            this.f63064e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.i) {
                UrlManager.getInstance().dealOneLink(a.this.f63056a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f63056a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view == a.this.k) {
                UrlManager.getInstance().dealOneLink(a.this.f63056a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            } else if (view != a.this.f63061f) {
                if (view != a.this.f63063h) {
                    if (view == a.this.f63062g) {
                        this.f63064e.a(4);
                        System.arraycopy(a.this.f63057b, 1, a.this.f63057b, 0, a.this.f63057b.length - 1);
                        a.this.f63057b[a.this.f63057b.length - 1] = SystemClock.uptimeMillis();
                        if (a.this.f63057b[0] >= a.this.f63057b[a.this.f63057b.length - 1] - 2000) {
                            a.this.f63057b = new long[5];
                            this.f63064e.a(6);
                            a.this.u();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f63064e.a(2);
            } else {
                this.f63064e.a(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f63066e;

        public b(d dVar) {
            this.f63066e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f63062g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f63066e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f63057b = new long[5];
        this.f63056a = aboutActivity;
        s();
        r(dVar);
    }

    public void o() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void q() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void r(d dVar) {
        View$OnClickListenerC1658a view$OnClickListenerC1658a = new View$OnClickListenerC1658a(dVar);
        b bVar = new b(dVar);
        this.f63061f.setOnClickListener(view$OnClickListenerC1658a);
        this.f63063h.setOnClickListener(view$OnClickListenerC1658a);
        this.i.setOnClickListener(view$OnClickListenerC1658a);
        this.j.setOnClickListener(view$OnClickListenerC1658a);
        this.k.setOnClickListener(view$OnClickListenerC1658a);
        this.f63062g.setOnClickListener(view$OnClickListenerC1658a);
        this.f63062g.setOnLongClickListener(bVar);
    }

    public final void s() {
        this.f63056a.setContentView(R.layout.about_activity);
        this.f63059d = (RelativeLayout) this.f63056a.findViewById(R.id.parent);
        this.f63062g = (ImageView) this.f63056a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f63056a.findViewById(R.id.view_navigation_bar);
        this.f63058c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63058c.setTitleText(this.f63056a.getPageContext().getString(R.string.version_info));
        this.f63060e = (TextView) this.f63056a.findViewById(R.id.text_versioninfo);
        this.f63061f = (SettingTextTestNewView) this.f63056a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f63056a.findViewById(R.id.about_guide);
        this.f63063h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f63056a.findViewById(R.id.tieba_protocol_text);
        this.i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f63056a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f63056a.findViewById(R.id.tieba_tdou_use_introduce);
        this.k = tbSettingTextTipView4;
        tbSettingTextTipView4.c();
        this.m = (ProgressBar) this.f63056a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f63060e.setText(this.f63056a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f63056a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f63056a.findViewById(R.id.text_version_protoco);
        x(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f63063h.setVisibility(8);
        }
        if (d.b.h0.r.d0.b.j().g("debug_plugin_switcher", false)) {
            w(0);
        }
    }

    public final void u() {
    }

    public void v() {
        SettingTextTestNewView settingTextTestNewView = this.f63061f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void w(int i) {
        this.f63056a.findViewById(R.id.line0).setVisibility(i);
    }

    public void x(int i) {
        SkinManager.setBackgroundColor(this.f63059d, R.color.CAM_X0201);
        this.f63058c.onChangeSkinType(getPageContext(), i);
        this.f63056a.getLayoutMode().k(i == 1);
        this.f63056a.getLayoutMode().j(this.f63059d);
        v();
    }
}
