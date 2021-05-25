package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes5.dex */
public class o implements d.a.c.j.e.n {

    /* renamed from: e  reason: collision with root package name */
    public final boolean f54151e;

    /* renamed from: f  reason: collision with root package name */
    public ForumData f54152f;

    public o(ForumData forumData, boolean z) {
        this.f54152f = forumData;
        this.f54151e = z;
    }

    public ForumData c() {
        return this.f54152f;
    }

    public boolean e() {
        return this.f54151e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return null;
    }
}
