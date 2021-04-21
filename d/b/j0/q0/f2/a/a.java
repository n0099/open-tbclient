package d.b.j0.q0.f2.a;

import d.b.i0.g0.b.g;
import d.b.i0.z0.w;
import java.util.HashMap;
import tbclient.ZoneRight.DataReq;
import tbclient.ZoneRight.ZoneRightReqIdl;
/* loaded from: classes4.dex */
public class a implements g {

    /* renamed from: e  reason: collision with root package name */
    public int f59617e;

    /* renamed from: f  reason: collision with root package name */
    public long f59618f;

    /* renamed from: g  reason: collision with root package name */
    public String f59619g;

    /* renamed from: h  reason: collision with root package name */
    public int f59620h;
    public int i;

    @Override // d.b.i0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        w.c(builder, true, false, true);
        builder.forum_id = Long.valueOf(d.b.c.e.m.b.f(this.f59619g, 0L));
        builder.thread_id = Long.valueOf(this.f59618f);
        builder.req_type = Integer.valueOf(this.f59620h == 1 ? 2 : 1);
        ZoneRightReqIdl.Builder builder2 = new ZoneRightReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    @Override // d.b.i0.g0.b.f
    public HashMap<String, Object> k() {
        return null;
    }

    @Override // d.b.i0.g0.b.f
    public HashMap<String, String> p() {
        return null;
    }
}
