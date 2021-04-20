package d.b.i0.y.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import d.b.c.e.p.l;
import d.b.h0.d0.g;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.s.a;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class b extends d.b.c.a.d<ChosenPostActivity> {

    /* renamed from: a  reason: collision with root package name */
    public ChosenPostActivity f63976a;

    /* renamed from: b  reason: collision with root package name */
    public View f63977b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f63978c;

    /* renamed from: d  reason: collision with root package name */
    public BdListView f63979d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.y.a.a f63980e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g0.g.a f63981f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63982g;

    /* renamed from: h  reason: collision with root package name */
    public g f63983h;
    public NoNetworkView i;
    public h j;
    public int k;
    public int l;
    public d.b.h0.r.f0.g m;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            b.this.f63976a.getModelController().B(z);
        }
    }

    /* renamed from: d.b.i0.y.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1711b implements AdapterView.OnItemClickListener {
        public C1711b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            tinfo item = b.this.f63980e.getItem(i);
            if (item == null) {
                return;
            }
            TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemLongClickListener {

        /* loaded from: classes4.dex */
        public class a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.r.s.a f63987e;

            public a(c cVar, d.b.h0.r.s.a aVar) {
                this.f63987e = aVar;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                this.f63987e.dismiss();
            }
        }

        /* renamed from: d.b.i0.y.a.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1712b implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.b.h0.r.s.a f63988e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f63989f;

            public C1712b(d.b.h0.r.s.a aVar, int i) {
                this.f63988e = aVar;
                this.f63989f = i;
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                this.f63988e.dismiss();
                d.b.h0.g0.c.b bVar = new d.b.h0.g0.c.b(4101, null, null, null);
                bVar.g(b.this.f63980e.getItem(this.f63989f));
                bVar.i(b.this.f63976a.getUniqueId());
                b.this.f63976a.getEventCenter().dispatchMvcEvent(bVar);
            }
        }

        public c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(b.this.getActivity());
            aVar.setMessage(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
            aVar.setNegativeButton(R.string.cancel, new a(this, aVar));
            aVar.setPositiveButton(R.string.confirm, new C1712b(aVar, i));
            aVar.create(b.this.f63976a.getPageContext());
            aVar.show();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements BdListView.q {
        public d() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void y(BdListView bdListView) {
            if (l.C()) {
                b.this.f63976a.getModelController().y();
            } else if (b.this.f63981f != null) {
                b.this.f63981f.d();
                b.this.f63981f.g(R.string.no_more_msg);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar = b.this;
            bVar.o(bVar.m());
            b.this.f63983h.attachView(b.this.m(), true);
            b.this.x();
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.f63982g = false;
        this.f63976a = chosenPostActivity;
    }

    public Activity getActivity() {
        return this.f63976a.getPageContext().getPageActivity();
    }

    public BdListView k() {
        return this.f63979d;
    }

    public d.b.h0.r.f0.g l() {
        if (this.m == null) {
            this.m = new d.b.h0.r.f0.g(this.f63976a.getPageContext());
        }
        return this.m;
    }

    public View m() {
        return this.f63977b;
    }

    public final void n(d.b.h0.g0.c.b bVar) {
        Object c2 = bVar.c();
        if (c2 instanceof Long) {
            this.f63980e.p(((Long) c2).longValue());
            if (this.f63980e.getCount() <= 5) {
                x();
            }
        }
    }

    public final void o(View view) {
        h hVar = this.j;
        if (hVar != null) {
            hVar.dettachView(view);
        }
    }

    public void onServerError(ErrorData errorData) {
        g gVar = this.f63983h;
        if (gVar != null) {
            gVar.dettachView(m());
        }
        if (errorData != null && this.f63980e.c() <= 0) {
            y(m(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.f63979d.A(0L);
        d.b.h0.g0.g.a aVar = this.f63981f;
        if (aVar != null) {
            aVar.g(R.string.no_more_msg);
        }
    }

    public void q(TbPageContext<?> tbPageContext, int i) {
        NavigationBar navigationBar = this.f63978c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(tbPageContext, i);
        }
        d.b.i0.y.a.a aVar = this.f63980e;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.g0.g.a aVar2 = this.f63981f;
        if (aVar2 != null) {
            aVar2.onChangeSkinType(tbPageContext, i);
        }
        NoNetworkView noNetworkView = this.i;
        if (noNetworkView != null) {
            noNetworkView.c(tbPageContext, i);
        }
        d.b.h0.r.f0.g gVar = this.m;
        if (gVar != null) {
            gVar.I(i);
        }
    }

    public View r() {
        View inflate = this.f63976a.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        this.f63977b = inflate;
        return inflate;
    }

    public boolean s(d.b.h0.g0.c.b bVar) {
        int b2 = bVar.b();
        if (b2 != 4102) {
            switch (b2) {
                case 4097:
                    this.f63982g = false;
                    break;
                case 4098:
                    this.f63982g = true;
                    break;
                case 4099:
                    v(bVar.a());
                    break;
            }
        } else {
            n(bVar);
        }
        return false;
    }

    public void u() {
        this.k = this.f63976a.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.l = this.f63976a.getResources().getDimensionPixelSize(R.dimen.ds150);
        NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.chosen_post_navigation_bar);
        this.f63978c = navigationBar;
        navigationBar.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.f63978c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63979d = (BdListView) m().findViewById(R.id.chosen_post_list);
        this.i = (NoNetworkView) m().findViewById(R.id.view_no_network);
        d.b.i0.y.a.a aVar = new d.b.i0.y.a.a(this.f63976a.getPageContext(), new Class[]{d.b.i0.y.a.c.c.class, d.b.i0.y.a.c.b.class, d.b.i0.y.a.c.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.f63976a.getEventCenter());
        this.f63980e = aVar;
        this.f63979d.setAdapter((ListAdapter) aVar);
        d.b.h0.r.f0.g l = l();
        this.m = l;
        this.f63979d.setPullRefresh(l);
        this.m.b(new a());
        this.f63979d.setOnItemClickListener(new C1711b());
        this.f63979d.setOnItemLongClickListener(new c());
        this.f63979d.setExOnSrollToBottomListener(new d());
        d.b.h0.g0.g.a aVar2 = new d.b.h0.g0.g.a(this.f63976a);
        this.f63981f = aVar2;
        aVar2.a();
        k().setNextPage(this.f63981f);
        g gVar = new g(getActivity());
        this.f63983h = gVar;
        gVar.onChangeSkinType();
        this.f63983h.attachView(m(), true);
        this.f63976a.getModelController().w();
    }

    public void v(d.b.h0.g0.b.a aVar) {
        if (aVar instanceof d.b.i0.y.a.d.b) {
            List<tinfo> b2 = ((d.b.i0.y.a.d.b) aVar).b();
            if (b2 != null && b2.size() > 0) {
                this.f63979d.setVisibility(0);
            }
            g gVar = this.f63983h;
            if (gVar != null) {
                gVar.dettachView(m());
            }
            if (this.f63982g) {
                this.f63980e.i(b2);
                return;
            }
            this.f63980e.k(b2);
            if (b2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(b2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void w(d.b.h0.g0.d.b bVar) {
        if (bVar instanceof d.b.h0.g0.d.a) {
            d.b.h0.g0.d.a aVar = (d.b.h0.g0.d.a) bVar;
            if (aVar.d()) {
                this.f63981f.d();
                if (aVar.b()) {
                    this.f63981f.f(R.string.loading);
                } else if (!aVar.a()) {
                    this.f63981f.g(R.string.no_more_msg);
                }
            } else {
                this.f63981f.e();
            }
            if (aVar.c()) {
                return;
            }
            this.f63979d.A(0L);
        }
    }

    public final void x() {
        d.b.h0.g0.c.b bVar = new d.b.h0.g0.c.b(4100, null, null, null);
        bVar.i(this.f63976a.getUniqueId());
        this.f63976a.getEventCenter().dispatchMvcEvent(bVar);
    }

    public final void y(View view, String str, boolean z) {
        if (this.j == null) {
            this.j = new h(getPageContext().getPageActivity(), new e(this, null));
        }
        this.j.l(str);
        this.j.attachView(view, z);
        this.j.o();
    }
}
