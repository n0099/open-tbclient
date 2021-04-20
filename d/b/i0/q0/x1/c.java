package d.b.i0.q0.x1;

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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.FollowUserButton;
import d.b.c.e.g.d;
import d.b.c.e.p.l;
import d.b.i0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.c.e.g.c f60398a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f60399b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f60400c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f60401d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.c.e.g.b f60402e;

    /* renamed from: f  reason: collision with root package name */
    public String f60403f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f60404g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f60405h;
    public String i;
    public String j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f60398a != null) {
                c.this.f60398a.e(c.this.f60400c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // d.b.c.e.g.d.a
        public void onDismiss() {
            c.this.f60398a = null;
            c.this.f60404g.removeCallbacks(c.this.f60405h);
        }

        @Override // d.b.c.e.g.d.a
        public void onShown() {
        }
    }

    /* renamed from: d.b.i0.q0.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1511c implements d.b.c.e.g.b {

        /* renamed from: d.b.i0.q0.x1.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.r.f0.m.a f60409e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f60410f;

            public a(d.b.h0.r.f0.m.a aVar, FollowUserButton followUserButton) {
                this.f60409e = aVar;
                this.f60410f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f60401d != null) {
                    c.this.f60401d.onClick(view);
                }
                this.f60409e.o(R.color.CAM_X0109);
                this.f60409e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                this.f60410f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                this.f60410f.setClickable(false);
                if (c.this.f60405h != null) {
                    c.this.f60404g.removeCallbacks(c.this.f60405h);
                    c.this.f60404g.postDelayed(c.this.f60405h, 1000L);
                }
            }
        }

        public C1511c() {
        }

        @Override // d.b.c.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.b.c.e.g.b
        public View b(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.frs_guide_bg);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
            FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            barImageView.setContentDescription(c.this.f60399b.getResources().getString(R.string.bar_header));
            barImageView.setStrokeWith(l.g(c.this.f60399b, R.dimen.tbds1));
            barImageView.setShowOval(true);
            barImageView.setPlaceHolder(1);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
            if (!StringUtils.isNull(c.this.f60403f)) {
                barImageView.W(c.this.f60403f, 10, false);
            }
            d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
            aVar.o(R.color.CAM_X0302);
            aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
            aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
            followUserButton.setConfig(aVar);
            followUserButton.setText(c.this.f60399b.getString(R.string.attention));
            followUserButton.setOnClickListener(new a(aVar, followUserButton));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(c.this.f60399b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(c.this.f60399b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(c.this.f60399b, R.dimen.tbds5)).into(findViewById);
            return inflate;
        }

        @Override // d.b.c.e.g.b
        public int c() {
            return 32;
        }

        @Override // d.b.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.b.c.e.g.b
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
            if (c.this.f60398a != null) {
                c.this.f60398a.e(c.this.f60400c);
                c.this.f60400c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a {
        public e() {
        }

        @Override // d.b.c.e.g.d.a
        public void onDismiss() {
            c.this.f60398a = null;
            c.this.f60404g.removeCallbacks(c.this.f60405h);
        }

        @Override // d.b.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.c.e.g.b {

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
                if (c.this.f60405h != null) {
                    c.this.f60404g.removeCallbacks(c.this.f60405h);
                    c.this.f60404g.postDelayed(c.this.f60405h, 1000L);
                }
            }
        }

        public f() {
        }

        @Override // d.b.c.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.b.c.e.g.b
        public View b(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.frs_guide_delete_thread_tip, (ViewGroup) null);
            EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.frs_guide_delete_thread_tip_describe);
            SkinManager.setViewTextColor(eMTextView, R.color.CAM_X0302);
            eMTextView.setText(c.this.i);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.frs_guide_delete_thread_tip_button);
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
            tBSpecificationBtn.setConfig(bVar);
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getString(R.string.frs_guide_delete_thread_tip_button));
            tBSpecificationBtn.setOnClickListener(new a());
            return inflate;
        }

        @Override // d.b.c.e.g.b
        public int c() {
            return 32;
        }

        @Override // d.b.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.b.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public c(Activity activity, int i) {
        this.f60399b = activity;
        this.f60400c = (ViewGroup) activity.findViewById(i);
    }

    public final d.b.c.e.g.b k() {
        return new C1511c();
    }

    public final d.b.c.e.g.b l() {
        return new f();
    }

    public void m() {
        d.b.c.e.g.c cVar = this.f60398a;
        if (cVar != null) {
            cVar.e(this.f60400c);
            this.f60400c.setVisibility(8);
        }
    }

    public void n(String str) {
        this.f60403f = str;
    }

    public void o(View.OnClickListener onClickListener) {
        this.f60401d = onClickListener;
    }

    public void p(String str) {
        this.i = str;
    }

    public void q(String str) {
        this.j = str;
    }

    public void r() {
        ViewGroup viewGroup = this.f60400c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.b.c.e.g.c cVar = this.f60398a;
        if (cVar != null) {
            cVar.e(this.f60400c);
        }
        this.f60405h = new d();
        d.b.c.e.g.d dVar = new d.b.c.e.g.d();
        dVar.d(true);
        dVar.g(new e());
        if (this.f60402e == null) {
            this.f60402e = l();
        }
        dVar.a(this.f60402e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.b.c.e.g.c b2 = dVar.b();
        this.f60398a = b2;
        b2.r(this.f60399b, this.f60400c, false);
        d.b.h0.r.u.c d2 = d.b.h0.r.u.c.d(this.f60400c);
        d2.k(R.string.J_X05);
        d2.p(R.array.S_O_X004);
        d2.f(R.color.CAM_X0207);
        this.f60404g.postDelayed(this.f60405h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup = this.f60400c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.b.c.e.g.c cVar = this.f60398a;
        if (cVar != null) {
            cVar.e(this.f60400c);
        }
        this.f60405h = new a();
        d.b.c.e.g.d dVar = new d.b.c.e.g.d();
        dVar.d(true);
        dVar.g(new b());
        if (this.f60402e == null) {
            this.f60402e = k();
        }
        dVar.a(this.f60402e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.b.c.e.g.c b2 = dVar.b();
        this.f60398a = b2;
        b2.r(this.f60399b, this.f60400c, false);
        this.f60404g.postDelayed(this.f60405h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
