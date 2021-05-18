package d.a.k0.q0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.z1;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class e implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<n0> f58303a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public static final n0 f58304b = new e();

    public static n0 e() {
        n0 n0Var = f58303a.get();
        return n0Var == null ? f58304b : n0Var;
    }

    @Override // d.a.k0.q0.n0
    public d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // d.a.k0.q0.n0
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // d.a.k0.q0.n0
    public d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }

    @Override // d.a.k0.q0.n0
    public d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        BdLog.e("Frs extra project not loaded.");
        return null;
    }
}
