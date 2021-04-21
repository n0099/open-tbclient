package d.b.j0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.b.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55390e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f55391f;

    public o(ForumData forumData, boolean z) {
        this.f55391f = forumData;
        this.f55390e = z;
    }

    public ForumData a() {
        return this.f55391f;
    }

    public boolean e() {
        return this.f55390e;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
