package d.b.i0.c2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.b.e.p.k;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.h0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.c2.k.g.e.b f53067a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f53068b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f53069c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f53070d;

    /* renamed from: g  reason: collision with root package name */
    public w f53073g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f53071e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53072f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53074h = false;
    public boolean i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f53069c = newSubPbActivity;
        this.f53070d = bdTypeListView;
    }

    public boolean a() {
        return this.f53074h;
    }

    public void b() {
        d.b.i0.c2.k.g.e.b bVar = new d.b.i0.c2.k.g.e.b(this.f53069c, PostData.o0);
        this.f53067a = bVar;
        bVar.l(this.f53072f);
        this.f53067a.c0(this.f53073g);
        this.f53067a.setFromCDN(this.i);
        this.f53071e.add(this.f53067a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f53069c, d.b.i0.c2.k.g.f.b.f53094f);
        this.f53068b = subPbReplyAdapter;
        this.f53071e.add(subPbReplyAdapter);
        this.f53071e.add(new d.b.i0.c2.k.g.e.c(this.f53069c, d.b.i0.c2.k.g.f.a.f53093e));
        this.f53070d.a(this.f53071e);
    }

    public void c() {
        if (this.f53070d.getAdapter2() != null) {
            this.f53070d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f53072f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f53067a.v0(a2Var);
        if (!k.isEmpty(this.f53069c.getSubPbModel().U())) {
            this.f53067a.u0(this.f53069c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f53069c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f53067a.t0(this.f53069c.getSubPbModel().k0());
        }
        this.f53070d.setData(list);
        this.f53070d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.i = z;
    }

    public void g(boolean z) {
        this.f53074h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f53067a.k(onLongClickListener);
    }

    public void i(TbRichTextView.w wVar) {
        this.f53067a.j(wVar);
    }
}
