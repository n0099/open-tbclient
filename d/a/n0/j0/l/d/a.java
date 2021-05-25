package d.a.n0.j0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
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
    public ArrayList<n> f56069a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f56070b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f56071c;

    /* renamed from: d  reason: collision with root package name */
    public c f56072d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56073e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f56069a = this.f56069a;
        aVar.f56070b = this.f56070b;
        aVar.f56071c = this.f56071c;
        aVar.f56072d = this.f56072d;
        aVar.f56073e = this.f56073e;
        return aVar;
    }

    public c b() {
        return this.f56072d;
    }

    public o1 c() {
        return this.f56071c;
    }

    public ArrayList<u1> d() {
        return this.f56070b;
    }

    public ArrayList<n> e() {
        return this.f56069a;
    }

    public boolean f() {
        return this.f56073e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f56069a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.U2(threadInfo);
            a2Var.L1();
            this.f56069a.add(a2Var);
        }
        this.f56070b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.h(generalResource);
                this.f56070b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f56071c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f56072d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f56082a = hotUserRankEntry.hot_user;
            cVar.f56083b = hotUserRankEntry.module_name;
            cVar.f56084c = hotUserRankEntry.module_icon;
        }
        this.f56073e = dataRes.is_new_url.intValue() == 1;
    }
}
