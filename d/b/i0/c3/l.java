package d.b.i0.c3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.b.b.j.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f53485g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f53486e;

    /* renamed from: f  reason: collision with root package name */
    public String f53487f;

    public List<FeedForumData> a() {
        return this.f53486e;
    }

    public String e() {
        return this.f53487f;
    }

    public void f(List<FeedForumData> list) {
        this.f53486e = list;
    }

    public void g(String str) {
        this.f53487f = str;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f53485g;
    }
}
