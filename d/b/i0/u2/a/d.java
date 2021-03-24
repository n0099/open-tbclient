package d.b.i0.u2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f61298a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f61299b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f61289a = forumList.avatar;
            bVar.f61290b = forumList.forum_name;
            bVar.f61291c = String.valueOf(forumList.forum_id);
            this.f61298a.add(bVar);
        }
        this.f61299b = dataRes.has_more.intValue() == 1;
    }
}
