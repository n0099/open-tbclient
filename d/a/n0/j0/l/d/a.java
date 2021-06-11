package d.a.n0.j0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.o1;
import d.a.m0.r.q.u1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f59758a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f59759b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f59760c;

    /* renamed from: d  reason: collision with root package name */
    public c f59761d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59762e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f59758a = this.f59758a;
        aVar.f59759b = this.f59759b;
        aVar.f59760c = this.f59760c;
        aVar.f59761d = this.f59761d;
        aVar.f59762e = this.f59762e;
        return aVar;
    }

    public c b() {
        return this.f59761d;
    }

    public o1 c() {
        return this.f59760c;
    }

    public ArrayList<u1> d() {
        return this.f59759b;
    }

    public ArrayList<n> e() {
        return this.f59758a;
    }

    public boolean f() {
        return this.f59762e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59758a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.V2(threadInfo);
            a2Var.M1();
            this.f59758a.add(a2Var);
        }
        this.f59759b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.c(generalResource);
                this.f59759b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f59760c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f59761d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f59771a = hotUserRankEntry.hot_user;
            cVar.f59772b = hotUserRankEntry.module_name;
            cVar.f59773c = hotUserRankEntry.module_icon;
        }
        this.f59762e = dataRes.is_new_url.intValue() == 1;
    }
}
