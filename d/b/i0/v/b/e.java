package d.b.i0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f61913a;

    /* renamed from: b  reason: collision with root package name */
    public long f61914b;

    /* renamed from: c  reason: collision with root package name */
    public long f61915c;

    /* renamed from: d  reason: collision with root package name */
    public int f61916d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f61917e;

    /* renamed from: f  reason: collision with root package name */
    public int f61918f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61919g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f61920h;

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
        return this.f61919g;
    }

    public int b() {
        return this.f61918f;
    }

    public long c() {
        return this.f61913a;
    }

    public long d() {
        return this.f61915c;
    }

    public NoticeContent e() {
        return this.f61920h;
    }

    public long f() {
        return this.f61917e;
    }

    public int g() {
        return this.f61916d;
    }

    public long h() {
        return this.f61914b;
    }

    public void k(boolean z) {
        this.f61919g = z;
    }

    public void l(int i) {
        this.f61918f = i;
    }

    public void m(long j) {
        this.f61913a = j;
    }

    public void n(long j) {
        this.f61915c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f61920h = noticeContent;
    }

    public void p(long j) {
        this.f61917e = j;
    }

    public void q(int i) {
        this.f61916d = i;
    }

    public void r(int i) {
    }

    public void s(long j) {
        this.f61914b = j;
    }
}
