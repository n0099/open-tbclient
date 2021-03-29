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
    public i f56776a;

    /* renamed from: b  reason: collision with root package name */
    public j f56777b;

    /* renamed from: c  reason: collision with root package name */
    public c f56778c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.b.j.e.a> f56779d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f56780e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56781f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56781f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f56776a = new i(tbPageContext);
        this.f56777b = new j(tbPageContext, d.b.i0.h2.e.j.f55297f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f56778c = eVar;
        this.f56777b.j0(eVar);
        this.f56779d.add(this.f56776a);
        this.f56779d.add(this.f56777b);
        this.f56781f.a(this.f56779d);
    }

    public void b() {
        if (this.f56781f.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f56781f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f56781f != null && (arrayList = this.f56780e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f15276f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f56780e);
                this.f56780e = mergeDynamicThreadByTime;
                this.f56781f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f56781f == null) {
            return;
        }
        this.f56780e.clear();
        this.f56780e.addAll(arrayList);
        this.f56781f.setData(this.f56780e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f56781f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
