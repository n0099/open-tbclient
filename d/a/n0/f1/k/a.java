package d.a.n0.f1.k;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, ImMessageCenterPojo> f58271a = new ConcurrentHashMap<>();

    /* renamed from: d.a.n0.f1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1372a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        this.f58271a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }

    public void b() {
        this.f58271a.clear();
    }

    public ImMessageCenterPojo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f58271a.get(str);
    }

    public void d(InterfaceC1372a interfaceC1372a) {
        interfaceC1372a.a(this.f58271a.values().iterator());
    }

    public boolean e(String str) {
        return (TextUtils.isEmpty(str) || this.f58271a.remove(str) == null) ? false : true;
    }
}
