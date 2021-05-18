package d.a.k0.t.d.g.d;

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
import d.a.c.e.i.a;
import d.a.c.j.e.n;
import d.a.j0.d0.h;
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61530a;

    /* renamed from: c  reason: collision with root package name */
    public f f61532c;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f61534e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61535f;

    /* renamed from: g  reason: collision with root package name */
    public View f61536g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f61537h;

    /* renamed from: i  reason: collision with root package name */
    public g f61538i;
    public NavigationBar j;
    public LinearLayout k;
    public d.a.j0.d0.g l;
    public PbListView m;
    public h n;
    public d.a.k0.t.d.g.a.a p;
    public d.a.k0.t.d.g.a.b q;
    public b r;

    /* renamed from: b  reason: collision with root package name */
    public int f61531b = -1;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61533d = BdUniqueId.gen();
    public final List<d.a.c.j.e.a> o = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f61530a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f61540e;

        /* renamed from: f  reason: collision with root package name */
        public View f61541f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61542g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f61543h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f61544i;
        public List<String> j;
        public String l;
        public boolean k = false;
        public a.c m = new a();

        /* loaded from: classes4.dex */
        public class a implements a.c {
            public a() {
            }

            @Override // d.a.c.e.i.a.c
            public void onLocationGeted(int i2, String str, Address address) {
                if (address != null) {
                    double latitude = address.getLatitude();
                    double longitude = address.getLongitude();
                    if (latitude == 0.0d || longitude == 0.0d) {
                        return;
                    }
                    d.a.k0.t.d.g.b.c cVar = new d.a.k0.t.d.g.b.c();
                    cVar.f61501a = b.this.l;
                    cVar.f61502b = String.valueOf(latitude);
                    cVar.f61503c = String.valueOf(longitude);
                    cVar.f61504d = true;
                    c.this.f61532c.b(cVar);
                    b.this.f61543h.setText(b.this.l);
                } else if (StringUtils.isNull(str)) {
                } else {
                    c.this.f61530a.showToast(str);
                }
            }
        }

        public b(View view) {
            this.f61541f = view;
            this.f61542g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f61541f.findViewById(R.id.live_sort);
            this.f61543h = textView;
            textView.setVisibility(8);
            this.f61543h.setOnClickListener(this);
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
                this.f61543h.setText(str);
                this.f61543h.setVisibility(0);
            }
            this.f61544i = new LinearLayout(c.this.f61530a.getPageActivity());
            this.f61544i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            SkinManager.setBackgroundResource(this.f61544i, R.drawable.bg_ala_sub_list_sort_panel);
            this.f61544i.setClipChildren(true);
            this.f61544i.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.f61530a.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.f61530a.getResources().getDimensionPixelOffset(R.dimen.ds88));
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.f61544i.addView(e(this.j.get(i2)), layoutParams);
                if (i2 != this.j.size() - 1) {
                    View view = new View(c.this.f61530a.getPageActivity());
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.f61530a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                    SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                    this.f61544i.addView(view);
                }
            }
            if (this.f61540e == null) {
                PopupWindow popupWindow = new PopupWindow(c.this.f61530a.getPageActivity());
                this.f61540e = popupWindow;
                popupWindow.setContentView(this.f61544i);
                this.f61540e.setWidth(-2);
                this.f61540e.setHeight(-2);
                this.f61540e.setAnimationStyle(16973826);
                this.f61540e.setBackgroundDrawable(c.this.f61530a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.f61540e.setOutsideTouchable(true);
                this.f61540e.setFocusable(true);
                this.f61540e.setTouchable(true);
            }
        }

        public final boolean d() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.f61530a.getPageActivity());
        }

        public final TextView e(String str) {
            TextView textView = new TextView(c.this.f61530a.getPageActivity());
            textView.setTextSize(0, c.this.f61530a.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        public void f() {
            SkinManager.setViewTextColor(this.f61542g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f61543h, R.color.CAM_X0109);
            this.f61543h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        public void g(int i2) {
            this.f61541f.setVisibility(i2);
        }

        public final void h() {
            if (this.f61540e != null) {
                int[] iArr = new int[2];
                this.f61543h.getLocationOnScreen(iArr);
                int height = ((View) this.f61543h.getParent()).getHeight() - this.f61543h.getHeight();
                if (iArr[1] - this.f61540e.getHeight() <= 50) {
                    d.a.c.e.m.g.d(this.f61540e, c.this.f61530a.getPageActivity());
                    return;
                }
                d.a.c.e.m.g.m(this.f61540e, c.this.f61534e, 0, (iArr[0] - (this.f61543h.getWidth() / 2)) - c.this.f61530a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f61543h.getHeight() + height);
                PopupWindow popupWindow = this.f61540e;
                if (popupWindow != null) {
                    popupWindow.update();
                }
            }
        }

        public void i(int i2) {
            if (this.f61542g != null) {
                this.f61542g.setText(c.this.f61530a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
                this.f61541f.setVisibility(0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f61543h) {
                h();
            } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
            } else {
                PopupWindow popupWindow = this.f61540e;
                if (popupWindow != null) {
                    d.a.c.e.m.g.d(popupWindow, c.this.f61530a.getPageActivity());
                }
                if (c.this.f61532c != null) {
                    String str = (String) view.getTag();
                    this.l = str;
                    if (str.contains("距离")) {
                        if (!d()) {
                            c.this.f61530a.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            d.a.c.e.i.a.l().i(false, this.m);
                            return;
                        }
                    }
                    d.a.k0.t.d.g.b.c cVar = new d.a.k0.t.d.g.b.c();
                    cVar.f61501a = this.l;
                    cVar.f61504d = false;
                    c.this.f61532c.b(cVar);
                    this.f61543h.setText(this.l);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f61530a = tbPageContext;
        this.f61534e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f61530a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f61535f = (LinearLayout) this.f61534e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f61534e.findViewById(R.id.sub_list_top_info);
        this.f61536g = findViewById;
        b bVar = new b(findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f61537h = (BdTypeListView) this.f61534e.findViewById(R.id.listView);
        g gVar = new g(this.f61530a);
        this.f61538i = gVar;
        gVar.Z(this.f61533d);
        this.f61537h.setPullRefresh(this.f61538i);
        PbListView pbListView = new PbListView(this.f61530a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        d.a.k0.t.d.g.a.a aVar = new d.a.k0.t.d.g.a.a(this.f61530a);
        this.p = aVar;
        aVar.h0(2);
        d.a.k0.t.d.g.a.b bVar2 = new d.a.k0.t.d.g.a.b(this.f61530a);
        this.q = bVar2;
        bVar2.h0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f61537h.a(this.o);
    }

    public void d() {
        this.f61537h.z();
    }

    public BdTypeListView e() {
        return this.f61537h;
    }

    public View f() {
        return this.f61534e;
    }

    public void g() {
        d.a.j0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this.f61534e);
            this.l = null;
        }
    }

    public void h() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this.f61534e);
            this.n = null;
        }
    }

    public void i() {
        PbListView pbListView = this.m;
        if (pbListView == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f61537h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        if (this.f61531b != i2) {
            this.f61531b = i2;
        }
        b bVar = this.r;
        if (bVar != null) {
            bVar.f();
        }
        d.a.j0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        NavigationBar navigationBar = this.j;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(tbPageContext, i2);
        }
        PbListView pbListView = this.m;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        h hVar = this.n;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.f61534e, R.color.CAM_X0201);
    }

    public void k() {
        d.a.j0.d0.g gVar = this.l;
        if (gVar != null) {
            if (gVar.i() != null) {
                this.l.dettachView(this.f61534e);
            }
            this.l.m();
            this.l = null;
        }
        g gVar2 = this.f61538i;
        if (gVar2 != null) {
            gVar2.a(null);
            this.f61538i.b(null);
            this.f61538i.l(null);
            this.f61538i.X();
            this.f61538i = null;
        }
        BdTypeListView bdTypeListView = this.f61537h;
        if (bdTypeListView != null) {
            bdTypeListView.setOnSrollToBottomListener(null);
            this.f61537h.setOnScrollListener(null);
            this.f61537h.setRecyclerListener(null);
            this.f61537h = null;
        }
    }

    public void l(int i2) {
        b bVar = this.r;
        if (bVar != null) {
            bVar.i(i2);
        }
    }

    public void m(List<String> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.r.c(list);
    }

    public void n(f fVar) {
        this.f61532c = fVar;
        d.a.k0.t.d.g.a.a aVar = this.p;
        if (aVar != null) {
            aVar.j0(fVar);
        }
        d.a.k0.t.d.g.a.b bVar = this.q;
        if (bVar != null) {
            bVar.j0(this.f61532c);
        }
    }

    public void o(int i2) {
        this.f61535f.setVisibility(i2);
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        if (list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f61537h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        this.f61538i.a(gVar);
    }

    public void r(BdListView.p pVar) {
        this.f61537h.setOnSrollToBottomListener(pVar);
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        if (z) {
            NavigationBar navigationBar = new NavigationBar(this.f61530a.getPageActivity());
            this.j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a());
            if (!StringUtils.isNull(str2)) {
                this.j.setCenterTextTitle(str2);
            } else if (!StringUtils.isNull(str)) {
                this.j.setCenterTextTitle(str);
            }
            this.f61534e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
        }
        if (!ListUtils.isEmpty(list)) {
            this.r.c(list);
        }
        this.p.m0(z3);
        this.q.m0(z3);
    }

    public void t() {
        TbPageContext tbPageContext = this.f61530a;
        if (tbPageContext == null || this.f61534e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.j0.d0.g(tbPageContext.getPageActivity(), this.f61530a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        d.a.j0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f61534e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.n == null) {
            this.n = new h(this.f61530a.getPageActivity(), onClickListener);
        }
        this.n.j(this.f61530a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
        this.n.l(str);
        this.n.attachView(this.f61534e, false);
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
                this.f61537h.setNextPage(this.m);
            }
            this.m.A(this.f61530a.getResources().getString(R.string.list_no_more));
            this.m.f();
        }
    }
}
