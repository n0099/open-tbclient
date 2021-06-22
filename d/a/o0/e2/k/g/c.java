package d.a.o0.e2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.e2.k.g.e.b f57443a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f57444b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f57445c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f57446d;

    /* renamed from: g  reason: collision with root package name */
    public w f57449g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f57447e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f57448f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57450h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57451i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f57445c = newSubPbActivity;
        this.f57446d = bdTypeListView;
    }

    public boolean a() {
        return this.f57450h;
    }

    public void b() {
        d.a.o0.e2.k.g.e.b bVar = new d.a.o0.e2.k.g.e.b(this.f57445c, PostData.u0);
        this.f57443a = bVar;
        bVar.e(this.f57448f);
        this.f57443a.a0(this.f57449g);
        this.f57443a.setFromCDN(this.f57451i);
        this.f57447e.add(this.f57443a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f57445c, d.a.o0.e2.k.g.f.b.f57471f);
        this.f57444b = subPbReplyAdapter;
        this.f57447e.add(subPbReplyAdapter);
        this.f57447e.add(new d.a.o0.e2.k.g.e.c(this.f57445c, d.a.o0.e2.k.g.f.a.f57470e));
        this.f57446d.a(this.f57447e);
    }

    public void c() {
        if (this.f57446d.getAdapter2() != null) {
            this.f57446d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f57448f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f57443a.w0(a2Var);
        if (!k.isEmpty(this.f57445c.getSubPbModel().c0())) {
            this.f57443a.v0(this.f57445c.getSubPbModel().c0());
        }
        NewSubPbActivity newSubPbActivity = this.f57445c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f57443a.t0(this.f57445c.getSubPbModel().u0());
        }
        this.f57446d.setData(list);
        this.f57446d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.f57451i = z;
    }

    public void g(boolean z) {
        this.f57450h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f57443a.d(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f57443a.p(xVar);
    }
}
