package d.b.j0.f1.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import d.b.i0.z0.w;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes4.dex */
public class l implements d.b.i0.g0.b.g, d.b.i0.g0.b.d {

    /* renamed from: e  reason: collision with root package name */
    public int f56296e;

    /* renamed from: f  reason: collision with root package name */
    public int f56297f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f56298g;

    public int b() {
        return this.f56296e;
    }

    public void c() {
        this.f56297f = 1;
        this.f56296e = 1;
        this.f56298g = null;
    }

    public void d(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        this.f56298g = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    @Override // d.b.i0.g0.b.i
    public Object e(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.f56297f);
            builder.ids = this.f56298g;
            builder.q_type = Integer.valueOf(d.b.i0.r.k.c().e());
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            builder.scr_h = Integer.valueOf(d.b.c.e.p.l.i(TbadkCoreApplication.getInst().getApp()));
            builder.scr_w = Integer.valueOf(d.b.c.e.p.l.k(TbadkCoreApplication.getInst().getApp()));
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

    public void f() {
        this.f56297f++;
        this.f56296e = 4;
    }

    public String getCacheKey() {
        return "replyme_cache";
    }

    @Override // d.b.i0.g0.b.d
    public boolean isNeedUid() {
        return true;
    }

    @Override // d.b.i0.g0.b.f
    public HashMap<String, Object> k() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        hashMap.put(Config.PACKAGE_NAME, String.valueOf(this.f56297f));
        hashMap.put("q_type", Integer.valueOf(d.b.i0.r.k.c().e()));
        hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
        hashMap.put("scr_h", Integer.valueOf(d.b.c.e.p.l.i(TbadkCoreApplication.getInst().getApp())));
        hashMap.put("scr_w", Integer.valueOf(d.b.c.e.p.l.k(TbadkCoreApplication.getInst().getApp())));
        if (this.f56296e == 4 && !TextUtils.isEmpty(this.f56298g)) {
            hashMap.put("ids", this.f56298g);
        }
        return hashMap;
    }

    @Override // d.b.i0.g0.b.f
    public HashMap<String, String> p() {
        return null;
    }

    public String q() {
        return "tb_user_replyme";
    }

    public boolean r() {
        return true;
    }
}
