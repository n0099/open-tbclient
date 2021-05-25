package d.a.n0.q0.c;

import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f58288a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f58289b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f58290c;

    /* renamed from: d  reason: collision with root package name */
    public String f58291d;

    public c(String str) {
        this.f58291d = str;
    }

    public ArrayList<n> a() {
        return this.f58290c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f58288a = dataRes.exact_match;
        this.f58289b = dataRes.fuzzy_match;
        this.f58290c = new ArrayList<>();
        b bVar = new b(this.f58291d);
        SearchForum searchForum = this.f58288a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f58290c.add(bVar);
        }
        List<SearchForum> list = this.f58289b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f58291d);
                bVar2.v(searchForum2);
                this.f58290c.add(bVar2);
            }
        }
    }
}
