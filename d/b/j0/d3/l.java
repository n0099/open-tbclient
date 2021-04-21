package d.b.j0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f55351g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f55352e;

    /* renamed from: f  reason: collision with root package name */
    public String f55353f;

    public List<FeedForumData> a() {
        return this.f55352e;
    }

    public String e() {
        return this.f55353f;
    }

    public void f(List<FeedForumData> list) {
        this.f55352e = list;
    }

    public void g(String str) {
        this.f55353f = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f55351g;
    }
}
