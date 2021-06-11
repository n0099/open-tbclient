package d.a.n0.b3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.k.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f55808b;

    /* renamed from: c  reason: collision with root package name */
    public Page f55809c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f55807a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f55810d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f55811e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f55812f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f55813g = 0;

    public List<n> a() {
        return this.f55807a;
    }

    public void b(d dVar) {
        String str = dVar.f55817d;
        this.f55809c = dVar.f55816c;
        List<RecommendForumInfo> list = dVar.f55814a;
        this.f55808b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f55808b) {
                b bVar = new b();
                bVar.t(recommendForumInfo);
                this.f55807a.add(bVar);
            }
        }
        Page page = this.f55809c;
        if (page != null) {
            this.f55810d = page.has_more.intValue() == 1;
            this.f55811e = this.f55809c.current_page.intValue();
        }
    }
}
