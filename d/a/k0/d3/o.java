package d.a.k0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.a.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f53938e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f53939f;

    public o(ForumData forumData, boolean z) {
        this.f53939f = forumData;
        this.f53938e = z;
    }

    public ForumData c() {
        return this.f53939f;
    }

    public boolean e() {
        return this.f53938e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
