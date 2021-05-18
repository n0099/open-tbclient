package d.a.k0.e1.f.j;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.k0.e1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54197b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f54198c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54199d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54200e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54201f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f54202g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f54203h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f54204i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1300a f54205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54206f;

        public a(a.C1300a c1300a, int i2) {
            this.f54205e = c1300a;
            this.f54206f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f54202g, this.f54205e, this.f54206f, 0L);
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
        this.f54198c = (BarImageView) d(R.id.bar_icon);
        this.f54199d = (TextView) d(R.id.bar_name);
        this.f54200e = (TextView) d(R.id.message_time);
        this.f54201f = (LinearLayout) d(R.id.item_container);
        this.f54202g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f54197b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void j() {
        SkinManager.setViewTextColor(this.f54200e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54199d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f54203h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.f54204i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f54201f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f54197b);
        }
    }

    public void k(Context context, a.C1300a c1300a, d.a.k0.e1.h.o.a aVar, d.a.k0.e1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        if (c1300a == null) {
            return;
        }
        if (this.k) {
            this.f54198c.setVisibility(8);
            this.f54199d.setVisibility(8);
            this.f54200e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54200e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f54200e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f54202g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f54201f.setPadding(g2, g3, g2, StringUtils.isNull(c1300a.f54418b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f54201f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f54201f.setLayoutParams(layoutParams2);
        } else {
            this.f54198c.setShowOval(true);
            this.f54198c.setAutoChangeStyle(true);
            this.f54198c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f54198c.setStrokeColorResId(R.color.CAM_X0401);
            this.f54198c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f54198c.V(aVar.c(), 10, false);
            this.f54199d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1300a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f54200e.setText(formatTimeForJustNow);
        this.f54204i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f54204i.setPadding(g5, 0, g5, 0);
        }
        this.f54204i.setData(c1300a, z);
        this.f54201f.removeAllViews();
        this.f54202g.setOnClickListener(new a(c1300a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f54203h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f54204i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f54201f.addView(this.f54203h);
            this.f54201f.addView(this.f54204i);
            this.f54203h.setData(c1300a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f54201f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f54204i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f54201f.addView(this.f54204i);
        }
        j();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
