package d.b.i0.c2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52438a;

    /* renamed from: b  reason: collision with root package name */
    public int f52439b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f52440c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f52441d;

    /* renamed from: e  reason: collision with root package name */
    public String f52442e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52443f;

    /* renamed from: g  reason: collision with root package name */
    public int f52444g;

    /* renamed from: h  reason: collision with root package name */
    public int f52445h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f52438a = managerElection.can_vote.intValue() == 1;
        kVar.f52439b = managerElection.vote_num.intValue();
        kVar.f52443f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f52444g = managerElection.remainder_time.intValue();
        kVar.f52445h = managerElection.status.intValue();
        kVar.f52442e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f52440c = managerElection.vote_condition_title;
        kVar.f52441d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f52438a;
    }

    public boolean b() {
        return this.f52443f;
    }

    public int c() {
        return this.f52444g;
    }

    public int d() {
        return this.f52445h;
    }

    public String e() {
        return this.f52442e;
    }

    public List<String> f() {
        return this.f52441d;
    }

    public List<String> g() {
        return this.f52440c;
    }

    public int h() {
        return this.f52439b;
    }

    public void j(boolean z) {
        this.f52438a = z;
    }

    public void k(int i) {
        this.f52445h = i;
    }

    public void l(int i) {
        this.f52439b = i;
    }
}
