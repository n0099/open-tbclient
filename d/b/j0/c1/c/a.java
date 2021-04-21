package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.CommonInteraction;
/* loaded from: classes4.dex */
public class a implements d.b.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f53913e;

    /* renamed from: f  reason: collision with root package name */
    public int f53914f;

    /* renamed from: g  reason: collision with root package name */
    public long f53915g;

    /* renamed from: h  reason: collision with root package name */
    public long f53916h;
    public int i;

    public void a(CommonInteraction commonInteraction) {
        if (commonInteraction == null) {
            return;
        }
        String str = commonInteraction.module_name;
        String str2 = commonInteraction.ques_desc;
        this.f53913e = commonInteraction.total_num.longValue();
        this.f53914f = commonInteraction.has_clicked.intValue();
        String str3 = commonInteraction.before_click_pic;
        String str4 = commonInteraction.after_click_pic;
        this.f53915g = commonInteraction.pk_id.longValue();
        this.f53916h = commonInteraction.user_pk_id.longValue();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }
}
