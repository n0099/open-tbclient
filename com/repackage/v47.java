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
import com.repackage.v67;
import java.util.Date;
/* loaded from: classes7.dex */
public class v47 extends y8<OfficialBarFeedActivity> {
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
        public final /* synthetic */ v67.a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ v47 c;

        public a(v47 v47Var, v67.a aVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v47Var, aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = v47Var;
            this.a = aVar;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.j == null) {
                return;
            }
            this.c.j.a(this.c.g, this.a, this.b, 0L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v47(TbPageContext<OfficialBarFeedActivity> tbPageContext, boolean z) {
        super(tbPageContext, R.layout.obfuscated_res_0x7f0d0631);
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
                super((b9) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = z;
        j();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = (BarImageView) e(R.id.obfuscated_res_0x7f090310);
            this.d = (TextView) e(R.id.obfuscated_res_0x7f09031f);
            this.e = (TextView) e(R.id.obfuscated_res_0x7f09141c);
            this.f = (LinearLayout) e(R.id.obfuscated_res_0x7f090f69);
            this.g = (RelativeLayout) e(R.id.obfuscated_res_0x7f0915fb);
            View e = e(R.id.obfuscated_res_0x7f0915fc);
            this.b = e;
            if (this.k) {
                e.setVisibility(8);
            }
        }
    }

    public void k() {
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
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(mi.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(mi.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(mi.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.f);
            } else {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0205).setShapeRadius(mi.f(this.mContext.getPageActivity(), R.dimen.tbds31)).setShadowColor(R.color.CAM_X0804).setShadowSide(ShadowDrawable.ALL).setShadowRadius(mi.f(this.mContext.getPageActivity(), R.dimen.tbds10)).setOffsetX(0).setOffsetY(mi.f(this.mContext.getPageActivity(), R.dimen.tbds5)).into(this.b);
            }
        }
    }

    public void l(Context context, v67.a aVar, f67 f67Var, i67 i67Var, int i, boolean z, int i2) {
        String formatTimeForJustNow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, f67Var, i67Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || aVar == null) {
            return;
        }
        if (this.k) {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setTextSize(0, mi.f(this.mContext.getPageActivity(), R.dimen.tbds40));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.removeRule(11);
            layoutParams.addRule(14);
            this.e.setLayoutParams(layoutParams);
            int f = mi.f(this.mContext.getPageActivity(), R.dimen.tbds10);
            int f2 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds5);
            int f3 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds52);
            this.g.setPadding(0, mi.f(this.mContext.getPageActivity(), R.dimen.tbds31), 0, 0);
            this.f.setPadding(f, f2, f, StringUtils.isNull(aVar.b) ? 0 : f3 + f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams2.topMargin = mi.f(this.mContext.getPageActivity(), R.dimen.tbds27);
            this.f.setLayoutParams(layoutParams2);
        } else {
            this.c.setShowOval(true);
            this.c.setAutoChangeStyle(true);
            this.c.setStrokeWith(mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.c.setStrokeColorResId(R.color.CAM_X0401);
            this.c.setPlaceHolder(1);
        }
        if (!this.k && f67Var != null) {
            this.c.K(f67Var.c(), 10, false);
            this.d.setText(String.format("%s%s", f67Var.a(), context.getString(R.string.obfuscated_res_0x7f0f064b)));
        }
        long j = aVar.m * 1000;
        if (this.k) {
            formatTimeForJustNow = li.getTimeStringNoYear(new Date(j));
        } else {
            formatTimeForJustNow = StringHelper.getFormatTimeForJustNow(j);
            if (StringHelper.isThisYear(formatTimeForJustNow)) {
                formatTimeForJustNow = StringHelper.getFormatTimeShort(j);
            }
        }
        this.e.setText(formatTimeForJustNow);
        this.i = new OfficialFeedItemBottom(context);
        if (this.k) {
            int f4 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds29);
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
                this.i.a(mi.f(this.mContext.getPageActivity(), R.dimen.tbds29));
            }
            this.f.addView(this.h);
            this.f.addView(this.i);
            this.h.setData(aVar, i, i67Var);
        } else {
            if (this.k) {
                int f5 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds10);
                int f6 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds5);
                int f7 = mi.f(this.mContext.getPageActivity(), R.dimen.tbds53);
                this.f.setPadding(f5, f6 + f7, f5, f7 + f5);
                this.i.a(mi.f(this.mContext.getPageActivity(), R.dimen.tbds26));
            }
            this.f.addView(this.i);
        }
        k();
    }

    public void m(OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.j = cVar;
        }
    }
}
