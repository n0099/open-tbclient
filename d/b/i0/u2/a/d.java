package d.b.i0.u2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f61299a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f61300b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f61290a = forumList.avatar;
            bVar.f61291b = forumList.forum_name;
            bVar.f61292c = String.valueOf(forumList.forum_id);
            this.f61299a.add(bVar);
        }
        this.f61300b = dataRes.has_more.intValue() == 1;
    }
}
