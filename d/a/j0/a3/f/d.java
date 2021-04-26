package d.a.j0.a3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f51259a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51260b;

    /* renamed from: c  reason: collision with root package name */
    public Page f51261c;

    /* renamed from: d  reason: collision with root package name */
    public String f51262d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f51262d = dataRes.class_name;
        this.f51261c = dataRes.page;
        this.f51260b = dataRes.page_structure;
        this.f51259a = dataRes.forum_info;
    }
}
