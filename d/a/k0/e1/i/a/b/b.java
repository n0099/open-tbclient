package d.a.k0.e1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f54329a;

    /* renamed from: b  reason: collision with root package name */
    public String f54330b;

    /* renamed from: c  reason: collision with root package name */
    public String f54331c;

    /* renamed from: d  reason: collision with root package name */
    public long f54332d;

    /* renamed from: e  reason: collision with root package name */
    public int f54333e;

    /* renamed from: f  reason: collision with root package name */
    public long f54334f;

    /* renamed from: g  reason: collision with root package name */
    public int f54335g;

    /* renamed from: h  reason: collision with root package name */
    public String f54336h;

    /* renamed from: i  reason: collision with root package name */
    public int f54337i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.f54337i;
    }

    public long b() {
        return this.f54334f;
    }

    public String c() {
        return this.f54330b;
    }

    public String d() {
        return this.f54336h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f54331c;
    }

    public long g() {
        return this.f54332d;
    }

    public int h() {
        return this.f54333e;
    }

    public int i() {
        return this.f54335g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f54329a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f54334f = broadcastInfo.bcast_id.longValue();
        this.f54329a = broadcastInfo.title;
        this.f54330b = broadcastInfo.content;
        this.f54331c = broadcastInfo.pic_url;
        this.f54332d = broadcastInfo.publish_time.intValue();
        this.f54333e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f54336h = broadcastInfo.ctr;
        this.f54335g = broadcastInfo.pv.intValue();
        this.f54337i = broadcastInfo.audit_status.intValue();
    }
}
