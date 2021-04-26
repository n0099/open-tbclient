package d.a.j0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
/* loaded from: classes4.dex */
public class b extends d.a.c.j.e.a<d.a.j0.i2.e.c, CardViewHolder<d.a.j0.i2.j.a>> {
    public TbPageContext<?> m;
    public d.a.c.e.k.b<PersonCommonForumItemView> n;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<PersonCommonForumItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            return new PersonCommonForumItemView(b.this.f40319e);
        }

        public PersonCommonForumItemView h(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.j0.i2.e.c.f55502f);
        this.n = new d.a.c.e.k.b<>(new a(), 12, 0);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: f0 */
    public CardViewHolder<d.a.j0.i2.j.a> P(ViewGroup viewGroup) {
        d.a.j0.i2.j.a aVar = new d.a.j0.i2.j.a(this.m);
        aVar.z(this.n);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.j0.i2.e.c cVar, CardViewHolder<d.a.j0.i2.j.a> cardViewHolder) {
        cardViewHolder.b().n(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().m(cVar);
        return cardViewHolder.a();
    }
}
