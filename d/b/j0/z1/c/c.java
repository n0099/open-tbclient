package d.b.j0.z1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f64669a;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (dataRes.class_foruminfo != null) {
            this.f64669a = new ArrayList();
            for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                a aVar = new a();
                aVar.f64662b = classForumInfo.class_id;
                aVar.f64663c = classForumInfo.class_name;
                ArrayList arrayList = new ArrayList();
                for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                    arrayList.add(new d(recommendForumInfo, false));
                }
                aVar.f64661a = arrayList;
                this.f64669a.add(aVar);
            }
        }
        Page page = dataRes.page;
    }
}
