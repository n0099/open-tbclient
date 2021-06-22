package d.a.o0.x.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f66998a;

    /* renamed from: b  reason: collision with root package name */
    public long f66999b;

    /* renamed from: c  reason: collision with root package name */
    public long f67000c;

    /* renamed from: d  reason: collision with root package name */
    public int f67001d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f67002e;

    /* renamed from: f  reason: collision with root package name */
    public int f67003f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67004g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f67005h;

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
        return this.f67004g;
    }

    public int b() {
        return this.f67003f;
    }

    public long c() {
        return this.f66998a;
    }

    public long d() {
        return this.f67000c;
    }

    public NoticeContent e() {
        return this.f67005h;
    }

    public long f() {
        return this.f67002e;
    }

    public int g() {
        return this.f67001d;
    }

    public long h() {
        return this.f66999b;
    }

    public void k(boolean z) {
        this.f67004g = z;
    }

    public void l(int i2) {
        this.f67003f = i2;
    }

    public void m(long j) {
        this.f66998a = j;
    }

    public void n(long j) {
        this.f67000c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f67005h = noticeContent;
    }

    public void p(long j) {
        this.f67002e = j;
    }

    public void q(int i2) {
        this.f67001d = i2;
    }

    public void r(int i2) {
    }

    public void s(long j) {
        this.f66999b = j;
    }
}
