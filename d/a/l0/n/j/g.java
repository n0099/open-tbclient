package d.a.l0.n.j;

import com.baidu.swan.pms.node.Node;
/* loaded from: classes3.dex */
public class g {
    public static d a(Node node) {
        Class<? extends d> processor;
        if (node == null || (processor = node.getProcessor()) == null) {
            return null;
        }
        try {
            return processor.newInstance();
        } catch (IllegalAccessException | InstantiationException e2) {
            if (d.a.l0.n.c.f47984a) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
