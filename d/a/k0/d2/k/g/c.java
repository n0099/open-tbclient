package d.a.k0.d2.k.g;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.adapter.SubPbReplyAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public d.a.k0.d2.k.g.e.b f53419a;

    /* renamed from: b  reason: collision with root package name */
    public SubPbReplyAdapter f53420b;

    /* renamed from: c  reason: collision with root package name */
    public NewSubPbActivity f53421c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeListView f53422d;

    /* renamed from: g  reason: collision with root package name */
    public w f53425g;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f53423e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f53424f = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f53426h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f53427i = true;

    public c(NewSubPbActivity newSubPbActivity, BdTypeListView bdTypeListView) {
        this.f53421c = newSubPbActivity;
        this.f53422d = bdTypeListView;
    }

    public boolean a() {
        return this.f53426h;
    }

    public void b() {
        d.a.k0.d2.k.g.e.b bVar = new d.a.k0.d2.k.g.e.b(this.f53421c, PostData.p0);
        this.f53419a = bVar;
        bVar.e(this.f53424f);
        this.f53419a.Z(this.f53425g);
        this.f53419a.setFromCDN(this.f53427i);
        this.f53423e.add(this.f53419a);
        SubPbReplyAdapter subPbReplyAdapter = new SubPbReplyAdapter(this.f53421c, d.a.k0.d2.k.g.f.b.f53447f);
        this.f53420b = subPbReplyAdapter;
        this.f53423e.add(subPbReplyAdapter);
        this.f53423e.add(new d.a.k0.d2.k.g.e.c(this.f53421c, d.a.k0.d2.k.g.f.a.f53446e));
        this.f53422d.a(this.f53423e);
    }

    public void c() {
        if (this.f53422d.getAdapter2() != null) {
            this.f53422d.getAdapter2().notifyDataSetChanged();
        }
    }

    public void d(View.OnClickListener onClickListener) {
        this.f53424f = onClickListener;
    }

    public void e(a2 a2Var, List<n> list) {
        this.f53419a.v0(a2Var);
        if (!k.isEmpty(this.f53421c.getSubPbModel().U())) {
            this.f53419a.u0(this.f53421c.getSubPbModel().U());
        }
        NewSubPbActivity newSubPbActivity = this.f53421c;
        if (newSubPbActivity != null && newSubPbActivity.getSubPbModel() != null) {
            this.f53419a.t0(this.f53421c.getSubPbModel().k0());
        }
        this.f53422d.setData(list);
        this.f53422d.getAdapter2().notifyDataSetChanged();
    }

    public void f(boolean z) {
        this.f53427i = z;
    }

    public void g(boolean z) {
        this.f53426h = z;
    }

    public void h(View.OnLongClickListener onLongClickListener) {
        this.f53419a.d(onLongClickListener);
    }

    public void i(TbRichTextView.x xVar) {
        this.f53419a.o(xVar);
    }
}
