package d.a.n0.s.f;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f60372a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.m0.s.f.a> f60373b;

    public List<d.a.m0.s.f.a> a() {
        if (this.f60373b == null) {
            this.f60373b = new ArrayList();
        }
        return this.f60373b;
    }

    public String b() {
        return this.f60372a;
    }

    public void c(listData listdata) {
        if (listdata != null) {
            this.f60372a = listdata.key;
            if (listdata.friend_list != null) {
                this.f60373b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    d.a.m0.s.f.a aVar = new d.a.m0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f60372a);
                    this.f60373b.add(aVar);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        if (robotslist != null) {
            this.f60372a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.f60373b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    d.a.m0.s.f.a aVar = new d.a.m0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f60372a);
                    this.f60373b.add(aVar);
                }
            }
        }
    }
}
