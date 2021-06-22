package d.a.o0.r0.f2.a;

import d.a.n0.g0.b.g;
import d.a.n0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f62373e;

    /* renamed from: f  reason: collision with root package name */
    public long f62374f;

    /* renamed from: g  reason: collision with root package name */
    public String f62375g;

    /* renamed from: h  reason: collision with root package name */
    public int f62376h;

    /* renamed from: i  reason: collision with root package name */
    public int f62377i;

    @Override // d.a.n0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.a.c.e.m.b.f(this.f62375g, 0L));
        builder.thread_id = Long.valueOf(this.f62374f);
        builder.req_type = Integer.valueOf(this.f62376h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.a.n0.g0.b.f
    public HashMap<String, Object> s() {
        return null;
    }

    @Override // d.a.n0.g0.b.f
    public HashMap<String, String> u() {
        return null;
    }
}
