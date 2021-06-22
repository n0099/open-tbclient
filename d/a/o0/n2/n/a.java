package d.a.o0.n2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
import d.a.o0.i2.e;
import d.a.o0.j2.c.i;
import d.a.o0.j2.c.j;
import d.a.o0.j2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f61542a;

    /* renamed from: b  reason: collision with root package name */
    public j f61543b;

    /* renamed from: c  reason: collision with root package name */
    public c f61544c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f61545d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f61546e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f61547f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61547f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f61542a = new i(tbPageContext);
        this.f61543b = new j(tbPageContext, d.a.o0.j2.e.j.f60234f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f61544c = eVar;
        this.f61543b.h0(eVar);
        this.f61545d.add(this.f61542a);
        this.f61545d.add(this.f61543b);
        this.f61547f.a(this.f61545d);
    }

    public void b() {
        if (this.f61547f.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f61547f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f61547f != null && (arrayList = this.f61546e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14415f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f61546e);
                this.f61546e = mergeDynamicThreadByTime;
                this.f61547f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f61547f == null) {
            return;
        }
        this.f61546e.clear();
        this.f61546e.addAll(arrayList);
        this.f61547f.setData(this.f61546e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f61547f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
