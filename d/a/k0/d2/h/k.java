package d.a.k0.d2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52735a;

    /* renamed from: b  reason: collision with root package name */
    public int f52736b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f52737c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f52738d;

    /* renamed from: e  reason: collision with root package name */
    public String f52739e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52740f;

    /* renamed from: g  reason: collision with root package name */
    public int f52741g;

    /* renamed from: h  reason: collision with root package name */
    public int f52742h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f52735a = managerElection.can_vote.intValue() == 1;
        kVar.f52736b = managerElection.vote_num.intValue();
        kVar.f52740f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f52741g = managerElection.remainder_time.intValue();
        kVar.f52742h = managerElection.status.intValue();
        kVar.f52739e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f52737c = managerElection.vote_condition_title;
        kVar.f52738d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f52735a;
    }

    public boolean b() {
        return this.f52740f;
    }

    public int c() {
        return this.f52741g;
    }

    public int d() {
        return this.f52742h;
    }

    public String e() {
        return this.f52739e;
    }

    public List<String> f() {
        return this.f52738d;
    }

    public List<String> g() {
        return this.f52737c;
    }

    public int h() {
        return this.f52736b;
    }

    public void j(boolean z) {
        this.f52735a = z;
    }

    public void k(int i2) {
        this.f52742h = i2;
    }

    public void l(int i2) {
        this.f52736b = i2;
    }
}
