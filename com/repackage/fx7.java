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
import com.repackage.dr4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<kr4> list, or4 or4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, or4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.R1() != null) {
                jr7 R1 = pbModel.R1();
                if (R1.h0() && TbadkCoreApplication.isLogin() && !j(postData) && !R1.g0()) {
                    kr4 kr4Var = new kr4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031a), or4Var);
                    list.add(kr4Var);
                    dp8.f(kr4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<kr4> b(List<kr4> list, AgreeData agreeData, SparseArray<Object> sparseArray, or4 or4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, or4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    kr4 kr4Var = new kr4(-1, lv7.i(R.string.obfuscated_res_0x7f0f0357, new Object[0]), or4Var);
                    kr4Var.d.setTag(sparseArray);
                    arrayList.add(kr4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                        kr4 kr4Var2 = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0358, new Object[0]), or4Var);
                        kr4Var2.d.setTag(sparseArray);
                        arrayList.add(kr4Var2);
                    }
                } else {
                    kr4 kr4Var3 = new kr4(-1, lv7.i(R.string.obfuscated_res_0x7f0f0356, new Object[0]), or4Var);
                    kr4Var3.d.setTag(sparseArray);
                    arrayList.add(kr4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                        kr4 kr4Var4 = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0359, new Object[0]), or4Var);
                        kr4Var4.d.setTag(sparseArray);
                        arrayList.add(kr4Var4);
                    }
                }
            } else {
                kr4 kr4Var5 = new kr4(-1, lv7.i(R.string.obfuscated_res_0x7f0f0356, new Object[0]), or4Var);
                kr4Var5.d.setTag(sparseArray);
                arrayList.add(kr4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                    kr4 kr4Var6 = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0358, new Object[0]), or4Var);
                    kr4Var6.d.setTag(sparseArray);
                    arrayList.add(kr4Var6);
                }
            }
            kr4 kr4Var7 = new kr4(-3, lv7.i(R.string.obfuscated_res_0x7f0f0fa6, new Object[0]), or4Var);
            kr4Var7.d.setTag(sparseArray);
            arrayList.add(kr4Var7);
            kr4 kr4Var8 = new kr4(-4, lv7.i(R.string.obfuscated_res_0x7f0f10eb, new Object[0]), or4Var);
            kr4Var8.d.setTag(sparseArray);
            arrayList.add(kr4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<kr4> c(List<kr4> list, AgreeData agreeData, SparseArray<Object> sparseArray, or4 or4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, or4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                        kr4 kr4Var = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0087, new Object[0]), or4Var);
                        kr4Var.d.setTag(sparseArray);
                        arrayList.add(kr4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                    kr4 kr4Var2 = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0359, new Object[0]), or4Var);
                    kr4Var2.d.setTag(sparseArray);
                    arrayList.add(kr4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0916ea) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0916ea)).booleanValue()) {
                kr4 kr4Var3 = new kr4(-2, lv7.i(R.string.obfuscated_res_0x7f0f0087, new Object[0]), or4Var);
                kr4Var3.d.setTag(sparseArray);
                arrayList.add(kr4Var3);
            }
            kr4 kr4Var4 = new kr4(-3, lv7.i(R.string.obfuscated_res_0x7f0f0fa6, new Object[0]), or4Var);
            kr4Var4.d.setTag(sparseArray);
            arrayList.add(0, kr4Var4);
            kr4 kr4Var5 = new kr4(-4, lv7.i(R.string.obfuscated_res_0x7f0f10eb, new Object[0]), or4Var);
            kr4Var5.d.setTag(sparseArray);
            arrayList.add(1, kr4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable d9<?> d9Var, dr4.e eVar, dr4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, d9Var, eVar, eVar2) == null) {
            dr4 dr4Var = new dr4(activity);
            dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f049a);
            dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e1, eVar);
            dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04dc, eVar2);
            dr4Var.setCancelable(true);
            dr4Var.create(d9Var);
            dr4Var.show();
        }
    }

    public static List<kr4> e(List<kr4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (kr4 kr4Var : list) {
                kr4Var.l(g(kr4Var));
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

    public static Drawable g(kr4 kr4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kr4Var)) == null) {
            switch (kr4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080966, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080950, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0358, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080954, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080955, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0356, new Object[0]).equals(kr4Var.g())) {
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
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0a6c, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094f, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0fbf, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080964, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0b0f, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080962, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0fbf, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080964, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lv7.i(R.string.obfuscated_res_0x7f0f049e, new Object[0]).equals(kr4Var.g())) {
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
                    if (lv7.i(R.string.obfuscated_res_0x7f0f04a9, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080953, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lv7.i(R.string.obfuscated_res_0x7f0f049e, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080953, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (lv7.i(R.string.obfuscated_res_0x7f0f0b0b, new Object[0]).equals(kr4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080960, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lv7.i(R.string.obfuscated_res_0x7f0f1459, new Object[0]).equals(kr4Var.g())) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pbModel)) == null) ? (pbModel == null || pbModel.R1() == null || !pbModel.R1().h0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(zr7 zr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zr7Var)) == null) ? zr7Var != null && zr7Var.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<kr4> k(List<kr4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<kr4> it = list.iterator();
                while (it.hasNext()) {
                    kr4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, zr7 zr7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, zr7Var)) == null) {
            if (textView != null && zr7Var != null && postData != null) {
                if (zr7Var.q() && TbadkCoreApplication.isLogin() && !j(postData) && !zr7Var.p()) {
                    dp8.f(textView, postData);
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
