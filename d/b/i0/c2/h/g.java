package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.b.h0.r.q.w1;
/* loaded from: classes4.dex */
public class g implements d.b.b.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52428e;

    /* renamed from: f  reason: collision with root package name */
    public String f52429f;

    /* renamed from: g  reason: collision with root package name */
    public int f52430g;

    /* renamed from: h  reason: collision with root package name */
    public int f52431h;
    public boolean i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f52428e = forumData.getName();
        this.f52429f = forumData.getImage_url();
        this.f52430g = forumData.getPost_num();
        this.f52431h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public g(w1 w1Var) {
        if (w1Var == null) {
            return;
        }
        this.f52428e = w1Var.f50917b;
        this.f52429f = w1Var.f50918c;
        this.f52430g = w1Var.f50923h;
        this.f52431h = w1Var.i;
        this.j = w1Var.f50916a;
    }
}
