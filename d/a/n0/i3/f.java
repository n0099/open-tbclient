package d.a.n0.i3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideActivity;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import d.a.c.e.m.g;
import d.a.n0.e3.f0;
import d.a.n0.e3.w;
/* loaded from: classes5.dex */
public class f implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f55800e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f55801f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.i3.a f55802g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f55803h;

    /* renamed from: i  reason: collision with root package name */
    public f0 f55804i;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.a.e {
        public a() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj == null) {
                f.this.f55800e.showToast(R.string.neterror);
            } else if (obj instanceof w) {
                int d2 = d.a.c.e.m.b.d(((w) obj).g(), 0);
                f.this.f55802g.b(d2);
                f.this.c(d2, true);
                f.this.f55800e.setHasLike(true);
                f.this.f55800e.setIsChanged(true);
                TiebaStatic.eventStat(f.this.f55800e.getPageContext().getPageActivity(), "notlogin_12", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f0.a {
        public b() {
        }

        @Override // d.a.n0.e3.f0.a
        public void a(String str, long j) {
            f.this.f55800e.showToast(R.string.error);
        }

        @Override // d.a.n0.e3.f0.a
        public void b(String str, long j) {
            int d2 = d.a.c.e.m.b.d(String.valueOf(j), 0);
            f.this.f55802g.a(d2);
            f.this.c(d2, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f55807e;

        public c(f fVar, NewUserGuideMainFragment.b bVar) {
            this.f55807e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f55807e.a();
        }
    }

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, NewUserGuideMainFragment.b bVar) {
        this.f55800e = newUserGuideActivity;
        this.f55801f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f55802g = new e(this.f55800e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f55802g = new d.a.n0.i3.b(this.f55800e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f55802g = new d(this.f55800e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f55803h = likeModel;
        likeModel.setLoadDataCallBack(new a());
        f0 f0Var = new f0();
        this.f55804i = f0Var;
        f0Var.b(new b());
        this.f55802g.d(this);
        this.f55802g.c(this.f55801f);
        ((Dialog) this.f55802g).setOnDismissListener(new c(this, bVar));
    }

    public void c(int i2, boolean z) {
        for (int i3 = 0; i3 < this.f55801f.getCard_list().size(); i3++) {
            if (this.f55801f.getCard_list().get(i3).getFid() == i2) {
                this.f55801f.getCard_list().get(i3).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    public void d() {
        NewUserGuideActivity newUserGuideActivity = this.f55800e;
        if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.f55802g.getRootView().setAnimation(scaleAnimation);
            this.f55802g.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.f55802g.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.f55804i.c(card.getFname(), card.getFid());
            } else {
                this.f55803h.I(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }
}
