package d.b.i0.t.d.f.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.special_forum.subtab.view.GameLiveDoubleViewHolder;
/* loaded from: classes4.dex */
public class d extends d.b.b.j.e.a<d.b.i0.t.d.c.e.e, GameLiveDoubleViewHolder> {
    public TbPageContext<?> m;
    public d.b.i0.t.d.f.e.a.c n;
    public d.b.i0.t.d.g.d.f o;
    public String p;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.t.d.c.e.e.f60327g);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: h0 */
    public GameLiveDoubleViewHolder R(ViewGroup viewGroup) {
        d.b.i0.t.d.f.e.a.c cVar = new d.b.i0.t.d.f.e.a.c(this.m, viewGroup);
        this.n = cVar;
        d.b.i0.t.d.g.d.f fVar = this.o;
        if (fVar != null) {
            cVar.w(fVar);
        }
        return new GameLiveDoubleViewHolder(this.n);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.t.d.c.e.e eVar, GameLiveDoubleViewHolder gameLiveDoubleViewHolder) {
        gameLiveDoubleViewHolder.f14925a.v(eVar, this.p);
        return gameLiveDoubleViewHolder.a();
    }

    public void j0(String str) {
        this.p = str;
    }

    public void l0(d.b.i0.t.d.g.d.f fVar) {
        this.o = fVar;
        d.b.i0.t.d.f.e.a.c cVar = this.n;
        if (cVar != null) {
            cVar.w(fVar);
        }
    }
}
