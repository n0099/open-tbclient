package d.a.n0.e2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e2.k.g.e.b f53629a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f53630b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f53631c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f53632d;

    /* renamed from: g  reason: collision with root package name */
    public w f53635g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f53633e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53634f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53636h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53637i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f53631c = newSubPbActivity;
        this.f53632d = bdTypeListView;
    }

    public boolean a() {
        return this.f53636h;
    }

    public void b() {
        d.a.n0.e2.k.g.e.b bVar = new d.a.n0.e2.k.g.e.b(this.f53631c, PostData.p0);
        this.f53629a = bVar;
        bVar.e(this.f53634f);
        this.f53629a.Z(this.f53635g);
        this.f53629a.setFromCDN(this.f53637i);
        this.f53633e.add(this.f53629a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f53631c, d.a.n0.e2.k.g.f.b.f53657f);
        this.f53630b = subPbReplyAdapter;
        this.f53633e.add(subPbReplyAdapter);
        this.f53633e.add(new d.a.n0.e2.k.g.e.c(this.f53631c, d.a.n0.e2.k.g.f.a.f53656e));
        this.f53632d.a(this.f53633e);
    }

    public void c() {
        if (this.f53632d.getAdapter2() != null) {
            this.f53632d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f53634f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f53629a.v0(a2Var);
        if (!k.isEmpty(this.f53631c.getSubPbModel().Y())) {
            this.f53629a.u0(this.f53631c.getSubPbModel().Y());
        }
        NewSubPbActivity newSubPbActivity = this.f53631c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f53629a.t0(this.f53631c.getSubPbModel().q0());
        }
        this.f53632d.setData(list);
        this.f53632d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.f53637i = z;
    }

    public void g(boolean z) {
        this.f53636h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f53629a.d(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f53629a.o(xVar);
    }
}
