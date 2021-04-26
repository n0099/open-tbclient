package d.a.j0.q0.x1;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import d.a.c.e.g.d;
import d.a.c.e.p.l;
import d.a.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.g.c f58934a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f58935b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f58936c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f58937d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.g.b f58938e;

    /* renamed from: f  reason: collision with root package name */
    public String f58939f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f58940g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f58941h;

    /* renamed from: i  reason: collision with root package name */
    public String f58942i;
    public String j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f58934a != null) {
                c.this.f58934a.e(c.this.f58936c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            c.this.f58934a = null;
            c.this.f58940g.removeCallbacks(c.this.f58941h);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* renamed from: d.a.j0.q0.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1473c implements d.a.c.e.g.b {

        /* renamed from: d.a.j0.q0.x1.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.i0.r.f0.m.a f58946e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f58947f;

            public a(d.a.i0.r.f0.m.a aVar, FollowUserButton followUserButton) {
                this.f58946e = aVar;
                this.f58947f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f58937d != null) {
                    c.this.f58937d.onClick(view);
                }
                this.f58946e.o(R.color.CAM_X0109);
                this.f58946e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                this.f58947f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                this.f58947f.setClickable(false);
                if (c.this.f58941h != null) {
                    c.this.f58940g.removeCallbacks(c.this.f58941h);
                    c.this.f58940g.postDelayed(c.this.f58941h, 1000L);
                }
            }
        }

        public C1473c() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 32;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.frs_guide_bg);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
            FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            barImageView.setContentDescription(c.this.f58935b.getResources().getString(R.string.bar_header));
            barImageView.setStrokeWith(l.g(c.this.f58935b, R.dimen.tbds1));
            barImageView.setShowOval(true);
            barImageView.setPlaceHolder(1);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
            if (!StringUtils.isNull(c.this.f58939f)) {
                barImageView.V(c.this.f58939f, 10, false);
            }
            d.a.i0.r.f0.m.a aVar = new d.a.i0.r.f0.m.a();
            aVar.o(R.color.CAM_X0302);
            aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
            aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
            followUserButton.setConfig(aVar);
            followUserButton.setText(c.this.f58935b.getString(R.string.attention));
            followUserButton.setOnClickListener(new a(aVar, followUserButton));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(c.this.f58935b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(c.this.f58935b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(c.this.f58935b, R.dimen.tbds5)).into(findViewById);
            return inflate;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f58934a != null) {
                c.this.f58934a.e(c.this.f58936c);
                c.this.f58936c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a {
        public e() {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            c.this.f58934a = null;
            c.this.f58940g.removeCallbacks(c.this.f58941h);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.c.e.g.b {

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MessageManager.getInstance().findTask(2002015) != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_forumId", c.this.j);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkCoreApplication.getInst().getApplicationContext(), "ForumAppealPage", hashMap)));
                }
                if (c.this.f58941h != null) {
                    c.this.f58940g.removeCallbacks(c.this.f58941h);
                    c.this.f58940g.postDelayed(c.this.f58941h, 1000L);
                }
            }
        }

        public f() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 32;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
            SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0302);
            eMTextView.setText(c.this.f58942i);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
            d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
            bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(bVar);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
            tBSpecificationBtn.setOnClickListener(new a());
            return inflate;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public c(Activity activity, int i2) {
        this.f58935b = activity;
        this.f58936c = (ViewGroup) activity.findViewById(i2);
    }

    public final d.a.c.e.g.b k() {
        return new C1473c();
    }

    public final d.a.c.e.g.b l() {
        return new f();
    }

    public void m() {
        d.a.c.e.g.c cVar = this.f58934a;
        if (cVar != null) {
            cVar.e(this.f58936c);
            this.f58936c.setVisibility(8);
        }
    }

    public void n(String str) {
        this.f58939f = str;
    }

    public void o(View.OnClickListener onClickListener) {
        this.f58937d = onClickListener;
    }

    public void p(String str) {
        this.f58942i = str;
    }

    public void q(String str) {
        this.j = str;
    }

    public void r() {
        ViewGroup viewGroup = this.f58936c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f58934a;
        if (cVar != null) {
            cVar.e(this.f58936c);
        }
        this.f58941h = new d();
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new e());
        if (this.f58938e == null) {
            this.f58938e = l();
        }
        dVar.a(this.f58938e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.c.e.g.c b2 = dVar.b();
        this.f58934a = b2;
        b2.q(this.f58935b, this.f58936c, false);
        d.a.i0.r.u.c d2 = d.a.i0.r.u.c.d(this.f58936c);
        d2.k(R.string.J_X05);
        d2.p(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f58940g.postDelayed(this.f58941h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup = this.f58936c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f58934a;
        if (cVar != null) {
            cVar.e(this.f58936c);
        }
        this.f58941h = new a();
        d.a.c.e.g.d dVar = new d.a.c.e.g.d();
        dVar.d(true);
        dVar.g(new b());
        if (this.f58938e == null) {
            this.f58938e = k();
        }
        dVar.a(this.f58938e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.a.c.e.g.c b2 = dVar.b();
        this.f58934a = b2;
        b2.q(this.f58935b, this.f58936c, false);
        this.f58940g.postDelayed(this.f58941h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
