package d.a.k0.l0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.a.j0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.a.j0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f57133f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.j0.w.p.c> f57134e = new LinkedList<>();

    public static p e() {
        if (f57133f == null) {
            synchronized (p.class) {
                if (f57133f == null) {
                    f57133f = new p();
                }
            }
        }
        return f57133f;
    }

    @Override // d.a.j0.w.p.a
    public void b(a.InterfaceC1158a interfaceC1158a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f57134e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f57134e.add(cVar);
                        if (interfaceC1158a != null) {
                            interfaceC1158a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.j0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.a.j0.w.p.a
    public void d() {
    }
}
