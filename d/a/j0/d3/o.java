package d.a.j0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.a.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f53231e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f53232f;

    public o(ForumData forumData, boolean z) {
        this.f53232f = forumData;
        this.f53231e = z;
    }

    public ForumData c() {
        return this.f53232f;
    }

    public boolean e() {
        return this.f53231e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
