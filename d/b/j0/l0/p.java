package d.b.j0.l0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.b.i0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.b.i0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f58421f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.i0.w.p.c> f58422e = new LinkedList<>();

    public static p e() {
        if (f58421f == null) {
            synchronized (p.class) {
                if (f58421f == null) {
                    f58421f = new p();
                }
            }
        }
        return f58421f;
    }

    @Override // d.b.i0.w.p.a
    public void b(a.InterfaceC1144a interfaceC1144a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f58422e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f58422e.add(cVar);
                        if (interfaceC1144a != null) {
                            interfaceC1144a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.b.i0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.b.i0.w.p.a
    public void d() {
    }
}
