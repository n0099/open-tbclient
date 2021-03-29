package d.b.g0.g.k0.i.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.b.g0.a.e;
import d.b.g0.a.h;
import d.b.g0.g.k0.i.b.d;
/* loaded from: classes3.dex */
public class a extends d.b.g0.g.k0.i.b.a {
    public int n;
    public d.b.g0.g.k0.i.c.b o;
    public d.b.g0.g.k0.i.c.b p;

    /* renamed from: d.b.g0.g.k0.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0976a implements View.OnClickListener {
        public View$OnClickListenerC0976a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48287g == null || a.this.n < -1) {
                return;
            }
            if (a.this.n == -1) {
                a.this.f48287g.c();
            } else {
                a.this.f48287g.s(a.this.n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            RecommendItemModel x = aVar.x(aVar.n);
            a.this.o.f48295b.setImageURI(x.iconUrl);
            a.this.o.f48296c.setText(x.appName);
            a.this.o.f48294a.setAlpha(1.0f);
            a aVar2 = a.this;
            RecommendItemModel x2 = a.this.x(aVar2.w(aVar2.n));
            a.this.p.f48295b.setImageURI(x2.iconUrl);
            a.this.p.f48296c.setText(x2.appName);
            a.this.p.f48294a.setAlpha(0.0f);
            a.super.k();
        }
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.n = -2;
    }

    @Override // d.b.g0.g.k0.i.b.a, d.b.g0.g.k0.i.b.b
    public void h(d.b.g0.g.k0.i.e.a aVar) {
        super.h(aVar);
        if (y(aVar)) {
            return;
        }
        this.n = -2;
        this.p.f48295b.setImageURI(aVar.f48302a.iconUrl);
        this.p.f48296c.setText(aVar.f48302a.appName);
    }

    @Override // d.b.g0.g.k0.i.b.a
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.f48285e);
        d.b.g0.g.k0.i.c.b bVar = new d.b.g0.g.k0.i.c.b(this.f48285e);
        this.p = bVar;
        bVar.f48294a.setAlpha(0.0f);
        frameLayout.addView(this.p.f48294a);
        d.b.g0.g.k0.i.c.b bVar2 = new d.b.g0.g.k0.i.c.b(this.f48285e);
        this.o = bVar2;
        bVar2.f48294a.setAlpha(0.0f);
        this.o.f48295b.setActualImageResource(17170445);
        this.o.f48296c.setText((CharSequence) null);
        frameLayout.addView(this.o.f48294a);
        this.o.f48294a.setOnClickListener(new View$OnClickListenerC0976a());
        return frameLayout;
    }

    @Override // d.b.g0.g.k0.i.b.a
    public void k() {
        if (y(this.f48286f)) {
            this.o.f48294a.setAlpha(1.0f);
            this.o.f48295b.setActualImageResource(e.swangame_recommend_gamecenter);
            this.o.f48296c.setText(h.swangame_recommend_button_goto_game_center);
            super.k();
            return;
        }
        this.n = w(this.n);
        this.p.f48294a.animate().setDuration(160L).alpha(1.0f);
        this.o.f48294a.animate().setDuration(160L).alpha(0.0f).setListener(new b());
    }

    public final int w(int i) {
        int i2 = i + 1;
        if (i2 == this.f48286f.f48303b.size()) {
            return -1;
        }
        return i2;
    }

    public final RecommendItemModel x(int i) {
        return i == -1 ? this.f48286f.f48302a : this.f48286f.f48303b.get(i);
    }

    public final boolean y(d.b.g0.g.k0.i.e.a aVar) {
        return aVar == null || aVar.f48303b == null || aVar.f48302a == null;
    }
}
