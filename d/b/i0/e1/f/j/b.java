package d.b.i0.e1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemBottom;
import com.baidu.tieba.im.chat.officialBar.OfficialFeedItemImage;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.e1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.b.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f55218b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f55219c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55220d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55221e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55222f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f55223g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f55224h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1266a f55225e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55226f;

        public a(a.C1266a c1266a, int i) {
            this.f55225e = c1266a;
            this.f55226f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f55223g, this.f55225e, this.f55226f, 0L);
            }
        }
    }

    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        this.j = null;
        this.k = z;
        h();
    }

    public final void h() {
        this.f55219c = (BarImageView) d(R.id.bar_icon);
        this.f55220d = (TextView) d(R.id.bar_name);
        this.f55221e = (TextView) d(R.id.message_time);
        this.f55222f = (LinearLayout) d(R.id.item_container);
        this.f55223g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f55218b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void i() {
        SkinManager.setViewTextColor(this.f55221e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55220d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f55224h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f55222f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f55218b);
        }
    }

    public void k(Context context, a.C1266a c1266a, d.b.i0.e1.h.o.a aVar, d.b.i0.e1.i.a.b.b bVar, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        if (c1266a == null) {
            return;
        }
        if (this.k) {
            this.f55219c.setVisibility(8);
            this.f55220d.setVisibility(8);
            this.f55221e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55221e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f55221e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f55223g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f55222f.setPadding(g2, g3, g2, StringUtils.isNull(c1266a.f55430b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f55222f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f55222f.setLayoutParams(layoutParams2);
        } else {
            this.f55219c.setShowOval(true);
            this.f55219c.setAutoChangeStyle(true);
            this.f55219c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f55219c.setStrokeColorResId(R.color.CAM_X0401);
            this.f55219c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f55219c.W(aVar.c(), 10, false);
            this.f55220d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1266a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f55221e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(g5, 0, g5, 0);
        }
        this.i.setData(c1266a, z);
        this.f55222f.removeAllViews();
        this.f55223g.setOnClickListener(new a(c1266a, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f55224h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f55222f.addView(this.f55224h);
            this.f55222f.addView(this.i);
            this.f55224h.setData(c1266a, i, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f55222f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f55222f.addView(this.i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
