package d.a.k0.q0.w1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView;
import d.a.k0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class a extends d.a.c.j.e.a<d, GameSubCommentView.GameSubCommentViewHolder> {
    public TbPageContext m;
    public InterfaceC1543a n;

    /* renamed from: d.a.k0.q0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1543a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: e0 */
    public GameSubCommentView.GameSubCommentViewHolder P(ViewGroup viewGroup) {
        GameSubCommentView gameSubCommentView = new GameSubCommentView(this.m);
        gameSubCommentView.d(this.n);
        return new GameSubCommentView.GameSubCommentViewHolder(gameSubCommentView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public View W(int i2, View view, ViewGroup viewGroup, d dVar, GameSubCommentView.GameSubCommentViewHolder gameSubCommentViewHolder) {
        if (dVar != null) {
            gameSubCommentViewHolder.b(dVar);
        }
        return gameSubCommentViewHolder.a();
    }

    public void g0(InterfaceC1543a interfaceC1543a) {
        this.n = interfaceC1543a;
    }
}
