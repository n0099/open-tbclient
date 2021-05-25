package d.a.n0.m0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.a.m0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.a.m0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f57323f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.m0.w.p.c> f57324e = new LinkedList<>();

    public static p e() {
        if (f57323f == null) {
            synchronized (p.class) {
                if (f57323f == null) {
                    f57323f = new p();
                }
            }
        }
        return f57323f;
    }

    @Override // d.a.m0.w.p.a
    public void b(a.InterfaceC1167a interfaceC1167a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f57324e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f57324e.add(cVar);
                        if (interfaceC1167a != null) {
                            interfaceC1167a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.m0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.a.m0.w.p.a
    public void d() {
    }
}
