package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.qq6;
/* compiled from: TopViewLogic.java */
/* loaded from: classes7.dex */
public final /* synthetic */ class zn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? UbsABTestHelper.isFrsModifyABTestA() : invokeV.booleanValue;
    }

    public static void b(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, view2) == null) && a()) {
            ViewCommonUtil.setViewMargin(view2, -1, -1, -1, UtilHelper.getDimenPixelSize(R.dimen.tbds9));
        }
    }

    public static void c(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, view2) == null) && a()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds18);
            ViewCommonUtil.setViewPadding(view2, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void d(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, view2) == null) {
            if (a()) {
                gs4 d = gs4.d(view2);
                d.n(R.string.J_X05);
                d.f(R.color.CAM_X0201);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
                    return;
                }
                return;
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
        }
    }

    public static void e(@NonNull qq6.f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) && a()) {
            ViewCommonUtil.setViewWidthHeight(fVar.d, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.c, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.e, -3, -2);
            ViewCommonUtil.setViewWidthHeight(fVar.f, -3, -2);
            ViewCommonUtil.setViewMargin(fVar.f, 0, 0, 0, 0);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds18);
            ViewCommonUtil.setViewPadding(fVar.f, -1, dimenPixelSize, -1, dimenPixelSize);
        }
    }

    public static void f(@NonNull TextView textView, @ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, textView, i) == null) {
            Context context = textView.getContext();
            if (a()) {
                textView.setTextColor(i);
                textView.setTextSize(0, mi.f(context, R.dimen.T_X07));
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = -2;
                return;
            }
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(mi.f(context, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(i).into(textView);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setTextSize(0, mi.f(context, R.dimen.T_X10));
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = mi.f(context, R.dimen.tbds74);
            layoutParams2.height = mi.f(context, R.dimen.tbds40);
        }
    }

    @Nullable
    public static BdTypeRecyclerView g(@Nullable FrsTopView frsTopView, @Nullable BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, frsTopView, bdTypeRecyclerView)) == null) {
            if (!a() || frsTopView == null || bdTypeRecyclerView == null) {
                return null;
            }
            View v = bdTypeRecyclerView.v(Integer.valueOf(ao6.a));
            if (v != null) {
                bdTypeRecyclerView.removeHeaderView(v);
            }
            if (frsTopView.getParent() instanceof ViewGroup) {
                ((ViewGroup) frsTopView.getParent()).removeView(frsTopView);
            }
            frsTopView.setTag(R.id.obfuscated_res_0x7f090f6c, Integer.valueOf(ao6.a));
            bdTypeRecyclerView.s(frsTopView);
            return bdTypeRecyclerView;
        }
        return (BdTypeRecyclerView) invokeLL.objValue;
    }
}
