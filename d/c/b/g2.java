package d.c.b;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public static final LinkedList<z> f65843a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public static final LinkedList<z> f65844b = new LinkedList<>();

    public static void a() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f65843a) {
            linkedList.addAll(f65843a);
            linkedList2.addAll(f65844b);
            f65843a.clear();
            f65844b.clear();
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
        synchronized (f65843a) {
            if (f65843a.size() > 200) {
                r0.c("drop event in cache", null);
                f65844b.add(f65843a.poll());
            }
            f65843a.add(zVar);
        }
    }
}
