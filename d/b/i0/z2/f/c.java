package d.b.i0.z2.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f63479b;

    /* renamed from: c  reason: collision with root package name */
    public Page f63480c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f63478a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f63481d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f63482e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f63483f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63484g = 0;

    public List<n> a() {
        return this.f63478a;
    }

    public void b(d dVar) {
        String str = dVar.f63488d;
        this.f63480c = dVar.f63487c;
        List<RecommendForumInfo> list = dVar.f63485a;
        this.f63479b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f63479b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f63478a.add(bVar);
            }
        }
        Page page = this.f63480c;
        if (page != null) {
            this.f63481d = page.has_more.intValue() == 1;
            this.f63482e = this.f63480c.current_page.intValue();
        }
    }
}
