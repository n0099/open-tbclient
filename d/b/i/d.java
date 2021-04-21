package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class d extends d.b.i.a<d.b.i0.r.q.a> {
    public CardUserInfoLayout j;
    public int k;
    public d.b.i0.r.q.a l;
    public b m;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.m != null) {
                d.this.m.a(d.this.l, view);
            }
            if (d.this.d() != null) {
                d.this.d().a(view, d.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(d.b.i0.r.q.a aVar, View view);
    }

    public d(Context context) {
        super(context);
        this.k = 34053;
        CardUserInfoLayout cardUserInfoLayout = new CardUserInfoLayout(context);
        this.j = cardUserInfoLayout;
        cardUserInfoLayout.setShowFlag(this.k);
        this.j.setUserAfterClickListener(new a());
    }

    @Override // d.b.i.a
    public void b(int i) {
        int i2 = i | this.k;
        this.k = i2;
        u(i2);
    }

    @Override // d.b.i.a
    public void c(int i) {
        int i2 = (~i) & this.k;
        this.k = i2;
        u(i2);
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.j.onChangeSkinType(tbPageContext, i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: q */
    public void a(d.b.i0.r.q.a aVar) {
        this.l = aVar;
        this.j.setData(aVar.n());
    }

    public void r(boolean z) {
        CardUserInfoLayout cardUserInfoLayout = this.j;
        if (cardUserInfoLayout == null || cardUserInfoLayout.getAvatar() == null) {
            return;
        }
        this.j.getAvatar().setClickable(z);
    }

    public void s(b bVar) {
        this.m = bVar;
    }

    public void t(BdUniqueId bdUniqueId) {
        this.j.setPageUniqueId(bdUniqueId);
    }

    public void u(int i) {
        this.j.setShowFlag(this.k);
    }

    public void v(TbPageContext tbPageContext) {
        this.j.setPageContext(tbPageContext);
    }

    public void w(boolean z) {
        CardUserInfoLayout cardUserInfoLayout = this.j;
        if (cardUserInfoLayout == null || cardUserInfoLayout.getUserName() == null) {
            return;
        }
        this.j.getUserName().setClickable(z);
    }
}
