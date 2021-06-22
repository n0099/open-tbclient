package d.a.o0.f1.f.j;

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
import d.a.o0.f1.l.c.a;
import java.util.Date;
/* loaded from: classes4.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f58201b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f58202c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58203d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58204e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58205f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58206g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f58207h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f58208i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1378a f58209e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58210f;

        public a(a.C1378a c1378a, int i2) {
            this.f58209e = c1378a;
            this.f58210f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f58206g, this.f58209e, this.f58210f, 0L);
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
        this.f58202c = (BarImageView) d(R.id.bar_icon);
        this.f58203d = (TextView) d(R.id.bar_name);
        this.f58204e = (TextView) d(R.id.message_time);
        this.f58205f = (LinearLayout) d(R.id.item_container);
        this.f58206g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f58201b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void i() {
        SkinManager.setViewTextColor(this.f58204e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f58203d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f58207h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.f58208i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58205f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58201b);
        }
    }

    public void k(Context context, a.C1378a c1378a, d.a.o0.f1.h.o.a aVar, d.a.o0.f1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        if (c1378a == null) {
            return;
        }
        if (this.k) {
            this.f58202c.setVisibility(8);
            this.f58203d.setVisibility(8);
            this.f58204e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f58204e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f58204e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f58206g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f58205f.setPadding(g2, g3, g2, StringUtils.isNull(c1378a.f58422b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f58205f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f58205f.setLayoutParams(layoutParams2);
        } else {
            this.f58202c.setShowOval(true);
            this.f58202c.setAutoChangeStyle(true);
            this.f58202c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f58202c.setStrokeColorResId(R.color.CAM_X0401);
            this.f58202c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f58202c.U(aVar.c(), 10, false);
            this.f58203d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1378a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f58204e.setText(formatTimeForJustNow);
        this.f58208i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f58208i.setPadding(g5, 0, g5, 0);
        }
        this.f58208i.setData(c1378a, z);
        this.f58205f.removeAllViews();
        this.f58206g.setOnClickListener(new a(c1378a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f58207h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f58208i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f58205f.addView(this.f58207h);
            this.f58205f.addView(this.f58208i);
            this.f58207h.setData(c1378a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f58205f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f58208i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f58205f.addView(this.f58208i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
