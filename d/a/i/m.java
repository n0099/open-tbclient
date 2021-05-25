package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class m extends d.a.i.a<d.a.m0.r.q.a> {
    public CardForumHeadLayout j;
    public d.a.m0.r.q.a k;

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

    @Override // d.a.i.a
    public View g() {
        return this.j;
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CardForumHeadLayout cardForumHeadLayout = this.j;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: p */
    public void a(d.a.m0.r.q.a aVar) {
        CardForumHeadLayout cardForumHeadLayout = this.j;
        if (cardForumHeadLayout == null || aVar == null) {
            return;
        }
        this.k = aVar;
        cardForumHeadLayout.setData(aVar.m());
    }
}
