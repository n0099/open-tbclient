package d.a.n0.f1.i.a.b;

import tbclient.BroadcastInfo;
import tbclient.RecommendForumInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f54519a;

    /* renamed from: b  reason: collision with root package name */
    public String f54520b;

    /* renamed from: c  reason: collision with root package name */
    public String f54521c;

    /* renamed from: d  reason: collision with root package name */
    public long f54522d;

    /* renamed from: e  reason: collision with root package name */
    public int f54523e;

    /* renamed from: f  reason: collision with root package name */
    public long f54524f;

    /* renamed from: g  reason: collision with root package name */
    public int f54525g;

    /* renamed from: h  reason: collision with root package name */
    public String f54526h;

    /* renamed from: i  reason: collision with root package name */
    public int f54527i;
    public RecommendForumInfo j;
    public ThreadInfo k;

    public int a() {
        return this.f54527i;
    }

    public long b() {
        return this.f54524f;
    }

    public String c() {
        return this.f54520b;
    }

    public String d() {
        return this.f54526h;
    }

    public RecommendForumInfo e() {
        return this.j;
    }

    public String f() {
        return this.f54521c;
    }

    public long g() {
        return this.f54522d;
    }

    public int h() {
        return this.f54523e;
    }

    public int i() {
        return this.f54525g;
    }

    public ThreadInfo j() {
        return this.k;
    }

    public String k() {
        return this.f54519a;
    }

    public void l(BroadcastInfo broadcastInfo) {
        if (broadcastInfo == null) {
            return;
        }
        this.f54524f = broadcastInfo.bcast_id.longValue();
        this.f54519a = broadcastInfo.title;
        this.f54520b = broadcastInfo.content;
        this.f54521c = broadcastInfo.pic_url;
        this.f54522d = broadcastInfo.publish_time.intValue();
        this.f54523e = broadcastInfo.pushuser_cnt.intValue();
        this.j = broadcastInfo.forum_info;
        this.k = broadcastInfo.thread_infos;
        this.f54526h = broadcastInfo.ctr;
        this.f54525g = broadcastInfo.pv.intValue();
        this.f54527i = broadcastInfo.audit_status.intValue();
    }
}
