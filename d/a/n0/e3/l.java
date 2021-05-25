package d.a.n0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.a.c.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f54112g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f54113e;

    /* renamed from: f  reason: collision with root package name */
    public String f54114f;

    public List<FeedForumData> c() {
        return this.f54113e;
    }

    public String e() {
        return this.f54114f;
    }

    public void f(List<FeedForumData> list) {
        this.f54113e = list;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f54112g;
    }

    public void h(String str) {
        this.f54114f = str;
    }
}
