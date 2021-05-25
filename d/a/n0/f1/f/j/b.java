package d.a.n0.f1.f.j;

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
import d.a.n0.f1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f54387b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f54388c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54389d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f54390e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f54391f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f54392g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f54393h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f54394i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1318a f54395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54396f;

        public a(a.C1318a c1318a, int i2) {
            this.f54395e = c1318a;
            this.f54396f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f54392g, this.f54395e, this.f54396f, 0L);
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
        this.f54388c = (BarImageView) d(R.id.bar_icon);
        this.f54389d = (TextView) d(R.id.bar_name);
        this.f54390e = (TextView) d(R.id.message_time);
        this.f54391f = (LinearLayout) d(R.id.item_container);
        this.f54392g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f54387b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void j() {
        SkinManager.setViewTextColor(this.f54390e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f54389d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f54393h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.f54394i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f54391f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f54387b);
        }
    }

    public void k(Context context, a.C1318a c1318a, d.a.n0.f1.h.o.a aVar, d.a.n0.f1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        if (c1318a == null) {
            return;
        }
        if (this.k) {
            this.f54388c.setVisibility(8);
            this.f54389d.setVisibility(8);
            this.f54390e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54390e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f54390e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f54392g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f54391f.setPadding(g2, g3, g2, StringUtils.isNull(c1318a.f54608b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f54391f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f54391f.setLayoutParams(layoutParams2);
        } else {
            this.f54388c.setShowOval(true);
            this.f54388c.setAutoChangeStyle(true);
            this.f54388c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f54388c.setStrokeColorResId(R.color.CAM_X0401);
            this.f54388c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f54388c.V(aVar.c(), 10, false);
            this.f54389d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1318a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f54390e.setText(formatTimeForJustNow);
        this.f54394i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f54394i.setPadding(g5, 0, g5, 0);
        }
        this.f54394i.setData(c1318a, z);
        this.f54391f.removeAllViews();
        this.f54392g.setOnClickListener(new a(c1318a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f54393h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f54394i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f54391f.addView(this.f54393h);
            this.f54391f.addView(this.f54394i);
            this.f54393h.setData(c1318a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f54391f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f54394i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f54391f.addView(this.f54394i);
        }
        j();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
