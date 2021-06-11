package d.a.n0.e2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.m0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e2.k.g.e.b f57318a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f57319b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f57320c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f57321d;

    /* renamed from: g  reason: collision with root package name */
    public w f57324g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f57322e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f57323f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57325h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57326i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f57320c = newSubPbActivity;
        this.f57321d = bdTypeListView;
    }

    public boolean a() {
        return this.f57325h;
    }

    public void b() {
        d.a.n0.e2.k.g.e.b bVar = new d.a.n0.e2.k.g.e.b(this.f57320c, PostData.p0);
        this.f57318a = bVar;
        bVar.e(this.f57323f);
        this.f57318a.a0(this.f57324g);
        this.f57318a.setFromCDN(this.f57326i);
        this.f57322e.add(this.f57318a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f57320c, d.a.n0.e2.k.g.f.b.f57346f);
        this.f57319b = subPbReplyAdapter;
        this.f57322e.add(subPbReplyAdapter);
        this.f57322e.add(new d.a.n0.e2.k.g.e.c(this.f57320c, d.a.n0.e2.k.g.f.a.f57345e));
        this.f57321d.a(this.f57322e);
    }

    public void c() {
        if (this.f57321d.getAdapter2() != null) {
            this.f57321d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f57323f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f57318a.w0(a2Var);
        if (!k.isEmpty(this.f57320c.getSubPbModel().c0())) {
            this.f57318a.v0(this.f57320c.getSubPbModel().c0());
        }
        NewSubPbActivity newSubPbActivity = this.f57320c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f57318a.t0(this.f57320c.getSubPbModel().u0());
        }
        this.f57321d.setData(list);
        this.f57321d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.f57326i = z;
    }

    public void g(boolean z) {
        this.f57325h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f57318a.d(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f57318a.p(xVar);
    }
}
