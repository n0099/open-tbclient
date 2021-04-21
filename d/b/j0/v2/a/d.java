package d.b.j0.v2.a;

import java.util.ArrayList;
import java.util.List;
import tbclient.ForumList;
import tbclient.GetDislikeList.DataRes;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f63458a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f63459b = true;

    public void a(DataRes dataRes) {
        if (dataRes == null) {
            return;
        }
        for (ForumList forumList : dataRes.forum_list) {
            b bVar = new b();
            bVar.f63449a = forumList.avatar;
            bVar.f63450b = forumList.forum_name;
            bVar.f63451c = String.valueOf(forumList.forum_id);
            this.f63458a.add(bVar);
        }
        this.f63459b = dataRes.has_more.intValue() == 1;
    }
}
