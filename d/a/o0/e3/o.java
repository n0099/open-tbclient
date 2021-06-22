package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.a.c.k.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f57965e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f57966f;

    public o(ForumData forumData, boolean z) {
        this.f57966f = forumData;
        this.f57965e = z;
    }

    public ForumData b() {
        return this.f57966f;
    }

    public boolean c() {
        return this.f57965e;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return null;
    }
}
