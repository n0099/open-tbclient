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
/* loaded from: classes4.dex */
public class b extends d.b.b.a.c<OfficialBarFeedActivity> {

    /* renamed from: b  reason: collision with root package name */
    public View f53695b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f53696c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53697d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53698e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f53699f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f53700g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f53701h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1202a f53702e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f53703f;

        public a(a.C1202a c1202a, int i) {
            this.f53702e = c1202a;
            this.f53703f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.j != null) {
                b.this.j.a(b.this.f53700g, this.f53702e, this.f53703f, 0L);
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
        this.f53696c = (BarImageView) d(R.id.bar_icon);
        this.f53697d = (TextView) d(R.id.bar_name);
        this.f53698e = (TextView) d(R.id.message_time);
        this.f53699f = (LinearLayout) d(R.id.item_container);
        this.f53700g = (RelativeLayout) d(R.id.official_bar_feed_item);
        View d2 = d(R.id.official_bar_feed_item_bg);
        this.f53695b = d2;
        if (this.k) {
            d2.setVisibility(8);
        }
    }

    public void i() {
        SkinManager.setViewTextColor(this.f53698e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f53697d, R.color.CAM_X0105);
        OfficialFeedItemImage officialFeedItemImage = this.f53701h;
        if (officialFeedItemImage != null) {
            officialFeedItemImage.c();
        }
        OfficialFeedItemBottom officialFeedItemBottom = this.i;
        if (officialFeedItemBottom != null) {
            officialFeedItemBottom.c();
        }
        if (this.k) {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53699f);
        } else {
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f53695b);
        }
    }

    public void k(Context context, a.C1202a c1202a, d.b.i0.d1.h.o.a aVar, d.b.i0.d1.i.a.b.b bVar, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        if (c1202a == null) {
            return;
        }
        if (this.k) {
            this.f53696c.setVisibility(8);
            this.f53697d.setVisibility(8);
            this.f53698e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f53698e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f53698e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f53700g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f53699f.setPadding(g2, g3, g2, StringUtils.isNull(c1202a.f53907b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f53699f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f53699f.setLayoutParams(layoutParams2);
        } else {
            this.f53696c.setShowOval(true);
            this.f53696c.setAutoChangeStyle(true);
            this.f53696c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f53696c.setStrokeColorResId(R.color.CAM_X0401);
            this.f53696c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f53696c.W(aVar.c(), 10, false);
            this.f53697d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1202a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f53698e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(g5, 0, g5, 0);
        }
        this.i.setData(c1202a, z);
        this.f53699f.removeAllViews();
        this.f53700g.setOnClickListener(new a(c1202a, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f53701h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f53699f.addView(this.f53701h);
            this.f53699f.addView(this.i);
            this.f53701h.setData(c1202a, i, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f53699f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f53699f.addView(this.i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        this.j = cVar;
    }
}
