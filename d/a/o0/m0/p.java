package d.a.o0.m0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.a.n0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.a.n0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f61137f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.n0.w.p.c> f61138e = new LinkedList<>();

    public static p e() {
        if (f61137f == null) {
            synchronized (p.class) {
                if (f61137f == null) {
                    f61137f = new p();
                }
            }
        }
        return f61137f;
    }

    @Override // d.a.n0.w.p.a
    public void b(a.InterfaceC1226a interfaceC1226a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f61138e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f61138e.add(cVar);
                        if (interfaceC1226a != null) {
                            interfaceC1226a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.a.n0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.a.n0.w.p.a
    public void d() {
    }
}
