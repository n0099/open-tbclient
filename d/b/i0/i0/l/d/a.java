package d.b.i0.i0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.o1;
import d.b.h0.r.q.u1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f55701a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f55702b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f55703c;

    /* renamed from: d  reason: collision with root package name */
    public c f55704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55705e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f55701a = this.f55701a;
        aVar.f55702b = this.f55702b;
        aVar.f55703c = this.f55703c;
        aVar.f55704d = this.f55704d;
        aVar.f55705e = this.f55705e;
        return aVar;
    }

    public c b() {
        return this.f55704d;
    }

    public o1 c() {
        return this.f55703c;
    }

    public ArrayList<u1> d() {
        return this.f55702b;
    }

    public ArrayList<n> e() {
        return this.f55701a;
    }

    public boolean f() {
        return this.f55705e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55701a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.Q2(threadInfo);
            a2Var.J1();
            this.f55701a.add(a2Var);
        }
        this.f55702b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.g(generalResource);
                this.f55702b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f55703c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f55704d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f55714a = hotUserRankEntry.hot_user;
            cVar.f55715b = hotUserRankEntry.module_name;
            cVar.f55716c = hotUserRankEntry.module_icon;
        }
        this.f55705e = dataRes.is_new_url.intValue() == 1;
    }
}
