package d.a.p0.u0;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public interface m0 {
    d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z);

    k<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);

    d.a.c.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z);

    d.a.c.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2);
}
