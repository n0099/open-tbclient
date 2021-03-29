package d.b.i0.z2.f;

import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.j.e.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public List<RecommendForumInfo> f63480b;

    /* renamed from: c  reason: collision with root package name */
    public Page f63481c;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f63479a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f63482d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f63483e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f63484f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f63485g = 0;

    public List<n> a() {
        return this.f63479a;
    }

    public void b(d dVar) {
        String str = dVar.f63489d;
        this.f63481c = dVar.f63488c;
        List<RecommendForumInfo> list = dVar.f63486a;
        this.f63480b = list;
        if (!ListUtils.isEmpty(list)) {
            for (RecommendForumInfo recommendForumInfo : this.f63480b) {
                b bVar = new b();
                bVar.v(recommendForumInfo);
                this.f63479a.add(bVar);
            }
        }
        Page page = this.f63481c;
        if (page != null) {
            this.f63482d = page.has_more.intValue() == 1;
            this.f63483e = this.f63481c.current_page.intValue();
        }
    }
}
