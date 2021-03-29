package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53486g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f53487e;

    /* renamed from: f  reason: collision with root package name */
    public String f53488f;

    public List<FeedForumData> a() {
        return this.f53487e;
    }

    public String e() {
        return this.f53488f;
    }

    public void f(List<FeedForumData> list) {
        this.f53487e = list;
    }

    public void g(String str) {
        this.f53488f = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53486g;
    }
}
