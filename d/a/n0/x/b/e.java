package d.a.n0.x.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66873a;

    /* renamed from: b  reason: collision with root package name */
    public long f66874b;

    /* renamed from: c  reason: collision with root package name */
    public long f66875c;

    /* renamed from: d  reason: collision with root package name */
    public int f66876d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f66877e;

    /* renamed from: f  reason: collision with root package name */
    public int f66878f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66879g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f66880h;

    public static e i(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.p(j(basic.remind_time));
        eVar.q(basic.status.intValue());
        eVar.l(basic.candidate_num.intValue());
        eVar.r(basic.total_vote_num.intValue());
        eVar.m(j(basic.begin_apply_time));
        eVar.s(j(basic.begin_vote_time));
        eVar.n(j(basic.begin_public_time));
        eVar.k(basic.is_voted.booleanValue());
        eVar.o(basic.notice);
        return eVar;
    }

    public static long j(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public boolean a() {
        return this.f66879g;
    }

    public int b() {
        return this.f66878f;
    }

    public long c() {
        return this.f66873a;
    }

    public long d() {
        return this.f66875c;
    }

    public NoticeContent e() {
        return this.f66880h;
    }

    public long f() {
        return this.f66877e;
    }

    public int g() {
        return this.f66876d;
    }

    public long h() {
        return this.f66874b;
    }

    public void k(boolean z) {
        this.f66879g = z;
    }

    public void l(int i2) {
        this.f66878f = i2;
    }

    public void m(long j) {
        this.f66873a = j;
    }

    public void n(long j) {
        this.f66875c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f66880h = noticeContent;
    }

    public void p(long j) {
        this.f66877e = j;
    }

    public void q(int i2) {
        this.f66876d = i2;
    }

    public void r(int i2) {
    }

    public void s(long j) {
        this.f66874b = j;
    }
}
