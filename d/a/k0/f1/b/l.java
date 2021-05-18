package d.a.k0.f1.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import d.a.j0.z0.w;
import java.util.HashMap;
import tbclient.ReplyMe.DataReq;
import tbclient.ReplyMe.ReplyMeReqIdl;
/* loaded from: classes4.dex */
public class l implements d.a.j0.g0.b.g, d.a.j0.g0.b.d {

    /* renamed from: e  reason: collision with root package name */
    public int f54885e;

    /* renamed from: f  reason: collision with root package name */
    public int f54886f = 1;

    /* renamed from: g  reason: collision with root package name */
    public String f54887g;

    public int a() {
        return this.f54885e;
    }

    public void b() {
        this.f54886f = 1;
        this.f54885e = 1;
        this.f54887g = null;
    }

    @Override // d.a.j0.g0.b.i
    public Object c(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = Integer.valueOf(this.f54886f);
            builder.ids = this.f54887g;
            builder.q_type = Integer.valueOf(d.a.j0.r.k.c().e());
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

    public void d(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        this.f54887g = String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id());
    }

    public void e() {
        this.f54886f++;
        this.f54885e = 4;
    }

    public String getCacheKey() {
        return "replyme_cache";
    }

    public boolean i() {
        return true;
    }

    @Override // d.a.j0.g0.b.d
    public boolean isNeedUid() {
        return true;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, Object> o() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        hashMap.put(Config.PACKAGE_NAME, String.valueOf(this.f54886f));
        hashMap.put("q_type", Integer.valueOf(d.a.j0.r.k.c().e()));
        hashMap.put("scr_dip", Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density));
        hashMap.put("scr_h", Integer.valueOf(d.a.c.e.p.l.i(TbadkCoreApplication.getInst().getApp())));
        hashMap.put("scr_w", Integer.valueOf(d.a.c.e.p.l.k(TbadkCoreApplication.getInst().getApp())));
        if (this.f54885e == 4 && !TextUtils.isEmpty(this.f54887g)) {
            hashMap.put("ids", this.f54887g);
        }
        return hashMap;
    }

    @Override // d.a.j0.g0.b.f
    public HashMap<String, String> q() {
        return null;
    }

    public String r() {
        return "tb_user_replyme";
    }
}
