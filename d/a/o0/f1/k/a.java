package d.a.o0.f1.k;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, ImMessageCenterPojo> f58396a = new ConcurrentHashMap<>();

    /* renamed from: d.a.o0.f1.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1376a {
        void a(Iterator<ImMessageCenterPojo> it);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo == null) {
            return;
        }
        this.f58396a.put(imMessageCenterPojo.getGid(), imMessageCenterPojo);
    }

    public void b() {
        this.f58396a.clear();
    }

    public ImMessageCenterPojo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f58396a.get(str);
    }

    public void d(InterfaceC1376a interfaceC1376a) {
        interfaceC1376a.a(this.f58396a.values().iterator());
    }

    public boolean e(String str) {
        return (TextUtils.isEmpty(str) || this.f58396a.remove(str) == null) ? false : true;
    }
}
