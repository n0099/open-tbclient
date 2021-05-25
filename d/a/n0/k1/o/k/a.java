package d.a.n0.k1.o.k;

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

    public static <T> void b(List<T> list, T t, int i2) {
        if (!h(list) && g(list, i2)) {
            try {
                list.add(i2, t);
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

    public static <T> T d(List<T> list, int i2) {
        if (!e(list) && g(list, i2)) {
            try {
                return list.get(i2);
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

    public static boolean g(List list, int i2) {
        return !h(list) && i2 >= 0 && i2 < list.size();
    }

    public static boolean h(Object obj) {
        return obj == null;
    }

    public static void i(List list, int i2) {
        if (!e(list) && g(list, i2)) {
            try {
                list.remove(i2);
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
