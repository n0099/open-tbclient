package d.b.i0.t.d.g.d;

import android.graphics.drawable.Drawable;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.b.c.e.i.a;
import d.b.c.j.e.n;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62201a;

    /* renamed from: c  reason: collision with root package name */
    public g f62203c;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f62205e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f62206f;

    /* renamed from: g  reason: collision with root package name */
    public View f62207g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f62208h;
    public d.b.h0.r.f0.g i;
    public NavigationBar j;
    public LinearLayout k;
    public d.b.h0.d0.g l;
    public PbListView m;
    public h n;
    public d.b.i0.t.d.g.a.a p;
    public d.b.i0.t.d.g.a.b q;
    public b r;

    /* renamed from: b  reason: collision with root package name */
    public int f62202b = -1;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f62204d = BdUniqueId.gen();
    public final List<d.b.c.j.e.a> o = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f62201a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f62210e;

        /* renamed from: f  reason: collision with root package name */
        public View f62211f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62212g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f62213h;
        public LinearLayout i;
        public List<String> j;
        public String l;
        public boolean k = false;
        public a.c m = new a();

        /* loaded from: classes4.dex */
        public class a implements a.c {
            public a() {
            }

            @Override // d.b.c.e.i.a.c
            public void onLocationGeted(int i, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude == 0.0d || longitude == 0.0d) {
                        return;
                    }
                    d.b.i0.t.d.g.b.c cVar = new d.b.i0.t.d.g.b.c();
                    cVar.f62174a = b.this.l;
                    cVar.f62175b = String.valueOf(latitude);
                    cVar.f62176c = String.valueOf(longitude);
                    cVar.f62177d = true;
                    c.this.f62203c.b(cVar);
                    b.this.f62213h.setText(b.this.l);
                } else if (StringUtils.isNull(str)) {
                } else {
                    c.this.f62201a.showToast(str);
                }
            }
        }

        public b(View view) {
            this.f62211f = view;
            this.f62212g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f62211f.findViewById(R.id.live_sort);
            this.f62213h = textView;
            textView.setVisibility(8);
            this.f62213h.setOnClickListener(this);
            f();
        }

        public void c(List<String> list) {
            this.j = list;
            if (ListUtils.isEmpty(list) || this.k) {
                return;
            }
            this.k = true;
            String str = this.j.get(0);
            if (!StringUtils.isNull(str)) {
                this.f62213h.setText(str);
                this.f62213h.setVisibility(0);
            }
            this.i = new LinearLayout(c.this.f62201a.getPageActivity());
            this.i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            SkinManager.setBackgroundResource(this.i, R.drawable.bg_ala_sub_list_sort_panel);
            this.i.setClipChildren(true);
            this.i.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.f62201a.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.f62201a.getResources().getDimensionPixelOffset(R.dimen.ds88));
            for (int i = 0; i < this.j.size(); i++) {
                this.i.addView(e(this.j.get(i)), layoutParams);
                if (i != this.j.size() - 1) {
                    View view = new View(c.this.f62201a.getPageActivity());
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.f62201a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                    SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                    this.i.addView(view);
                }
            }
            if (this.f62210e == null) {
                PopupWindow popupWindow = new PopupWindow(c.this.f62201a.getPageActivity());
                this.f62210e = popupWindow;
                popupWindow.setContentView(this.i);
                this.f62210e.setWidth(-2);
                this.f62210e.setHeight(-2);
                this.f62210e.setAnimationStyle(16973826);
                this.f62210e.setBackgroundDrawable(c.this.f62201a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.f62210e.setOutsideTouchable(true);
                this.f62210e.setFocusable(true);
                this.f62210e.setTouchable(true);
            }
        }

        public final boolean d() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.f62201a.getPageActivity());
        }

        public final TextView e(String str) {
            TextView textView = new TextView(c.this.f62201a.getPageActivity());
            textView.setTextSize(0, c.this.f62201a.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        public void f() {
            SkinManager.setViewTextColor(this.f62212g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f62213h, R.color.CAM_X0109);
            this.f62213h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        public void g(int i) {
            this.f62211f.setVisibility(i);
        }

        public final void h() {
            if (this.f62210e != null) {
                int[] iArr = new int[2];
                this.f62213h.getLocationOnScreen(iArr);
                int height = ((View) this.f62213h.getParent()).getHeight() - this.f62213h.getHeight();
                if (iArr[1] - this.f62210e.getHeight() <= 50) {
                    d.b.c.e.m.g.d(this.f62210e, c.this.f62201a.getPageActivity());
                    return;
                }
                d.b.c.e.m.g.m(this.f62210e, c.this.f62205e, 0, (iArr[0] - (this.f62213h.getWidth() / 2)) - c.this.f62201a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f62213h.getHeight() + height);
                PopupWindow popupWindow = this.f62210e;
                if (popupWindow != null) {
                    popupWindow.update();
                }
            }
        }

        public void i(int i) {
            if (this.f62212g != null) {
                this.f62212g.setText(c.this.f62201a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i)));
                this.f62211f.setVisibility(0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f62213h) {
                h();
            } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
            } else {
                PopupWindow popupWindow = this.f62210e;
                if (popupWindow != null) {
                    d.b.c.e.m.g.d(popupWindow, c.this.f62201a.getPageActivity());
                }
                if (c.this.f62203c != null) {
                    String str = (String) view.getTag();
                    this.l = str;
                    if (str.contains("距离")) {
                        if (!d()) {
                            c.this.f62201a.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            d.b.c.e.i.a.l().i(false, this.m);
                            return;
                        }
                    }
                    d.b.i0.t.d.g.b.c cVar = new d.b.i0.t.d.g.b.c();
                    cVar.f62174a = this.l;
                    cVar.f62177d = false;
                    c.this.f62203c.b(cVar);
                    this.f62213h.setText(this.l);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f62201a = tbPageContext;
        this.f62205e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f62201a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f62206f = (LinearLayout) this.f62205e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f62205e.findViewById(R.id.sub_list_top_info);
        this.f62207g = findViewById;
        b bVar = new b(findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f62208h = (BdTypeListView) this.f62205e.findViewById(R.id.listView);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f62201a);
        this.i = gVar;
        gVar.Z(this.f62204d);
        this.f62208h.setPullRefresh(this.i);
        PbListView pbListView = new PbListView(this.f62201a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        d.b.i0.t.d.g.a.a aVar = new d.b.i0.t.d.g.a.a(this.f62201a);
        this.p = aVar;
        aVar.l0(2);
        d.b.i0.t.d.g.a.b bVar2 = new d.b.i0.t.d.g.a.b(this.f62201a);
        this.q = bVar2;
        bVar2.l0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f62208h.a(this.o);
    }

    public void d() {
        this.f62208h.z();
    }

    public BdTypeListView e() {
        return this.f62208h;
    }

    public View f() {
        return this.f62205e;
    }

    public void g() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this.f62205e);
            this.l = null;
        }
    }

    public void h() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this.f62205e);
            this.n = null;
        }
    }

    public void i() {
        PbListView pbListView = this.m;
        if (pbListView == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f62208h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i) {
        if (this.f62202b != i) {
            this.f62202b = i;
        }
        b bVar = this.r;
        if (bVar != null) {
            bVar.f();
        }
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        NavigationBar navigationBar = this.j;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(tbPageContext, i);
        }
        PbListView pbListView = this.m;
        if (pbListView != null) {
            pbListView.d(i);
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f62205e, R.color.CAM_X0201);
    }

    public void k() {
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            if (gVar.i() != null) {
                this.l.dettachView(this.f62205e);
            }
            this.l.m();
            this.l = null;
        }
        d.b.h0.r.f0.g gVar2 = this.i;
        if (gVar2 != null) {
            gVar2.b(null);
            this.i.c(null);
            this.i.g(null);
            this.i.X();
            this.i = null;
        }
        BdTypeListView bdTypeListView = this.f62208h;
        if (bdTypeListView != null) {
            bdTypeListView.setOnSrollToBottomListener(null);
            this.f62208h.setOnScrollListener(null);
            this.f62208h.setRecyclerListener(null);
            this.f62208h = null;
        }
    }

    public void l(int i) {
        b bVar = this.r;
        if (bVar != null) {
            bVar.i(i);
        }
    }

    public void m(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.r.c(list);
    }

    public void n(g gVar) {
        this.f62203c = gVar;
        d.b.i0.t.d.g.a.a aVar = this.p;
        if (aVar != null) {
            aVar.n0(gVar);
        }
        d.b.i0.t.d.g.a.b bVar = this.q;
        if (bVar != null) {
            bVar.n0(this.f62203c);
        }
    }

    public void o(int i) {
        this.f62206f.setVisibility(i);
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        if (list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f62208h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        this.i.b(gVar);
    }

    public void r(BdListView.p pVar) {
        this.f62208h.setOnSrollToBottomListener(pVar);
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        if (z) {
            NavigationBar navigationBar = new NavigationBar(this.f62201a.getPageActivity());
            this.j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a());
            if (!StringUtils.isNull(str2)) {
                this.j.setCenterTextTitle(str2);
            } else if (!StringUtils.isNull(str)) {
                this.j.setCenterTextTitle(str);
            }
            this.f62205e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
        }
        if (!ListUtils.isEmpty(list)) {
            this.r.c(list);
        }
        this.p.o0(z3);
        this.q.o0(z3);
    }

    public void t() {
        TbPageContext tbPageContext = this.f62201a;
        if (tbPageContext == null || this.f62205e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.b.h0.d0.g(tbPageContext.getPageActivity(), this.f62201a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        d.b.h0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f62205e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.n == null) {
            this.n = new h(this.f62201a.getPageActivity(), onClickListener);
        }
        this.n.j(this.f62201a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
        this.n.l(str);
        this.n.attachView(this.f62205e, false);
        if (z) {
            this.n.o();
        } else {
            this.n.e();
        }
    }

    public void v() {
        PbListView pbListView = this.m;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.f62208h.setNextPage(this.m);
            }
            this.m.A(this.f62201a.getResources().getString(R.string.list_no_more));
            this.m.f();
        }
    }
}
