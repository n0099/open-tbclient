package d.b.i0.d2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.d2.k.g.e.b f54476a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f54477b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f54478c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f54479d;

    /* renamed from: g  reason: collision with root package name */
    public w f54482g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f54480e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f54481f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54483h = false;
    public boolean i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f54478c = newSubPbActivity;
        this.f54479d = bdTypeListView;
    }

    public boolean a() {
        return this.f54483h;
    }

    public void b() {
        d.b.i0.d2.k.g.e.b bVar = new d.b.i0.d2.k.g.e.b(this.f54478c, PostData.p0);
        this.f54476a = bVar;
        bVar.l(this.f54481f);
        this.f54476a.c0(this.f54482g);
        this.f54476a.setFromCDN(this.i);
        this.f54480e.add(this.f54476a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f54478c, d.b.i0.d2.k.g.f.b.f54503f);
        this.f54477b = subPbReplyAdapter;
        this.f54480e.add(subPbReplyAdapter);
        this.f54480e.add(new d.b.i0.d2.k.g.e.c(this.f54478c, d.b.i0.d2.k.g.f.a.f54502e));
        this.f54479d.a(this.f54480e);
    }

    public void c() {
        if (this.f54479d.getAdapter2() != null) {
            this.f54479d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54481f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f54476a.v0(a2Var);
        if (!k.isEmpty(this.f54478c.getSubPbModel().U())) {
            this.f54476a.u0(this.f54478c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f54478c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f54476a.t0(this.f54478c.getSubPbModel().k0());
        }
        this.f54479d.setData(list);
        this.f54479d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.i = z;
    }

    public void g(boolean z) {
        this.f54483h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f54476a.k(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f54476a.j(xVar);
    }
}
