package d.b.i0.m2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.i0.h2.e;
import d.b.i0.i2.c.i;
import d.b.i0.i2.c.j;
import d.b.i0.i2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f58405a;

    /* renamed from: b  reason: collision with root package name */
    public j f58406b;

    /* renamed from: c  reason: collision with root package name */
    public c f58407c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f58408d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f58409e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f58410f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f58410f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f58405a = new i(tbPageContext);
        this.f58406b = new j(tbPageContext, d.b.i0.i2.e.j.f57155f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f58407c = eVar;
        this.f58406b.j0(eVar);
        this.f58408d.add(this.f58405a);
        this.f58408d.add(this.f58406b);
        this.f58410f.a(this.f58408d);
    }

    public void b() {
        if (this.f58410f.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f58410f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f58410f != null && (arrayList = this.f58409e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14939f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f58409e);
                this.f58409e = mergeDynamicThreadByTime;
                this.f58410f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f58410f == null) {
            return;
        }
        this.f58409e.clear();
        this.f58409e.addAll(arrayList);
        this.f58410f.setData(this.f58409e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f58410f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
