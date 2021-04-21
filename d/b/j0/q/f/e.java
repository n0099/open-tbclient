package d.b.j0.q.f;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f59428a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.i0.s.f.a> f59429b;

    public List<d.b.i0.s.f.a> a() {
        if (this.f59429b == null) {
            this.f59429b = new ArrayList();
        }
        return this.f59429b;
    }

    public String b() {
        return this.f59428a;
    }

    public void c(listData listdata) {
        if (listdata != null) {
            this.f59428a = listdata.key;
            if (listdata.friend_list != null) {
                this.f59429b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    d.b.i0.s.f.a aVar = new d.b.i0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f59428a);
                    this.f59429b.add(aVar);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        if (robotslist != null) {
            this.f59428a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.f59429b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    d.b.i0.s.f.a aVar = new d.b.i0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f59428a);
                    this.f59429b.add(aVar);
                }
            }
        }
    }
}
