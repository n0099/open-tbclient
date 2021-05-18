package d.a.k0.a1.g.i;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.j.e.c;
import d.a.j0.r.f0.f;
/* loaded from: classes4.dex */
public class b extends c implements BigdaySwipeRefreshLayout.k, PersonalizePageView.d0 {
    public TbImageView k;
    public LottieAnimationView l;
    public ImageView m;
    public TextView n;
    public d.a.j0.r.n.a o;
    public String p;
    public String q;
    public String r;
    public String s;
    public f.g t;
    public f.InterfaceC1125f u;
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
            if (b.this.k.getBdImage() != null || b.this.o == null || k.isEmpty(b.this.o.f49840a)) {
                return;
            }
            b.this.k.V(b.this.o.f49840a, 41, false);
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

    public d.a.j0.r.n.a G() {
        return this.o;
    }

    public void H() {
    }

    public final void I(float f2) {
        d.a.j0.r.n.a aVar;
        this.n.setAlpha(f2);
        this.m.setAlpha(f2);
        if (this.m.getBackground() != null || (aVar = this.o) == null) {
            return;
        }
        if (aVar.f49842c == 1) {
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
        } else {
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
        }
    }

    public void J(d.a.j0.r.n.a aVar) {
        if (aVar.a()) {
            this.o = aVar;
        }
        if (aVar.f49842c == 1) {
            this.n.setTextColor(p().getResources().getColor(R.color.CAM_X0101));
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_black);
            this.l.setAnimation(R.raw.lottie_refresh_light);
        } else {
            this.n.setTextColor(p().getResources().getColor(R.color.cp_cont_b_alpha40));
            this.m.setBackgroundResource(R.drawable.bigday_text_mask_white);
            this.l.setAnimation(R.raw.lottie_refresh_dark);
        }
        this.l.setFrame(0);
        this.k.V(aVar.f49840a, 41, false);
        this.k.setOnDrawListener(new a());
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void a(f.g gVar) {
        this.t = gVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void b(f.h hVar) {
        this.v = hVar;
    }

    @Override // d.a.c.j.e.c, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void e(float f2, float f3) {
        super.e(f2, f3);
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
        this.l.setAlpha(1.0f - ((f4 - dimension2) / (h() - dimension2)));
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void f() {
        this.n.setText(this.s);
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void g() {
        d.a.j0.r.n.a aVar = this.o;
        if (aVar == null || !aVar.a()) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        Context p = p();
        d.a.j0.r.n.a aVar2 = this.o;
        messageManager.sendMessage(new CustomMessage(2002001, new BigdayActivityConfig(p, aVar2.f49840a, aVar2.f49841b, aVar2.f49843d)));
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public int h() {
        return (int) (l.i(p()) * 0.3d);
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void i(f.e eVar) {
        this.w = eVar;
    }

    @Override // com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout.k
    public void j() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.FALSE));
        this.n.animate().alpha(0.0f).setDuration(200L).start();
        this.m.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // com.baidu.tieba.homepage.personalize.PersonalizePageView.d0
    public void l(f.InterfaceC1125f interfaceC1125f) {
        this.u = interfaceC1125f;
    }

    @Override // d.a.c.j.e.c
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

    @Override // d.a.c.j.e.c
    public void o(boolean z) {
        I(1.0f);
        this.l.setAlpha(1.0f);
        this.n.setText(this.p);
        f.e eVar = this.w;
        if (eVar != null) {
            eVar.a();
        }
        f.InterfaceC1125f interfaceC1125f = this.u;
        if (interfaceC1125f != null) {
            interfaceC1125f.a(getView(), z);
        }
        this.l.cancelAnimation();
    }

    @Override // d.a.c.j.e.c
    public void u() {
        this.n.setText("");
        this.l.animate().alpha(0.0f).setDuration(200L).start();
    }

    @Override // d.a.c.j.e.c
    public void v(boolean z) {
        f.g gVar = this.t;
        if (gVar != null) {
            gVar.onListPullRefresh(z);
        }
    }

    @Override // d.a.c.j.e.c
    public void x(boolean z) {
        I(1.0f);
        this.n.setText(this.p);
        f.h hVar = this.v;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    @Override // d.a.c.j.e.c
    public void y() {
        I(1.0f);
        this.n.setText(this.q);
        this.l.setAlpha(1.0f);
        this.l.setMinAndMaxFrame(8, 58);
        this.l.loop(true);
        this.l.playAnimation();
    }

    @Override // d.a.c.j.e.c
    public void z() {
        this.n.setText(this.r);
    }
}
