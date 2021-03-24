package d.b.i0.p0.f2.a;

import d.b.h0.g0.b.g;
import d.b.h0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f57496e;

    /* renamed from: f  reason: collision with root package name */
    public long f57497f;

    /* renamed from: g  reason: collision with root package name */
    public String f57498g;

    /* renamed from: h  reason: collision with root package name */
    public int f57499h;
    public int i;

    @Override // d.b.h0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.b.b.e.m.b.f(this.f57498g, 0L));
        builder.thread_id = Long.valueOf(this.f57497f);
        builder.req_type = Integer.valueOf(this.f57499h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, Object> k() {
        return null;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, String> p() {
        return null;
    }
}
