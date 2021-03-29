package d.b.i0.d1.f.j;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.d1.l.c.a;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends d.b.b.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53696b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f53697c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53698d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53699e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53700f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f53701g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f53702h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1203a f53703e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53704f;

        public a(a.C1203a c1203a, int i) {
            this.f53703e = c1203a;
            this.f53704f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f53701g, this.f53703e, this.f53704f, 0L);
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
        this.f53697c = (BarImageView) d(R.id.bar_icon);
        this.f53698d = (TextView) d(R.id.bar_name);
        this.f53699e = (TextView) d(R.id.message_time);
        this.f53700f = (LinearLayout) d(R.id.item_container);
        this.f53701g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f53696b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void i() {
        SkinManager.setViewTextColor(this.f53699e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f53698d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f53702h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53700f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53696b);
        }
    }

    public void k(Context context, a.C1203a c1203a, d.b.i0.d1.h.o.a aVar, d.b.i0.d1.i.a.b.b bVar, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        if (c1203a == null) {
            return;
        }
        if (this.k) {
            this.f53697c.setVisibility(8);
            this.f53698d.setVisibility(8);
            this.f53699e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53699e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f53699e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f53701g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f53700f.setPadding(g2, g3, g2, StringUtils.isNull(c1203a.f53908b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53700f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f53700f.setLayoutParams(layoutParams2);
        } else {
            this.f53697c.setShowOval(true);
            this.f53697c.setAutoChangeStyle(true);
            this.f53697c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f53697c.setStrokeColorResId(R.color.CAM_X0401);
            this.f53697c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f53697c.W(aVar.c(), 10, false);
            this.f53698d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1203a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f53699e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(g5, 0, g5, 0);
        }
        this.i.setData(c1203a, z);
        this.f53700f.removeAllViews();
        this.f53701g.setOnClickListener(new a(c1203a, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f53702h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f53700f.addView(this.f53702h);
            this.f53700f.addView(this.i);
            this.f53702h.setData(c1203a, i, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f53700f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f53700f.addView(this.i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
