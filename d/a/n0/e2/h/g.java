package d.a.n0.e2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.a.m0.r.q.w1;
/* loaded from: classes4.dex */
public class g implements d.a.c.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52928e;

    /* renamed from: f  reason: collision with root package name */
    public String f52929f;

    /* renamed from: g  reason: collision with root package name */
    public int f52930g;

    /* renamed from: h  reason: collision with root package name */
    public int f52931h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f52932i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f52928e = forumData.getName();
        this.f52929f = forumData.getImage_url();
        this.f52930g = forumData.getPost_num();
        this.f52931h = forumData.getMember_num();
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
        this.f52928e = w1Var.f50158b;
        this.f52929f = w1Var.f50159c;
        this.f52930g = w1Var.f50164h;
        this.f52931h = w1Var.f50165i;
        this.j = w1Var.f50157a;
    }
}
