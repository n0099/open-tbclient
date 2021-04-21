package d.b.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends d.b.i.a<d.b.i0.r.q.a> {
    public CardForumHeadLayout j;
    public d.b.i0.r.q.a k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.d() != null) {
                m.this.d().a(view, m.this.k);
            }
        }
    }

    public m(Context context) {
        super(context);
        CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(context);
        this.j = cardForumHeadLayout;
        cardForumHeadLayout.setAfterClickListener(new a());
    }

    @Override // d.b.i.a
    public View g() {
        return this.j;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        CardForumHeadLayout cardForumHeadLayout = this.j;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: p */
    public void a(d.b.i0.r.q.a aVar) {
        CardForumHeadLayout cardForumHeadLayout = this.j;
        if (cardForumHeadLayout == null || aVar == null) {
            return;
        }
        this.k = aVar;
        cardForumHeadLayout.setData(aVar.n());
    }
}
