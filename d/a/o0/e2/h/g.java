package d.a.o0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.a.n0.r.q.w1;
/* loaded from: classes5.dex */
public class g implements d.a.c.k.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56742e;

    /* renamed from: f  reason: collision with root package name */
    public String f56743f;

    /* renamed from: g  reason: collision with root package name */
    public int f56744g;

    /* renamed from: h  reason: collision with root package name */
    public int f56745h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56746i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f56742e = forumData.getName();
        this.f56743f = forumData.getImage_url();
        this.f56744g = forumData.getPost_num();
        this.f56745h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return l;
    }

    public g(w1 w1Var) {
        if (w1Var == null) {
            return;
        }
        this.f56742e = w1Var.f53941b;
        this.f56743f = w1Var.f53942c;
        this.f56744g = w1Var.f53947h;
        this.f56745h = w1Var.f53948i;
        this.j = w1Var.f53940a;
    }
}
