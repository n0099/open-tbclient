package d.a.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes4.dex */
public class a implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f51670e;

    /* renamed from: f  reason: collision with root package name */
    public int f51671f;

    /* renamed from: g  reason: collision with root package name */
    public long f51672g;

    /* renamed from: h  reason: collision with root package name */
    public long f51673h;

    /* renamed from: i  reason: collision with root package name */
    public int f51674i;

    public void c(CommonInteraction commonInteraction) {
        if (commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f51670e = commonInteraction.total_num.longValue();
        this.f51671f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f51672g = commonInteraction.pk_id.longValue();
        this.f51673h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
