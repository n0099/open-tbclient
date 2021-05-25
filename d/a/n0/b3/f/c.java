package d.a.n0.b3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f52119b;

    /* renamed from: c  reason: collision with root package name */
    public Page f52120c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f52118a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f52121d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f52122e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f52123f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f52124g = 0;

    public List<n> a() {
        return this.f52118a;
    }

    public void b(d dVar) {
        String str = dVar.f52128d;
        this.f52120c = dVar.f52127c;
        List<RecommendForumInfo> list = dVar.f52125a;
        this.f52119b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f52119b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f52118a.add(bVar);
            }
        }
        Page page = this.f52120c;
        if (page != null) {
            this.f52121d = page.has_more.intValue() == 1;
            this.f52122e = this.f52120c.current_page.intValue();
        }
    }
}
