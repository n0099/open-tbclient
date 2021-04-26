package d.a.j0.z1.b;

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
import d.a.i0.b.d;
import d.a.j0.z1.c.c;
import d.a.j0.z1.e.b;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements b.d, InterestedForumAdapter.c, View.OnClickListener, b.c {

    /* renamed from: e  reason: collision with root package name */
    public final InterestedForumFragment f62939e;

    /* renamed from: f  reason: collision with root package name */
    public final b f62940f;

    /* renamed from: g  reason: collision with root package name */
    public final BdRecyclerView f62941g;

    /* renamed from: h  reason: collision with root package name */
    public InterestedForumAdapter f62942h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f62943i;
    public final TBSpecificationBtn j;
    public final TBSpecificationBtn k;
    public final TbPageContext<BaseFragmentActivity> l;
    public BdListView.p m = new C1694a();

    /* renamed from: d.a.j0.z1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1694a implements BdListView.p {
        public C1694a() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (a.this.f62940f.i()) {
                a.this.f62940f.h();
                a.this.i();
            }
        }
    }

    public a(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, b bVar) {
        this.f62939e = interestedForumFragment;
        this.f62941g = bdRecyclerView;
        this.f62940f = bVar;
        this.l = tbPageContext;
        this.k = tBSpecificationBtn;
        this.j = tBSpecificationBtn2;
        f();
        g();
    }

    @Override // d.a.j0.z1.e.b.c
    public void a() {
        if (d.l()) {
            this.f62939e.getActivity().setResult(-1);
            this.f62939e.getActivity().finish();
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.l.getPageActivity()).createNormalCfg(0)));
    }

    @Override // d.a.j0.z1.e.b.d
    public void b(c cVar) {
        List<d.a.j0.z1.c.a> list;
        if (cVar != null && (list = cVar.f62953a) != null && !ListUtils.isEmpty(list)) {
            if (this.f62941g.getVisibility() == 8) {
                this.f62941g.setVisibility(0);
            }
            this.f62942h.m(cVar.f62953a);
            this.f62939e.I0();
        }
        if (this.f62940f.i()) {
            return;
        }
        j();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void c(int i2, boolean z) {
        if (i2 > 0 && !this.k.isEnabled()) {
            this.k.setEnabled(true);
            this.k.setText(this.f62941g.getResources().getString(R.string.start_the_trip));
        } else if (i2 == 0) {
            this.k.setEnabled(false);
            this.k.setText(this.f62941g.getResources().getString(R.string.try_to_select));
        }
        d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
        if (!z) {
            this.j.setText(this.l.getString(R.string.select_all));
            this.j.setConfig(bVar);
            return;
        }
        this.j.setText(this.l.getString(R.string.unselect_all));
        bVar.r(R.color.CAM_X0109);
        this.j.setConfig(bVar);
    }

    public void e(List<d.a.j0.z1.c.b> list) {
        this.f62940f.m(list);
        this.f62940f.h();
    }

    public final void f() {
        this.f62942h = new InterestedForumAdapter();
        BdRecyclerView bdRecyclerView = this.f62941g;
        bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
        this.f62941g.setAdapter(this.f62942h);
        PbListView pbListView = new PbListView(this.f62941g.getContext());
        this.f62943i = pbListView;
        pbListView.a();
        this.f62943i.o(R.color.CAM_X0205);
        this.f62943i.v();
        this.f62943i.C(SkinManager.getColor(R.color.CAM_X0109));
        this.f62943i.E(R.dimen.tbfontsize33);
        this.f62943i.y(R.color.CAM_X0110);
        this.f62941g.setNextPage(this.f62943i);
        i();
    }

    public final void g() {
        this.f62941g.setOnSrollToBottomListener(this.m);
        this.f62940f.o(this);
        this.f62940f.n(this);
        this.f62942h.v(this);
        this.k.setOnClickListener(this);
    }

    public void h() {
        this.f62942h.s();
    }

    public void i() {
        this.f62943i.H();
        this.f62943i.O();
        this.f62943i.A(this.f62941g.getContext().getString(R.string.list_loading));
        this.f62943i.J(l.g(this.f62941g.getContext(), R.dimen.tbds217));
    }

    public void j() {
        this.f62943i.B(this.f62941g.getContext().getString(R.string.interested_forum_list_no_more), l.g(this.f62941g.getContext(), R.dimen.tbds178));
        this.f62943i.E(R.dimen.tbds36);
        this.f62943i.y(R.color.CAM_X0109);
        this.f62943i.f();
        this.f62943i.J(l.g(this.f62941g.getContext(), R.dimen.tbds217));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.k) {
            try {
                this.f62940f.e(this.f62942h.n());
                d.a.j0.z1.d.a.a(2, 1, this.f62939e.F0());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.j0.z1.e.b.d
    public void onError(int i2, String str) {
        this.f62939e.J0(str);
    }
}
