package d.a.j0.d2.h;

import java.util.List;
import tbclient.ManagerElection;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public boolean f52036a;

    /* renamed from: b  reason: collision with root package name */
    public int f52037b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f52038c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f52039d;

    /* renamed from: e  reason: collision with root package name */
    public String f52040e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52041f;

    /* renamed from: g  reason: collision with root package name */
    public int f52042g;

    /* renamed from: h  reason: collision with root package name */
    public int f52043h;

    public static k i(ManagerElection managerElection) {
        if (managerElection == null) {
            return null;
        }
        k kVar = new k();
        managerElection.begin_vote_time.intValue();
        kVar.f52036a = managerElection.can_vote.intValue() == 1;
        kVar.f52037b = managerElection.vote_num.intValue();
        kVar.f52041f = managerElection.is_show_distribute.intValue() == 1;
        kVar.f52042g = managerElection.remainder_time.intValue();
        kVar.f52043h = managerElection.status.intValue();
        kVar.f52040e = managerElection.tail_text;
        List<String> list = managerElection.vote_condition_pic;
        kVar.f52038c = managerElection.vote_condition_title;
        kVar.f52039d = managerElection.vote_condition;
        return kVar;
    }

    public boolean a() {
        return this.f52036a;
    }

    public boolean b() {
        return this.f52041f;
    }

    public int c() {
        return this.f52042g;
    }

    public int d() {
        return this.f52043h;
    }

    public String e() {
        return this.f52040e;
    }

    public List<String> f() {
        return this.f52039d;
    }

    public List<String> g() {
        return this.f52038c;
    }

    public int h() {
        return this.f52037b;
    }

    public void j(boolean z) {
        this.f52036a = z;
    }

    public void k(int i2) {
        this.f52043h = i2;
    }

    public void l(int i2) {
        this.f52037b = i2;
    }
}
