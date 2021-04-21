package d.b.j0.e1.f.j;

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
import d.b.j0.e1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.b.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f55639b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f55640c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55641d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55642e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f55643f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f55644g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f55645h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1289a f55646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f55647f;

        public a(a.C1289a c1289a, int i) {
            this.f55646e = c1289a;
            this.f55647f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f55644g, this.f55646e, this.f55647f, 0L);
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
        this.f55640c = (BarImageView) d(R.id.bar_icon);
        this.f55641d = (TextView) d(R.id.bar_name);
        this.f55642e = (TextView) d(R.id.message_time);
        this.f55643f = (LinearLayout) d(R.id.item_container);
        this.f55644g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f55639b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void i() {
        SkinManager.setViewTextColor(this.f55642e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55641d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f55645h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f55643f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f55639b);
        }
    }

    public void k(Context context, a.C1289a c1289a, d.b.j0.e1.h.o.a aVar, d.b.j0.e1.i.a.b.b bVar, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        if (c1289a == null) {
            return;
        }
        if (this.k) {
            this.f55640c.setVisibility(8);
            this.f55641d.setVisibility(8);
            this.f55642e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f55642e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f55642e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f55644g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f55643f.setPadding(g2, g3, g2, StringUtils.isNull(c1289a.f55851b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f55643f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f55643f.setLayoutParams(layoutParams2);
        } else {
            this.f55640c.setShowOval(true);
            this.f55640c.setAutoChangeStyle(true);
            this.f55640c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f55640c.setStrokeColorResId(R.color.CAM_X0401);
            this.f55640c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f55640c.W(aVar.c(), 10, false);
            this.f55641d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1289a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f55642e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(g5, 0, g5, 0);
        }
        this.i.setData(c1289a, z);
        this.f55643f.removeAllViews();
        this.f55644g.setOnClickListener(new a(c1289a, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f55645h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f55643f.addView(this.f55645h);
            this.f55643f.addView(this.i);
            this.f55645h.setData(c1289a, i, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f55643f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f55643f.addView(this.i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
