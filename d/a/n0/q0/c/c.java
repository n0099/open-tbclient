package d.a.n0.q0.c;

import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f61979a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f61980b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f61981c;

    /* renamed from: d  reason: collision with root package name */
    public String f61982d;

    public c(String str) {
        this.f61982d = str;
    }

    public ArrayList<n> a() {
        return this.f61981c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f61979a = dataRes.exact_match;
        this.f61980b = dataRes.fuzzy_match;
        this.f61981c = new ArrayList<>();
        b bVar = new b(this.f61982d);
        SearchForum searchForum = this.f61979a;
        if (searchForum != null) {
            bVar.t(searchForum);
            this.f61981c.add(bVar);
        }
        List<SearchForum> list = this.f61980b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f61982d);
                bVar2.t(searchForum2);
                this.f61981c.add(bVar2);
            }
        }
    }
}
