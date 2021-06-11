package d.a.n0.a2.b;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import d.a.c.e.p.l;
import d.a.m0.b.d;
import d.a.n0.a2.c.c;
import d.a.n0.a2.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f54831e;

    /* renamed from: f  reason: collision with root package name */
    public final b f54832f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f54833g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f54834h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f54835i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public boolean m = false;
    public BdListView.p n = new C1235a();

    /* renamed from: d.a.n0.a2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1235a implements BdListView.p {
        public C1235a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f54832f.k()) {
                a.this.f54832f.j();
                a.this.j();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f54831e = interestedForumFragment;
        this.f54833g = bdRecyclerView;
        this.f54832f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        h();
    }

    @Override // d.a.n0.a2.e.b.c
    public void a() {
        if (!this.m) {
            this.m = true;
        } else if (d.l()) {
            this.f54831e.getActivity().setResult(-1);
            this.f54831e.getActivity().finish();
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
        }
    }

    @Override // d.a.n0.a2.e.b.d
    public void b(c cVar) {
        List<d.a.n0.a2.c.a> list;
        if (cVar != null && (list = cVar.f54845a) != null && !ListUtils.isEmpty(list)) {
            if (this.f54833g.getVisibility() == 8) {
                this.f54833g.setVisibility(0);
            }
            this.f54834h.m(cVar.f54845a);
            this.f54831e.K0();
        }
        if (this.f54832f.k()) {
            return;
        }
        k();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        if (i2 > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f54833g.getResources().getString(R.string.start_the_trip));
        } else if (i2 == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f54833g.getResources().getString(R.string.try_to_select));
        }
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.a.n0.a2.c.b> list) {
        this.f54832f.o(list);
        this.f54832f.j();
        this.f54832f.e();
    }

    public final void f() {
        this.f54834h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f54833g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f54833g.setAdapter(this.f54834h);
        PbListView pbListView = new PbListView(this.f54833g.getContext());
        this.f54835i = pbListView;
        pbListView.a();
        this.f54835i.o(R.color.CAM_X0205);
        this.f54835i.v();
        this.f54835i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f54835i.E(R.dimen.tbfontsize33);
        this.f54835i.y(R.color.CAM_X0110);
        this.f54833g.setNextPage(this.f54835i);
        j();
    }

    public final void h() {
        this.f54833g.setOnSrollToBottomListener(this.n);
        this.f54832f.q(this);
        this.f54832f.p(this);
        this.f54834h.v(this);
        this.k.setOnClickListener(this);
    }

    public void i() {
        this.f54834h.s();
    }

    public void j() {
        this.f54835i.H();
        this.f54835i.O();
        this.f54835i.A(this.f54833g.getContext().getString(R.string.list_loading));
        this.f54835i.J(l.g(this.f54833g.getContext(), R.dimen.tbds217));
    }

    public void k() {
        this.f54835i.B(this.f54833g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f54833g.getContext(), R.dimen.tbds178));
        this.f54835i.E(R.dimen.tbds36);
        this.f54835i.y(R.color.CAM_X0109);
        this.f54835i.f();
        this.f54835i.J(l.g(this.f54833g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f54832f.f(this.f54834h.n());
                d.a.n0.a2.d.a.a(2, 1, this.f54831e.H0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.n0.a2.e.b.d
    public void onError(int i2, String str) {
        this.f54831e.L0(str);
    }
}
