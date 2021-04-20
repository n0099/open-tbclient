package d.b.i0.d2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53834a;

    /* renamed from: b  reason: collision with root package name */
    public int f53835b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f53836c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f53837d;

    /* renamed from: e  reason: collision with root package name */
    public String f53838e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53839f;

    /* renamed from: g  reason: collision with root package name */
    public int f53840g;

    /* renamed from: h  reason: collision with root package name */
    public int f53841h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f53834a = managerElection.can_vote.intValue() == 1;
        kVar.f53835b = managerElection.vote_num.intValue();
        kVar.f53839f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f53840g = managerElection.remainder_time.intValue();
        kVar.f53841h = managerElection.status.intValue();
        kVar.f53838e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f53836c = managerElection.vote_condition_title;
        kVar.f53837d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f53834a;
    }

    public boolean b() {
        return this.f53839f;
    }

    public int c() {
        return this.f53840g;
    }

    public int d() {
        return this.f53841h;
    }

    public String e() {
        return this.f53838e;
    }

    public List<String> f() {
        return this.f53837d;
    }

    public List<String> g() {
        return this.f53836c;
    }

    public int h() {
        return this.f53835b;
    }

    public void j(boolean z) {
        this.f53834a = z;
    }

    public void k(int i) {
        this.f53841h = i;
    }

    public void l(int i) {
        this.f53835b = i;
    }
}
