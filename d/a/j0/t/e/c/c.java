package d.a.j0.t.e.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.j.e.n;
import d.a.i0.r.f0.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public d.a.j0.t.e.d.c A;
    public d.a.j0.t.e.a.d B;
    public d.a.j0.q0.x1.b C;
    public NavigationBar D;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60876a;

    /* renamed from: b  reason: collision with root package name */
    public int f60877b = -1;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.t.e.c.d f60878c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60879d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f60880e;

    /* renamed from: f  reason: collision with root package name */
    public View f60881f;

    /* renamed from: g  reason: collision with root package name */
    public View f60882g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60883h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60884i;
    public BdTypeMultiColumnListView j;
    public PopupWindow k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public String p;
    public boolean q;
    public d.a.i0.r.f0.g r;
    public PbListView s;
    public NoNetworkView t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
            customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, c.this.f60876a.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.r();
        }
    }

    /* renamed from: d.a.j0.t.e.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1574c implements View.OnTouchListener {
        public View$OnTouchListenerC1574c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.C.b(view, motionEvent);
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.s(1);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.s(2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PopupWindow.OnDismissListener {
        public f() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            c.this.l();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12573").param("fid", c.this.p));
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(c.this.f60876a.getPageActivity())));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMultiColumnListView.OnScrollToBottomListener f60892e;

        public h(c cVar, BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
            this.f60892e = onScrollToBottomListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener = this.f60892e;
            if (onScrollToBottomListener != null) {
                onScrollToBottomListener.onScrollToBottom();
            }
        }
    }

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        this.q = false;
        this.f60876a = tbPageContext;
        this.f60879d = z;
        this.f60880e = bdUniqueId;
        this.p = str;
        this.q = z2;
    }

    public void A() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.j.setNextPage(this.s);
            }
            this.s.A(this.f60876a.getResources().getString(R.string.load_more));
            this.s.f();
        }
    }

    public void B() {
        PbListView pbListView = this.s;
        if (pbListView != null) {
            if (pbListView.b().getParent() == null) {
                this.j.setNextPage(this.s);
            }
            this.s.M();
            this.s.O();
        }
    }

    public void C() {
        if (this.A == null) {
            d.a.j0.t.e.d.c cVar = new d.a.j0.t.e.d.c(this.f60876a.getPageActivity());
            this.A = cVar;
            cVar.a();
            this.A.e(new g());
        }
        if (this.A.b().getParent() == null) {
            this.j.setNextPage(this.A);
        }
    }

    public final void D() {
        n();
        SkinManager.setBackgroundResource(this.l, R.drawable.bg_ala_frs_game_live_sort_panel);
        SkinManager.setBackgroundResource(this.m, R.drawable.ala_frs_game_live_sort_selecor);
        SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
        SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        int[] iArr = new int[2];
        this.f60884i.getLocationOnScreen(iArr);
        int height = ((View) this.f60884i.getParent()).getHeight() - this.f60884i.getHeight();
        if (iArr[1] - this.k.getHeight() <= 50) {
            d.a.c.e.m.g.d(this.k, this.f60876a.getPageActivity());
            return;
        }
        d.a.c.e.m.g.m(this.k, this.f60881f, 0, (iArr[0] - (this.f60884i.getWidth() / 2)) - this.f60876a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f60884i.getHeight() + height);
        this.k.update();
    }

    public void g() {
        this.j.completePullRefresh();
    }

    public void h() {
        if (this.j == null || !j.z()) {
            return;
        }
        this.j.startPullRefresh();
    }

    public BdTypeMultiColumnListView i() {
        return this.j;
    }

    public NavigationBar j() {
        return this.D;
    }

    public View k() {
        return this.f60881f;
    }

    public final void l() {
    }

    public final void m() {
        if (this.u == null) {
            View inflate = LayoutInflater.from(this.f60876a.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
            this.u = inflate;
            this.v = (TextView) inflate.findViewById(R.id.frs_game_live_recommand1);
            this.w = (TextView) this.u.findViewById(R.id.frs_game_live_recommand2);
            this.x = (TextView) this.u.findViewById(R.id.frs_game_live_recommand3);
            this.y = this.u.findViewById(R.id.frs_game_live_recommand_line1);
            this.z = this.u.findViewById(R.id.frs_game_live_recommand_line2);
        }
        p();
    }

    public final void n() {
        if (this.l == null) {
            View inflate = LayoutInflater.from(this.f60876a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
            this.l = inflate;
            this.m = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
            this.n = (TextView) this.l.findViewById(R.id.frs_game_live_new);
            this.o = this.l.findViewById(R.id.frs_game_live_sort_sepline);
            this.m.setOnClickListener(new d());
            this.n.setOnClickListener(new e());
        }
        if (this.k == null) {
            PopupWindow popupWindow = new PopupWindow(this.f60876a.getPageActivity());
            this.k = popupWindow;
            popupWindow.setContentView(this.l);
            this.k.setWidth(-2);
            this.k.setHeight(-2);
            this.k.setAnimationStyle(16973826);
            this.k.setBackgroundDrawable(this.f60876a.getResources().getDrawable(R.drawable.popup_window_transparent));
            this.k.setOutsideTouchable(true);
            this.k.setFocusable(true);
            this.k.setTouchable(true);
            this.k.setOnDismissListener(new f());
        }
    }

    public void o() {
        View inflate = LayoutInflater.from(this.f60876a.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
        this.f60881f = inflate;
        if (this.q) {
            NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.view_navigation_bar);
            this.D = navigationBar;
            navigationBar.setVisibility(0);
            this.D.onChangeSkinType(this.f60876a, TbadkCoreApplication.getInst().getSkinType());
            this.D.showBottomLine(true);
            this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
            this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        this.f60882g = this.f60881f.findViewById(R.id.frs_game_live_topinfo);
        this.f60883h = (TextView) this.f60881f.findViewById(R.id.frs_game_live_num);
        this.f60884i = (TextView) this.f60881f.findViewById(R.id.frs_game_live_sort);
        BdTypeMultiColumnListView bdTypeMultiColumnListView = (BdTypeMultiColumnListView) this.f60881f.findViewById(R.id.listView);
        this.j = bdTypeMultiColumnListView;
        bdTypeMultiColumnListView.setColumnDiv((int) this.f60876a.getResources().getDimension(R.dimen.ds16));
        this.t = (NoNetworkView) this.f60881f.findViewById(R.id.vNoNetwork);
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(this.f60876a);
        this.r = gVar;
        gVar.Z(this.f60880e);
        this.j.setPullRefresh(this.r);
        PbListView pbListView = new PbListView(this.f60876a.getPageActivity());
        this.s = pbListView;
        pbListView.a();
        this.B = new d.a.j0.t.e.a.d(this.f60876a, this.j);
        this.f60884i.setOnClickListener(new b());
        if (this.f60879d) {
            this.C = new d.a.j0.q0.x1.b(this.f60876a.getPageActivity(), this.f60880e, this.f60879d);
            this.j.setOnTouchListener(new View$OnTouchListenerC1574c());
        }
    }

    public final void p() {
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
    }

    public void q(int i2) {
        if (this.f60877b != i2) {
            this.f60877b = i2;
        }
        NavigationBar navigationBar = this.D;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60876a, i2);
        }
        NavigationBar navigationBar2 = this.D;
        if (navigationBar2 != null) {
            navigationBar2.onChangeSkinType(this.f60876a, i2);
            this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
        }
        SkinManager.setViewTextColor(this.f60883h, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f60884i, R.color.CAM_X0109);
        this.j.setContentBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f60884i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
    }

    public final void r() {
        D();
    }

    public final void s(int i2) {
        u(i2);
        d.a.c.e.m.g.d(this.k, this.f60876a.getPageActivity());
        d.a.j0.t.e.c.d dVar = this.f60878c;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void t(int i2) {
        if (this.f60883h != null) {
            this.f60883h.setText(this.f60876a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i2)));
            if (i2 <= 1) {
                this.f60884i.setVisibility(8);
            } else {
                this.f60884i.setVisibility(0);
            }
        }
    }

    public void u(int i2) {
        TextView textView;
        if (i2 == 1) {
            TextView textView2 = this.f60884i;
            if (textView2 != null) {
                textView2.setText(this.f60876a.getString(R.string.frs_game_live_sort_hot));
            }
        } else if (i2 != 2 || (textView = this.f60884i) == null) {
        } else {
            textView.setText(this.f60876a.getString(R.string.frs_game_live_sort_new));
        }
    }

    public void v(d.a.j0.t.c cVar) {
        this.B.b(cVar);
    }

    public void w(List<n> list, boolean z, boolean z2) {
        if (list == null) {
            list = new LinkedList<>();
        }
        if (z2) {
            m();
            this.f60882g.setVisibility(8);
            View view = this.u;
            if (view != null) {
                this.j.removeHeaderView(view);
                this.j.addHeaderView(this.u);
            }
            this.B.c(list);
            this.j.setNextPage(null);
            return;
        }
        View view2 = this.u;
        if (view2 != null) {
            this.j.removeHeaderView(view2);
        }
        if (list.size() == 0) {
            this.f60882g.setVisibility(8);
            this.B.c(list);
            this.j.setNextPage(null);
            return;
        }
        this.f60882g.setVisibility(0);
        this.B.c(list);
        if (z) {
            A();
        } else {
            C();
        }
    }

    public void x(d.a.j0.t.e.c.d dVar) {
        this.f60878c = dVar;
    }

    public void y(f.g gVar) {
        this.r.a(gVar);
    }

    public void z(BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.j.setOnSrollToBottomListener(onScrollToBottomListener);
        this.s.z(new h(this, onScrollToBottomListener));
    }
}
