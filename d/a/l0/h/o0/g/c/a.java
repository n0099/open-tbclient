package d.a.l0.h.o0.g.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.a.l0.f.g;
import d.a.l0.h.o0.g.b.d;
/* loaded from: classes3.dex */
public class a extends d.a.l0.h.o0.g.b.a {
    public int n;
    public d.a.l0.h.o0.g.c.b o;
    public d.a.l0.h.o0.g.c.b p;

    /* renamed from: d.a.l0.h.o0.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1043a implements View.OnClickListener {
        public View$OnClickListenerC1043a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f47590g == null || a.this.n < -1) {
                return;
            }
            if (a.this.n == -1) {
                a.this.f47590g.p();
            } else {
                a.this.f47590g.v(a.this.n);
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
            a.this.o.f47599b.setImageURI(y.iconUrl);
            a.this.o.f47600c.setText(y.appName);
            a.this.o.f47598a.setAlpha(1.0f);
            a aVar2 = a.this;
            RecommendItemModel y2 = a.this.y(aVar2.x(aVar2.n));
            a.this.p.f47599b.setImageURI(y2.iconUrl);
            a.this.p.f47600c.setText(y2.appName);
            a.this.p.f47598a.setAlpha(0.0f);
            a.super.k();
        }
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.n = -2;
    }

    @Override // d.a.l0.h.o0.g.b.a, d.a.l0.h.o0.g.b.b
    public void d(d.a.l0.h.o0.g.e.a aVar) {
        super.d(aVar);
        if (z(aVar)) {
            return;
        }
        this.n = -2;
        this.p.f47599b.setImageURI(aVar.f47606a.iconUrl);
        this.p.f47600c.setText(aVar.f47606a.appName);
    }

    @Override // d.a.l0.h.o0.g.b.a
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.f47588e);
        d.a.l0.h.o0.g.c.b bVar = new d.a.l0.h.o0.g.c.b(this.f47588e);
        this.p = bVar;
        bVar.f47598a.setAlpha(0.0f);
        frameLayout.addView(this.p.f47598a);
        d.a.l0.h.o0.g.c.b bVar2 = new d.a.l0.h.o0.g.c.b(this.f47588e);
        this.o = bVar2;
        bVar2.f47598a.setAlpha(0.0f);
        this.o.f47599b.setActualImageResource(17170445);
        this.o.f47600c.setText((CharSequence) null);
        frameLayout.addView(this.o.f47598a);
        this.o.f47598a.setOnClickListener(new View$OnClickListenerC1043a());
        return frameLayout;
    }

    @Override // d.a.l0.h.o0.g.b.a
    public void k() {
        if (z(this.f47589f)) {
            this.o.f47598a.setAlpha(1.0f);
            this.o.f47599b.setActualImageResource(d.a.l0.f.d.swangame_recommend_gamecenter);
            this.o.f47600c.setText(g.swangame_recommend_button_goto_game_center);
            super.k();
            return;
        }
        this.n = x(this.n);
        this.p.f47598a.animate().setDuration(160L).alpha(1.0f);
        this.o.f47598a.animate().setDuration(160L).alpha(0.0f).setListener(new b());
    }

    public final int x(int i2) {
        int i3 = i2 + 1;
        if (i3 == this.f47589f.f47607b.size()) {
            return -1;
        }
        return i3;
    }

    public final RecommendItemModel y(int i2) {
        return i2 == -1 ? this.f47589f.f47606a : this.f47589f.f47607b.get(i2);
    }

    public final boolean z(d.a.l0.h.o0.g.e.a aVar) {
        return aVar == null || aVar.f47607b == null || aVar.f47606a == null;
    }
}
