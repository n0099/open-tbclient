package d.b.i0.i0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
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
    public ArrayList<n> f56825a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f56826b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f56827c;

    /* renamed from: d  reason: collision with root package name */
    public c f56828d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56829e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f56825a = this.f56825a;
        aVar.f56826b = this.f56826b;
        aVar.f56827c = this.f56827c;
        aVar.f56828d = this.f56828d;
        aVar.f56829e = this.f56829e;
        return aVar;
    }

    public c b() {
        return this.f56828d;
    }

    public o1 c() {
        return this.f56827c;
    }

    public ArrayList<u1> d() {
        return this.f56826b;
    }

    public ArrayList<n> e() {
        return this.f56825a;
    }

    public boolean f() {
        return this.f56829e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f56825a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.f56825a.add(a2Var);
        }
        this.f56826b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.g(generalResource);
                this.f56826b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f56827c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f56828d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f56838a = hotUserRankEntry.hot_user;
            cVar.f56839b = hotUserRankEntry.module_name;
            cVar.f56840c = hotUserRankEntry.module_icon;
        }
        this.f56829e = dataRes.is_new_url.intValue() == 1;
    }
}
