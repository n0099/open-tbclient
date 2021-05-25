package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes4.dex */
public class a implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52549e;

    /* renamed from: f  reason: collision with root package name */
    public int f52550f;

    /* renamed from: g  reason: collision with root package name */
    public long f52551g;

    /* renamed from: h  reason: collision with root package name */
    public long f52552h;

    /* renamed from: i  reason: collision with root package name */
    public int f52553i;

    public void c(CommonInteraction commonInteraction) {
        if (commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f52549e = commonInteraction.total_num.longValue();
        this.f52550f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f52551g = commonInteraction.pk_id.longValue();
        this.f52552h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
