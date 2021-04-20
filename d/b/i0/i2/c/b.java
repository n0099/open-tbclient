package d.b.i0.i2.c;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
/* loaded from: classes3.dex */
public class b extends d.b.c.j.e.a<d.b.i0.i2.e.c, CardViewHolder<d.b.i0.i2.j.a>> {
    public TbPageContext<?> m;
    public d.b.c.e.k.b<PersonCommonForumItemView> n;

    /* loaded from: classes3.dex */
    public class a implements d.b.c.e.k.c<PersonCommonForumItemView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.c.e.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            if (personCommonForumItemView != null) {
                personCommonForumItemView.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            return new PersonCommonForumItemView(b.this.f42855e);
        }

        public PersonCommonForumItemView h(PersonCommonForumItemView personCommonForumItemView) {
            return personCommonForumItemView;
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), d.b.i0.i2.e.c.f57131f);
        this.n = new d.b.c.e.k.b<>(new a(), 12, 0);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public CardViewHolder<d.b.i0.i2.j.a> R(ViewGroup viewGroup) {
        d.b.i0.i2.j.a aVar = new d.b.i0.i2.j.a(this.m);
        aVar.B(this.n);
        return new CardViewHolder<>(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.i2.e.c cVar, CardViewHolder<d.b.i0.i2.j.a> cardViewHolder) {
        cardViewHolder.b().o(this.m, TbadkCoreApplication.getInst().getSkinType());
        cardViewHolder.b().n(cVar);
        return cardViewHolder.a();
    }
}
