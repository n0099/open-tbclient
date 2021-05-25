package d.a.n0.b3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f52125a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f52126b;

    /* renamed from: c  reason: collision with root package name */
    public Page f52127c;

    /* renamed from: d  reason: collision with root package name */
    public String f52128d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f52128d = dataRes.class_name;
        this.f52127c = dataRes.page;
        this.f52126b = dataRes.page_structure;
        this.f52125a = dataRes.forum_info;
    }
}
