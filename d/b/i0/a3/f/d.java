package d.b.i0.a3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f53105a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f53106b;

    /* renamed from: c  reason: collision with root package name */
    public Page f53107c;

    /* renamed from: d  reason: collision with root package name */
    public String f53108d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f53108d = dataRes.class_name;
        this.f53107c = dataRes.page;
        this.f53106b = dataRes.page_structure;
        this.f53105a = dataRes.forum_info;
    }
}
