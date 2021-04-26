package d.a.h0.g.k0.i.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.h0.a.e;
import d.a.h0.a.h;
import d.a.h0.g.k0.i.b.d;
/* loaded from: classes3.dex */
public class a extends d.a.h0.g.k0.i.b.a {
    public int n;
    public d.a.h0.g.k0.i.c.b o;
    public d.a.h0.g.k0.i.c.b p;

    /* renamed from: d.a.h0.g.k0.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0947a implements View.OnClickListener {
        public View$OnClickListenerC0947a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f46484g == null || a.this.n < -1) {
                return;
            }
            if (a.this.n == -1) {
                a.this.f46484g.q();
            } else {
                a.this.f46484g.w(a.this.n);
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
            RecommendItemModel y = aVar.y(aVar.n);
            a.this.o.f46493b.setImageURI(y.iconUrl);
            a.this.o.f46494c.setText(y.appName);
            a.this.o.f46492a.setAlpha(1.0f);
            a aVar2 = a.this;
            RecommendItemModel y2 = a.this.y(aVar2.x(aVar2.n));
            a.this.p.f46493b.setImageURI(y2.iconUrl);
            a.this.p.f46494c.setText(y2.appName);
            a.this.p.f46492a.setAlpha(0.0f);
            a.super.k();
        }
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.n = -2;
    }

    @Override // d.a.h0.g.k0.i.b.a, d.a.h0.g.k0.i.b.b
    public void e(d.a.h0.g.k0.i.e.a aVar) {
        super.e(aVar);
        if (z(aVar)) {
            return;
        }
        this.n = -2;
        this.p.f46493b.setImageURI(aVar.f46500a.iconUrl);
        this.p.f46494c.setText(aVar.f46500a.appName);
    }

    @Override // d.a.h0.g.k0.i.b.a
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.f46482e);
        d.a.h0.g.k0.i.c.b bVar = new d.a.h0.g.k0.i.c.b(this.f46482e);
        this.p = bVar;
        bVar.f46492a.setAlpha(0.0f);
        frameLayout.addView(this.p.f46492a);
        d.a.h0.g.k0.i.c.b bVar2 = new d.a.h0.g.k0.i.c.b(this.f46482e);
        this.o = bVar2;
        bVar2.f46492a.setAlpha(0.0f);
        this.o.f46493b.setActualImageResource(17170445);
        this.o.f46494c.setText((CharSequence) null);
        frameLayout.addView(this.o.f46492a);
        this.o.f46492a.setOnClickListener(new View$OnClickListenerC0947a());
        return frameLayout;
    }

    @Override // d.a.h0.g.k0.i.b.a
    public void k() {
        if (z(this.f46483f)) {
            this.o.f46492a.setAlpha(1.0f);
            this.o.f46493b.setActualImageResource(e.swangame_recommend_gamecenter);
            this.o.f46494c.setText(h.swangame_recommend_button_goto_game_center);
            super.k();
            return;
        }
        this.n = x(this.n);
        this.p.f46492a.animate().setDuration(160L).alpha(1.0f);
        this.o.f46492a.animate().setDuration(160L).alpha(0.0f).setListener(new b());
    }

    public final int x(int i2) {
        int i3 = i2 + 1;
        if (i3 == this.f46483f.f46501b.size()) {
            return -1;
        }
        return i3;
    }

    public final RecommendItemModel y(int i2) {
        return i2 == -1 ? this.f46483f.f46500a : this.f46483f.f46501b.get(i2);
    }

    public final boolean z(d.a.h0.g.k0.i.e.a aVar) {
        return aVar == null || aVar.f46501b == null || aVar.f46500a == null;
    }
}
