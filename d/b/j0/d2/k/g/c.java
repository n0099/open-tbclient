package d.b.j0.d2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.d2.k.g.e.b f54897a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f54898b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f54899c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f54900d;

    /* renamed from: g  reason: collision with root package name */
    public w f54903g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f54901e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f54902f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54904h = false;
    public boolean i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f54899c = newSubPbActivity;
        this.f54900d = bdTypeListView;
    }

    public boolean a() {
        return this.f54904h;
    }

    public void b() {
        d.b.j0.d2.k.g.e.b bVar = new d.b.j0.d2.k.g.e.b(this.f54899c, PostData.p0);
        this.f54897a = bVar;
        bVar.l(this.f54902f);
        this.f54897a.c0(this.f54903g);
        this.f54897a.setFromCDN(this.i);
        this.f54901e.add(this.f54897a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f54899c, d.b.j0.d2.k.g.f.b.f54924f);
        this.f54898b = subPbReplyAdapter;
        this.f54901e.add(subPbReplyAdapter);
        this.f54901e.add(new d.b.j0.d2.k.g.e.c(this.f54899c, d.b.j0.d2.k.g.f.a.f54923e));
        this.f54900d.a(this.f54901e);
    }

    public void c() {
        if (this.f54900d.getAdapter2() != null) {
            this.f54900d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f54902f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f54897a.v0(a2Var);
        if (!k.isEmpty(this.f54899c.getSubPbModel().U())) {
            this.f54897a.u0(this.f54899c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f54899c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f54897a.t0(this.f54899c.getSubPbModel().k0());
        }
        this.f54900d.setData(list);
        this.f54900d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.i = z;
    }

    public void g(boolean z) {
        this.f54904h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f54897a.k(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f54897a.j(xVar);
    }
}
