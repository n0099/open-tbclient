package d.a.j0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.a.i0.r.q.w1;
/* loaded from: classes3.dex */
public class g implements d.a.c.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52024e;

    /* renamed from: f  reason: collision with root package name */
    public String f52025f;

    /* renamed from: g  reason: collision with root package name */
    public int f52026g;

    /* renamed from: h  reason: collision with root package name */
    public int f52027h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52028i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f52024e = forumData.getName();
        this.f52025f = forumData.getImage_url();
        this.f52026g = forumData.getPost_num();
        this.f52027h = forumData.getMember_num();
        this.j = forumData.getId();
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return l;
    }

    public g(w1 w1Var) {
        if (w1Var == null) {
            return;
        }
        this.f52024e = w1Var.f49295b;
        this.f52025f = w1Var.f49296c;
        this.f52026g = w1Var.f49301h;
        this.f52027h = w1Var.f49302i;
        this.j = w1Var.f49294a;
    }
}
