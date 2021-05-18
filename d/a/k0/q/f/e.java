package d.a.k0.q.f;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f58209a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.j0.s.f.a> f58210b;

    public List<d.a.j0.s.f.a> a() {
        if (this.f58210b == null) {
            this.f58210b = new ArrayList();
        }
        return this.f58210b;
    }

    public String b() {
        return this.f58209a;
    }

    public void c(listData listdata) {
        if (listdata != null) {
            this.f58209a = listdata.key;
            if (listdata.friend_list != null) {
                this.f58210b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    d.a.j0.s.f.a aVar = new d.a.j0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f58209a);
                    this.f58210b.add(aVar);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        if (robotslist != null) {
            this.f58209a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.f58210b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    d.a.j0.s.f.a aVar = new d.a.j0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f58209a);
                    this.f58210b.add(aVar);
                }
            }
        }
    }
}
