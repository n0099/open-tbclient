package d.b.i0.d1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f53823a;

    /* renamed from: b  reason: collision with root package name */
    public String f53824b;

    /* renamed from: c  reason: collision with root package name */
    public String f53825c;

    /* renamed from: d  reason: collision with root package name */
    public long f53826d;

    /* renamed from: e  reason: collision with root package name */
    public int f53827e;

    /* renamed from: f  reason: collision with root package name */
    public long f53828f;

    /* renamed from: g  reason: collision with root package name */
    public int f53829g;

    /* renamed from: h  reason: collision with root package name */
    public String f53830h;
    public int i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.i;
    }

    public long b() {
        return this.f53828f;
    }

    public String c() {
        return this.f53824b;
    }

    public String d() {
        return this.f53830h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f53825c;
    }

    public long g() {
        return this.f53826d;
    }

    public int h() {
        return this.f53827e;
    }

    public int i() {
        return this.f53829g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f53823a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f53828f = broadcastInfo.bcast_id.longValue();
        this.f53823a = broadcastInfo.title;
        this.f53824b = broadcastInfo.content;
        this.f53825c = broadcastInfo.pic_url;
        this.f53826d = broadcastInfo.publish_time.intValue();
        this.f53827e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f53830h = broadcastInfo.ctr;
        this.f53829g = broadcastInfo.pv.intValue();
        this.i = broadcastInfo.audit_status.intValue();
    }
}
