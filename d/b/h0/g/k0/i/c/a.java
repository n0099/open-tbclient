package d.b.h0.g.k0.i.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import d.b.h0.a.e;
import d.b.h0.a.h;
import d.b.h0.g.k0.i.b.d;
/* loaded from: classes3.dex */
public class a extends d.b.h0.g.k0.i.b.a {
    public int n;
    public d.b.h0.g.k0.i.c.b o;
    public d.b.h0.g.k0.i.c.b p;

    /* renamed from: d.b.h0.g.k0.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1008a implements View.OnClickListener {
        public View$OnClickListenerC1008a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f49008g == null || a.this.n < -1) {
                return;
            }
            if (a.this.n == -1) {
                a.this.f49008g.c();
            } else {
                a.this.f49008g.s(a.this.n);
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
            a.this.o.f49016b.setImageURI(x.iconUrl);
            a.this.o.f49017c.setText(x.appName);
            a.this.o.f49015a.setAlpha(1.0f);
            a aVar2 = a.this;
            RecommendItemModel x2 = a.this.x(aVar2.w(aVar2.n));
            a.this.p.f49016b.setImageURI(x2.iconUrl);
            a.this.p.f49017c.setText(x2.appName);
            a.this.p.f49015a.setAlpha(0.0f);
            a.super.k();
        }
    }

    public a(@NonNull Context context, @NonNull d dVar) {
        super(context, dVar);
        this.n = -2;
    }

    @Override // d.b.h0.g.k0.i.b.a, d.b.h0.g.k0.i.b.b
    public void h(d.b.h0.g.k0.i.e.a aVar) {
        super.h(aVar);
        if (y(aVar)) {
            return;
        }
        this.n = -2;
        this.p.f49016b.setImageURI(aVar.f49023a.iconUrl);
        this.p.f49017c.setText(aVar.f49023a.appName);
    }

    @Override // d.b.h0.g.k0.i.b.a
    public View i() {
        FrameLayout frameLayout = new FrameLayout(this.f49006e);
        d.b.h0.g.k0.i.c.b bVar = new d.b.h0.g.k0.i.c.b(this.f49006e);
        this.p = bVar;
        bVar.f49015a.setAlpha(0.0f);
        frameLayout.addView(this.p.f49015a);
        d.b.h0.g.k0.i.c.b bVar2 = new d.b.h0.g.k0.i.c.b(this.f49006e);
        this.o = bVar2;
        bVar2.f49015a.setAlpha(0.0f);
        this.o.f49016b.setActualImageResource(17170445);
        this.o.f49017c.setText((CharSequence) null);
        frameLayout.addView(this.o.f49015a);
        this.o.f49015a.setOnClickListener(new View$OnClickListenerC1008a());
        return frameLayout;
    }

    @Override // d.b.h0.g.k0.i.b.a
    public void k() {
        if (y(this.f49007f)) {
            this.o.f49015a.setAlpha(1.0f);
            this.o.f49016b.setActualImageResource(e.swangame_recommend_gamecenter);
            this.o.f49017c.setText(h.swangame_recommend_button_goto_game_center);
            super.k();
            return;
        }
        this.n = w(this.n);
        this.p.f49015a.animate().setDuration(160L).alpha(1.0f);
        this.o.f49015a.animate().setDuration(160L).alpha(0.0f).setListener(new b());
    }

    public final int w(int i) {
        int i2 = i + 1;
        if (i2 == this.f49007f.f49024b.size()) {
            return -1;
        }
        return i2;
    }

    public final RecommendItemModel x(int i) {
        return i == -1 ? this.f49007f.f49023a : this.f49007f.f49024b.get(i);
    }

    public final boolean y(d.b.h0.g.k0.i.e.a aVar) {
        return aVar == null || aVar.f49024b == null || aVar.f49023a == null;
    }
}
