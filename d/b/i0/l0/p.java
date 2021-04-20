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
    public static p f58000f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.b.h0.w.p.c> f58001e = new LinkedList<>();

    public static p e() {
        if (f58000f == null) {
            synchronized (p.class) {
                if (f58000f == null) {
                    f58000f = new p();
                }
            }
        }
        return f58000f;
    }

    @Override // d.b.h0.w.p.a
    public void b(a.InterfaceC1122a interfaceC1122a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f58001e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f58001e.add(cVar);
                        if (interfaceC1122a != null) {
                            interfaceC1122a.a(cVar);
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
