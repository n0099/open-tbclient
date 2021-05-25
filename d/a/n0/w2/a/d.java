package d.a.n0.w2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f62524a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f62525b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f62515a = forumList.avatar;
            bVar.f62516b = forumList.forum_name;
            bVar.f62517c = String.valueOf(forumList.forum_id);
            this.f62524a.add(bVar);
        }
        this.f62525b = dataRes.has_more.intValue() == 1;
    }
}
