package d.a.n0.r0.f2.a;

import d.a.m0.g0.b.g;
import d.a.m0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f62248e;

    /* renamed from: f  reason: collision with root package name */
    public long f62249f;

    /* renamed from: g  reason: collision with root package name */
    public String f62250g;

    /* renamed from: h  reason: collision with root package name */
    public int f62251h;

    /* renamed from: i  reason: collision with root package name */
    public int f62252i;

    @Override // d.a.m0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.a.c.e.m.b.f(this.f62250g, 0L));
        builder.thread_id = Long.valueOf(this.f62249f);
        builder.req_type = Integer.valueOf(this.f62251h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, Object> s() {
        return null;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, String> u() {
        return null;
    }
}
