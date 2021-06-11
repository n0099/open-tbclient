package d.a.n0.v.d.g.d;

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
import d.a.c.k.e.n;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65533a;

    /* renamed from: c  reason: collision with root package name */
    public f f65535c;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f65537e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f65538f;

    /* renamed from: g  reason: collision with root package name */
    public View f65539g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeListView f65540h;

    /* renamed from: i  reason: collision with root package name */
    public g f65541i;
    public NavigationBar j;
    public LinearLayout k;
    public d.a.m0.d0.g l;
    public PbListView m;
    public h n;
    public d.a.n0.v.d.g.a.a p;
    public d.a.n0.v.d.g.a.b q;
    public b r;

    /* renamed from: b  reason: collision with root package name */
    public int f65534b = -1;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f65536d = BdUniqueId.gen();
    public final List<d.a.c.k.e.a> o = new ArrayList();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f65533a.getPageActivity().finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public PopupWindow f65543e;

        /* renamed from: f  reason: collision with root package name */
        public View f65544f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65545g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65546h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f65547i;
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
                    d.a.n0.v.d.g.b.c cVar = new d.a.n0.v.d.g.b.c();
                    cVar.f65504a = b.this.l;
                    cVar.f65505b = String.valueOf(latitude);
                    cVar.f65506c = String.valueOf(longitude);
                    cVar.f65507d = true;
                    c.this.f65535c.b(cVar);
                    b.this.f65546h.setText(b.this.l);
                } else if (StringUtils.isNull(str)) {
                } else {
                    c.this.f65533a.showToast(str);
                }
            }
        }

        public b(View view) {
            this.f65544f = view;
            this.f65545g = (TextView) view.findViewById(R.id.live_num);
            TextView textView = (TextView) this.f65544f.findViewById(R.id.live_sort);
            this.f65546h = textView;
            textView.setVisibility(8);
            this.f65546h.setOnClickListener(this);
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
                this.f65546h.setText(str);
                this.f65546h.setVisibility(0);
            }
            this.f65547i = new LinearLayout(c.this.f65533a.getPageActivity());
            this.f65547i.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            SkinManager.setBackgroundResource(this.f65547i, R.drawable.bg_ala_sub_list_sort_panel);
            this.f65547i.setClipChildren(true);
            this.f65547i.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c.this.f65533a.getResources().getDimensionPixelOffset(R.dimen.ds176), c.this.f65533a.getResources().getDimensionPixelOffset(R.dimen.ds88));
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                this.f65547i.addView(e(this.j.get(i2)), layoutParams);
                if (i2 != this.j.size() - 1) {
                    View view = new View(c.this.f65533a.getPageActivity());
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, c.this.f65533a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds1)));
                    SkinManager.setBackgroundResource(view, R.color.CAM_X0204);
                    this.f65547i.addView(view);
                }
            }
            if (this.f65543e == null) {
                PopupWindow popupWindow = new PopupWindow(c.this.f65533a.getPageActivity());
                this.f65543e = popupWindow;
                popupWindow.setContentView(this.f65547i);
                this.f65543e.setWidth(-2);
                this.f65543e.setHeight(-2);
                this.f65543e.setAnimationStyle(16973826);
                this.f65543e.setBackgroundDrawable(c.this.f65533a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.f65543e.setOutsideTouchable(true);
                this.f65543e.setFocusable(true);
                this.f65543e.setTouchable(true);
            }
        }

        public final boolean d() {
            return UtilHelper.isSystemLocationProviderEnabled(c.this.f65533a.getPageActivity());
        }

        public final TextView e(String str) {
            TextView textView = new TextView(c.this.f65533a.getPageActivity());
            textView.setTextSize(0, c.this.f65533a.getResources().getDimension(R.dimen.ds28));
            textView.setText(str);
            textView.setTag(str);
            textView.setGravity(17);
            SkinManager.setBackgroundResource(textView, R.drawable.ala_sub_list_live_sort_text_selecor);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            textView.setOnClickListener(this);
            return textView;
        }

        public void f() {
            SkinManager.setViewTextColor(this.f65545g, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f65546h, R.color.CAM_X0109);
            this.f65546h.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_sub_list_arrow_n), (Drawable) null);
        }

        public void g(int i2) {
            this.f65544f.setVisibility(i2);
        }

        public final void h() {
            if (this.f65543e != null) {
                int[] iArr = new int[2];
                this.f65546h.getLocationOnScreen(iArr);
                int height = ((View) this.f65546h.getParent()).getHeight() - this.f65546h.getHeight();
                if (iArr[1] - this.f65543e.getHeight() <= 50) {
                    d.a.c.e.m.g.d(this.f65543e, c.this.f65533a.getPageActivity());
                    return;
                }
                d.a.c.e.m.g.m(this.f65543e, c.this.f65537e, 0, (iArr[0] - (this.f65546h.getWidth() / 2)) - c.this.f65533a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f65546h.getHeight() + height);
                PopupWindow popupWindow = this.f65543e;
                if (popupWindow != null) {
                    popupWindow.update();
                }
            }
        }

        public void i(int i2) {
            if (this.f65545g != null) {
                this.f65545g.setText(c.this.f65533a.getPageActivity().getResources().getString(R.string.square_sub_live_num, StringHelper.numberUniformFormatExtra(i2)));
                this.f65544f.setVisibility(0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.f65546h) {
                h();
            } else if (!(view instanceof TextView) || view.getTag() == null || !(view.getTag() instanceof String) || StringUtils.isNull((String) view.getTag())) {
            } else {
                PopupWindow popupWindow = this.f65543e;
                if (popupWindow != null) {
                    d.a.c.e.m.g.d(popupWindow, c.this.f65533a.getPageActivity());
                }
                if (c.this.f65535c != null) {
                    String str = (String) view.getTag();
                    this.l = str;
                    if (str.contains("距离")) {
                        if (!d()) {
                            c.this.f65533a.showToast(R.string.square_sub_list_no_shared_location);
                            return;
                        } else {
                            d.a.c.e.i.a.l().i(false, this.m);
                            return;
                        }
                    }
                    d.a.n0.v.d.g.b.c cVar = new d.a.n0.v.d.g.b.c();
                    cVar.f65504a = this.l;
                    cVar.f65507d = false;
                    c.this.f65535c.b(cVar);
                    this.f65546h.setText(this.l);
                }
            }
        }
    }

    public c(TbPageContext tbPageContext) {
        this.f65533a = tbPageContext;
        this.f65537e = (LinearLayout) LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.new_square_sub_list_layout, (ViewGroup) null);
        this.k = (LinearLayout) LayoutInflater.from(this.f65533a.getPageActivity()).inflate(R.layout.ala_sub_list_no_data, (ViewGroup) null);
        this.f65538f = (LinearLayout) this.f65537e.findViewById(R.id.liveListLinearLayout);
        View findViewById = this.f65537e.findViewById(R.id.sub_list_top_info);
        this.f65539g = findViewById;
        b bVar = new b(findViewById);
        this.r = bVar;
        bVar.g(8);
        this.f65540h = (BdTypeListView) this.f65537e.findViewById(R.id.listView);
        g gVar = new g(this.f65533a);
        this.f65541i = gVar;
        gVar.Z(this.f65536d);
        this.f65540h.setPullRefresh(this.f65541i);
        PbListView pbListView = new PbListView(this.f65533a.getPageActivity());
        this.m = pbListView;
        pbListView.a();
        d.a.n0.v.d.g.a.a aVar = new d.a.n0.v.d.g.a.a(this.f65533a);
        this.p = aVar;
        aVar.i0(2);
        d.a.n0.v.d.g.a.b bVar2 = new d.a.n0.v.d.g.a.b(this.f65533a);
        this.q = bVar2;
        bVar2.i0(2);
        this.o.add(this.p);
        this.o.add(this.q);
        this.f65540h.a(this.o);
    }

    public void d() {
        this.f65540h.z();
    }

    public BdTypeListView e() {
        return this.f65540h;
    }

    public View f() {
        return this.f65537e;
    }

    public void g() {
        d.a.m0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.dettachView(this.f65537e);
            this.l = null;
        }
    }

    public void h() {
        h hVar = this.n;
        if (hVar != null) {
            hVar.dettachView(this.f65537e);
            this.n = null;
        }
    }

    public void i() {
        PbListView pbListView = this.m;
        if (pbListView == null || pbListView.b().getParent() == null) {
            return;
        }
        this.f65540h.removeFooterView(this.m.b());
    }

    public void j(TbPageContext tbPageContext, int i2) {
        if (this.f65534b != i2) {
            this.f65534b = i2;
        }
        b bVar = this.r;
        if (bVar != null) {
            bVar.f();
        }
        d.a.m0.d0.g gVar = this.l;
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
        SkinManager.setBackgroundResource(this.f65537e, R.color.CAM_X0201);
    }

    public void k() {
        d.a.m0.d0.g gVar = this.l;
        if (gVar != null) {
            if (gVar.i() != null) {
                this.l.dettachView(this.f65537e);
            }
            this.l.m();
            this.l = null;
        }
        g gVar2 = this.f65541i;
        if (gVar2 != null) {
            gVar2.a(null);
            this.f65541i.b(null);
            this.f65541i.l(null);
            this.f65541i.X();
            this.f65541i = null;
        }
        BdTypeListView bdTypeListView = this.f65540h;
        if (bdTypeListView != null) {
            bdTypeListView.setOnSrollToBottomListener(null);
            this.f65540h.setOnScrollListener(null);
            this.f65540h.setRecyclerListener(null);
            this.f65540h = null;
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
        this.f65535c = fVar;
        d.a.n0.v.d.g.a.a aVar = this.p;
        if (aVar != null) {
            aVar.k0(fVar);
        }
        d.a.n0.v.d.g.a.b bVar = this.q;
        if (bVar != null) {
            bVar.k0(this.f65535c);
        }
    }

    public void o(int i2) {
        this.f65538f.setVisibility(i2);
    }

    public void p(List<n> list) {
        BdTypeListView bdTypeListView;
        if (list == null || ListUtils.isEmpty(list) || (bdTypeListView = this.f65540h) == null) {
            return;
        }
        bdTypeListView.setData(list);
    }

    public void q(f.g gVar) {
        this.f65541i.a(gVar);
    }

    public void r(BdListView.p pVar) {
        this.f65540h.setOnSrollToBottomListener(pVar);
    }

    public void s(boolean z, List<String> list, String str, String str2, boolean z2, boolean z3) {
        if (z) {
            NavigationBar navigationBar = new NavigationBar(this.f65533a.getPageActivity());
            this.j = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).setOnClickListener(new a());
            if (!StringUtils.isNull(str2)) {
                this.j.setCenterTextTitle(str2);
            } else if (!StringUtils.isNull(str)) {
                this.j.setCenterTextTitle(str);
            }
            this.f65537e.addView(this.j, 0, new LinearLayout.LayoutParams(-1, -2));
            SkinManager.setBackgroundColor(this.j.getBottomLine(), R.color.CAM_X0204);
        }
        if (!ListUtils.isEmpty(list)) {
            this.r.c(list);
        }
        this.p.l0(z3);
        this.q.l0(z3);
    }

    public void t() {
        TbPageContext tbPageContext = this.f65533a;
        if (tbPageContext == null || this.f65537e == null) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.m0.d0.g(tbPageContext.getPageActivity(), this.f65533a.getResources().getDimensionPixelSize(R.dimen.ds360));
        }
        d.a.m0.d0.g gVar = this.l;
        if (gVar != null) {
            gVar.attachView(this.f65537e, true);
        }
    }

    public void u(String str, View.OnClickListener onClickListener, boolean z) {
        if (this.n == null) {
            this.n = new h(this.f65533a.getPageActivity(), onClickListener);
        }
        this.n.j(this.f65533a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds180));
        this.n.l(str);
        this.n.attachView(this.f65537e, false);
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
                this.f65540h.setNextPage(this.m);
            }
            this.m.A(this.f65533a.getResources().getString(R.string.live_sub_tab_no_more_data));
            this.m.f();
        }
    }
}
