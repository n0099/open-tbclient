package d.c.b;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedList<z> f65938a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public static final LinkedList<z> f65939b = new LinkedList<>();

    public static void a() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f65938a) {
            linkedList.addAll(f65938a);
            linkedList2.addAll(f65939b);
            f65938a.clear();
            f65939b.clear();
        }
        while (!linkedList.isEmpty()) {
            x1.d((z) linkedList.poll());
        }
        while (!linkedList2.isEmpty()) {
            z zVar = (z) linkedList2.poll();
            i0 i0Var = null;
            if (zVar instanceof i0) {
                i0Var = (i0) zVar;
            } else if (zVar instanceof b0) {
                b0 b0Var = (b0) zVar;
                i0Var = new i0("" + b0Var.p() + b0Var.q(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
            } else if (zVar instanceof d0) {
                i0Var = new i0(((d0) zVar).q(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
            }
            x1.d(i0Var);
        }
    }

    public static void b(z zVar) {
        synchronized (f65938a) {
            if (f65938a.size() > 200) {
                r0.c("drop event in cache", null);
                f65939b.add(f65938a.poll());
            }
            f65938a.add(zVar);
        }
    }
}
