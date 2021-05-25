package d.a.l0.h.o0.g.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter;
import com.baidu.swan.games.view.recommend.listmode.ListRecommendDivider;
import d.a.l0.a.g1.f;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class a extends d.a.l0.h.o0.g.b.a {
    public h n;
    public View o;
    public View p;
    public ImageView q;
    public View r;
    public RecyclerView s;
    public ListRecommendAdapter t;

    /* renamed from: d.a.l0.h.o0.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1044a implements View.OnClickListener {
        public View$OnClickListenerC1044a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f47590g != null) {
                a.this.f47590g.b();
            }
            a.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ListRecommendAdapter.a {
        public b() {
        }

        @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
        public void a(int i2) {
            if (a.this.f47590g != null) {
                a.this.f47590g.v(i2);
            }
            a.this.y();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f47589f != null && a.this.f47590g != null) {
                a.this.f47590g.p();
            }
            a.this.y();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.y();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) a.this.r.getLayoutParams();
            layoutParams.width = a.this.p.getWidth();
            int height = a.this.p.getHeight();
            layoutParams.height = height;
            layoutParams.topMargin = -height;
            a.this.r.setVisibility(0);
        }
    }

    public a(@NonNull Context context, @NonNull d.a.l0.h.o0.g.b.d dVar) {
        super(context, dVar);
    }

    public final void A(View view) {
        view.setOnClickListener(new View$OnClickListenerC1044a());
        this.t.e(new b());
        this.o.findViewById(d.a.l0.f.e.swangame_recommend_dialog_game_center).setOnClickListener(new c());
        this.q.setOnClickListener(new d());
    }

    public final void B() {
        C();
        h hVar = this.n;
        if (hVar != null) {
            hVar.show();
        }
    }

    public final void C() {
        boolean a2 = d.a.l0.a.c1.a.H().a();
        this.r.setVisibility(8);
        this.q.setImageResource(a2 ? d.a.l0.f.d.swangame_recommend_button_close_night : d.a.l0.f.d.swangame_recommend_button_close);
        if (a2) {
            this.p.post(new e());
        }
    }

    public final void D() {
        SwanAppActivity activity = f.V().getActivity();
        float min = Math.min(activity != null && activity.isLandScape() ? 2.5f : 5.0f, this.s.getAdapter().getItemCount());
        Resources resources = this.f47588e.getResources();
        float dimension = resources.getDimension(d.a.l0.f.c.swangame_recommend_dialog_list_divider_height);
        float dimension2 = resources.getDimension(d.a.l0.f.c.swangame_recommend_dialog_list_default_padding);
        float dimension3 = resources.getDimension(d.a.l0.f.c.swangame_recommend_dialog_width);
        Pair<Integer, Integer> y = f.V().y();
        this.s.getLayoutParams().width = (int) Math.min(dimension3, ((Integer) y.first).intValue());
        this.s.getLayoutParams().height = (int) Math.min((int) ((min * (resources.getDimension(d.a.l0.f.c.swangame_recommend_dialog_list_item_height) + dimension)) + dimension2), ((Integer) y.second).intValue() * 0.67f);
        this.s.requestLayout();
    }

    @Override // d.a.l0.h.o0.g.b.a, d.a.l0.h.o0.g.b.b
    public void d(d.a.l0.h.o0.g.e.a aVar) {
        super.d(aVar);
        this.t.f(aVar);
        D();
    }

    @Override // d.a.l0.h.o0.g.b.a
    @SuppressLint({"InflateParams"})
    public View i() {
        View i2 = super.i();
        View inflate = LayoutInflater.from(this.f47588e).inflate(d.a.l0.f.f.swangame_recommend_dialog, (ViewGroup) null);
        this.o = inflate;
        this.p = inflate.findViewById(d.a.l0.f.e.swangame_recommend_dialog_content);
        this.r = this.o.findViewById(d.a.l0.f.e.swangame_recommend_dialog_night_mask);
        this.q = (ImageView) this.o.findViewById(d.a.l0.f.e.swangame_recommend_dialog_cancel);
        z();
        RecyclerView recyclerView = (RecyclerView) this.o.findViewById(d.a.l0.f.e.swangame_recommend_dialog_list);
        this.s = recyclerView;
        recyclerView.setItemAnimator(null);
        this.s.setLayoutManager(new LinearLayoutManager(this.f47588e));
        this.s.addItemDecoration(new ListRecommendDivider(this.f47588e));
        ListRecommendAdapter listRecommendAdapter = new ListRecommendAdapter(this.f47588e);
        this.t = listRecommendAdapter;
        this.s.setAdapter(listRecommendAdapter);
        A(i2);
        return i2;
    }

    public final void y() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dismiss();
        }
    }

    public final void z() {
        h.a aVar = new h.a(this.f47588e);
        aVar.m(true);
        aVar.f(true);
        aVar.k(false);
        aVar.j();
        aVar.b();
        aVar.p(17170445);
        aVar.W(this.o);
        aVar.t(false);
        this.n = aVar.c();
        d.a.l0.a.v2.f.b(f.V().getActivity(), this.n);
    }
}
