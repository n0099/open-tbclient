package d.b.i0.e1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55346a;

    /* renamed from: b  reason: collision with root package name */
    public String f55347b;

    /* renamed from: c  reason: collision with root package name */
    public String f55348c;

    /* renamed from: d  reason: collision with root package name */
    public long f55349d;

    /* renamed from: e  reason: collision with root package name */
    public int f55350e;

    /* renamed from: f  reason: collision with root package name */
    public long f55351f;

    /* renamed from: g  reason: collision with root package name */
    public int f55352g;

    /* renamed from: h  reason: collision with root package name */
    public String f55353h;
    public int i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.i;
    }

    public long b() {
        return this.f55351f;
    }

    public String c() {
        return this.f55347b;
    }

    public String d() {
        return this.f55353h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f55348c;
    }

    public long g() {
        return this.f55349d;
    }

    public int h() {
        return this.f55350e;
    }

    public int i() {
        return this.f55352g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f55346a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f55351f = broadcastInfo.bcast_id.longValue();
        this.f55346a = broadcastInfo.title;
        this.f55347b = broadcastInfo.content;
        this.f55348c = broadcastInfo.pic_url;
        this.f55349d = broadcastInfo.publish_time.intValue();
        this.f55350e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f55353h = broadcastInfo.ctr;
        this.f55352g = broadcastInfo.pv.intValue();
        this.i = broadcastInfo.audit_status.intValue();
    }
}
