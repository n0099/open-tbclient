package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.a.m0.r.q.w1;
/* loaded from: classes5.dex */
public class g implements d.a.c.k.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56617e;

    /* renamed from: f  reason: collision with root package name */
    public String f56618f;

    /* renamed from: g  reason: collision with root package name */
    public int f56619g;

    /* renamed from: h  reason: collision with root package name */
    public int f56620h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f56621i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f56617e = forumData.getName();
        this.f56618f = forumData.getImage_url();
        this.f56619g = forumData.getPost_num();
        this.f56620h = forumData.getMember_num();
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
        this.f56617e = w1Var.f53834b;
        this.f56618f = w1Var.f53835c;
        this.f56619g = w1Var.f53840h;
        this.f56620h = w1Var.f53841i;
        this.j = w1Var.f53833a;
    }
}
