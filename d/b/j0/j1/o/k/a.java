package d.b.j0.j1.o.k;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    public static <T> void a(List<T> list, T t) {
        if (h(list)) {
            return;
        }
        try {
            list.add(t);
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static <T> void b(List<T> list, T t, int i) {
        if (!h(list) && g(list, i)) {
            try {
                list.add(i, t);
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
            }
        }
    }

    public static void c(List list) {
        if (e(list)) {
            return;
        }
        try {
            list.clear();
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static <T> T d(List<T> list, int i) {
        if (!e(list) && g(list, i)) {
            try {
                return list.get(i);
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
                return null;
            }
        }
        return null;
    }

    public static boolean e(List list) {
        if (h(list) || list.isEmpty()) {
            BdLog.e("list is empty");
            return true;
        }
        return false;
    }

    public static boolean f(Map map) {
        if (h(map) || map.isEmpty()) {
            BdLog.e("map is empty");
            return true;
        }
        return false;
    }

    public static boolean g(List list, int i) {
        return !h(list) && i >= 0 && i < list.size();
    }

    public static boolean h(Object obj) {
        return obj == null;
    }

    public static void i(List list, int i) {
        if (!e(list) && g(list, i)) {
            try {
                list.remove(i);
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
            }
        }
    }

    public static <T> void j(List<T> list, T t) {
        if (e(list)) {
            return;
        }
        try {
            list.remove(t);
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static int k(List list) {
        if (!h(list) && !list.isEmpty()) {
            try {
                return list.size();
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
            }
        }
        return 0;
    }

    public static void l(Exception exc) {
        if (BdBaseApplication.getInst().isDebugMode() && (exc instanceof RuntimeException)) {
            throw ((RuntimeException) exc);
        }
    }
}
