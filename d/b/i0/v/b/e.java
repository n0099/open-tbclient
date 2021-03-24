package d.b.i0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f61912a;

    /* renamed from: b  reason: collision with root package name */
    public long f61913b;

    /* renamed from: c  reason: collision with root package name */
    public long f61914c;

    /* renamed from: d  reason: collision with root package name */
    public int f61915d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f61916e;

    /* renamed from: f  reason: collision with root package name */
    public int f61917f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61918g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f61919h;

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
        return this.f61918g;
    }

    public int b() {
        return this.f61917f;
    }

    public long c() {
        return this.f61912a;
    }

    public long d() {
        return this.f61914c;
    }

    public NoticeContent e() {
        return this.f61919h;
    }

    public long f() {
        return this.f61916e;
    }

    public int g() {
        return this.f61915d;
    }

    public long h() {
        return this.f61913b;
    }

    public void k(boolean z) {
        this.f61918g = z;
    }

    public void l(int i) {
        this.f61917f = i;
    }

    public void m(long j) {
        this.f61912a = j;
    }

    public void n(long j) {
        this.f61914c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f61919h = noticeContent;
    }

    public void p(long j) {
        this.f61916e = j;
    }

    public void q(int i) {
        this.f61915d = i;
    }

    public void r(int i) {
    }

    public void s(long j) {
        this.f61913b = j;
    }
}
