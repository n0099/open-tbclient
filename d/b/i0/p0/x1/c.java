package d.b.i0.p0.x1;

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
import d.b.b.e.g.d;
import d.b.b.e.p.l;
import d.b.i0.c3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.g.c f58729a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f58730b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f58731c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f58732d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.b.e.g.b f58733e;

    /* renamed from: f  reason: collision with root package name */
    public String f58734f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f58735g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f58736h;
    public String i;
    public String j;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f58729a != null) {
                c.this.f58729a.e(c.this.f58731c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // d.b.b.e.g.d.a
        public void onDismiss() {
            c.this.f58729a = null;
            c.this.f58735g.removeCallbacks(c.this.f58736h);
        }

        @Override // d.b.b.e.g.d.a
        public void onShown() {
        }
    }

    /* renamed from: d.b.i0.p0.x1.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1447c implements d.b.b.e.g.b {

        /* renamed from: d.b.i0.p0.x1.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.r.f0.m.a f58740e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ FollowUserButton f58741f;

            public a(d.b.h0.r.f0.m.a aVar, FollowUserButton followUserButton) {
                this.f58740e = aVar;
                this.f58741f = followUserButton;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.f58732d != null) {
                    c.this.f58732d.onClick(view);
                }
                this.f58740e.o(R.color.CAM_X0109);
                this.f58740e.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
                this.f58741f.setText(TbadkCoreApplication.getInst().getString(R.string.followed));
                this.f58741f.setClickable(false);
                if (c.this.f58736h != null) {
                    c.this.f58735g.removeCallbacks(c.this.f58736h);
                    c.this.f58735g.postDelayed(c.this.f58736h, 1000L);
                }
            }
        }

        public C1447c() {
        }

        @Override // d.b.b.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.b.b.e.g.b
        public View b(LayoutInflater layoutInflater) {
            View inflate = layoutInflater.inflate(R.layout.frs_guide_tip, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.frs_guide_bg);
            BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.frs_guide_bar_icon);
            FollowUserButton followUserButton = (FollowUserButton) inflate.findViewById(R.id.frs_guide_concern_btn);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.frs_guide_text), R.color.CAM_X0302);
            barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            barImageView.setContentDescription(c.this.f58730b.getResources().getString(R.string.bar_header));
            barImageView.setStrokeWith(l.g(c.this.f58730b, R.dimen.tbds1));
            barImageView.setShowOval(true);
            barImageView.setPlaceHolder(1);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
            if (!StringUtils.isNull(c.this.f58734f)) {
                barImageView.W(c.this.f58734f, 10, false);
            }
            d.b.h0.r.f0.m.a aVar = new d.b.h0.r.f0.m.a();
            aVar.o(R.color.CAM_X0302);
            aVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds28));
            aVar.i(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            aVar.f(UtilHelper.getDimenPixelSize(R.dimen.tbds11));
            followUserButton.setConfig(aVar);
            followUserButton.setText(c.this.f58730b.getString(R.string.attention));
            followUserButton.setOnClickListener(new a(aVar, followUserButton));
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(l.g(c.this.f58730b, R.dimen.tbds21)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(c.this.f58730b, R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(c.this.f58730b, R.dimen.tbds5)).into(findViewById);
            return inflate;
        }

        @Override // d.b.b.e.g.b
        public int c() {
            return 32;
        }

        @Override // d.b.b.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.b.b.e.g.b
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
            if (c.this.f58729a != null) {
                c.this.f58729a.e(c.this.f58731c);
                c.this.f58731c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a {
        public e() {
        }

        @Override // d.b.b.e.g.d.a
        public void onDismiss() {
            c.this.f58729a = null;
            c.this.f58735g.removeCallbacks(c.this.f58736h);
        }

        @Override // d.b.b.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.b.e.g.b {

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
                if (c.this.f58736h != null) {
                    c.this.f58735g.removeCallbacks(c.this.f58736h);
                    c.this.f58735g.postDelayed(c.this.f58736h, 1000L);
                }
            }
        }

        public f() {
        }

        @Override // d.b.b.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.b.b.e.g.b
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

        @Override // d.b.b.e.g.b
        public int c() {
            return 32;
        }

        @Override // d.b.b.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.b.b.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public c(Activity activity, int i) {
        this.f58730b = activity;
        this.f58731c = (ViewGroup) activity.findViewById(i);
    }

    public final d.b.b.e.g.b k() {
        return new C1447c();
    }

    public final d.b.b.e.g.b l() {
        return new f();
    }

    public void m() {
        d.b.b.e.g.c cVar = this.f58729a;
        if (cVar != null) {
            cVar.e(this.f58731c);
            this.f58731c.setVisibility(8);
        }
    }

    public void n(String str) {
        this.f58734f = str;
    }

    public void o(View.OnClickListener onClickListener) {
        this.f58732d = onClickListener;
    }

    public void p(String str) {
        this.i = str;
    }

    public void q(String str) {
        this.j = str;
    }

    public void r() {
        ViewGroup viewGroup = this.f58731c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.b.b.e.g.c cVar = this.f58729a;
        if (cVar != null) {
            cVar.e(this.f58731c);
        }
        this.f58736h = new d();
        d.b.b.e.g.d dVar = new d.b.b.e.g.d();
        dVar.d(true);
        dVar.g(new e());
        if (this.f58733e == null) {
            this.f58733e = l();
        }
        dVar.a(this.f58733e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.b.b.e.g.c b2 = dVar.b();
        this.f58729a = b2;
        b2.r(this.f58730b, this.f58731c, false);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.f58731c);
        a2.h(R.string.J_X05);
        a2.m(R.array.S_O_X004);
        a2.c(R.color.CAM_X0207);
        this.f58735g.postDelayed(this.f58736h, 5000L);
    }

    public void s() {
        ViewGroup viewGroup = this.f58731c;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.b.b.e.g.c cVar = this.f58729a;
        if (cVar != null) {
            cVar.e(this.f58731c);
        }
        this.f58736h = new a();
        d.b.b.e.g.d dVar = new d.b.b.e.g.d();
        dVar.d(true);
        dVar.g(new b());
        if (this.f58733e == null) {
            this.f58733e = k();
        }
        dVar.a(this.f58733e);
        dVar.e(R.anim.frs_guide_tip_enter);
        dVar.f(R.anim.frs_guide_tip_out);
        d.b.b.e.g.c b2 = dVar.b();
        this.f58729a = b2;
        b2.r(this.f58730b, this.f58731c, false);
        this.f58735g.postDelayed(this.f58736h, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
    }
}
