package d.a.o0.e2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56754a;

    /* renamed from: b  reason: collision with root package name */
    public int f56755b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f56756c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f56757d;

    /* renamed from: e  reason: collision with root package name */
    public String f56758e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56759f;

    /* renamed from: g  reason: collision with root package name */
    public int f56760g;

    /* renamed from: h  reason: collision with root package name */
    public int f56761h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f56754a = managerElection.can_vote.intValue() == 1;
        kVar.f56755b = managerElection.vote_num.intValue();
        kVar.f56759f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f56760g = managerElection.remainder_time.intValue();
        kVar.f56761h = managerElection.status.intValue();
        kVar.f56758e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f56756c = managerElection.vote_condition_title;
        kVar.f56757d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f56754a;
    }

    public boolean b() {
        return this.f56759f;
    }

    public int c() {
        return this.f56760g;
    }

    public int d() {
        return this.f56761h;
    }

    public String e() {
        return this.f56758e;
    }

    public List<String> f() {
        return this.f56757d;
    }

    public List<String> g() {
        return this.f56756c;
    }

    public int h() {
        return this.f56755b;
    }

    public void j(boolean z) {
        this.f56754a = z;
    }

    public void k(int i2) {
        this.f56761h = i2;
    }

    public void l(int i2) {
        this.f56755b = i2;
    }
}
