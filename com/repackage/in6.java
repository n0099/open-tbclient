package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes6.dex */
public class in6 implements hn6, gn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TbClipImageView e;
    public uh8 f;
    public ImageView g;
    public ImageOverlayView h;
    public FrsViewData i;
    public View.OnClickListener j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ in6 a;

        public a(in6 in6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {in6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = in6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null && "tiebaclient://accelerator".equals(this.a.f.d)) {
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921662, new ff6(3));
                    CustomMessage customMessage = new CustomMessage(2921662);
                    customMessage.setTag(this.a.i.getFrsFragmentTag());
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (!TextUtils.equals(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f089c), this.a.f.b) || this.a.i == null || this.a.i.getForum() == null || TextUtils.isEmpty(this.a.i.getForum().getId())) {
                    if (this.a.f != null && this.a.f.f != null) {
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.f.g).param("obj_source", "frs_card").param("obj_id", this.a.f.f.b).param("obj_name", this.a.f.f.a).param("obj_param1", this.a.f.f.d.intValue()));
                    }
                    if (this.a.f != null && !"tiebaclient://accelerator".equals(this.a.f.d)) {
                        jn6.b(view2.getContext(), this.a.f);
                    }
                    jn6.c(this.a.f);
                    return;
                }
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(view2.getContext());
                hotUserRankActivityConfig.setForumId(Long.valueOf(ng.g(this.a.i.getForum().getId(), 0L)));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotUserRankActivityConfig));
                StatisticItem statisticItem = new StatisticItem("c13666");
                statisticItem.param("fid", this.a.i.getForum().getId());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public in6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0339, (ViewGroup) null);
        this.a = inflate;
        this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090b9d);
        this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090b9f);
        this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090ba1);
        TbClipImageView tbClipImageView = (TbClipImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090ba0);
        this.e = tbClipImageView;
        tbClipImageView.setDrawerType(1);
        this.e.setIsRound(true);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds57);
        int dimensionPixelOffset2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds1);
        int dimensionPixelOffset3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds15);
        ImageOverlayView imageOverlayView = (ImageOverlayView) this.a.findViewById(R.id.obfuscated_res_0x7f090e3d);
        this.h = imageOverlayView;
        imageOverlayView.a(3, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, R.color.CAM_X0618, dimensionPixelOffset3);
        this.h.setStrokeStyle(1);
        this.h.setLoadImageType(12);
        this.a.setOnClickListener(this.j);
        this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090b9e);
    }

    @Override // com.repackage.hn6
    public void a(th8 th8Var, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, th8Var, frsViewData) == null) || th8Var == null || ListUtils.isEmpty(th8Var.b)) {
            return;
        }
        this.i = frsViewData;
        uh8 uh8Var = th8Var.b.get(0);
        if (uh8Var == null) {
            return;
        }
        this.f = uh8Var;
        if (!TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f089c), this.f.b)) {
            this.c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f066d));
        } else {
            this.c.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f073f));
            this.b.setText(this.a.getContext().getString(R.string.obfuscated_res_0x7f0f0871));
        }
        this.d.setText(StringHelper.cutStringWithEllipsisStrict(uh8Var.c, 20));
        if (TextUtils.equals(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f089c), uh8Var.b)) {
            this.h.setVisibility(0);
            this.e.setVisibility(8);
            f(frsViewData);
        } else {
            this.e.J(uh8Var.b, 10, false);
            this.e.setVisibility(0);
            this.h.setVisibility(8);
        }
        jn6.d(uh8Var);
    }

    @Override // com.repackage.gn6
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(pi.f(getView().getContext(), R.dimen.tbds10)).defaultColorValue(i).into(this.b);
        }
    }

    public final boolean f(FrsViewData frsViewData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData)) == null) {
            if (frsViewData.getHotUserRankData() == null || frsViewData.getHotUserRankData().hot_user == null || frsViewData.getHotUserRankData().hot_user.size() <= 0) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            for (ShortUserInfo shortUserInfo : frsViewData.getHotUserRankData().hot_user) {
                if (shortUserInfo != null) {
                    arrayList.add(shortUserInfo.portrait);
                }
            }
            this.h.setData(arrayList);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.hn6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // com.repackage.hn6
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.h.d();
        }
    }
}
