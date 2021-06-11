package d.a.n0.n2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.k;
import d.a.c.k.e.n;
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
    public i f61417a;

    /* renamed from: b  reason: collision with root package name */
    public j f61418b;

    /* renamed from: c  reason: collision with root package name */
    public c f61419c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f61420d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f61421e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f61422f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f61422f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f61417a = new i(tbPageContext);
        this.f61418b = new j(tbPageContext, d.a.n0.j2.e.j.f60109f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f61419c = eVar;
        this.f61418b.h0(eVar);
        this.f61420d.add(this.f61417a);
        this.f61420d.add(this.f61418b);
        this.f61422f.a(this.f61420d);
    }

    public void b() {
        if (this.f61422f.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f61422f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f61422f != null && (arrayList = this.f61421e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14333f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f61421e);
                this.f61421e = mergeDynamicThreadByTime;
                this.f61422f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f61422f == null) {
            return;
        }
        this.f61421e.clear();
        this.f61421e.addAll(arrayList);
        this.f61422f.setData(this.f61421e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f61422f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
