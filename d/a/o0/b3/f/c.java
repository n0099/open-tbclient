package d.a.o0.b3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f55933b;

    /* renamed from: c  reason: collision with root package name */
    public Page f55934c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f55932a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f55935d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f55936e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f55937f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f55938g = 0;

    public List<n> a() {
        return this.f55932a;
    }

    public void b(d dVar) {
        String str = dVar.f55942d;
        this.f55934c = dVar.f55941c;
        List<RecommendForumInfo> list = dVar.f55939a;
        this.f55933b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f55933b) {
                b bVar = new b();
                bVar.t(recommendForumInfo);
                this.f55932a.add(bVar);
            }
        }
        Page page = this.f55934c;
        if (page != null) {
            this.f55935d = page.has_more.intValue() == 1;
            this.f55936e = this.f55934c.current_page.intValue();
        }
    }
}
