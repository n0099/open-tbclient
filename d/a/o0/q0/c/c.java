package d.a.o0.q0.c;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f62104a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f62105b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f62106c;

    /* renamed from: d  reason: collision with root package name */
    public String f62107d;

    public c(String str) {
        this.f62107d = str;
    }

    public ArrayList<n> a() {
        return this.f62106c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f62104a = dataRes.exact_match;
        this.f62105b = dataRes.fuzzy_match;
        this.f62106c = new ArrayList<>();
        b bVar = new b(this.f62107d);
        SearchForum searchForum = this.f62104a;
        if (searchForum != null) {
            bVar.t(searchForum);
            this.f62106c.add(bVar);
        }
        List<SearchForum> list = this.f62105b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f62107d);
                bVar2.t(searchForum2);
                this.f62106c.add(bVar2);
            }
        }
    }
}
