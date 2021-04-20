package d.b.i0.d2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.b.h0.r.q.w1;
/* loaded from: classes3.dex */
public class g implements d.b.c.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53823e;

    /* renamed from: f  reason: collision with root package name */
    public String f53824f;

    /* renamed from: g  reason: collision with root package name */
    public int f53825g;

    /* renamed from: h  reason: collision with root package name */
    public int f53826h;
    public boolean i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f53823e = forumData.getName();
        this.f53824f = forumData.getImage_url();
        this.f53825g = forumData.getPost_num();
        this.f53826h = forumData.getMember_num();
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
        this.f53823e = w1Var.f51324b;
        this.f53824f = w1Var.f51325c;
        this.f53825g = w1Var.f51330h;
        this.f53826h = w1Var.i;
        this.j = w1Var.f51323a;
    }
}
