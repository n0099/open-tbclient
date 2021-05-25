package d.a.n0.e2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52940a;

    /* renamed from: b  reason: collision with root package name */
    public int f52941b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f52942c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f52943d;

    /* renamed from: e  reason: collision with root package name */
    public String f52944e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52945f;

    /* renamed from: g  reason: collision with root package name */
    public int f52946g;

    /* renamed from: h  reason: collision with root package name */
    public int f52947h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f52940a = managerElection.can_vote.intValue() == 1;
        kVar.f52941b = managerElection.vote_num.intValue();
        kVar.f52945f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f52946g = managerElection.remainder_time.intValue();
        kVar.f52947h = managerElection.status.intValue();
        kVar.f52944e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f52942c = managerElection.vote_condition_title;
        kVar.f52943d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f52940a;
    }

    public boolean b() {
        return this.f52945f;
    }

    public int c() {
        return this.f52946g;
    }

    public int d() {
        return this.f52947h;
    }

    public String e() {
        return this.f52944e;
    }

    public List<String> f() {
        return this.f52943d;
    }

    public List<String> g() {
        return this.f52942c;
    }

    public int h() {
        return this.f52941b;
    }

    public void j(boolean z) {
        this.f52940a = z;
    }

    public void k(int i2) {
        this.f52947h = i2;
    }

    public void l(int i2) {
        this.f52941b = i2;
    }
}
