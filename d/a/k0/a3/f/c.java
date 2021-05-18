package d.a.k0.a3.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f51952b;

    /* renamed from: c  reason: collision with root package name */
    public Page f51953c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f51951a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f51954d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f51955e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51956f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f51957g = 0;

    public List<n> a() {
        return this.f51951a;
    }

    public void b(d dVar) {
        String str = dVar.f51961d;
        this.f51953c = dVar.f51960c;
        List<RecommendForumInfo> list = dVar.f51958a;
        this.f51952b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f51952b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f51951a.add(bVar);
            }
        }
        Page page = this.f51953c;
        if (page != null) {
            this.f51954d = page.has_more.intValue() == 1;
            this.f51955e = this.f51953c.current_page.intValue();
        }
    }
}
