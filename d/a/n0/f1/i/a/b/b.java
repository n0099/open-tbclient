package d.a.n0.f1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f58208a;

    /* renamed from: b  reason: collision with root package name */
    public String f58209b;

    /* renamed from: c  reason: collision with root package name */
    public String f58210c;

    /* renamed from: d  reason: collision with root package name */
    public long f58211d;

    /* renamed from: e  reason: collision with root package name */
    public int f58212e;

    /* renamed from: f  reason: collision with root package name */
    public long f58213f;

    /* renamed from: g  reason: collision with root package name */
    public int f58214g;

    /* renamed from: h  reason: collision with root package name */
    public String f58215h;

    /* renamed from: i  reason: collision with root package name */
    public int f58216i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.f58216i;
    }

    public long b() {
        return this.f58213f;
    }

    public String c() {
        return this.f58209b;
    }

    public String d() {
        return this.f58215h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f58210c;
    }

    public long g() {
        return this.f58211d;
    }

    public int h() {
        return this.f58212e;
    }

    public int i() {
        return this.f58214g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f58208a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f58213f = broadcastInfo.bcast_id.longValue();
        this.f58208a = broadcastInfo.title;
        this.f58209b = broadcastInfo.content;
        this.f58210c = broadcastInfo.pic_url;
        this.f58211d = broadcastInfo.publish_time.intValue();
        this.f58212e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f58215h = broadcastInfo.ctr;
        this.f58214g = broadcastInfo.pv.intValue();
        this.f58216i = broadcastInfo.audit_status.intValue();
    }
}
