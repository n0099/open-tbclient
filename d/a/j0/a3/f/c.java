package d.a.j0.a3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f51253b;

    /* renamed from: c  reason: collision with root package name */
    public Page f51254c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f51252a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f51255d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f51256e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51257f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f51258g = 0;

    public List<n> a() {
        return this.f51252a;
    }

    public void b(d dVar) {
        String str = dVar.f51262d;
        this.f51254c = dVar.f51261c;
        List<RecommendForumInfo> list = dVar.f51259a;
        this.f51253b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f51253b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f51252a.add(bVar);
            }
        }
        Page page = this.f51254c;
        if (page != null) {
            this.f51255d = page.has_more.intValue() == 1;
            this.f51256e = this.f51254c.current_page.intValue();
        }
    }
}
