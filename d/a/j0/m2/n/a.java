package d.a.j0.m2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.j0.h2.e;
import d.a.j0.i2.c.i;
import d.a.j0.i2.c.j;
import d.a.j0.i2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f56841a;

    /* renamed from: b  reason: collision with root package name */
    public j f56842b;

    /* renamed from: c  reason: collision with root package name */
    public c f56843c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f56844d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f56845e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f56846f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f56846f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f56841a = new i(tbPageContext);
        this.f56842b = new j(tbPageContext, d.a.j0.i2.e.j.f55529f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f56843c = eVar;
        this.f56842b.g0(eVar);
        this.f56844d.add(this.f56841a);
        this.f56844d.add(this.f56842b);
        this.f56846f.a(this.f56844d);
    }

    public void b() {
        if (this.f56846f.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f56846f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f56846f != null && (arrayList = this.f56845e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f15058f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f56845e);
                this.f56845e = mergeDynamicThreadByTime;
                this.f56846f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f56846f == null) {
            return;
        }
        this.f56845e.clear();
        this.f56845e.addAll(arrayList);
        this.f56846f.setData(this.f56845e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f56846f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
