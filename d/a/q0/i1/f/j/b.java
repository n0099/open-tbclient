package d.a.q0.i1.f.j;

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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.q0.i1.l.c.a;
import java.util.Date;
/* loaded from: classes8.dex */
public class b extends d.a.d.a.c<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f58923b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f58924c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58925d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58926e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f58927f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f58928g;

    /* renamed from: h  reason: collision with root package name */
    public OfficialFeedItemImage f58929h;

    /* renamed from: i  reason: collision with root package name */
    public OfficialFeedItemBottom f58930i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.C1473a f58931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58932f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f58933g;

        public a(b bVar, a.C1473a c1473a, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c1473a, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58933g = bVar;
            this.f58931e = c1473a;
            this.f58932f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58933g.j == null) {
                return;
            }
            this.f58933g.j.a(this.f58933g.f58928g, this.f58931e, this.f58932f, 0L);
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
                super((d.a.d.a.f) objArr2[0], ((Integer) objArr2[1]).intValue());
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
            this.f58924c = (BarImageView) d(R.id.bar_icon);
            this.f58925d = (TextView) d(R.id.bar_name);
            this.f58926e = (TextView) d(R.id.message_time);
            this.f58927f = (LinearLayout) d(R.id.item_container);
            this.f58928g = (RelativeLayout) d(R.id.official_bar_feed_item);
            View d2 = d(R.id.official_bar_feed_item_bg);
            this.f58923b = d2;
            if (this.k) {
                d2.setVisibility(8);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f58926e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f58925d, R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.f58929h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.f58930i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58927f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(l.g(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(l.g(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f58923b);
            }
        }
    }

    public void k(Context context, a.C1473a c1473a, d.a.q0.i1.h.o.a aVar, d.a.q0.i1.i.a.b.b bVar, int i2, boolean z, int i3) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, c1473a, aVar, bVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)}) == null) || c1473a == null) {
            return;
        }
        if (this.k) {
            this.f58924c.setVisibility(8);
            this.f58925d.setVisibility(8);
            this.f58926e.setTextSize(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f58926e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.f58926e.setLayoutParams(layoutParams);
            int g2 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
            int g3 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
            int g4 = l.g(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.f58928g.setPadding(0, l.g(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f58927f.setPadding(g2, g3, g2, StringUtils.isNull(c1473a.f59144b) ? 0 : g4 + g2);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f58927f.getLayoutParams();
            layoutParams2.topMargin = l.g(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f58927f.setLayoutParams(layoutParams2);
        } else {
            this.f58924c.setShowOval(true);
            this.f58924c.setAutoChangeStyle(true);
            this.f58924c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f58924c.setStrokeColorResId(R.color.CAM_X0401);
            this.f58924c.setPlaceHolder(1);
        }
        if (!this.k && aVar != null) {
            this.f58924c.M(aVar.c(), 10, false);
            this.f58925d.setText(String.format("%s%s", aVar.a(), context.getString(R.string.forum)));
        }
        long j = c1473a.m * 1000;
        if (this.k) {
            formatTimeForJustNow = k.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.f58926e.setText(formatTimeForJustNow);
        this.f58930i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int g5 = l.g(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.f58930i.setPadding(g5, 0, g5, 0);
        }
        this.f58930i.setData(c1473a, z);
        this.f58927f.removeAllViews();
        this.f58928g.setOnClickListener(new a(this, c1473a, i3));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.f58929h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.f58930i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f58927f.addView(this.f58929h);
            this.f58927f.addView(this.f58930i);
            this.f58929h.setData(c1473a, i2, bVar);
        } else {
            if (this.k) {
                int g6 = l.g(this.mContext.getPageActivity(), R.dimen.tbds10);
                int g7 = l.g(this.mContext.getPageActivity(), R.dimen.tbds5);
                int g8 = l.g(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f58927f.setPadding(g6, g7 + g8, g6, g8 + g6);
                this.f58930i.a(l.g(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f58927f.addView(this.f58930i);
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
