package d.a.o0.a2.c;

import java.util.ArrayList;
import java.util.List;
import tbclient.ClassForumInfo;
import tbclient.GetVerticalForumList.DataRes;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f54970a;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        if (dataRes.class_foruminfo != null) {
            this.f54970a = new ArrayList();
            for (ClassForumInfo classForumInfo : dataRes.class_foruminfo) {
                a aVar = new a();
                aVar.f54963b = classForumInfo.class_id;
                aVar.f54964c = classForumInfo.class_name;
                ArrayList arrayList = new ArrayList();
                for (RecommendForumInfo recommendForumInfo : classForumInfo.forum_info) {
                    arrayList.add(new d(recommendForumInfo, false));
                }
                aVar.f54962a = arrayList;
                this.f54970a.add(aVar);
            }
        }
        Page page = dataRes.page;
    }
}
