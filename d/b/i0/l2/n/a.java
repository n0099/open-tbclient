package d.b.i0.l2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.b.b.e.p.k;
import d.b.b.j.e.n;
import d.b.i0.g2.e;
import d.b.i0.h2.c.i;
import d.b.i0.h2.c.j;
import d.b.i0.h2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f56775a;

    /* renamed from: b  reason: collision with root package name */
    public j f56776b;

    /* renamed from: c  reason: collision with root package name */
    public c f56777c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f56778d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f56779e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56780f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56780f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f56775a = new i(tbPageContext);
        this.f56776b = new j(tbPageContext, d.b.i0.h2.e.j.f55296f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f56777c = eVar;
        this.f56776b.j0(eVar);
        this.f56778d.add(this.f56775a);
        this.f56778d.add(this.f56776b);
        this.f56780f.a(this.f56778d);
    }

    public void b() {
        if (this.f56780f.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f56780f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f56780f != null && (arrayList = this.f56779e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f15275f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f56779e);
                this.f56779e = mergeDynamicThreadByTime;
                this.f56780f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f56780f == null) {
            return;
        }
        this.f56779e.clear();
        this.f56779e.addAll(arrayList);
        this.f56780f.setData(this.f56779e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f56780f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
