package d.a.k0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes4.dex */
public class a implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52369e;

    /* renamed from: f  reason: collision with root package name */
    public int f52370f;

    /* renamed from: g  reason: collision with root package name */
    public long f52371g;

    /* renamed from: h  reason: collision with root package name */
    public long f52372h;

    /* renamed from: i  reason: collision with root package name */
    public int f52373i;

    public void c(CommonInteraction commonInteraction) {
        if (commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f52369e = commonInteraction.total_num.longValue();
        this.f52370f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f52371g = commonInteraction.pk_id.longValue();
        this.f52372h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
