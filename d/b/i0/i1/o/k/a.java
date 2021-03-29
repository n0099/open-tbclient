package d.b.i0.i1.o.k;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static <T> void a(List<T> list, T t) {
        if (g(list)) {
            return;
        }
        try {
            list.add(t);
        } catch (Exception e2) {
            BdLog.e(e2);
            k(e2);
        }
    }

    public static <T> void b(List<T> list, T t, int i) {
        if (!g(list) && f(list, i)) {
            try {
                list.add(i, t);
            } catch (Exception e2) {
                BdLog.e(e2);
                k(e2);
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
            k(e2);
        }
    }

    public static <T> T d(List<T> list, int i) {
        if (!e(list) && f(list, i)) {
            try {
                return list.get(i);
            } catch (Exception e2) {
                BdLog.e(e2);
                k(e2);
                return null;
            }
        }
        return null;
    }

    public static boolean e(List list) {
        if (g(list) || list.isEmpty()) {
            BdLog.e("list is empty");
            return true;
        }
        return false;
    }

    public static boolean f(List list, int i) {
        return !g(list) && i >= 0 && i < list.size();
    }

    public static boolean g(Object obj) {
        return obj == null;
    }

    public static void h(List list, int i) {
        if (!e(list) && f(list, i)) {
            try {
                list.remove(i);
            } catch (Exception e2) {
                BdLog.e(e2);
                k(e2);
            }
        }
    }

    public static <T> void i(List<T> list, T t) {
        if (e(list)) {
            return;
        }
        try {
            list.remove(t);
        } catch (Exception e2) {
            BdLog.e(e2);
            k(e2);
        }
    }

    public static int j(List list) {
        if (!g(list) && !list.isEmpty()) {
            try {
                return list.size();
            } catch (Exception e2) {
                BdLog.e(e2);
                k(e2);
            }
        }
        return 0;
    }

    public static void k(Exception exc) {
        if (BdBaseApplication.getInst().isDebugMode() && (exc instanceof RuntimeException)) {
            throw ((RuntimeException) exc);
        }
    }
}
