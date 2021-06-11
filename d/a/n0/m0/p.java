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
    public static p f61012f;

    /* renamed from: e  reason: collision with root package name */
    public LinkedList<d.a.m0.w.p.c> f61013e = new LinkedList<>();

    public static p e() {
        if (f61012f == null) {
            synchronized (p.class) {
                if (f61012f == null) {
                    f61012f = new p();
                }
            }
        }
        return f61012f;
    }

    @Override // d.a.m0.w.p.a
    public void b(a.InterfaceC1223a interfaceC1223a) {
        if (FileHelper.checkSD()) {
            List<MyEmotionGroupData> h2 = a.c().h(TbadkCoreApplication.getCurrentAccount());
            this.f61013e.clear();
            for (MyEmotionGroupData myEmotionGroupData : h2) {
                EmotionGroupData j = g.k().j(myEmotionGroupData.getGroupId());
                if (j != null) {
                    c cVar = new c(j);
                    if (cVar.d() != null) {
                        this.f61013e.add(cVar);
                        if (interfaceC1223a != null) {
                            interfaceC1223a.a(cVar);
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
