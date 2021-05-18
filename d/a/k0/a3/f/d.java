package d.a.k0.a3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f51958a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f51959b;

    /* renamed from: c  reason: collision with root package name */
    public Page f51960c;

    /* renamed from: d  reason: collision with root package name */
    public String f51961d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f51961d = dataRes.class_name;
        this.f51960c = dataRes.page;
        this.f51959b = dataRes.page_structure;
        this.f51958a = dataRes.forum_info;
    }
}
