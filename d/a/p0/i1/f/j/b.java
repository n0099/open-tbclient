package d.a.p0.i1.f.j;

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
import d.a.p0.i1.l.c.a;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends d.a.c.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f58309b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f58310c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58311d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58312e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58313f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58314g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f58315h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f58316i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1468a f58317e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58318f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f58319g;

        public a(b bVar, a.C1468a c1468a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1468a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58319g = bVar;
            this.f58317e = c1468a;
            this.f58318f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58319g.j == null) {
                return;
            }
            this.f58319g.j.a(this.f58319g.f58314g, this.f58317e, this.f58318f, 0L);
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
            this.f58310c = (BarImageView) d(R.id.bar_icon);
            this.f58311d = (TextView) d(R.id.bar_name);
            this.f58312e = (TextView) d(R.id.message_time);
            this.f58313f = (LinearLayout) d(R.id.item_container);
            this.f58314g = (RelativeLayout) d(R.id.official_bar_feed_item);
            View d2 = d(R.id.official_bar_feed_item_bg);
            this.f58309b = d2;
            if (this.k) {
                d2.setVisibility(8);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f58312e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f58311d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f58315h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f58316i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58313f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58309b);
            }
        }
    }

    public void k(Context context, a.C1468a c1468a, d.a.p0.i1.h.o.a aVar, d.a.p0.i1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1468a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1468a == null) {
            return;
        }
        if (this.k) {
            this.f58310c.setVisibility(8);
            this.f58311d.setVisibility(8);
            this.f58312e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f58312e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f58312e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f58314g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f58313f.setPadding(g2, g3, g2, StringUtils.isNull(c1468a.f58530b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f58313f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f58313f.setLayoutParams(layoutParams2);
        } else {
            this.f58310c.setShowOval(true);
            this.f58310c.setAutoChangeStyle(true);
            this.f58310c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f58310c.setStrokeColorResId(R.color.CAM_X0401);
            this.f58310c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f58310c.M(aVar.c(), 10, false);
            this.f58311d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1468a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f58312e.setText(formatTimeForJustNow);
        this.f58316i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f58316i.setPadding(g5, 0, g5, 0);
        }
        this.f58316i.setData(c1468a, z);
        this.f58313f.removeAllViews();
        this.f58314g.setOnClickListener(new a(this, c1468a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f58315h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f58316i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f58313f.addView(this.f58315h);
            this.f58313f.addView(this.f58316i);
            this.f58315h.setData(c1468a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f58313f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f58316i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f58313f.addView(this.f58316i);
        }
        j();
    }

    public void l(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
