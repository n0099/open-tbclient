package d.b.i0.a3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f53099b;

    /* renamed from: c  reason: collision with root package name */
    public Page f53100c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f53098a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f53101d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f53102e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f53103f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f53104g = 0;

    public List<n> a() {
        return this.f53098a;
    }

    public void b(d dVar) {
        String str = dVar.f53108d;
        this.f53100c = dVar.f53107c;
        List<RecommendForumInfo> list = dVar.f53105a;
        this.f53099b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f53099b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f53098a.add(bVar);
            }
        }
        Page page = this.f53100c;
        if (page != null) {
            this.f53101d = page.has_more.intValue() == 1;
            this.f53102e = this.f53100c.current_page.intValue();
        }
    }
}
