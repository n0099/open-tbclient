package d.b.g0.g.k0.i.d;

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
import d.b.g0.a.f;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class a extends d.b.g0.g.k0.i.b.a {
    public g n;
    public View o;
    public View p;
    public ImageView q;
    public View r;
    public RecyclerView s;
    public ListRecommendAdapter t;

    /* renamed from: d.b.g0.g.k0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0976a implements View.OnClickListener {
        public View$OnClickListenerC0976a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48286g != null) {
                a.this.f48286g.d();
            }
            a.this.B();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ListRecommendAdapter.a {
        public b() {
        }

        @Override // com.baidu.swan.games.view.recommend.listmode.ListRecommendAdapter.a
        public void a(int i) {
            if (a.this.f48286g != null) {
                a.this.f48286g.s(i);
            }
            a.this.x();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f48285f != null && a.this.f48286g != null) {
                a.this.f48286g.c();
            }
            a.this.x();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.x();
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

    public a(@NonNull Context context, @NonNull d.b.g0.g.k0.i.b.d dVar) {
        super(context, dVar);
    }

    public final void A(View view) {
        view.setOnClickListener(new View$OnClickListenerC0976a());
        this.t.e(new b());
        this.o.findViewById(f.swangame_recommend_dialog_game_center).setOnClickListener(new c());
        this.q.setOnClickListener(new d());
    }

    public final void B() {
        C();
        g gVar = this.n;
        if (gVar != null) {
            gVar.show();
        }
    }

    public final void C() {
        boolean a2 = d.b.g0.a.w0.a.z().a();
        this.r.setVisibility(8);
        this.q.setImageResource(a2 ? d.b.g0.a.e.swangame_recommend_button_close_night : d.b.g0.a.e.swangame_recommend_button_close);
        if (a2) {
            this.p.post(new e());
        }
    }

    public final void D() {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        float min = Math.min(activity != null && activity.isLandScape() ? 2.5f : 5.0f, this.s.getAdapter().getItemCount());
        Resources resources = this.f48284e.getResources();
        float dimension = resources.getDimension(d.b.g0.a.d.swangame_recommend_dialog_list_divider_height);
        float dimension2 = resources.getDimension(d.b.g0.a.d.swangame_recommend_dialog_list_default_padding);
        float dimension3 = resources.getDimension(d.b.g0.a.d.swangame_recommend_dialog_width);
        Pair<Integer, Integer> c2 = d.b.g0.a.z0.f.V().c();
        this.s.getLayoutParams().width = (int) Math.min(dimension3, ((Integer) c2.first).intValue());
        this.s.getLayoutParams().height = (int) Math.min((int) ((min * (resources.getDimension(d.b.g0.a.d.swangame_recommend_dialog_list_item_height) + dimension)) + dimension2), ((Integer) c2.second).intValue() * 0.67f);
        this.s.requestLayout();
    }

    @Override // d.b.g0.g.k0.i.b.a, d.b.g0.g.k0.i.b.b
    public void h(d.b.g0.g.k0.i.e.a aVar) {
        super.h(aVar);
        this.t.f(aVar);
        D();
    }

    @Override // d.b.g0.g.k0.i.b.a
    public View i() {
        View i = super.i();
        View inflate = LayoutInflater.from(this.f48284e).inflate(d.b.g0.a.g.swangame_recommend_dialog, (ViewGroup) null);
        this.o = inflate;
        this.p = inflate.findViewById(f.swangame_recommend_dialog_content);
        this.r = this.o.findViewById(f.swangame_recommend_dialog_night_mask);
        this.q = (ImageView) this.o.findViewById(f.swangame_recommend_dialog_cancel);
        y();
        RecyclerView recyclerView = (RecyclerView) this.o.findViewById(f.swangame_recommend_dialog_list);
        this.s = recyclerView;
        recyclerView.setItemAnimator(null);
        this.s.setLayoutManager(new LinearLayoutManager(this.f48284e));
        this.s.addItemDecoration(new ListRecommendDivider(this.f48284e));
        ListRecommendAdapter listRecommendAdapter = new ListRecommendAdapter(this.f48284e);
        this.t = listRecommendAdapter;
        this.s.setAdapter(listRecommendAdapter);
        A(i);
        return i;
    }

    public final void x() {
        g gVar = this.n;
        if (gVar != null) {
            gVar.dismiss();
        }
    }

    public final void y() {
        g.a aVar = new g.a(this.f48284e);
        aVar.m(true);
        aVar.f(true);
        aVar.k(false);
        aVar.j();
        aVar.b();
        aVar.p(17170445);
        aVar.W(this.o);
        aVar.u(false);
        this.n = aVar.c();
        d.b.g0.a.i2.e.b(d.b.g0.a.z0.f.V().getActivity(), this.n);
    }
}
