package d.b.i0.v2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f63037a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f63038b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f63028a = forumList.avatar;
            bVar.f63029b = forumList.forum_name;
            bVar.f63030c = String.valueOf(forumList.forum_id);
            this.f63037a.add(bVar);
        }
        this.f63038b = dataRes.has_more.intValue() == 1;
    }
}
