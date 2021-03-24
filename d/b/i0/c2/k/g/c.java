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
    public d.b.i0.c2.k.g.e.b f53066a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f53067b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f53068c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f53069d;

    /* renamed from: g  reason: collision with root package name */
    public w f53072g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f53070e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53071f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53073h = false;
    public boolean i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f53068c = newSubPbActivity;
        this.f53069d = bdTypeListView;
    }

    public boolean a() {
        return this.f53073h;
    }

    public void b() {
        d.b.i0.c2.k.g.e.b bVar = new d.b.i0.c2.k.g.e.b(this.f53068c, PostData.o0);
        this.f53066a = bVar;
        bVar.l(this.f53071f);
        this.f53066a.c0(this.f53072g);
        this.f53066a.setFromCDN(this.i);
        this.f53070e.add(this.f53066a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f53068c, d.b.i0.c2.k.g.f.b.f53093f);
        this.f53067b = subPbReplyAdapter;
        this.f53070e.add(subPbReplyAdapter);
        this.f53070e.add(new d.b.i0.c2.k.g.e.c(this.f53068c, d.b.i0.c2.k.g.f.a.f53092e));
        this.f53069d.a(this.f53070e);
    }

    public void c() {
        if (this.f53069d.getAdapter2() != null) {
            this.f53069d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f53071f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f53066a.v0(a2Var);
        if (!k.isEmpty(this.f53068c.getSubPbModel().U())) {
            this.f53066a.u0(this.f53068c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f53068c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f53066a.t0(this.f53068c.getSubPbModel().k0());
        }
        this.f53069d.setData(list);
        this.f53069d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.i = z;
    }

    public void g(boolean z) {
        this.f53073h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f53066a.k(onLongClickListener);
    }

    public void i(TbRichTextView.w wVar) {
        this.f53066a.j(wVar);
    }
}
