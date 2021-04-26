package d.a.j0.e1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f53622a;

    /* renamed from: b  reason: collision with root package name */
    public String f53623b;

    /* renamed from: c  reason: collision with root package name */
    public String f53624c;

    /* renamed from: d  reason: collision with root package name */
    public long f53625d;

    /* renamed from: e  reason: collision with root package name */
    public int f53626e;

    /* renamed from: f  reason: collision with root package name */
    public long f53627f;

    /* renamed from: g  reason: collision with root package name */
    public int f53628g;

    /* renamed from: h  reason: collision with root package name */
    public String f53629h;

    /* renamed from: i  reason: collision with root package name */
    public int f53630i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.f53630i;
    }

    public long b() {
        return this.f53627f;
    }

    public String c() {
        return this.f53623b;
    }

    public String d() {
        return this.f53629h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f53624c;
    }

    public long g() {
        return this.f53625d;
    }

    public int h() {
        return this.f53626e;
    }

    public int i() {
        return this.f53628g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f53622a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f53627f = broadcastInfo.bcast_id.longValue();
        this.f53622a = broadcastInfo.title;
        this.f53623b = broadcastInfo.content;
        this.f53624c = broadcastInfo.pic_url;
        this.f53625d = broadcastInfo.publish_time.intValue();
        this.f53626e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f53629h = broadcastInfo.ctr;
        this.f53628g = broadcastInfo.pv.intValue();
        this.f53630i = broadcastInfo.audit_status.intValue();
    }
}
