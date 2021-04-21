package d.b.j0.e1.k;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, ImMessageCenterPojo> f55825a = new ConcurrentHashMap<>();

    /* renamed from: d.b.j0.e1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1287a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        this.f55825a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }

    public void b() {
        this.f55825a.clear();
    }

    public ImMessageCenterPojo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f55825a.get(str);
    }

    public void d(InterfaceC1287a interfaceC1287a) {
        interfaceC1287a.a(this.f55825a.values().iterator());
    }

    public boolean e(String str) {
        return (TextUtils.isEmpty(str) || this.f55825a.remove(str) == null) ? false : true;
    }
}
