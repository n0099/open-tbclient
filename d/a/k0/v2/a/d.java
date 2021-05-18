package d.a.k0.v2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f62417a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f62418b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f62408a = forumList.avatar;
            bVar.f62409b = forumList.forum_name;
            bVar.f62410c = String.valueOf(forumList.forum_id);
            this.f62417a.add(bVar);
        }
        this.f62418b = dataRes.has_more.intValue() == 1;
    }
}
