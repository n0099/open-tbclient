package d.a.n0.b1.h.h;

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
public class b0 extends d.a.c.k.e.a<d.a.n0.b1.h.j.h, CardViewHolder<b>> {
    public static final int n = d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public class a implements d.a.c.k.e.w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f55407e;

        public a(b bVar) {
            this.f55407e = bVar;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b bVar;
            if (view == null || (bVar = this.f55407e) == null || d.a.c.e.p.k.isEmpty(bVar.p)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12885"));
            UrlManager.getInstance().dealOneLink(b0.this.m, new String[]{this.f55407e.p});
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.n0.z.b<d.a.n0.b1.h.j.h> {
        public TbImageView m;
        public ImageView n;
        public View o;
        public String p;

        public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
            super(tbPageContext, viewGroup);
            TbImageView tbImageView = (TbImageView) m().findViewById(R.id.quiz_entrance_img);
            this.m = tbImageView;
            tbImageView.setAutoChangeStyle(true);
            this.m.setRadiusById(R.string.J_X06);
            this.m.setConrers(15);
            this.m.setScaleType(ImageView.ScaleType.FIT_XY);
            this.m.setPlaceHolder(2);
            this.o = m().findViewById(R.id.close_layout);
            this.n = (ImageView) m().findViewById(R.id.close);
            this.o.setOnClickListener(this);
            m().setOnClickListener(this);
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_card_close22, R.color.CAM_X0101, null);
            o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }

        @Override // d.a.n0.z.b
        public int h() {
            return R.layout.card_quiz_entrance;
        }

        @Override // d.a.n0.z.b
        public void o(TbPageContext tbPageContext, int i2) {
            SkinManager.setBackgroundColor(m(), R.color.transparent);
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
        /* renamed from: u */
        public void n(d.a.n0.b1.h.j.h hVar) {
            if (hVar != null) {
                v(hVar.f55498f, hVar.f55497e);
                this.m.setPlaceHolder(2);
                this.m.U(hVar.f55499g, 10, false);
                this.p = hVar.f55500h;
            }
            o(k(), TbadkCoreApplication.getInst().getSkinType());
        }

        public final void v(int i2, int i3) {
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
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public CardViewHolder<b> Q(ViewGroup viewGroup) {
        b bVar = new b(this.m, viewGroup);
        bVar.m().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
        a0(new a(bVar));
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.n0.b1.h.j.h hVar, CardViewHolder<b> cardViewHolder) {
        if (hVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c12884"));
        cardViewHolder.b().n(hVar);
        return cardViewHolder.b().m();
    }
}
