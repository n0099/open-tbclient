package d.a.j0.i0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.o1;
import d.a.i0.r.q.u1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f55178a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f55179b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f55180c;

    /* renamed from: d  reason: collision with root package name */
    public c f55181d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55182e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f55178a = this.f55178a;
        aVar.f55179b = this.f55179b;
        aVar.f55180c = this.f55180c;
        aVar.f55181d = this.f55181d;
        aVar.f55182e = this.f55182e;
        return aVar;
    }

    public c b() {
        return this.f55181d;
    }

    public o1 c() {
        return this.f55180c;
    }

    public ArrayList<u1> d() {
        return this.f55179b;
    }

    public ArrayList<n> e() {
        return this.f55178a;
    }

    public boolean f() {
        return this.f55182e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55178a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.f55178a.add(a2Var);
        }
        this.f55179b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.h(generalResource);
                this.f55179b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f55180c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f55181d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f55191a = hotUserRankEntry.hot_user;
            cVar.f55192b = hotUserRankEntry.module_name;
            cVar.f55193c = hotUserRankEntry.module_icon;
        }
        this.f55182e = dataRes.is_new_url.intValue() == 1;
    }
}
