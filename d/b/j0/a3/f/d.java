package d.b.j0.a3.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f53526a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f53527b;

    /* renamed from: c  reason: collision with root package name */
    public Page f53528c;

    /* renamed from: d  reason: collision with root package name */
    public String f53529d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f53529d = dataRes.class_name;
        this.f53528c = dataRes.page;
        this.f53527b = dataRes.page_structure;
        this.f53526a = dataRes.forum_info;
    }
}
