package d.a.j0.d2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.d2.k.g.e.b f52716a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f52717b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f52718c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f52719d;

    /* renamed from: g  reason: collision with root package name */
    public w f52722g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52720e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f52721f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52723h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52724i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f52718c = newSubPbActivity;
        this.f52719d = bdTypeListView;
    }

    public boolean a() {
        return this.f52723h;
    }

    public void b() {
        d.a.j0.d2.k.g.e.b bVar = new d.a.j0.d2.k.g.e.b(this.f52718c, PostData.p0);
        this.f52716a = bVar;
        bVar.e(this.f52721f);
        this.f52716a.Z(this.f52722g);
        this.f52716a.setFromCDN(this.f52724i);
        this.f52720e.add(this.f52716a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f52718c, d.a.j0.d2.k.g.f.b.f52744f);
        this.f52717b = subPbReplyAdapter;
        this.f52720e.add(subPbReplyAdapter);
        this.f52720e.add(new d.a.j0.d2.k.g.e.c(this.f52718c, d.a.j0.d2.k.g.f.a.f52743e));
        this.f52719d.a(this.f52720e);
    }

    public void c() {
        if (this.f52719d.getAdapter2() != null) {
            this.f52719d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f52721f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f52716a.v0(a2Var);
        if (!k.isEmpty(this.f52718c.getSubPbModel().U())) {
            this.f52716a.u0(this.f52718c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f52718c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f52716a.t0(this.f52718c.getSubPbModel().k0());
        }
        this.f52719d.setData(list);
        this.f52719d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.f52724i = z;
    }

    public void g(boolean z) {
        this.f52723h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f52716a.d(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f52716a.o(xVar);
    }
}
