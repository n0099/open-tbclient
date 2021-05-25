package d.a.n0.b1.g.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
/* loaded from: classes4.dex */
public class b0 extends d.a.c.j.e.a<d.a.n0.b1.g.j.h, CardViewHolder<b>> {
    public static final int n = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.j.e.w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f51724e;

        public a(b bVar) {
            this.f51724e = bVar;
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b bVar;
            if (view == null || (bVar = this.f51724e) == null || d.a.c.e.p.k.isEmpty(bVar.p)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12885"));
            UrlManager.getInstance().dealOneLink(b0.this.m, new String[]{this.f51724e.p});
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.n0.z.b<d.a.n0.b1.g.j.h> {
        public TbImageView m;
        public ImageView n;
        public View o;
        public String p;

        public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            TbImageView tbImageView = (TbImageView) l().findViewById(R.id.quiz_entrance_img);
            this.m = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.m.setRadiusById(R.string.J_X06);
            this.m.setConrers(15);
            this.m.setScaleType(ImageView.ScaleType.FIT_XY);
            this.m.setPlaceHolder(2);
            this.o = l().findViewById(R.id.close_layout);
            this.n = (ImageView) l().findViewById(R.id.close);
            this.o.setOnClickListener(this);
            l().setOnClickListener(this);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // d.a.n0.z.b
        public int g() {
            return R.layout.card_quiz_entrance;
        }

        @Override // d.a.n0.z.b
        public void n(TbPageContext tbPageContext, int i2) {
            SkinManager.setBackgroundColor(l(), R.color.transparent);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == this.o) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016569));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z.b
        /* renamed from: t */
        public void m(d.a.n0.b1.g.j.h hVar) {
            if (hVar != null) {
                u(hVar.f51815f, hVar.f51814e);
                this.m.setPlaceHolder(2);
                this.m.V(hVar.f51816g, 10, false);
                this.p = hVar.f51817h;
            }
            n(k(), TbadkCoreApplication.getInst().getSkinType());
        }

        public final void u(int i2, int i3) {
            if (this.m == null) {
                return;
            }
            Context context = TbadkCoreApplication.getInst().getContext();
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (context == null || layoutParams == null) {
                return;
            }
            int i4 = b0.n;
            int i5 = (i2 <= 0 || i3 <= 0) ? (int) (((i4 * 1.0f) * 182.0f) / 988.0f) : (int) (((i4 * 1.0f) * i3) / i2);
            layoutParams.width = -1;
            layoutParams.height = i5;
            this.m.setLayoutParams(layoutParams);
        }
    }

    public b0(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: g0 */
    public CardViewHolder<b> P(ViewGroup viewGroup) {
        b bVar = new b(this.m, viewGroup);
        bVar.l().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
        Z(new a(bVar));
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: h0 */
    public View W(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.g.j.h hVar, CardViewHolder<b> cardViewHolder) {
        if (hVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c12884"));
        cardViewHolder.b().m(hVar);
        return cardViewHolder.b().l();
    }
}
