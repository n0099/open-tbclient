package d.a.k0.y.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes4.dex */
public class a extends d.a.j0.g0.f.b<tinfo, d.a.j0.g0.d.b, d.a.j0.g0.f.a<tinfo, d.a.j0.g0.d.b>> {
    public a(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
    }

    @Override // d.a.j0.g0.f.b
    public int o(int i2) {
        tinfo item = getItem(i2);
        if (item == null) {
            return -1;
        }
        List<Pic> list = item.pics;
        if (list != null) {
            int size = list.size();
            if (size >= 3) {
                return 0;
            }
            if (size > 0 && size < 3) {
                return 2;
            }
        }
        return 1;
    }

    public void p(long j) {
        List<tinfo> d2;
        Long l;
        if (j > 0 && (d2 = d()) != null && d2.size() > 0) {
            tinfo tinfoVar = null;
            int size = d2.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    tinfo tinfoVar2 = d2.get(i2);
                    if (tinfoVar2 != null && (l = tinfoVar2.thread_id) != null && l.longValue() == j) {
                        tinfoVar = d2.get(i2);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (tinfoVar != null) {
                h(tinfoVar);
            }
        }
    }
}
