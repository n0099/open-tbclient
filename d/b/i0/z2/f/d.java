package d.b.i0.z2.f;

import java.util.List;
import tbclient.GetForumSquare.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<RecommendForumInfo> f63486a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f63487b;

    /* renamed from: c  reason: collision with root package name */
    public Page f63488c;

    /* renamed from: d  reason: collision with root package name */
    public String f63489d;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        this.f63489d = dataRes.class_name;
        this.f63488c = dataRes.page;
        this.f63487b = dataRes.page_structure;
        this.f63486a = dataRes.forum_info;
    }
}
