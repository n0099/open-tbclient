package d.a.s0.i1.f.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.s0.i1.l.c.a;
import java.util.Date;
/* loaded from: classes9.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f61544b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f61545c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61546d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61547e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f61548f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f61549g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f61550h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f61551i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1512a f61552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61553f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f61554g;

        public a(b bVar, a.C1512a c1512a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1512a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61554g = bVar;
            this.f61552e = c1512a;
            this.f61553f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f61554g.j == null) {
                return;
            }
            this.f61554g.j.a(this.f61554g.f61549g, this.f61552e, this.f61553f, 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.official_feed_item_container);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.c.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        h();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61545c = (BarImageView) d(R.id.bar_icon);
            this.f61546d = (TextView) d(R.id.bar_name);
            this.f61547e = (TextView) d(R.id.message_time);
            this.f61548f = (LinearLayout) d(R.id.item_container);
            this.f61549g = (RelativeLayout) d(R.id.official_bar_feed_item);
            View d2 = d(R.id.official_bar_feed_item_bg);
            this.f61544b = d2;
            if (this.k) {
                d2.setVisibility(8);
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f61547e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f61546d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f61550h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f61551i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f61548f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f61544b);
            }
        }
    }

    public void k(Context context, a.C1512a c1512a, d.a.s0.i1.h.o.a aVar, d.a.s0.i1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1512a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1512a == null) {
            return;
        }
        if (this.k) {
            this.f61545c.setVisibility(8);
            this.f61546d.setVisibility(8);
            this.f61547e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f61547e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f61547e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f61549g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f61548f.setPadding(g2, g3, g2, StringUtils.isNull(c1512a.f61765b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f61548f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f61548f.setLayoutParams(layoutParams2);
        } else {
            this.f61545c.setShowOval(true);
            this.f61545c.setAutoChangeStyle(true);
            this.f61545c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f61545c.setStrokeColorResId(R.color.CAM_X0401);
            this.f61545c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f61545c.M(aVar.c(), 10, false);
            this.f61546d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1512a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f61547e.setText(formatTimeForJustNow);
        this.f61551i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f61551i.setPadding(g5, 0, g5, 0);
        }
        this.f61551i.setData(c1512a, z);
        this.f61548f.removeAllViews();
        this.f61549g.setOnClickListener(new a(this, c1512a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f61550h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f61551i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f61548f.addView(this.f61550h);
            this.f61548f.addView(this.f61551i);
            this.f61550h.setData(c1512a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f61548f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f61551i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f61548f.addView(this.f61551i);
        }
        i();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
