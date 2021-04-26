package d.a.j0.l0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.a.i0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.a.i0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f56426f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.i0.w.p.c> f56427e = new LinkedList<>();

    public static p e() {
        if (f56426f == null) {
            synchronized (p.class) {
                if (f56426f == null) {
                    f56426f = new p();
                }
            }
        }
        return f56426f;
    }

    @Override // d.a.i0.w.p.a
    public void b(a.InterfaceC1083a interfaceC1083a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f56427e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f56427e.add(cVar);
                        if (interfaceC1083a != null) {
                            interfaceC1083a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.i0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.a.i0.w.p.a
    public void d() {
    }
}
