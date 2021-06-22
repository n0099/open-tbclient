package d.a.o0.f1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f58333a;

    /* renamed from: b  reason: collision with root package name */
    public String f58334b;

    /* renamed from: c  reason: collision with root package name */
    public String f58335c;

    /* renamed from: d  reason: collision with root package name */
    public long f58336d;

    /* renamed from: e  reason: collision with root package name */
    public int f58337e;

    /* renamed from: f  reason: collision with root package name */
    public long f58338f;

    /* renamed from: g  reason: collision with root package name */
    public int f58339g;

    /* renamed from: h  reason: collision with root package name */
    public String f58340h;

    /* renamed from: i  reason: collision with root package name */
    public int f58341i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.f58341i;
    }

    public long b() {
        return this.f58338f;
    }

    public String c() {
        return this.f58334b;
    }

    public String d() {
        return this.f58340h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f58335c;
    }

    public long g() {
        return this.f58336d;
    }

    public int h() {
        return this.f58337e;
    }

    public int i() {
        return this.f58339g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f58333a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f58338f = broadcastInfo.bcast_id.longValue();
        this.f58333a = broadcastInfo.title;
        this.f58334b = broadcastInfo.content;
        this.f58335c = broadcastInfo.pic_url;
        this.f58336d = broadcastInfo.publish_time.intValue();
        this.f58337e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f58340h = broadcastInfo.ctr;
        this.f58339g = broadcastInfo.pv.intValue();
        this.f58341i = broadcastInfo.audit_status.intValue();
    }
}
