package d.b.i0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes3.dex */
public class l implements d.b.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f54930g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f54931e;

    /* renamed from: f  reason: collision with root package name */
    public String f54932f;

    public List<FeedForumData> a() {
        return this.f54931e;
    }

    public String e() {
        return this.f54932f;
    }

    public void f(List<FeedForumData> list) {
        this.f54931e = list;
    }

    public void g(String str) {
        this.f54932f = str;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return f54930g;
    }
}
