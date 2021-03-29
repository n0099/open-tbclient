package d.b.i0.y.a.d;

import com.baidu.tieba.chosen.posts.request.ChosenPostCacheModel;
import d.b.h0.g0.b.d;
import d.b.h0.g0.b.g;
import d.b.h0.z0.w;
import java.util.HashMap;
import tbclient.HotThread.DataReq;
import tbclient.HotThread.HotThreadReqIdl;
/* loaded from: classes4.dex */
public class a implements g, d {

    /* renamed from: e  reason: collision with root package name */
    public int f62559e;

    public void b() {
        this.f62559e++;
    }

    @Override // d.b.h0.g0.b.i
    public Object e(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.pn = Integer.valueOf(this.f62559e);
        HotThreadReqIdl.Builder builder2 = new HotThreadReqIdl.Builder();
        DataReq build = builder.build(false);
        builder2.data = build;
        w.a(build, true);
        return builder2.build(false);
    }

    @Override // d.b.h0.g0.b.c
    public String getCacheKey() {
        return ChosenPostCacheModel.CACHE_KEY;
    }

    @Override // d.b.h0.g0.b.d
    public boolean isNeedUid() {
        return false;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, Object> k() {
        return null;
    }

    @Override // d.b.h0.g0.b.f
    public HashMap<String, String> p() {
        return null;
    }

    @Override // d.b.h0.g0.b.d
    public String q() {
        return "tb.pb_normal";
    }

    @Override // d.b.h0.g0.b.d
    public boolean r() {
        return true;
    }
}
