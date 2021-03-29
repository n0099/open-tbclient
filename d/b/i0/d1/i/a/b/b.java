package d.b.i0.d1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f53824a;

    /* renamed from: b  reason: collision with root package name */
    public String f53825b;

    /* renamed from: c  reason: collision with root package name */
    public String f53826c;

    /* renamed from: d  reason: collision with root package name */
    public long f53827d;

    /* renamed from: e  reason: collision with root package name */
    public int f53828e;

    /* renamed from: f  reason: collision with root package name */
    public long f53829f;

    /* renamed from: g  reason: collision with root package name */
    public int f53830g;

    /* renamed from: h  reason: collision with root package name */
    public String f53831h;
    public int i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.i;
    }

    public long b() {
        return this.f53829f;
    }

    public String c() {
        return this.f53825b;
    }

    public String d() {
        return this.f53831h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f53826c;
    }

    public long g() {
        return this.f53827d;
    }

    public int h() {
        return this.f53828e;
    }

    public int i() {
        return this.f53830g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f53824a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f53829f = broadcastInfo.bcast_id.longValue();
        this.f53824a = broadcastInfo.title;
        this.f53825b = broadcastInfo.content;
        this.f53826c = broadcastInfo.pic_url;
        this.f53827d = broadcastInfo.publish_time.intValue();
        this.f53828e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f53831h = broadcastInfo.ctr;
        this.f53830g = broadcastInfo.pv.intValue();
        this.i = broadcastInfo.audit_status.intValue();
    }
}
