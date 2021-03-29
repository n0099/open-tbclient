package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import tbclient.Hottopic.HotThread;
/* loaded from: classes3.dex */
public class g implements d.b.b.j.e.n {

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f52115f = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52116e;

    public void a(HotThread hotThread) {
        if (hotThread == null) {
            return;
        }
        this.f52116e = hotThread.hot_title;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return f52115f;
    }
}
