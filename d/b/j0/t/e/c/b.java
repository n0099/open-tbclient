package d.b.j0.t.e.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.c.j.e.n;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62673a;

    /* renamed from: b  reason: collision with root package name */
    public int f62674b = -1;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.t.e.c.d f62675c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f62676d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f62677e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f62678f;

    /* renamed from: g  reason: collision with root package name */
    public View f62679g;

    /* renamed from: h  reason: collision with root package name */
    public View f62680h;
    public TextView i;
    public TextView j;
    public BdTypeListView k;
    public PopupWindow l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public g q;
    public PbListView r;
    public NoNetworkView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View w;
    public View x;
    public d.b.j0.t.e.a.g y;
    public d.b.j0.q0.x1.b z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m();
        }
    }

    /* renamed from: d.b.j0.t.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1633b implements View.OnTouchListener {
        public View$OnTouchListenerC1633b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b.this.z.b(view, motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.n(1);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.n(2);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PopupWindow.OnDismissListener {
        public e() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            b.this.h();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdListView.p f62686e;

        public f(b bVar, BdListView.p pVar) {
            this.f62686e = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdListView.p pVar = this.f62686e;
            if (pVar != null) {
                pVar.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.f62673a = tbPageContext;
        this.f62676d = z;
        this.f62677e = z2;
        this.f62678f = bdUniqueId;
    }

    public void e() {
        this.k.z();
    }

    public BdTypeListView f() {
        return this.k;
    }

    public View g() {
        return this.f62679g;
    }

    public final void h() {
    }

    public final void i() {
        if (this.m == null) {
            View inflate = LayoutInflater.from(this.f62673a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.m = inflate;
            this.n = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
            this.o = (TextView) this.m.findViewById(R.id.frs_game_live_new);
            this.p = this.m.findViewById(R.id.frs_game_live_sort_sepline);
            this.n.setOnClickListener(new c());
            this.o.setOnClickListener(new d());
        }
        if (this.l == null) {
            PopupWindow popupWindow = new PopupWindow(this.f62673a.getPageActivity());
            this.l = popupWindow;
            popupWindow.setContentView(this.m);
            this.l.setWidth(-2);
            this.l.setHeight(-2);
            this.l.setAnimationStyle(16973826);
            this.l.setBackgroundDrawable(this.f62673a.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.l.setOutsideTouchable(true);
            this.l.setFocusable(true);
            this.l.setTouchable(true);
            this.l.setOnDismissListener(new e());
        }
    }

    public void j() {
        View inflate = LayoutInflater.from(this.f62673a.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.f62679g = inflate;
        this.f62680h = inflate.findViewById(R.id.frs_game_live_topinfo);
        this.i = (TextView) this.f62679g.findViewById(R.id.frs_game_live_num);
        this.j = (TextView) this.f62679g.findViewById(R.id.frs_game_live_sort);
        this.k = (BdTypeListView) this.f62679g.findViewById(R.id.listView);
        this.s = (NoNetworkView) this.f62679g.findViewById(R.id.vNoNetwork);
        g gVar = new g(this.f62673a);
        this.q = gVar;
        gVar.Z(this.f62678f);
        this.k.setPullRefresh(this.q);
        PbListView pbListView = new PbListView(this.f62673a.getPageActivity());
        this.r = pbListView;
        pbListView.a();
        this.y = new d.b.j0.t.e.a.g(this.f62673a, this.k, this.f62676d);
        this.j.setOnClickListener(new a());
        if (this.f62677e) {
            this.z = new d.b.j0.q0.x1.b(this.f62673a.getPageActivity(), this.f62678f, this.f62677e);
            this.k.setOnTouchListener(new View$OnTouchListenerC1633b());
        }
    }

    public final void k() {
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
    }

    public void l(int i) {
        if (this.f62674b != i) {
            this.f62674b = i;
        }
        k();
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    public final void m() {
        y();
    }

    public final void n(int i) {
        p(i);
        d.b.c.e.m.g.d(this.l, this.f62673a.getPageActivity());
        d.b.j0.t.e.c.d dVar = this.f62675c;
        if (dVar != null) {
            dVar.a(i);
        }
    }

    public void o(int i) {
        if (this.i != null) {
            this.i.setText(this.f62673a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
        }
    }

    public void p(int i) {
        TextView textView;
        if (i == 1) {
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(this.f62673a.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i != 2 || (textView = this.j) == null) {
        } else {
            textView.setText(this.f62673a.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void q(d.b.j0.t.c cVar) {
        this.y.b(cVar);
    }

    public void r(d.b.j0.t.e.c.d dVar) {
        this.f62675c = dVar;
    }

    public void s(f.g gVar) {
        this.q.b(gVar);
    }

    public void t(List<n> list, boolean z, boolean z2) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            this.f62680h.setVisibility(0);
        } else {
            this.f62680h.setVisibility(8);
        }
        this.y.c(list);
        if (z2) {
            v();
        } else {
            x();
        }
    }

    public void u(BdListView.p pVar) {
        this.k.setOnSrollToBottomListener(pVar);
        this.r.z(new f(this, pVar));
    }

    public void v() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.A(this.f62673a.getResources().getString(R.string.load_more));
            this.r.f();
        }
    }

    public void w() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.M();
            this.r.O();
        }
    }

    public void x() {
        PbListView pbListView = this.r;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.k.setNextPage(this.r);
            }
            this.r.A(this.f62673a.getResources().getString(R.string.list_no_more));
            this.r.f();
        }
    }

    public final void y() {
        i();
        SkinManager.setBackgroundResource(this.m, R.drawable.bg_ala_frs_game_live_sort_panel);
        SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
        SkinManager.setBackgroundResource(this.o, R.drawable.ala_frs_game_live_sort_selecor);
        SkinManager.setBackgroundResource(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.j.getLocationOnScreen(iArr);
        int height = ((View) this.j.getParent()).getHeight() - this.j.getHeight();
        if (iArr[1] - this.l.getHeight() <= 50) {
            d.b.c.e.m.g.d(this.l, this.f62673a.getPageActivity());
            return;
        }
        d.b.c.e.m.g.m(this.l, this.f62679g, 0, (iArr[0] - (this.j.getWidth() / 2)) - this.f62673a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.j.getHeight() + height);
        this.l.update();
    }
}
