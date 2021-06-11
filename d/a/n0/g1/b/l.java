package d.a.n0.g1.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import d.a.m0.z0.w;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes4.dex */
public class l implements d.a.m0.g0.b.g, d.a.m0.g0.b.d {

    /* renamed from: e  reason: collision with root package name */
    public int f58762e;

    /* renamed from: f  reason: collision with root package name */
    public int f58763f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f58764g;

    public int a() {
        return this.f58762e;
    }

    public void b() {
        this.f58763f = 1;
        this.f58762e = 1;
        this.f58764g = null;
    }

    public void c(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        this.f58764g = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    public void d() {
        this.f58763f++;
        this.f58762e = 4;
    }

    @Override // d.a.m0.g0.b.i
    public Object e(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.f58763f);
            builder.ids = this.f58764g;
            builder.q_type = Integer.valueOf(d.a.m0.r.k.c().e());
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            builder.scr_h = Integer.valueOf(d.a.c.e.p.l.i(TbadkCoreApplication.getInst().getApp()));
            builder.scr_w = Integer.valueOf(d.a.c.e.p.l.k(TbadkCoreApplication.getInst().getApp()));
            if (z) {
                w.a(builder, true);
            }
            ReplyMeReqIdl.Builder builder2 = new ReplyMeReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getCacheKey() {
        return "replyme_cache";
    }

    @Override // d.a.m0.g0.b.d
    public boolean isNeedUid() {
        return true;
    }

    public boolean l() {
        return true;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, Object> s() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        hashMap.put(Config.PACKAGE_NAME, String.valueOf(this.f58763f));
        hashMap.put("q_type", Integer.valueOf(d.a.m0.r.k.c().e()));
        hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
        hashMap.put("scr_h", Integer.valueOf(d.a.c.e.p.l.i(TbadkCoreApplication.getInst().getApp())));
        hashMap.put("scr_w", Integer.valueOf(d.a.c.e.p.l.k(TbadkCoreApplication.getInst().getApp())));
        if (this.f58762e == 4 && !TextUtils.isEmpty(this.f58764g)) {
            hashMap.put("ids", this.f58764g);
        }
        return hashMap;
    }

    @Override // d.a.m0.g0.b.f
    public HashMap<String, String> u() {
        return null;
    }

    public String v() {
        return "tb_user_replyme";
    }
}
