package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.b.b.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f53525e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f53526f;

    public o(ForumData forumData, boolean z) {
        this.f53526f = forumData;
        this.f53525e = z;
    }

    public ForumData a() {
        return this.f53526f;
    }

    public boolean e() {
        return this.f53525e;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
