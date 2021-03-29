package d.b.i0.z0.g.h;

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
/* loaded from: classes3.dex */
public class a0 extends d.b.b.j.e.a<d.b.i0.z0.g.j.h, CardViewHolder<b>> {
    public static final int n = d.b.b.e.p.l.k(TbadkCoreApplication.getInst()) - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2);
    public TbPageContext m;

    /* loaded from: classes3.dex */
    public class a implements d.b.b.j.e.w {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f63106e;

        public a(b bVar) {
            this.f63106e = bVar;
        }

        @Override // d.b.b.j.e.w
        public void f(View view, d.b.b.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            b bVar;
            if (view == null || (bVar = this.f63106e) == null || d.b.b.e.p.k.isEmpty(bVar.p)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12885"));
            UrlManager.getInstance().dealOneLink(a0.this.m, new String[]{this.f63106e.p});
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d.b.i0.x.b<d.b.i0.z0.g.j.h> {
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

        @Override // d.b.i0.x.b
        public int h() {
            return R.layout.card_quiz_entrance;
        }

        @Override // d.b.i0.x.b
        public void o(TbPageContext tbPageContext, int i) {
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
        @Override // d.b.i0.x.b
        /* renamed from: v */
        public void n(d.b.i0.z0.g.j.h hVar) {
            if (hVar != null) {
                w(hVar.f63192f, hVar.f63191e);
                this.m.setPlaceHolder(2);
                this.m.W(hVar.f63193g, 10, false);
                this.p = hVar.f63194h;
            }
            o(l(), TbadkCoreApplication.getInst().getSkinType());
        }

        public final void w(int i, int i2) {
            if (this.m == null) {
                return;
            }
            Context context = TbadkCoreApplication.getInst().getContext();
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (context == null || layoutParams == null) {
                return;
            }
            int i3 = a0.n;
            int i4 = (i <= 0 || i2 <= 0) ? (int) (((i3 * 1.0f) * 182.0f) / 988.0f) : (int) (((i3 * 1.0f) * i2) / i);
            layoutParams.width = -1;
            layoutParams.height = i4;
            this.m.setLayoutParams(layoutParams);
        }
    }

    public a0(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public CardViewHolder<b> R(ViewGroup viewGroup) {
        b bVar = new b(this.m, viewGroup);
        bVar.m().setPadding(0, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), 0, 0);
        c0(new a(bVar));
        return new CardViewHolder<>(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: l0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.z0.g.j.h hVar, CardViewHolder<b> cardViewHolder) {
        if (hVar == null || cardViewHolder == null || cardViewHolder.b() == null) {
            return null;
        }
        TiebaStatic.log(new StatisticItem("c12884"));
        cardViewHolder.b().n(hVar);
        return cardViewHolder.b().m();
    }
}
