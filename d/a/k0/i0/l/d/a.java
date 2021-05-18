package d.a.k0.i0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.o1;
import d.a.j0.r.q.u1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f55885a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f55886b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f55887c;

    /* renamed from: d  reason: collision with root package name */
    public c f55888d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55889e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f55885a = this.f55885a;
        aVar.f55886b = this.f55886b;
        aVar.f55887c = this.f55887c;
        aVar.f55888d = this.f55888d;
        aVar.f55889e = this.f55889e;
        return aVar;
    }

    public c b() {
        return this.f55888d;
    }

    public o1 c() {
        return this.f55887c;
    }

    public ArrayList<u1> d() {
        return this.f55886b;
    }

    public ArrayList<n> e() {
        return this.f55885a;
    }

    public boolean f() {
        return this.f55889e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55885a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.T2(threadInfo);
            a2Var.K1();
            this.f55885a.add(a2Var);
        }
        this.f55886b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.h(generalResource);
                this.f55886b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f55887c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f55888d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f55898a = hotUserRankEntry.hot_user;
            cVar.f55899b = hotUserRankEntry.module_name;
            cVar.f55900c = hotUserRankEntry.module_icon;
        }
        this.f55889e = dataRes.is_new_url.intValue() == 1;
    }
}
