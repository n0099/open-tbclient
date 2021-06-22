package d.a.o0.w2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f66364a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f66365b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f66355a = forumList.avatar;
            bVar.f66356b = forumList.forum_name;
            bVar.f66357c = String.valueOf(forumList.forum_id);
            this.f66364a.add(bVar);
        }
        this.f66365b = dataRes.has_more.intValue() == 1;
    }
}
