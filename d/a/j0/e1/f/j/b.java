package d.a.j0.e1.f.j;

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
import d.a.j0.e1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53490b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f53491c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53492d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53493e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53494f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f53495g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f53496h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f53497i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1228a f53498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53499f;

        public a(a.C1228a c1228a, int i2) {
            this.f53498e = c1228a;
            this.f53499f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f53495g, this.f53498e, this.f53499f, 0L);
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
        this.f53491c = (BarImageView) d(R.id.bar_icon);
        this.f53492d = (TextView) d(R.id.bar_name);
        this.f53493e = (TextView) d(R.id.message_time);
        this.f53494f = (LinearLayout) d(R.id.item_container);
        this.f53495g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f53490b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void j() {
        SkinManager.setViewTextColor(this.f53493e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f53492d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f53496h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.f53497i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53494f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53490b);
        }
    }

    public void k(Context context, a.C1228a c1228a, d.a.j0.e1.h.o.a aVar, d.a.j0.e1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        if (c1228a == null) {
            return;
        }
        if (this.k) {
            this.f53491c.setVisibility(8);
            this.f53492d.setVisibility(8);
            this.f53493e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53493e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f53493e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f53495g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f53494f.setPadding(g2, g3, g2, StringUtils.isNull(c1228a.f53711b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53494f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f53494f.setLayoutParams(layoutParams2);
        } else {
            this.f53491c.setShowOval(true);
            this.f53491c.setAutoChangeStyle(true);
            this.f53491c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f53491c.setStrokeColorResId(R.color.CAM_X0401);
            this.f53491c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f53491c.V(aVar.c(), 10, false);
            this.f53492d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1228a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f53493e.setText(formatTimeForJustNow);
        this.f53497i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f53497i.setPadding(g5, 0, g5, 0);
        }
        this.f53497i.setData(c1228a, z);
        this.f53494f.removeAllViews();
        this.f53495g.setOnClickListener(new a(c1228a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f53496h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f53497i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f53494f.addView(this.f53496h);
            this.f53494f.addView(this.f53497i);
            this.f53496h.setData(c1228a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f53494f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f53497i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f53494f.addView(this.f53497i);
        }
        j();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
