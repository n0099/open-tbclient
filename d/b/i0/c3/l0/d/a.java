package d.b.i0.c3.l0.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a {
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    public HashMap<String, List<b>> mAsyncCallBackMethodList;
    public HashSet<String> mNotificationNameList;

    public c addObserver(String str, c cVar, boolean z) {
        if (cVar == null) {
            cVar = new c();
        }
        if (this.mNotificationNameList.contains(str)) {
            cVar.k(false);
            cVar.p(true);
            List<b> list = this.mAsyncCallBackMethodList.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            b bVar = new b();
            bVar.d(cVar.c());
            bVar.c(z);
            list.add(bVar);
            this.mAsyncCallBackMethodList.put(str, list);
        }
        return cVar;
    }

    public abstract c dispatch(e eVar, c cVar);

    public abstract List<c> processNotification(String str, HashMap hashMap);
}
