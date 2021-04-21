package d.b.j0.a3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f53520b;

    /* renamed from: c  reason: collision with root package name */
    public Page f53521c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f53519a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f53522d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f53523e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f53524f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f53525g = 0;

    public List<n> a() {
        return this.f53519a;
    }

    public void b(d dVar) {
        String str = dVar.f53529d;
        this.f53521c = dVar.f53528c;
        List<RecommendForumInfo> list = dVar.f53526a;
        this.f53520b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f53520b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f53519a.add(bVar);
            }
        }
        Page page = this.f53521c;
        if (page != null) {
            this.f53522d = page.has_more.intValue() == 1;
            this.f53523e = this.f53521c.current_page.intValue();
        }
    }
}
