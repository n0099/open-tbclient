package com.repackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.repackage.nq4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class lw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<uq4> list, yq4 yq4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, yq4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.Q1() != null) {
                rq7 Q1 = pbModel.Q1();
                if (Q1.h0() && TbadkCoreApplication.isLogin() && !j(postData) && !Q1.g0()) {
                    uq4 uq4Var = new uq4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0316), yq4Var);
                    list.add(uq4Var);
                    ho8.f(uq4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<uq4> b(List<uq4> list, AgreeData agreeData, SparseArray<Object> sparseArray, yq4 yq4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, yq4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    uq4 uq4Var = new uq4(-1, tu7.h(R.string.obfuscated_res_0x7f0f0353, new Object[0]), yq4Var);
                    uq4Var.d.setTag(sparseArray);
                    arrayList.add(uq4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                        uq4 uq4Var2 = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0354, new Object[0]), yq4Var);
                        uq4Var2.d.setTag(sparseArray);
                        arrayList.add(uq4Var2);
                    }
                } else {
                    uq4 uq4Var3 = new uq4(-1, tu7.h(R.string.obfuscated_res_0x7f0f0352, new Object[0]), yq4Var);
                    uq4Var3.d.setTag(sparseArray);
                    arrayList.add(uq4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                        uq4 uq4Var4 = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0355, new Object[0]), yq4Var);
                        uq4Var4.d.setTag(sparseArray);
                        arrayList.add(uq4Var4);
                    }
                }
            } else {
                uq4 uq4Var5 = new uq4(-1, tu7.h(R.string.obfuscated_res_0x7f0f0352, new Object[0]), yq4Var);
                uq4Var5.d.setTag(sparseArray);
                arrayList.add(uq4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                    uq4 uq4Var6 = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0354, new Object[0]), yq4Var);
                    uq4Var6.d.setTag(sparseArray);
                    arrayList.add(uq4Var6);
                }
            }
            uq4 uq4Var7 = new uq4(-3, tu7.h(R.string.obfuscated_res_0x7f0f0fc2, new Object[0]), yq4Var);
            uq4Var7.d.setTag(sparseArray);
            arrayList.add(uq4Var7);
            uq4 uq4Var8 = new uq4(-4, tu7.h(R.string.obfuscated_res_0x7f0f1145, new Object[0]), yq4Var);
            uq4Var8.d.setTag(sparseArray);
            arrayList.add(uq4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<uq4> c(List<uq4> list, AgreeData agreeData, SparseArray<Object> sparseArray, yq4 yq4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, yq4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                        uq4 uq4Var = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yq4Var);
                        uq4Var.d.setTag(sparseArray);
                        arrayList.add(uq4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                    uq4 uq4Var2 = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0355, new Object[0]), yq4Var);
                    uq4Var2.d.setTag(sparseArray);
                    arrayList.add(uq4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091666) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091666)).booleanValue()) {
                uq4 uq4Var3 = new uq4(-2, tu7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yq4Var);
                uq4Var3.d.setTag(sparseArray);
                arrayList.add(uq4Var3);
            }
            uq4 uq4Var4 = new uq4(-3, tu7.h(R.string.obfuscated_res_0x7f0f0fc2, new Object[0]), yq4Var);
            uq4Var4.d.setTag(sparseArray);
            arrayList.add(0, uq4Var4);
            uq4 uq4Var5 = new uq4(-4, tu7.h(R.string.obfuscated_res_0x7f0f1145, new Object[0]), yq4Var);
            uq4Var5.d.setTag(sparseArray);
            arrayList.add(1, uq4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable d9<?> d9Var, nq4.e eVar, nq4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, d9Var, eVar, eVar2) == null) {
            nq4 nq4Var = new nq4(activity);
            nq4Var.setMessageId(R.string.obfuscated_res_0x7f0f0492);
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04dc, eVar);
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04d7, eVar2);
            nq4Var.setCancelable(true);
            nq4Var.create(d9Var);
            nq4Var.show();
        }
    }

    public static List<uq4> e(List<uq4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (uq4 uq4Var : list) {
                uq4Var.l(g(uq4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder f(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.Q() != null ? postData.Q().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(uq4 uq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, uq4Var)) == null) {
            switch (uq4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095d, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080947, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0354, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094b, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094c, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0352, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080954, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080955, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095c, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080948, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0a92, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080945, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080946, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0fdb, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095b, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0b33, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080959, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0fdb, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095b, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0496, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094a, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080940, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080950, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080935, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f04a1, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094a, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0496, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094a, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080944, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (tu7.h(R.string.obfuscated_res_0x7f0f0b2f, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080957, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (tu7.h(R.string.obfuscated_res_0x7f0f14b0, new Object[0]).equals(uq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080958, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.Q1() == null || !pbModel.Q1().h0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(hr7 hr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, hr7Var)) == null) ? hr7Var != null && hr7Var.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<uq4> k(List<uq4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<uq4> it = list.iterator();
                while (it.hasNext()) {
                    uq4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, hr7 hr7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, hr7Var)) == null) {
            if (textView != null && hr7Var != null && postData != null) {
                if (hr7Var.q() && TbadkCoreApplication.isLogin() && !j(postData) && !hr7Var.p()) {
                    ho8.f(textView, postData);
                    textView.setVisibility(0);
                    return true;
                }
                textView.setVisibility(8);
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i != -4) {
                if (i != -3) {
                    if (i != -2) {
                        if (i != -1) {
                            switch (i) {
                                case 4:
                                    return 5;
                                case 5:
                                    return 7;
                                case 6:
                                    return 6;
                                case 7:
                                    return 9;
                                case 8:
                                    return 8;
                                default:
                                    return 0;
                            }
                        }
                        return 1;
                    }
                    return 2;
                }
                return 3;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    public static SpannableString n(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
            return spannableString;
        }
        return (SpannableString) invokeLI.objValue;
    }
}
