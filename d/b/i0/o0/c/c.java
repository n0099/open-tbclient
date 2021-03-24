package d.b.i0.o0.c;

import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public SearchForum f57246a;

    /* renamed from: b  reason: collision with root package name */
    public List<SearchForum> f57247b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f57248c;

    /* renamed from: d  reason: collision with root package name */
    public String f57249d;

    public c(String str) {
        this.f57249d = str;
    }

    public ArrayList<n> a() {
        return this.f57248c;
    }

    public void b(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f57246a = dataRes.exact_match;
        this.f57247b = dataRes.fuzzy_match;
        this.f57248c = new ArrayList<>();
        b bVar = new b(this.f57249d);
        SearchForum searchForum = this.f57246a;
        if (searchForum != null) {
            bVar.v(searchForum);
            this.f57248c.add(bVar);
        }
        List<SearchForum> list = this.f57247b;
        if (list == null) {
            return;
        }
        for (SearchForum searchForum2 : list) {
            if (searchForum2 != null) {
                b bVar2 = new b(this.f57249d);
                bVar2.v(searchForum2);
                this.f57248c.add(bVar2);
            }
        }
    }
}
