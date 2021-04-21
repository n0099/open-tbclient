package d.b.j0.p0.c;

import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f59314a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f59315b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f59316c;

    /* renamed from: d  reason: collision with root package name */
    public String f59317d;

    public c(String str) {
        this.f59317d = str;
    }

    public ArrayList<n> a() {
        return this.f59316c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f59314a = dataRes.exact_match;
        this.f59315b = dataRes.fuzzy_match;
        this.f59316c = new ArrayList<>();
        b bVar = new b(this.f59317d);
        SearchForum searchForum = this.f59314a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f59316c.add(bVar);
        }
        List<SearchForum> list = this.f59315b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f59317d);
                bVar2.v(searchForum2);
                this.f59316c.add(bVar2);
            }
        }
    }
}
