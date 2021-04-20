package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes3.dex */
public class o implements d.b.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f54969e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f54970f;

    public o(ForumData forumData, boolean z) {
        this.f54970f = forumData;
        this.f54969e = z;
    }

    public ForumData a() {
        return this.f54970f;
    }

    public boolean e() {
        return this.f54969e;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
