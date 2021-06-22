package d.a.o0.k1.r;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import d.a.o0.k1.p.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<a> f60602a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final a f60603b = new b();

    public static a d() {
        a aVar = f60602a.get();
        return aVar == null ? f60603b : aVar;
    }

    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.p.a a(e eVar) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        BdLog.e("Card project loaded failed.");
        return null;
    }

    @Override // d.a.o0.k1.r.a
    public d.a.o0.k1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        BdLog.e("Card project loaded failed.");
        return null;
    }
}
