package d.b.j0.e1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55767a;

    /* renamed from: b  reason: collision with root package name */
    public String f55768b;

    /* renamed from: c  reason: collision with root package name */
    public String f55769c;

    /* renamed from: d  reason: collision with root package name */
    public long f55770d;

    /* renamed from: e  reason: collision with root package name */
    public int f55771e;

    /* renamed from: f  reason: collision with root package name */
    public long f55772f;

    /* renamed from: g  reason: collision with root package name */
    public int f55773g;

    /* renamed from: h  reason: collision with root package name */
    public String f55774h;
    public int i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.i;
    }

    public long b() {
        return this.f55772f;
    }

    public String c() {
        return this.f55768b;
    }

    public String d() {
        return this.f55774h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f55769c;
    }

    public long g() {
        return this.f55770d;
    }

    public int h() {
        return this.f55771e;
    }

    public int i() {
        return this.f55773g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f55767a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f55772f = broadcastInfo.bcast_id.longValue();
        this.f55767a = broadcastInfo.title;
        this.f55768b = broadcastInfo.content;
        this.f55769c = broadcastInfo.pic_url;
        this.f55770d = broadcastInfo.publish_time.intValue();
        this.f55771e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f55774h = broadcastInfo.ctr;
        this.f55773g = broadcastInfo.pv.intValue();
        this.i = broadcastInfo.audit_status.intValue();
    }
}
