package d.b.i0.u2.c;

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
import d.b.b.e.p.k;
/* loaded from: classes5.dex */
public class a extends d.b.b.a.d<AboutActivity> {

    /* renamed from: a  reason: collision with root package name */
    public AboutActivity f61317a;

    /* renamed from: b  reason: collision with root package name */
    public long[] f61318b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61319c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout f61320d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61321e;

    /* renamed from: f  reason: collision with root package name */
    public SettingTextTestNewView f61322f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f61323g;

    /* renamed from: h  reason: collision with root package name */
    public TbSettingTextTipView f61324h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TextView l;
    public ProgressBar m;

    /* renamed from: d.b.i0.u2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1597a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f61325e;

        public View$OnClickListenerC1597a(d dVar) {
            this.f61325e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.i) {
                UrlManager.getInstance().dealOneLink(a.this.f61317a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/eula_mobile.html"});
            } else if (view == a.this.j) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.f61317a.getPageContext(), new String[]{"http://tieba.baidu.com/tb/mobile/wisemainstatic/secretright.html"}, true);
            } else if (view == a.this.k) {
                UrlManager.getInstance().dealOneLink(a.this.f61317a.getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile.html"});
            } else if (view != a.this.f61322f) {
                if (view != a.this.f61324h) {
                    if (view == a.this.f61323g) {
                        this.f61325e.a(4);
                        System.arraycopy(a.this.f61318b, 1, a.this.f61318b, 0, a.this.f61318b.length - 1);
                        a.this.f61318b[a.this.f61318b.length - 1] = SystemClock.uptimeMillis();
                        if (a.this.f61318b[0] >= a.this.f61318b[a.this.f61318b.length - 1] - 2000) {
                            a.this.f61318b = new long[5];
                            this.f61325e.a(6);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f61325e.a(2);
            } else {
                this.f61325e.a(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f61327e;

        public b(d dVar) {
            this.f61327e = dVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view == a.this.f61323g && TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                this.f61327e.a(5);
                return true;
            }
            return false;
        }
    }

    public a(AboutActivity aboutActivity, d dVar) {
        super(aboutActivity.getPageContext());
        this.f61318b = new long[5];
        this.f61317a = aboutActivity;
        r();
        q(dVar);
    }

    public void n() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public void o() {
        ProgressBar progressBar = this.m;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public final void q(d dVar) {
        View$OnClickListenerC1597a view$OnClickListenerC1597a = new View$OnClickListenerC1597a(dVar);
        b bVar = new b(dVar);
        this.f61322f.setOnClickListener(view$OnClickListenerC1597a);
        this.f61324h.setOnClickListener(view$OnClickListenerC1597a);
        this.i.setOnClickListener(view$OnClickListenerC1597a);
        this.j.setOnClickListener(view$OnClickListenerC1597a);
        this.k.setOnClickListener(view$OnClickListenerC1597a);
        this.f61323g.setOnClickListener(view$OnClickListenerC1597a);
        this.f61323g.setOnLongClickListener(bVar);
    }

    public final void r() {
        this.f61317a.setContentView(R.layout.about_activity);
        this.f61320d = (RelativeLayout) this.f61317a.findViewById(R.id.parent);
        this.f61323g = (ImageView) this.f61317a.findViewById(R.id.image_logo);
        NavigationBar navigationBar = (NavigationBar) this.f61317a.findViewById(R.id.view_navigation_bar);
        this.f61319c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61319c.setTitleText(this.f61317a.getPageContext().getString(R.string.version_info));
        this.f61321e = (TextView) this.f61317a.findViewById(R.id.text_versioninfo);
        this.f61322f = (SettingTextTestNewView) this.f61317a.findViewById(R.id.about_version_update);
        TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.f61317a.findViewById(R.id.about_guide);
        this.f61324h = tbSettingTextTipView;
        tbSettingTextTipView.c();
        TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.f61317a.findViewById(R.id.tieba_protocol_text);
        this.i = tbSettingTextTipView2;
        tbSettingTextTipView2.c();
        TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.f61317a.findViewById(R.id.tieba_privacy_text);
        this.j = tbSettingTextTipView3;
        tbSettingTextTipView3.c();
        TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.f61317a.findViewById(R.id.tieba_tdou_use_introduce);
        this.k = tbSettingTextTipView4;
        tbSettingTextTipView4.c();
        this.m = (ProgressBar) this.f61317a.findViewById(R.id.about_progress);
        String version = TbConfig.getVersion();
        if (TbConfig.getVersionType() == 1 && !k.isEmpty(TbConfig.getSubVersion())) {
            version = version + "." + TbConfig.getSubVersion();
        }
        this.f61321e.setText(this.f61317a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.f61317a.getPageContext().getString(R.string.setting_version_text) + " " + version);
        this.l = (TextView) this.f61317a.findViewById(R.id.text_version_protoco);
        v(TbadkCoreApplication.getInst().getSkinType());
        if (MessageManager.getInstance().findTask(2015001) == null) {
            this.f61324h.setVisibility(8);
        }
        if (d.b.h0.r.d0.b.i().g("debug_plugin_switcher", false)) {
            u(0);
        }
    }

    public void s() {
        SettingTextTestNewView settingTextTestNewView = this.f61322f;
        if (settingTextTestNewView != null) {
            settingTextTestNewView.i();
        }
    }

    public final void u(int i) {
        this.f61317a.findViewById(R.id.line0).setVisibility(i);
    }

    public void v(int i) {
        SkinManager.setBackgroundColor(this.f61320d, R.color.CAM_X0201);
        this.f61319c.onChangeSkinType(getPageContext(), i);
        this.f61317a.getLayoutMode().k(i == 1);
        this.f61317a.getLayoutMode().j(this.f61320d);
        s();
    }
}
