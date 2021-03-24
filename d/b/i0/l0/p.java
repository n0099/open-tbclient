package d.b.i0.l0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.MyEmotionGroupData;
import d.b.h0.w.p.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class p extends d.b.h0.w.p.a {

    /* renamed from: f  reason: collision with root package name */
    public static p f56593f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.h0.w.p.c> f56594e = new LinkedList<>();

    public static p e() {
        if (f56593f == null) {
            synchronized (p.class) {
                if (f56593f == null) {
                    f56593f = new p();
                }
            }
        }
        return f56593f;
    }

    @Override // d.b.h0.w.p.a
    public void b(a.InterfaceC1108a interfaceC1108a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f56594e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f56594e.add(cVar);
                        if (interfaceC1108a != null) {
                            interfaceC1108a.a(cVar);
                        }
                    }
                }
            }
        }
    }

    @Override // d.b.h0.w.p.a
    public int c() {
        return 4;
    }

    @Override // d.b.h0.w.p.a
    public void d() {
    }
}
