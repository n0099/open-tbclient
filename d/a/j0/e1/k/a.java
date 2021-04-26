package d.a.j0.e1.k;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, ImMessageCenterPojo> f53685a = new ConcurrentHashMap<>();

    /* renamed from: d.a.j0.e1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1226a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        this.f53685a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }

    public void b() {
        this.f53685a.clear();
    }

    public ImMessageCenterPojo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f53685a.get(str);
    }

    public void d(InterfaceC1226a interfaceC1226a) {
        interfaceC1226a.a(this.f53685a.values().iterator());
    }

    public boolean e(String str) {
        return (TextUtils.isEmpty(str) || this.f53685a.remove(str) == null) ? false : true;
    }
}
