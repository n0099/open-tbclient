package d.b.i0.q0.w1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView;
import d.b.i0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class a extends d.b.c.j.e.a<d, GameSubCommentView.GameSubCommentViewHolder> {
    public TbPageContext m;
    public InterfaceC1507a n;

    /* renamed from: d.b.i0.q0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1507a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: h0 */
    public GameSubCommentView.GameSubCommentViewHolder R(ViewGroup viewGroup) {
        GameSubCommentView gameSubCommentView = new GameSubCommentView(this.m);
        gameSubCommentView.d(this.n);
        return new GameSubCommentView.GameSubCommentViewHolder(gameSubCommentView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d dVar, GameSubCommentView.GameSubCommentViewHolder gameSubCommentViewHolder) {
        if (dVar != null) {
            gameSubCommentViewHolder.b(dVar);
        }
        return gameSubCommentViewHolder.a();
    }

    public void j0(InterfaceC1507a interfaceC1507a) {
        this.n = interfaceC1507a;
    }
}
