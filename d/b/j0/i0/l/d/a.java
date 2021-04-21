package d.b.j0.i0.l.d;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.i0.r.q.o1;
import d.b.i0.r.q.u1;
import java.util.ArrayList;
import tbclient.GeneralResource;
import tbclient.HotUserRankEntry;
import tbclient.Tabfeedlist.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f57246a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<u1> f57247b;

    /* renamed from: c  reason: collision with root package name */
    public o1 f57248c;

    /* renamed from: d  reason: collision with root package name */
    public c f57249d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57250e;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public a clone() {
        a aVar = new a();
        aVar.f57246a = this.f57246a;
        aVar.f57247b = this.f57247b;
        aVar.f57248c = this.f57248c;
        aVar.f57249d = this.f57249d;
        aVar.f57250e = this.f57250e;
        return aVar;
    }

    public c b() {
        return this.f57249d;
    }

    public o1 c() {
        return this.f57248c;
    }

    public ArrayList<u1> d() {
        return this.f57247b;
    }

    public ArrayList<n> e() {
        return this.f57246a;
    }

    public boolean f() {
        return this.f57250e;
    }

    public void g(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57246a = new ArrayList<>(ListUtils.getCount(dataRes.thread_list));
        for (ThreadInfo threadInfo : dataRes.thread_list) {
            a2 a2Var = new a2();
            a2Var.R2(threadInfo);
            a2Var.J1();
            this.f57246a.add(a2Var);
        }
        this.f57247b = new ArrayList<>();
        if (!ListUtils.isEmpty(dataRes.resource_list)) {
            for (GeneralResource generalResource : dataRes.resource_list) {
                u1 u1Var = new u1();
                u1Var.g(generalResource);
                this.f57247b.add(u1Var);
            }
        }
        o1 o1Var = new o1();
        this.f57248c = o1Var;
        o1Var.C(dataRes.recommend_forum_info);
        if (dataRes.hot_userrank_entry != null) {
            c cVar = new c();
            this.f57249d = cVar;
            HotUserRankEntry hotUserRankEntry = dataRes.hot_userrank_entry;
            cVar.f57259a = hotUserRankEntry.hot_user;
            cVar.f57260b = hotUserRankEntry.module_name;
            cVar.f57261c = hotUserRankEntry.module_icon;
        }
        this.f57250e = dataRes.is_new_url.intValue() == 1;
    }
}
