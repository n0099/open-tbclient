package d.a.k0.p0.c;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f58092a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f58093b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f58094c;

    /* renamed from: d  reason: collision with root package name */
    public String f58095d;

    public c(String str) {
        this.f58095d = str;
    }

    public ArrayList<n> a() {
        return this.f58094c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58092a = dataRes.exact_match;
        this.f58093b = dataRes.fuzzy_match;
        this.f58094c = new ArrayList<>();
        b bVar = new b(this.f58095d);
        SearchForum searchForum = this.f58092a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f58094c.add(bVar);
        }
        List<SearchForum> list = this.f58093b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f58095d);
                bVar2.v(searchForum2);
                this.f58094c.add(bVar2);
            }
        }
    }
}
