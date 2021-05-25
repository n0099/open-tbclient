package d.a.n0.n2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.n0.i2.e;
import d.a.n0.j2.c.i;
import d.a.n0.j2.c.j;
import d.a.n0.j2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f57728a;

    /* renamed from: b  reason: collision with root package name */
    public j f57729b;

    /* renamed from: c  reason: collision with root package name */
    public c f57730c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57731d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f57732e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f57733f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f57733f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f57728a = new i(tbPageContext);
        this.f57729b = new j(tbPageContext, d.a.n0.j2.e.j.f56420f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f57730c = eVar;
        this.f57729b.g0(eVar);
        this.f57731d.add(this.f57728a);
        this.f57731d.add(this.f57729b);
        this.f57733f.a(this.f57731d);
    }

    public void b() {
        if (this.f57733f.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f57733f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f57733f != null && (arrayList = this.f57732e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14276f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f57732e);
                this.f57732e = mergeDynamicThreadByTime;
                this.f57733f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f57733f == null) {
            return;
        }
        this.f57732e.clear();
        this.f57732e.addAll(arrayList);
        this.f57733f.setData(this.f57732e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f57733f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
