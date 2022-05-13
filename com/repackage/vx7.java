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
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class vx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<ur4> list, yr4 yr4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, yr4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.P1() != null) {
                bs7 P1 = pbModel.P1();
                if (P1.h0() && TbadkCoreApplication.isLogin() && !j(postData) && !P1.g0()) {
                    ur4 ur4Var = new ur4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0316), yr4Var);
                    list.add(ur4Var);
                    xq8.f(ur4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<ur4> b(List<ur4> list, AgreeData agreeData, SparseArray<Object> sparseArray, yr4 yr4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, yr4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    ur4 ur4Var = new ur4(-1, dw7.h(R.string.obfuscated_res_0x7f0f0361, new Object[0]), yr4Var);
                    ur4Var.d.setTag(sparseArray);
                    arrayList.add(ur4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                        ur4 ur4Var2 = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]), yr4Var);
                        ur4Var2.d.setTag(sparseArray);
                        arrayList.add(ur4Var2);
                    }
                } else {
                    ur4 ur4Var3 = new ur4(-1, dw7.h(R.string.obfuscated_res_0x7f0f0360, new Object[0]), yr4Var);
                    ur4Var3.d.setTag(sparseArray);
                    arrayList.add(ur4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                        ur4 ur4Var4 = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0363, new Object[0]), yr4Var);
                        ur4Var4.d.setTag(sparseArray);
                        arrayList.add(ur4Var4);
                    }
                }
            } else {
                ur4 ur4Var5 = new ur4(-1, dw7.h(R.string.obfuscated_res_0x7f0f0360, new Object[0]), yr4Var);
                ur4Var5.d.setTag(sparseArray);
                arrayList.add(ur4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                    ur4 ur4Var6 = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]), yr4Var);
                    ur4Var6.d.setTag(sparseArray);
                    arrayList.add(ur4Var6);
                }
            }
            ur4 ur4Var7 = new ur4(-3, dw7.h(R.string.obfuscated_res_0x7f0f0fa6, new Object[0]), yr4Var);
            ur4Var7.d.setTag(sparseArray);
            arrayList.add(ur4Var7);
            ur4 ur4Var8 = new ur4(-4, dw7.h(R.string.obfuscated_res_0x7f0f1129, new Object[0]), yr4Var);
            ur4Var8.d.setTag(sparseArray);
            arrayList.add(ur4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<ur4> c(List<ur4> list, AgreeData agreeData, SparseArray<Object> sparseArray, yr4 yr4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, yr4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                        ur4 ur4Var = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yr4Var);
                        ur4Var.d.setTag(sparseArray);
                        arrayList.add(ur4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                    ur4 ur4Var2 = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0363, new Object[0]), yr4Var);
                    ur4Var2.d.setTag(sparseArray);
                    arrayList.add(ur4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916be) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916be)).booleanValue()) {
                ur4 ur4Var3 = new ur4(-2, dw7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), yr4Var);
                ur4Var3.d.setTag(sparseArray);
                arrayList.add(ur4Var3);
            }
            ur4 ur4Var4 = new ur4(-3, dw7.h(R.string.obfuscated_res_0x7f0f0fa6, new Object[0]), yr4Var);
            ur4Var4.d.setTag(sparseArray);
            arrayList.add(0, ur4Var4);
            ur4 ur4Var5 = new ur4(-4, dw7.h(R.string.obfuscated_res_0x7f0f1129, new Object[0]), yr4Var);
            ur4Var5.d.setTag(sparseArray);
            arrayList.add(1, ur4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable b9<?> b9Var, nr4.e eVar, nr4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, b9Var, eVar, eVar2) == null) {
            nr4 nr4Var = new nr4(activity);
            nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0499);
            nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, eVar);
            nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, eVar2);
            nr4Var.setCancelable(true);
            nr4Var.create(b9Var);
            nr4Var.show();
        }
    }

    public static List<ur4> e(List<ur4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (ur4 ur4Var : list) {
                ur4Var.l(g(ur4Var));
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
            String tbRichText = postData.P() != null ? postData.P().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable g(ur4 ur4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, ur4Var)) == null) {
            switch (ur4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080966, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080950, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080954, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080955, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0360, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095d, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095e, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080956, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080965, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080951, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0a87, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094f, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0fc0, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080964, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0b29, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080962, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0fc0, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080964, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (dw7.h(R.string.obfuscated_res_0x7f0f049d, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080953, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080949, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080959, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08093e, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f04a8, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080953, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (dw7.h(R.string.obfuscated_res_0x7f0f049d, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080953, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (dw7.h(R.string.obfuscated_res_0x7f0f0b25, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080960, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (dw7.h(R.string.obfuscated_res_0x7f0f148f, new Object[0]).equals(ur4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080961, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean h(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.P1() == null || !pbModel.P1().h0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(rs7 rs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, rs7Var)) == null) ? rs7Var != null && rs7Var.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<ur4> k(List<ur4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<ur4> it = list.iterator();
                while (it.hasNext()) {
                    ur4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, rs7 rs7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, rs7Var)) == null) {
            if (textView != null && rs7Var != null && postData != null) {
                if (rs7Var.q() && TbadkCoreApplication.isLogin() && !j(postData) && !rs7Var.p()) {
                    xq8.f(textView, postData);
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
