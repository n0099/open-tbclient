package d.b.i0.h3;

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
import d.b.c.e.m.g;
import d.b.i0.d3.f0;
import d.b.i0.d3.w;
/* loaded from: classes5.dex */
public class f implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public NewUserGuideActivity f56564e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f56565f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.h3.a f56566g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f56567h;
    public f0 i;

    /* loaded from: classes5.dex */
    public class a extends d.b.c.a.e {
        public a() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj == null) {
                f.this.f56564e.showToast(R.string.neterror);
            } else if (obj instanceof w) {
                int d2 = d.b.c.e.m.b.d(((w) obj).g(), 0);
                f.this.f56566g.a(d2);
                f.this.c(d2, true);
                f.this.f56564e.setHasLike(true);
                f.this.f56564e.setIsChanged(true);
                TiebaStatic.eventStat(f.this.f56564e.getPageContext().getPageActivity(), "notlogin_12", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f0.a {
        public b() {
        }

        @Override // d.b.i0.d3.f0.a
        public void a(String str, long j) {
            f.this.f56564e.showToast(R.string.error);
        }

        @Override // d.b.i0.d3.f0.a
        public void b(String str, long j) {
            int d2 = d.b.c.e.m.b.d(String.valueOf(j), 0);
            f.this.f56566g.b(d2);
            f.this.c(d2, false);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnDismissListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewUserGuideMainFragment.b f56570e;

        public c(f fVar, NewUserGuideMainFragment.b bVar) {
            this.f56570e = bVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f56570e.a();
        }
    }

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, NewUserGuideMainFragment.b bVar) {
        this.f56564e = newUserGuideActivity;
        this.f56565f = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.f56566g = new e(this.f56564e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.f56566g = new d.b.i0.h3.b(this.f56564e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.f56566g = new d(this.f56564e.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        LikeModel likeModel = new LikeModel(newUserGuideActivity.getPageContext());
        this.f56567h = likeModel;
        likeModel.setLoadDataCallBack(new a());
        f0 f0Var = new f0();
        this.i = f0Var;
        f0Var.b(new b());
        this.f56566g.d(this);
        this.f56566g.c(this.f56565f);
        ((Dialog) this.f56566g).setOnDismissListener(new c(this, bVar));
    }

    public void c(int i, boolean z) {
        for (int i2 = 0; i2 < this.f56565f.getCard_list().size(); i2++) {
            if (this.f56565f.getCard_list().get(i2).getFid() == i) {
                this.f56565f.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    public void d() {
        NewUserGuideActivity newUserGuideActivity = this.f56564e;
        if (newUserGuideActivity == null || g.e(newUserGuideActivity.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.f56566g.getRootView().setAnimation(scaleAnimation);
            this.f56566g.show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.f56566g.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.i.c(card.getFname(), card.getFid());
            } else {
                this.f56567h.I(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }
}
