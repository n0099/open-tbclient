package d.a.c.c.e.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class c {
    public static boolean a(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && next.i()) {
                next.g();
                if (next.o() >= next.l()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<e> linkedList, int i2, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null) {
                if (i2 != 0 && m.getTag() == bdUniqueId && i2 == m.getCmd()) {
                    return true;
                }
                if (i2 == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(LinkedList<e> linkedList, a aVar, int i2) {
        SocketMessage m;
        if (aVar == null) {
            return false;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null && m.getCmd() == i2 && aVar.onFindMessage(m)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(LinkedList<e> linkedList, int i2) {
        SocketMessage m;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null && m.getCmd() == i2) {
                return true;
            }
        }
        return false;
    }

    public static e f(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.peek();
    }

    public static int g(e eVar, LinkedList<e> linkedList) {
        if (eVar == null || linkedList == null) {
            return -1;
        }
        int size = linkedList.size();
        int i2 = 0;
        while (i2 < size && linkedList.get(i2).n() <= eVar.n()) {
            i2++;
        }
        return i2;
    }

    public static boolean h(e eVar, LinkedList<e> linkedList) {
        int g2;
        if (eVar == null || linkedList == null || (g2 = g(eVar, linkedList)) < 0 || g2 > linkedList.size()) {
            return false;
        }
        linkedList.add(g2, eVar);
        return true;
    }

    public static boolean i(LinkedList<e> linkedList, LinkedList<e> linkedList2) {
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            e poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<e> linkedList, LinkedList<e> linkedList2, e eVar) {
        if (eVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(eVar)) {
            return false;
        }
        linkedList2.add(eVar);
        return true;
    }

    public static e k(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && !next.i()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static e l(LinkedList<e> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        return linkedList.poll();
    }

    public static void m(LinkedList<e> linkedList, int i2, BdUniqueId bdUniqueId) {
        SocketMessage m;
        if (linkedList == null) {
            return;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null && ((i2 != 0 && m.getTag() == bdUniqueId && i2 == m.getCmd()) || (i2 == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(e eVar, LinkedList<e> linkedList) {
        if (eVar == null || linkedList == null) {
            return false;
        }
        return linkedList.remove(eVar);
    }

    public static void o(LinkedList<e> linkedList, int i2) {
        SocketMessage m;
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && (m = next.m()) != null && m.getCmd() == i2) {
                it.remove();
            }
        }
    }

    public static e p(int i2, LinkedList<e> linkedList) {
        if (linkedList == null) {
            return null;
        }
        Iterator<e> it = linkedList.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next != null && next.q() == i2) {
                it.remove();
                next.w();
                return next;
            }
        }
        return null;
    }

    public static int q(LinkedList<e> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        return linkedList.size();
    }
}
