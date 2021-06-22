package d.a.o0.b3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f55939a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f55940b;

    /* renamed from: c  reason: collision with root package name */
    public Page f55941c;

    /* renamed from: d  reason: collision with root package name */
    public String f55942d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f55942d = dataRes.class_name;
        this.f55941c = dataRes.page;
        this.f55940b = dataRes.page_structure;
        this.f55939a = dataRes.forum_info;
    }
}
