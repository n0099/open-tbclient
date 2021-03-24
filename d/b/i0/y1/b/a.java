package d.b.i0.y1.b;

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
import d.b.b.e.p.l;
import d.b.h0.b.d;
import d.b.i0.y1.c.c;
import d.b.i0.y1.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f62573e;

    /* renamed from: f  reason: collision with root package name */
    public final b f62574f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f62575g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f62576h;
    public PbListView i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public BdListView.p m = new C1675a();

    /* renamed from: d.b.i0.y1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1675a implements BdListView.p {
        public C1675a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f62574f.i()) {
                a.this.f62574f.h();
                a.this.j();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f62573e = interestedForumFragment;
        this.f62575g = bdRecyclerView;
        this.f62574f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        h();
    }

    @Override // d.b.i0.y1.e.b.c
    public void a() {
        if (d.k()) {
            this.f62573e.getActivity().setResult(-1);
            this.f62573e.getActivity().finish();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
    }

    @Override // d.b.i0.y1.e.b.d
    public void b(c cVar) {
        List<d.b.i0.y1.c.a> list;
        if (cVar != null && (list = cVar.f62586a) != null && !ListUtils.isEmpty(list)) {
            if (this.f62575g.getVisibility() == 8) {
                this.f62575g.setVisibility(0);
            }
            this.f62576h.m(cVar.f62586a);
            this.f62573e.H0();
        }
        if (this.f62574f.i()) {
            return;
        }
        k();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i, boolean z) {
        if (i > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f62575g.getResources().getString(R.string.start_the_trip));
        } else if (i == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f62575g.getResources().getString(R.string.try_to_select));
        }
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.b.i0.y1.c.b> list) {
        this.f62574f.m(list);
        this.f62574f.h();
    }

    public final void f() {
        this.f62576h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f62575g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f62575g.setAdapter(this.f62576h);
        PbListView pbListView = new PbListView(this.f62575g.getContext());
        this.i = pbListView;
        pbListView.a();
        this.i.o(R.color.CAM_X0205);
        this.i.v();
        this.i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.i.E(R.dimen.tbfontsize33);
        this.i.y(R.color.CAM_X0110);
        this.f62575g.setNextPage(this.i);
        j();
    }

    public final void h() {
        this.f62575g.setOnSrollToBottomListener(this.m);
        this.f62574f.o(this);
        this.f62574f.n(this);
        this.f62576h.w(this);
        this.k.setOnClickListener(this);
    }

    public void i() {
        this.f62576h.s();
    }

    public void j() {
        this.i.H();
        this.i.O();
        this.i.A(this.f62575g.getContext().getString(R.string.list_loading));
        this.i.J(l.g(this.f62575g.getContext(), R.dimen.tbds217));
    }

    public void k() {
        this.i.B(this.f62575g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f62575g.getContext(), R.dimen.tbds178));
        this.i.E(R.dimen.tbds36);
        this.i.y(R.color.CAM_X0109);
        this.i.f();
        this.i.J(l.g(this.f62575g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f62574f.e(this.f62576h.n());
                d.b.i0.y1.d.a.a(2, 1, this.f62573e.E0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.i0.y1.e.b.d
    public void onError(int i, String str) {
        this.f62573e.I0(str);
    }
}
