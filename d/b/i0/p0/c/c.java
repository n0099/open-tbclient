package d.b.i0.p0.c;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f58893a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f58894b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f58895c;

    /* renamed from: d  reason: collision with root package name */
    public String f58896d;

    public c(String str) {
        this.f58896d = str;
    }

    public ArrayList<n> a() {
        return this.f58895c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58893a = dataRes.exact_match;
        this.f58894b = dataRes.fuzzy_match;
        this.f58895c = new ArrayList<>();
        b bVar = new b(this.f58896d);
        SearchForum searchForum = this.f58893a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f58895c.add(bVar);
        }
        List<SearchForum> list = this.f58894b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f58896d);
                bVar2.v(searchForum2);
                this.f58895c.add(bVar2);
            }
        }
    }
}
