package d.b.j0.m2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.b.c.e.p.k;
import d.b.c.j.e.n;
import d.b.j0.h2.e;
import d.b.j0.i2.c.i;
import d.b.j0.i2.c.j;
import d.b.j0.i2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f58826a;

    /* renamed from: b  reason: collision with root package name */
    public j f58827b;

    /* renamed from: c  reason: collision with root package name */
    public c f58828c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f58829d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f58830e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f58831f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f58831f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f58826a = new i(tbPageContext);
        this.f58827b = new j(tbPageContext, d.b.j0.i2.e.j.f57576f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f58828c = eVar;
        this.f58827b.j0(eVar);
        this.f58829d.add(this.f58826a);
        this.f58829d.add(this.f58827b);
        this.f58831f.a(this.f58829d);
    }

    public void b() {
        if (this.f58831f.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f58831f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f58831f != null && (arrayList = this.f58830e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14947f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f58830e);
                this.f58830e = mergeDynamicThreadByTime;
                this.f58831f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f58831f == null) {
            return;
        }
        this.f58830e.clear();
        this.f58830e.addAll(arrayList);
        this.f58831f.setData(this.f58830e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f58831f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
