package d.b.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.b.i0.r.q.w1;
/* loaded from: classes3.dex */
public class g implements d.b.c.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f54244e;

    /* renamed from: f  reason: collision with root package name */
    public String f54245f;

    /* renamed from: g  reason: collision with root package name */
    public int f54246g;

    /* renamed from: h  reason: collision with root package name */
    public int f54247h;
    public boolean i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f54244e = forumData.getName();
        this.f54245f = forumData.getImage_url();
        this.f54246g = forumData.getPost_num();
        this.f54247h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public g(w1 w1Var) {
        if (w1Var == null) {
            return;
        }
        this.f54244e = w1Var.f51660b;
        this.f54245f = w1Var.f51661c;
        this.f54246g = w1Var.f51666h;
        this.f54247h = w1Var.i;
        this.j = w1Var.f51659a;
    }
}
