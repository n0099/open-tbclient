package d.a.n0.e2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f56629a;

    /* renamed from: b  reason: collision with root package name */
    public int f56630b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f56631c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f56632d;

    /* renamed from: e  reason: collision with root package name */
    public String f56633e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56634f;

    /* renamed from: g  reason: collision with root package name */
    public int f56635g;

    /* renamed from: h  reason: collision with root package name */
    public int f56636h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f56629a = managerElection.can_vote.intValue() == 1;
        kVar.f56630b = managerElection.vote_num.intValue();
        kVar.f56634f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f56635g = managerElection.remainder_time.intValue();
        kVar.f56636h = managerElection.status.intValue();
        kVar.f56633e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f56631c = managerElection.vote_condition_title;
        kVar.f56632d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f56629a;
    }

    public boolean b() {
        return this.f56634f;
    }

    public int c() {
        return this.f56635g;
    }

    public int d() {
        return this.f56636h;
    }

    public String e() {
        return this.f56633e;
    }

    public List<String> f() {
        return this.f56632d;
    }

    public List<String> g() {
        return this.f56631c;
    }

    public int h() {
        return this.f56630b;
    }

    public void j(boolean z) {
        this.f56629a = z;
    }

    public void k(int i2) {
        this.f56636h = i2;
    }

    public void l(int i2) {
        this.f56630b = i2;
    }
}
