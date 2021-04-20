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
    public class View$OnClickListenerC0988a implements View.OnClickListener {
        public View$OnClickListenerC0988a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48679g == null || a.this.n < -1) {
                return;
            }
            if (a.this.n == -1) {
                a.this.f48679g.c();
            } else {
                a.this.f48679g.s(a.this.n);
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
            a.this.o.f48687b.setImageURI(x.iconUrl);
            a.this.o.f48688c.setText(x.appName);
            a.this.o.f48686a.setAlpha(1.0f);
            a aVar2 = a.this;
            RecommendItemModel x2 = a.this.x(aVar2.w(aVar2.n));
            a.this.p.f48687b.setImageURI(x2.iconUrl);
            a.this.p.f48688c.setText(x2.appName);
            a.this.p.f48686a.setAlpha(0.0f);
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
        this.p.f48687b.setImageURI(aVar.f48694a.iconUrl);
        this.p.f48688c.setText(aVar.f48694a.appName);
    }

    @Override // d.b.g0.g.k0.i.b.a
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.f48677e);
        d.b.g0.g.k0.i.c.b bVar = new d.b.g0.g.k0.i.c.b(this.f48677e);
        this.p = bVar;
        bVar.f48686a.setAlpha(0.0f);
        frameLayout.addView(this.p.f48686a);
        d.b.g0.g.k0.i.c.b bVar2 = new d.b.g0.g.k0.i.c.b(this.f48677e);
        this.o = bVar2;
        bVar2.f48686a.setAlpha(0.0f);
        this.o.f48687b.setActualImageResource(17170445);
        this.o.f48688c.setText((CharSequence) null);
        frameLayout.addView(this.o.f48686a);
        this.o.f48686a.setOnClickListener(new View$OnClickListenerC0988a());
        return frameLayout;
    }

    @Override // d.b.g0.g.k0.i.b.a
    public void k() {
        if (y(this.f48678f)) {
            this.o.f48686a.setAlpha(1.0f);
            this.o.f48687b.setActualImageResource(e.swangame_recommend_gamecenter);
            this.o.f48688c.setText(h.swangame_recommend_button_goto_game_center);
            super.k();
            return;
        }
        this.n = w(this.n);
        this.p.f48686a.animate().setDuration(160L).alpha(1.0f);
        this.o.f48686a.animate().setDuration(160L).alpha(0.0f).setListener(new b());
    }

    public final int w(int i) {
        int i2 = i + 1;
        if (i2 == this.f48678f.f48695b.size()) {
            return -1;
        }
        return i2;
    }

    public final RecommendItemModel x(int i) {
        return i == -1 ? this.f48678f.f48694a : this.f48678f.f48695b.get(i);
    }

    public final boolean y(d.b.g0.g.k0.i.e.a aVar) {
        return aVar == null || aVar.f48695b == null || aVar.f48694a == null;
    }
}
