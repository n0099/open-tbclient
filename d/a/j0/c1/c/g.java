package d.a.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes4.dex */
public class g implements d.a.c.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f51699f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51700e;

    public void c(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f51700e = hotThread.hot_title;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return f51699f;
    }
}
