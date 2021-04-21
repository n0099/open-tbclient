package d.b.j0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f63343a;

    /* renamed from: b  reason: collision with root package name */
    public long f63344b;

    /* renamed from: c  reason: collision with root package name */
    public long f63345c;

    /* renamed from: d  reason: collision with root package name */
    public int f63346d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63347e;

    /* renamed from: f  reason: collision with root package name */
    public int f63348f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63349g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f63350h;

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
        return this.f63349g;
    }

    public int b() {
        return this.f63348f;
    }

    public long c() {
        return this.f63343a;
    }

    public long d() {
        return this.f63345c;
    }

    public NoticeContent e() {
        return this.f63350h;
    }

    public long f() {
        return this.f63347e;
    }

    public int g() {
        return this.f63346d;
    }

    public long h() {
        return this.f63344b;
    }

    public void k(boolean z) {
        this.f63349g = z;
    }

    public void l(int i) {
        this.f63348f = i;
    }

    public void m(long j) {
        this.f63343a = j;
    }

    public void n(long j) {
        this.f63345c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f63350h = noticeContent;
    }

    public void p(long j) {
        this.f63347e = j;
    }

    public void q(int i) {
        this.f63346d = i;
    }

    public void r(int i) {
    }

    public void s(long j) {
        this.f63344b = j;
    }
}
