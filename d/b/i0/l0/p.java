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
    public static p f56594f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.h0.w.p.c> f56595e = new LinkedList<>();

    public static p e() {
        if (f56594f == null) {
            synchronized (p.class) {
                if (f56594f == null) {
                    f56594f = new p();
                }
            }
        }
        return f56594f;
    }

    @Override // d.b.h0.w.p.a
    public void b(a.InterfaceC1109a interfaceC1109a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f56595e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f56595e.add(cVar);
                        if (interfaceC1109a != null) {
                            interfaceC1109a.a(cVar);
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
