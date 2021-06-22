package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes4.dex */
public class a implements d.a.c.k.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f56363e;

    /* renamed from: f  reason: collision with root package name */
    public int f56364f;

    /* renamed from: g  reason: collision with root package name */
    public long f56365g;

    /* renamed from: h  reason: collision with root package name */
    public long f56366h;

    /* renamed from: i  reason: collision with root package name */
    public int f56367i;

    public void b(CommonInteraction commonInteraction) {
        if (commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f56363e = commonInteraction.total_num.longValue();
        this.f56364f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f56365g = commonInteraction.pk_id.longValue();
        this.f56366h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }
}
