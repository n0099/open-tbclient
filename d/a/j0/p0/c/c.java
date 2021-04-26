package d.a.j0.p0.c;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f57350a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f57351b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f57352c;

    /* renamed from: d  reason: collision with root package name */
    public String f57353d;

    public c(String str) {
        this.f57353d = str;
    }

    public ArrayList<n> a() {
        return this.f57352c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57350a = dataRes.exact_match;
        this.f57351b = dataRes.fuzzy_match;
        this.f57352c = new ArrayList<>();
        b bVar = new b(this.f57353d);
        SearchForum searchForum = this.f57350a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f57352c.add(bVar);
        }
        List<SearchForum> list = this.f57351b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f57353d);
                bVar2.v(searchForum2);
                this.f57352c.add(bVar2);
            }
        }
    }
}
