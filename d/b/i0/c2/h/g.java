package d.b.i0.c2.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
import d.b.h0.r.q.w1;
/* loaded from: classes4.dex */
public class g implements d.b.b.j.e.n {
    public static BdUniqueId l = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52427e;

    /* renamed from: f  reason: collision with root package name */
    public String f52428f;

    /* renamed from: g  reason: collision with root package name */
    public int f52429g;

    /* renamed from: h  reason: collision with root package name */
    public int f52430h;
    public boolean i = false;
    public String j;
    public String k;

    public g(ForumData forumData) {
        if (forumData == null) {
            return;
        }
        this.f52427e = forumData.getName();
        this.f52428f = forumData.getImage_url();
        this.f52429g = forumData.getPost_num();
        this.f52430h = forumData.getMember_num();
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
        this.f52427e = w1Var.f50916b;
        this.f52428f = w1Var.f50917c;
        this.f52429g = w1Var.f50922h;
        this.f52430h = w1Var.i;
        this.j = w1Var.f50915a;
    }
}
