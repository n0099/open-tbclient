package d.b.i0.c2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52439a;

    /* renamed from: b  reason: collision with root package name */
    public int f52440b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f52441c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f52442d;

    /* renamed from: e  reason: collision with root package name */
    public String f52443e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52444f;

    /* renamed from: g  reason: collision with root package name */
    public int f52445g;

    /* renamed from: h  reason: collision with root package name */
    public int f52446h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f52439a = managerElection.can_vote.intValue() == 1;
        kVar.f52440b = managerElection.vote_num.intValue();
        kVar.f52444f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f52445g = managerElection.remainder_time.intValue();
        kVar.f52446h = managerElection.status.intValue();
        kVar.f52443e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f52441c = managerElection.vote_condition_title;
        kVar.f52442d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f52439a;
    }

    public boolean b() {
        return this.f52444f;
    }

    public int c() {
        return this.f52445g;
    }

    public int d() {
        return this.f52446h;
    }

    public String e() {
        return this.f52443e;
    }

    public List<String> f() {
        return this.f52442d;
    }

    public List<String> g() {
        return this.f52441c;
    }

    public int h() {
        return this.f52440b;
    }

    public void j(boolean z) {
        this.f52439a = z;
    }

    public void k(int i) {
        this.f52446h = i;
    }

    public void l(int i) {
        this.f52440b = i;
    }
}
