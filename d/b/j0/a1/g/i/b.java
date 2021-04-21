package d.b.j0.a1.g.i;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.c.j.e.c;
import d.b.i0.r.f0.f;
/* loaded from: classes4.dex */
public class b extends c implements BigdaySwipeRefreshLayout.k, PersonalizePageView.d0 {
    public TbImageView k;
    public LottieAnimationView l;
    public ImageView m;
    public TextView n;
    public d.b.i0.r.n.a o;
    public String p;
    public String q;
    public String r;
    public String s;
    public f.g t;
    public f.InterfaceC1110f u;
    public f.h v;
    public f.e w;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.g {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(TbImageView tbImageView, Canvas canvas) {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void b(TbImageView tbImageView, Canvas canvas) {
            if (b.this.k.getBdImage() != null || b.this.o == null || k.isEmpty(b.this.o.f51392a)) {
                return;
            }
            b.this.k.W(b.this.o.f51392a, 41, false);
        }
    }

    public b(Context context) {
        super(context);
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        if (context != null) {
            this.p = context.getText(R.string.adp_pull_to_refresh).toString();
            this.q = context.getText(R.string.bigday_refreshing).toString();
            this.r = context.getText(R.string.bigday_release_to_refresh).toString();
            this.s = context.getText(R.string.bigday_release_to_ad).toString();
        }
    }

    public d.b.i0.r.n.a G() {
        return this.o;
    }

    public void H() {
    }

    public final void I(float f2) {
        d.b.i0.r.n.a aVar;
        this.n.setAlpha(f2);
        this.m.setAlpha(f2);
        if (this.m.getBackground() != null || (aVar = this.o) == null) {
            return;
        }
        if (aVar.f51394c == 1) {
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
        } else {
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
        }
    }

    public void J(d.b.i0.r.n.a aVar) {
        if (aVar.a()) {
            this.o = aVar;
        }
        if (aVar.f51394c == 1) {
            this.n.setTextColor(p().getResources().getColor(R.color.CAM_X0101));
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.l.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.n.setTextColor(p().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.l.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.l.setFrame(0);
        this.k.W(aVar.f51392a, 41, false);
        this.k.setOnDrawListener(new a());
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void a(f.e eVar) {
        this.w = eVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void b(f.g gVar) {
        this.t = gVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void c(f.h hVar) {
        this.v = hVar;
    }

    @Override // d.b.c.j.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void f(float f2, float f3) {
        super.f(f2, f3);
        float dimension = getView().getResources().getDimension(R.dimen.tbds120);
        float dimension2 = getView().getResources().getDimension(R.dimen.tbds236);
        float f4 = f2 * dimension2;
        if (f4 < dimension2) {
            float f5 = 0.09090909f;
            float f6 = ((f4 - dimension) / (dimension2 - dimension)) * 0.09090909f;
            if (f6 < 0.0f) {
                f5 = 0.0f;
            } else if (f6 <= 0.09090909f) {
                f5 = f6;
            }
            this.l.setProgress(f5);
            return;
        }
        this.l.setAlpha(1.0f - ((f4 - dimension2) / (l() - dimension2)));
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void g(f.InterfaceC1110f interfaceC1110f) {
        this.u = interfaceC1110f;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void h() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
        this.n.animate().alpha(0.0f).setDuration(200L).start();
        this.m.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void i() {
        this.n.setText(this.s);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void k() {
        d.b.i0.r.n.a aVar = this.o;
        if (aVar == null || !aVar.a()) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        Context p = p();
        d.b.i0.r.n.a aVar2 = this.o;
        messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(p, aVar2.f51392a, aVar2.f51393b, aVar2.f51395d)));
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int l() {
        return (int) (l.i(p()) * 0.3d);
    }

    @Override // d.b.c.j.e.c
    public View n() {
        View inflate = LayoutInflater.from(p()).inflate(R.layout.bigday_pull_view, (ViewGroup) null, false);
        this.k = (TbImageView) inflate.findViewById(R.id.pull_image);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.bigday_close);
        this.l = (LottieAnimationView) inflate.findViewById(R.id.bigday_lotti);
        this.m = (ImageView) inflate.findViewById(R.id.text_mask);
        this.n = (TextView) inflate.findViewById(R.id.state_text);
        if (UtilHelper.canUseStyleImmersiveSticky() && (imageView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) imageView.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds25));
        }
        this.k.setAutoChangeStyle(false);
        this.n.setText(this.p);
        return inflate;
    }

    @Override // d.b.c.j.e.c
    public void o(boolean z) {
        I(1.0f);
        this.l.setAlpha(1.0f);
        this.n.setText(this.p);
        f.e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
        f.InterfaceC1110f interfaceC1110f = this.u;
        if (interfaceC1110f != null) {
            interfaceC1110f.a(getView(), z);
        }
        this.l.cancelAnimation();
    }

    @Override // d.b.c.j.e.c
    public void u() {
        this.n.setText("");
        this.l.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // d.b.c.j.e.c
    public void v(boolean z) {
        f.g gVar = this.t;
        if (gVar != null) {
            gVar.onListPullRefresh(z);
        }
    }

    @Override // d.b.c.j.e.c
    public void x(boolean z) {
        I(1.0f);
        this.n.setText(this.p);
        f.h hVar = this.v;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    @Override // d.b.c.j.e.c
    public void y() {
        I(1.0f);
        this.n.setText(this.q);
        this.l.setAlpha(1.0f);
        this.l.setMinAndMaxFrame(8, 58);
        this.l.loop(true);
        this.l.playAnimation();
    }

    @Override // d.b.c.j.e.c
    public void z() {
        this.n.setText(this.r);
    }
}
