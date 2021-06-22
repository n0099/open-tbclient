package d.a.o0.e3;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.FeedForumData;
import java.util.List;
/* loaded from: classes5.dex */
public class l implements d.a.c.k.e.n {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f57926g = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public List<FeedForumData> f57927e;

    /* renamed from: f  reason: collision with root package name */
    public String f57928f;

    public List<FeedForumData> b() {
        return this.f57927e;
    }

    public String c() {
        return this.f57928f;
    }

    public void e(List<FeedForumData> list) {
        this.f57927e = list;
    }

    public void g(String str) {
        this.f57928f = str;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return f57926g;
    }
}
