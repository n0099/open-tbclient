package d.a.n0.v3;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f62368a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f62369b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f62370c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62371d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62372e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f62373f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f62374g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f62375h;

    /* renamed from: i  reason: collision with root package name */
    public PermissionJudgePolicy f62376i;
    public View j;
    public ImageView k;
    public PopupWindow l;
    public boolean m;
    public Handler n;
    public int o;
    public Runnable p;
    public Runnable q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o == 1) {
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 22));
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "1"));
            }
            d.this.p(6, false);
            d.a.n0.u2.a.v().L(6, false, true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new DressupCenterActivityConfig(d.this.f62368a)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.o == 1) {
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 23));
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
            }
            d.this.p(5, false);
            TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "2"));
            d.this.p(5, false);
            d.a.n0.u2.a.v().L(5, false, true);
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2015004)) {
                BdToast.d(d.this.f62368a, d.this.f62368a.getResources().getString(R.string.plugin_video_installing), 0).q();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2015004, new IntentConfig(view.getContext())));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* loaded from: classes5.dex */
        public class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
            public a() {
            }

            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
            public void onPermissionsGranted() {
                TiebaStatic.log(new StatisticItem("c12706"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(d.this.f62368a)));
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f62368a instanceof Activity) {
                Activity activity = (Activity) d.this.f62368a;
                if (d.this.f62376i == null) {
                    d.this.f62376i = new PermissionJudgePolicy();
                }
                d.this.f62376i.clearRequestPermissionList();
                d.this.f62376i.appendRequestPermission(activity, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
                d.this.f62376i.setOnPermissionsGrantedListener(new a());
                d.this.f62376i.startRequestPermission(activity);
            }
        }
    }

    /* renamed from: d.a.n0.v3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1691d implements Runnable {
        public RunnableC1691d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = d.this.f62374g;
            if (imageView == null) {
                return;
            }
            d.a.c.e.m.g.k(d.this.l, imageView);
            d.a.m0.r.d0.b.j().t("show_person_tab_feedback_tips", true);
            d.this.m = true;
            d.this.n.postDelayed(d.this.q, 3000L);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.l();
        }
    }

    public d(int i2) {
        TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds28);
        this.n = new Handler();
        this.p = new RunnableC1691d();
        this.q = new e();
        this.o = i2;
    }

    public void k() {
        this.f62369b.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
        if (this.o == 1) {
            RelativeLayout relativeLayout = this.f62370c;
            if (relativeLayout != null && relativeLayout.getParent() == null) {
                this.f62369b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f62370c, (View.OnClickListener) null);
            }
            RelativeLayout relativeLayout2 = this.f62373f;
            if (relativeLayout2 != null && relativeLayout2.getParent() == null) {
                this.f62369b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f62373f, (View.OnClickListener) null);
            }
            View view = this.j;
            if (view == null || view.getParent() != null) {
                return;
            }
            this.f62369b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.j, (View.OnClickListener) null);
        }
    }

    public final void l() {
        d.a.c.e.m.g.c(this.l);
    }

    public void m(int i2) {
        if (this.f62371d != null) {
            if (2 == i2) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62371d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.f62369b.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62371d, R.drawable.icon_pure_topbar_store44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62371d, R.drawable.icon_pure_topbar_store44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView imageView = this.f62372e;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.drawable.icon_news_down_bar_one);
            }
        }
        if (this.f62374g != null) {
            if (2 == i2) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62374g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else if (this.f62369b.getBarBgView().getAlpha() < 0.5f) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62374g, R.drawable.icon_pure_topbar_set44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f62374g, R.drawable.icon_pure_topbar_set44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            ImageView imageView2 = this.f62375h;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.drawable.icon_news_down_bar_one);
            }
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, R.drawable.icon_pure_topbar_scan44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n(Context context, NavigationBar navigationBar) {
        this.f62368a = context;
        this.f62369b = navigationBar;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_dressup, (ViewGroup) null);
        this.f62370c = relativeLayout;
        this.f62371d = (ImageView) relativeLayout.findViewById(R.id.person_navigation_dressup_img);
        this.f62372e = (ImageView) this.f62370c.findViewById(R.id.person_navigation_dressup_red_tip);
        RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.item_person_host_navigation_setting, (ViewGroup) null);
        this.f62373f = relativeLayout2;
        this.f62374g = (ImageView) relativeLayout2.findViewById(R.id.person_navigation_setting_img);
        this.f62375h = (ImageView) this.f62373f.findViewById(R.id.person_navigation_setting_red_tip);
        View inflate = LayoutInflater.from(this.f62368a).inflate(R.layout.item_person_host_navigation_scan, (ViewGroup) null);
        this.j = inflate;
        this.k = (ImageView) inflate.findViewById(R.id.person_navigation_scan_img);
    }

    public void o(f fVar) {
        RelativeLayout relativeLayout = this.f62370c;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new a());
        }
        RelativeLayout relativeLayout2 = this.f62373f;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new b());
        }
        View view = this.j;
        if (view != null) {
            view.setOnClickListener(new c());
        }
    }

    public void p(int i2, boolean z) {
        ImageView imageView;
        ImageView imageView2;
        if (i2 == 5 && (imageView2 = this.f62375h) != null) {
            imageView2.setVisibility(z ? 0 : 8);
        } else if (i2 != 6 || (imageView = this.f62372e) == null) {
        } else {
            imageView.setVisibility(z ? 0 : 8);
        }
    }
}
