package com.repackage;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.widget.ad.VipAdFreeGuideLayout;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ft6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, str, str2, i)) == null) {
            if ("personalize".equals(str) && xl5.k().s(AbsDataRecorder.Scene.RECOMMEND)) {
                return true;
            }
            if ("frs_new_tab".equals(str2) && xl5.k().s(AbsDataRecorder.Scene.FRS_NEW)) {
                return true;
            }
            if ("frs_hot_tab".equals(str2) && xl5.k().s(AbsDataRecorder.Scene.FRS_HOT)) {
                return true;
            }
            return "pb".equals(str) && xl5.k().r(i, AbsDataRecorder.Scene.PB);
        }
        return invokeLLI.booleanValue;
    }

    public static void b(FunAdNativeViewHolder funAdNativeViewHolder, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, int i) {
        ViewGroup c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, Integer.valueOf(i)}) == null) {
            if ("personalize".equals(str) || "frs_new_tab".equals(str2) || "frs_hot_tab".equals(str2)) {
                if (vipAdFreeGuideLayout != null) {
                    vipAdFreeGuideLayout.setBottomCornerRound(true);
                }
            } else if ("pb".equals(str)) {
                if (!xl5.k().m() || i != 1) {
                    if (vipAdFreeGuideLayout != null) {
                        vipAdFreeGuideLayout.setBottomCornerRound(false);
                        vipAdFreeGuideLayout.setAllCornerRound(true);
                        return;
                    }
                    return;
                }
                vipAdFreeGuideLayout.setBottomCornerRound(false);
                vipAdFreeGuideLayout.setAllCornerRound(false);
                if (funAdNativeViewHolder == null || funAdNativeViewHolder.d() == null || (c = funAdNativeViewHolder.d().c(null)) == null) {
                    return;
                }
                c.setPadding(c.getPaddingLeft(), c.getPaddingTop(), c.getPaddingRight(), 0);
            }
        }
    }

    public static void c(VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, vipAdFreeGuideLayout, str, str2, str3) == null) {
            if ("personalize".equals(str2)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.RECOMMEND, str);
            } else if ("frs_new_tab".equals(str3)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_NEW, str);
            } else if ("frs_hot_tab".equals(str3)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.FRS_HOT, str);
            } else if ("pb".equals(str2)) {
                vipAdFreeGuideLayout.setInfo(AbsDataRecorder.Scene.PB, str);
            }
        }
    }

    public static void d(FunAdNativeViewHolder funAdNativeViewHolder, VipAdFreeGuideLayout vipAdFreeGuideLayout, String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, Integer.valueOf(i)}) == null) || vipAdFreeGuideLayout == null) {
            return;
        }
        vipAdFreeGuideLayout.setVisibility(0);
        b(funAdNativeViewHolder, vipAdFreeGuideLayout, str2, str3, i);
        vipAdFreeGuideLayout.f();
        c(vipAdFreeGuideLayout, str, str2, str3);
    }

    public static void e(zk8 zk8Var, FunAdNativeViewHolder funAdNativeViewHolder, String str, String str2, String str3, int i) {
        int f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zk8Var, funAdNativeViewHolder, str, str2, str3, Integer.valueOf(i)}) == null) {
            VipAdFreeGuideLayout vipAdFreeGuideLayout = funAdNativeViewHolder.d().getVipAdFreeGuideLayout();
            if (zk8Var == null || vipAdFreeGuideLayout == null) {
                return;
            }
            if ("personalize".equals(str2)) {
                f = xl5.k().j(zk8Var.g());
            } else {
                f = zk8Var.f();
            }
            if (f == 1) {
                vipAdFreeGuideLayout.setVisibility(8);
            } else if (f == 2) {
                d(funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, i);
            } else if (a(str2, str3, i)) {
                d(funAdNativeViewHolder, vipAdFreeGuideLayout, str, str2, str3, i);
                xl5.k().c();
                if ("personalize".equals(str2)) {
                    xl5.k().p(zk8Var.g(), 2);
                } else {
                    zk8Var.q(2);
                }
            } else {
                vipAdFreeGuideLayout.setVisibility(8);
                if ("personalize".equals(str2)) {
                    xl5.k().p(zk8Var.g(), 1);
                } else {
                    zk8Var.q(1);
                }
            }
        }
    }
}
