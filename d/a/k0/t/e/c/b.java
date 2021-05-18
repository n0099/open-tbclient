package d.a.k0.t.e.c;

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
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61585a;

    /* renamed from: b  reason: collision with root package name */
    public int f61586b = -1;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.t.e.c.d f61587c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61588d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61589e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f61590f;

    /* renamed from: g  reason: collision with root package name */
    public View f61591g;

    /* renamed from: h  reason: collision with root package name */
    public View f61592h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f61593i;
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
    public d.a.k0.t.e.a.g y;
    public d.a.k0.q0.x1.b z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m();
        }
    }

    /* renamed from: d.a.k0.t.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1638b implements View.OnTouchListener {
        public View$OnTouchListenerC1638b() {
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
        public final /* synthetic */ BdListView.p f61599e;

        public f(b bVar, BdListView.p pVar) {
            this.f61599e = pVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdListView.p pVar = this.f61599e;
            if (pVar != null) {
                pVar.onScrollToBottom();
            }
        }
    }

    public b(TbPageContext tbPageContext, boolean z, boolean z2, BdUniqueId bdUniqueId) {
        this.f61585a = tbPageContext;
        this.f61588d = z;
        this.f61589e = z2;
        this.f61590f = bdUniqueId;
    }

    public void e() {
        this.k.z();
    }

    public BdTypeListView f() {
        return this.k;
    }

    public View g() {
        return this.f61591g;
    }

    public final void h() {
    }

    public final void i() {
        if (this.m == null) {
            View inflate = LayoutInflater.from(this.f61585a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.m = inflate;
            this.n = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
            this.o = (TextView) this.m.findViewById(R.id.frs_game_live_new);
            this.p = this.m.findViewById(R.id.frs_game_live_sort_sepline);
            this.n.setOnClickListener(new c());
            this.o.setOnClickListener(new d());
        }
        if (this.l == null) {
            PopupWindow popupWindow = new PopupWindow(this.f61585a.getPageActivity());
            this.l = popupWindow;
            popupWindow.setContentView(this.m);
            this.l.setWidth(-2);
            this.l.setHeight(-2);
            this.l.setAnimationStyle(16973826);
            this.l.setBackgroundDrawable(this.f61585a.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.l.setOutsideTouchable(true);
            this.l.setFocusable(true);
            this.l.setTouchable(true);
            this.l.setOnDismissListener(new e());
        }
    }

    public void j() {
        View inflate = LayoutInflater.from(this.f61585a.getPageActivity()).inflate(R.layout.ala_frs_game_live_list, (ViewGroup) null);
        this.f61591g = inflate;
        this.f61592h = inflate.findViewById(R.id.frs_game_live_topinfo);
        this.f61593i = (TextView) this.f61591g.findViewById(R.id.frs_game_live_num);
        this.j = (TextView) this.f61591g.findViewById(R.id.frs_game_live_sort);
        this.k = (BdTypeListView) this.f61591g.findViewById(R.id.listView);
        this.s = (NoNetworkView) this.f61591g.findViewById(R.id.vNoNetwork);
        g gVar = new g(this.f61585a);
        this.q = gVar;
        gVar.Z(this.f61590f);
        this.k.setPullRefresh(this.q);
        PbListView pbListView = new PbListView(this.f61585a.getPageActivity());
        this.r = pbListView;
        pbListView.a();
        this.y = new d.a.k0.t.e.a.g(this.f61585a, this.k, this.f61588d);
        this.j.setOnClickListener(new a());
        if (this.f61589e) {
            this.z = new d.a.k0.q0.x1.b(this.f61585a.getPageActivity(), this.f61590f, this.f61589e);
            this.k.setOnTouchListener(new View$OnTouchListenerC1638b());
        }
    }

    public final void k() {
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.w, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
    }

    public void l(int i2) {
        if (this.f61586b != i2) {
            this.f61586b = i2;
        }
        k();
        SkinManager.setViewTextColor(this.f61593i, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0109);
        this.j.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    public final void m() {
        y();
    }

    public final void n(int i2) {
        p(i2);
        d.a.c.e.m.g.d(this.l, this.f61585a.getPageActivity());
        d.a.k0.t.e.c.d dVar = this.f61587c;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void o(int i2) {
        if (this.f61593i != null) {
            this.f61593i.setText(this.f61585a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i2)));
            if (i2 <= 1) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
        }
    }

    public void p(int i2) {
        TextView textView;
        if (i2 == 1) {
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(this.f61585a.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i2 != 2 || (textView = this.j) == null) {
        } else {
            textView.setText(this.f61585a.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void q(d.a.k0.t.c cVar) {
        this.y.b(cVar);
    }

    public void r(d.a.k0.t.e.c.d dVar) {
        this.f61587c = dVar;
    }

    public void s(f.g gVar) {
        this.q.a(gVar);
    }

    public void t(List<n> list, boolean z, boolean z2) {
        if (list == null || ListUtils.isEmpty(list)) {
            return;
        }
        if (z) {
            this.f61592h.setVisibility(0);
        } else {
            this.f61592h.setVisibility(8);
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
            this.r.A(this.f61585a.getResources().getString(R.string.load_more));
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
            this.r.A(this.f61585a.getResources().getString(R.string.list_no_more));
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
            d.a.c.e.m.g.d(this.l, this.f61585a.getPageActivity());
            return;
        }
        d.a.c.e.m.g.m(this.l, this.f61591g, 0, (iArr[0] - (this.j.getWidth() / 2)) - this.f61585a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.j.getHeight() + height);
        this.l.update();
    }
}
