package d.a.j0.q.f;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f57467a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.i0.s.f.a> f57468b;

    public List<d.a.i0.s.f.a> a() {
        if (this.f57468b == null) {
            this.f57468b = new ArrayList();
        }
        return this.f57468b;
    }

    public String b() {
        return this.f57467a;
    }

    public void c(listData listdata) {
        if (listdata != null) {
            this.f57467a = listdata.key;
            if (listdata.friend_list != null) {
                this.f57468b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    d.a.i0.s.f.a aVar = new d.a.i0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f57467a);
                    this.f57468b.add(aVar);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        if (robotslist != null) {
            this.f57467a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.f57468b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    d.a.i0.s.f.a aVar = new d.a.i0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f57467a);
                    this.f57468b.add(aVar);
                }
            }
        }
    }
}
