package d.b.i0.i1.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import d.b.i0.i1.p.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f56059a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final a f56060b = new b();

    public static a d() {
        a aVar = f56059a.get();
        return aVar == null ? f56060b : aVar;
    }

    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.s.a a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.p.a b(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.b.i0.i1.r.a
    public d.b.i0.i1.o.g.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}
