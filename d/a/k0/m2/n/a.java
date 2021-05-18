package d.a.k0.m2.n;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.k0.h2.e;
import d.a.k0.i2.c.i;
import d.a.k0.i2.c.j;
import d.a.k0.i2.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public i f57548a;

    /* renamed from: b  reason: collision with root package name */
    public j f57549b;

    /* renamed from: c  reason: collision with root package name */
    public c f57550c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57551d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<n> f57552e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public BdTypeListView f57553f;

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.f57553f = bdTypeListView;
        a(tbPageContext);
    }

    public final void a(TbPageContext<?> tbPageContext) {
        this.f57548a = new i(tbPageContext);
        this.f57549b = new j(tbPageContext, d.a.k0.i2.e.j.f56236f);
        e eVar = new e(tbPageContext, this, tbPageContext.getUniqueId());
        this.f57550c = eVar;
        this.f57549b.g0(eVar);
        this.f57551d.add(this.f57548a);
        this.f57551d.add(this.f57549b);
        this.f57553f.a(this.f57551d);
    }

    public void b() {
        if (this.f57553f.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f57553f.getAdapter2().notifyDataSetChanged();
        }
    }

    public boolean c(String str) {
        ArrayList<n> arrayList;
        boolean z = false;
        if (k.isEmpty(str)) {
            return false;
        }
        if (this.f57553f != null && (arrayList = this.f57552e) != null) {
            Iterator<n> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if ((next instanceof CardPersonDynamicThreadData) && StringHelper.equals(str, ((CardPersonDynamicThreadData) next).f14373f)) {
                    z = true;
                    it.remove();
                    break;
                }
            }
            if (z) {
                ArrayList<n> mergeDynamicThreadByTime = PersonPostModel.mergeDynamicThreadByTime(this.f57552e);
                this.f57552e = mergeDynamicThreadByTime;
                this.f57553f.setData(mergeDynamicThreadByTime);
                b();
            }
        }
        return z;
    }

    public void d(ArrayList<n> arrayList) {
        if (arrayList == null || this.f57553f == null) {
            return;
        }
        this.f57552e.clear();
        this.f57552e.addAll(arrayList);
        this.f57553f.setData(this.f57552e);
    }

    public void e() {
        BdTypeListView bdTypeListView = this.f57553f;
        if (bdTypeListView != null) {
            bdTypeListView.F();
        }
    }
}
