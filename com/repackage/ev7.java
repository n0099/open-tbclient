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
import com.repackage.dq4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class ev7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<kq4> list, oq4 oq4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, oq4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.P1() != null) {
                kp7 P1 = pbModel.P1();
                if (P1.h0() && TbadkCoreApplication.isLogin() && !j(postData) && !P1.g0()) {
                    kq4 kq4Var = new kq4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0318), oq4Var);
                    list.add(kq4Var);
                    zn8.f(kq4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<kq4> b(List<kq4> list, AgreeData agreeData, SparseArray<Object> sparseArray, oq4 oq4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, agreeData, sparseArray, oq4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    kq4 kq4Var = new kq4(-1, mt7.h(R.string.obfuscated_res_0x7f0f0363, new Object[0]), oq4Var);
                    kq4Var.d.setTag(sparseArray);
                    arrayList.add(kq4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                        kq4 kq4Var2 = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0364, new Object[0]), oq4Var);
                        kq4Var2.d.setTag(sparseArray);
                        arrayList.add(kq4Var2);
                    }
                } else {
                    kq4 kq4Var3 = new kq4(-1, mt7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]), oq4Var);
                    kq4Var3.d.setTag(sparseArray);
                    arrayList.add(kq4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                        kq4 kq4Var4 = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0365, new Object[0]), oq4Var);
                        kq4Var4.d.setTag(sparseArray);
                        arrayList.add(kq4Var4);
                    }
                }
            } else {
                kq4 kq4Var5 = new kq4(-1, mt7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]), oq4Var);
                kq4Var5.d.setTag(sparseArray);
                arrayList.add(kq4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                    kq4 kq4Var6 = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0364, new Object[0]), oq4Var);
                    kq4Var6.d.setTag(sparseArray);
                    arrayList.add(kq4Var6);
                }
            }
            kq4 kq4Var7 = new kq4(-3, mt7.h(R.string.obfuscated_res_0x7f0f0fb7, new Object[0]), oq4Var);
            kq4Var7.d.setTag(sparseArray);
            arrayList.add(kq4Var7);
            kq4 kq4Var8 = new kq4(-4, mt7.h(R.string.obfuscated_res_0x7f0f113a, new Object[0]), oq4Var);
            kq4Var8.d.setTag(sparseArray);
            arrayList.add(kq4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<kq4> c(List<kq4> list, AgreeData agreeData, SparseArray<Object> sparseArray, oq4 oq4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, oq4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                        kq4 kq4Var = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), oq4Var);
                        kq4Var.d.setTag(sparseArray);
                        arrayList.add(kq4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                    kq4 kq4Var2 = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0365, new Object[0]), oq4Var);
                    kq4Var2.d.setTag(sparseArray);
                    arrayList.add(kq4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f091673) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091673)).booleanValue()) {
                kq4 kq4Var3 = new kq4(-2, mt7.h(R.string.obfuscated_res_0x7f0f0087, new Object[0]), oq4Var);
                kq4Var3.d.setTag(sparseArray);
                arrayList.add(kq4Var3);
            }
            kq4 kq4Var4 = new kq4(-3, mt7.h(R.string.obfuscated_res_0x7f0f0fb7, new Object[0]), oq4Var);
            kq4Var4.d.setTag(sparseArray);
            arrayList.add(0, kq4Var4);
            kq4 kq4Var5 = new kq4(-4, mt7.h(R.string.obfuscated_res_0x7f0f113a, new Object[0]), oq4Var);
            kq4Var5.d.setTag(sparseArray);
            arrayList.add(1, kq4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void d(Activity activity, @Nullable b9<?> b9Var, dq4.e eVar, dq4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, activity, b9Var, eVar, eVar2) == null) {
            dq4 dq4Var = new dq4(activity);
            dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f04a0);
            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ea, eVar);
            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, eVar2);
            dq4Var.setCancelable(true);
            dq4Var.create(b9Var);
            dq4Var.show();
        }
    }

    public static List<kq4> e(List<kq4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (kq4 kq4Var : list) {
                kq4Var.l(g(kq4Var));
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

    public static Drawable g(kq4 kq4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, kq4Var)) == null) {
            switch (kq4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080972, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095c, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0364, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080960, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080961, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0362, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080969, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096a, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080962, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080971, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0a8e, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095a, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095b, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0fd0, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080970, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0b2f, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0fd0, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080970, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (mt7.h(R.string.obfuscated_res_0x7f0f04a4, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095f, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080955, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080965, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08094a, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f04af, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095f, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (mt7.h(R.string.obfuscated_res_0x7f0f04a4, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095f, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080959, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (mt7.h(R.string.obfuscated_res_0x7f0f0b2b, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096c, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (mt7.h(R.string.obfuscated_res_0x7f0f14a3, new Object[0]).equals(kq4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096d, SkinManager.getColor(R.color.CAM_X0107), null);
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

    public static boolean i(aq7 aq7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aq7Var)) == null) ? aq7Var != null && aq7Var.q() : invokeL.booleanValue;
    }

    public static boolean j(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<kq4> k(List<kq4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<kq4> it = list.iterator();
                while (it.hasNext()) {
                    kq4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
    }

    public static boolean l(TextView textView, PostData postData, aq7 aq7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, textView, postData, aq7Var)) == null) {
            if (textView != null && aq7Var != null && postData != null) {
                if (aq7Var.q() && TbadkCoreApplication.isLogin() && !j(postData) && !aq7Var.p()) {
                    zn8.f(textView, postData);
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
