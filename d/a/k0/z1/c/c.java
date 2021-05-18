package d.a.k0.z1.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f63677a;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (dataRes.class_foruminfo != null) {
            this.f63677a = new ArrayList();
            for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                a aVar = new a();
                aVar.f63670b = classForumInfo.class_id;
                aVar.f63671c = classForumInfo.class_name;
                ArrayList arrayList = new ArrayList();
                for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                    arrayList.add(new d(recommendForumInfo, false));
                }
                aVar.f63669a = arrayList;
                this.f63677a.add(aVar);
            }
        }
        Page page = dataRes.page;
    }
}
