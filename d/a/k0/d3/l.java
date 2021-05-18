package d.a.k0.d3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53899g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f53900e;

    /* renamed from: f  reason: collision with root package name */
    public String f53901f;

    public List<FeedForumData> c() {
        return this.f53900e;
    }

    public String e() {
        return this.f53901f;
    }

    public void f(List<FeedForumData> list) {
        this.f53900e = list;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f53899g;
    }

    public void h(String str) {
        this.f53901f = str;
    }
}
