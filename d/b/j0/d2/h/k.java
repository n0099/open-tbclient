package d.b.j0.d2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f54255a;

    /* renamed from: b  reason: collision with root package name */
    public int f54256b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f54257c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f54258d;

    /* renamed from: e  reason: collision with root package name */
    public String f54259e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54260f;

    /* renamed from: g  reason: collision with root package name */
    public int f54261g;

    /* renamed from: h  reason: collision with root package name */
    public int f54262h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f54255a = managerElection.can_vote.intValue() == 1;
        kVar.f54256b = managerElection.vote_num.intValue();
        kVar.f54260f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f54261g = managerElection.remainder_time.intValue();
        kVar.f54262h = managerElection.status.intValue();
        kVar.f54259e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f54257c = managerElection.vote_condition_title;
        kVar.f54258d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f54255a;
    }

    public boolean b() {
        return this.f54260f;
    }

    public int c() {
        return this.f54261g;
    }

    public int d() {
        return this.f54262h;
    }

    public String e() {
        return this.f54259e;
    }

    public List<String> f() {
        return this.f54258d;
    }

    public List<String> g() {
        return this.f54257c;
    }

    public int h() {
        return this.f54256b;
    }

    public void j(boolean z) {
        this.f54255a = z;
    }

    public void k(int i) {
        this.f54262h = i;
    }

    public void l(int i) {
        this.f54256b = i;
    }
}
