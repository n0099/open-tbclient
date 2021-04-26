package d.a.j0.j1.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import d.a.j0.j1.p.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f55901a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final a f55902b = new b();

    public static a d() {
        a aVar = f55901a.get();
        return aVar == null ? f55902b : aVar;
    }

    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.p.a a(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.j0.j1.r.a
    public d.a.j0.j1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}
