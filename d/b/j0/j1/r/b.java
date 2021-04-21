package d.b.j0.j1.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import d.b.j0.j1.p.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f57927a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final a f57928b = new b();

    public static a d() {
        a aVar = f57927a.get();
        return aVar == null ? f57928b : aVar;
    }

    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.s.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.p.a b(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.b.j0.j1.r.a
    public d.b.j0.j1.o.g.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}
