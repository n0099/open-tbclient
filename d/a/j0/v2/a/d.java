package d.a.j0.v2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f61693a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f61694b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f61684a = forumList.avatar;
            bVar.f61685b = forumList.forum_name;
            bVar.f61686c = String.valueOf(forumList.forum_id);
            this.f61693a.add(bVar);
        }
        this.f61694b = dataRes.has_more.intValue() == 1;
    }
}
