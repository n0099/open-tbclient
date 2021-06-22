package d.a.o0.s.f;

import java.util.ArrayList;
import java.util.List;
import tbclient.GetAddressList.friendList;
import tbclient.GetAddressList.listData;
import tbclient.GetAddressList.robotsList;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f64186a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.n0.s.f.a> f64187b;

    public List<d.a.n0.s.f.a> a() {
        if (this.f64187b == null) {
            this.f64187b = new ArrayList();
        }
        return this.f64187b;
    }

    public String b() {
        return this.f64186a;
    }

    public void c(listData listdata) {
        if (listdata != null) {
            this.f64186a = listdata.key;
            if (listdata.friend_list != null) {
                this.f64187b = new ArrayList();
                for (friendList friendlist : listdata.friend_list) {
                    d.a.n0.s.f.a aVar = new d.a.n0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f64186a);
                    this.f64187b.add(aVar);
                }
            }
        }
    }

    public void d(robotsList robotslist) {
        if (robotslist != null) {
            this.f64186a = robotslist.key;
            if (robotslist.friend_list != null) {
                this.f64187b = new ArrayList();
                for (friendList friendlist : robotslist.friend_list) {
                    d.a.n0.s.f.a aVar = new d.a.n0.s.f.a();
                    aVar.j(friendlist);
                    aVar.k(this.f64186a);
                    this.f64187b.add(aVar);
                }
            }
        }
    }
}
