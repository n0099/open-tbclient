package d.a.n0.b3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f55814a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f55815b;

    /* renamed from: c  reason: collision with root package name */
    public Page f55816c;

    /* renamed from: d  reason: collision with root package name */
    public String f55817d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55817d = dataRes.class_name;
        this.f55816c = dataRes.page;
        this.f55815b = dataRes.page_structure;
        this.f55814a = dataRes.forum_info;
    }
}
