package d.a.n0.k1.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import d.a.n0.k1.p.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f56788a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final a f56789b = new b();

    public static a d() {
        a aVar = f56788a.get();
        return aVar == null ? f56789b : aVar;
    }

    @Override // d.a.n0.k1.r.a
    public d.a.n0.k1.p.a a(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.n0.k1.r.a
    public d.a.n0.k1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.n0.k1.r.a
    public d.a.n0.k1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}
