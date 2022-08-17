package com.repackage;

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
import com.repackage.p87;
import java.util.Date;
/* loaded from: classes7.dex */
public class q67 extends a9<OfficialBarFeedActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public LinearLayout f;
    public RelativeLayout g;
    public OfficialFeedItemImage h;
    public OfficialFeedItemBottom i;
    public OfficialBarFeedMsglistAdapter.c j;
    public boolean k;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p87.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ q67 c;

        public a(q67 q67Var, p87.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q67Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q67Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.j == null) {
                return;
            }
            this.c.j.c(this.c.g, this.a, this.b, 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q67(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d066d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        n();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = (BarImageView) j(R.id.obfuscated_res_0x7f090329);
            this.d = (TextView) j(R.id.obfuscated_res_0x7f090337);
            this.e = (TextView) j(R.id.obfuscated_res_0x7f091503);
            this.f = (LinearLayout) j(R.id.obfuscated_res_0x7f090f79);
            this.g = (RelativeLayout) j(R.id.obfuscated_res_0x7f0916ed);
            View j = j(R.id.obfuscated_res_0x7f0916ee);
            this.b = j;
            if (this.k) {
                j.setVisibility(8);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            OfficialFeedItemImage officialFeedItemImage = this.h;
            if (officialFeedItemImage != null) {
                officialFeedItemImage.c();
            }
            OfficialFeedItemBottom officialFeedItemBottom = this.i;
            if (officialFeedItemBottom != null) {
                officialFeedItemBottom.c();
            }
            if (this.k) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(qi.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(qi.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(qi.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(qi.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(qi.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(qi.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.b);
            }
        }
    }

    public void p(Context context, p87.a aVar, a87 a87Var, d87 d87Var, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, a87Var, d87Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || aVar == null) {
            return;
        }
        if (this.k) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setTextSize(0, qi.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.e.setLayoutParams(layoutParams);
            int f = qi.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f2 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f3 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.g.setPadding(0, qi.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f.setPadding(f, f2, f, StringUtils.isNull(aVar.b) ? 0 : f3 + f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.topMargin = qi.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f.setLayoutParams(layoutParams2);
        } else {
            this.c.setShowOval(true);
            this.c.setAutoChangeStyle(true);
            this.c.setStrokeWith(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.c.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setPlaceHolder(1);
        }
        if (!this.k && a87Var != null) {
            this.c.K(a87Var.c(), 10, false);
            this.d.setText(String.format("%s%s", a87Var.a(), context.getString(R.string.obfuscated_res_0x7f0f065a)));
        }
        long j = aVar.m * 1000;
        if (this.k) {
            formatTimeForJustNow = pi.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int f4 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds29);
            this.i.setPadding(f4, 0, f4, 0);
        }
        this.i.setData(aVar, z);
        this.f.removeAllViews();
        this.g.setOnClickListener(new a(this, aVar, i2));
        if (z) {
            OfficialFeedItemImage officialFeedItemImage = new OfficialFeedItemImage(context, this.k);
            this.h = officialFeedItemImage;
            if (this.k) {
                officialFeedItemImage.a();
                this.i.a(qi.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f.addView(this.h);
            this.f.addView(this.i);
            this.h.setData(aVar, i, d87Var);
        } else {
            if (this.k) {
                int f5 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f6 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f7 = qi.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f.setPadding(f5, f6 + f7, f5, f7 + f5);
                this.i.a(qi.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f.addView(this.i);
        }
        o();
    }

    public void q(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
