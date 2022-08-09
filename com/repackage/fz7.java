package com.repackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
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
import com.repackage.ur4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(List<bs4> list, fs4 fs4Var, PostData postData, vt7 vt7Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, list, fs4Var, postData, vt7Var)) == null) {
            if (list == null || postData == null || vt7Var == null || !vt7Var.q() || !TbadkCoreApplication.isLogin() || k(postData) || vt7Var.p()) {
                return false;
            }
            bs4 bs4Var = new bs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031f), fs4Var);
            list.add(bs4Var);
            ur8.f(bs4Var.d, postData);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean b(List<bs4> list, fs4 fs4Var, PostData postData, PbModel pbModel) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, list, fs4Var, postData, pbModel)) == null) {
            if (list != null && postData != null && pbModel != null && pbModel.Q1() != null) {
                ft7 Q1 = pbModel.Q1();
                if (Q1.j0() && TbadkCoreApplication.isLogin() && !k(postData) && !Q1.i0()) {
                    bs4 bs4Var = new bs4(9, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f031f), fs4Var);
                    list.add(bs4Var);
                    ur8.f(bs4Var.d, postData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static List<bs4> c(List<bs4> list, AgreeData agreeData, SparseArray<Object> sparseArray, fs4 fs4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, list, agreeData, sparseArray, fs4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    bs4 bs4Var = new bs4(-1, lx7.k(R.string.obfuscated_res_0x7f0f035d, new Object[0]), fs4Var);
                    bs4Var.d.setTag(sparseArray);
                    arrayList.add(bs4Var);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                        bs4 bs4Var2 = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f035e, new Object[0]), fs4Var);
                        bs4Var2.d.setTag(sparseArray);
                        arrayList.add(bs4Var2);
                    }
                } else {
                    bs4 bs4Var3 = new bs4(-1, lx7.k(R.string.obfuscated_res_0x7f0f035c, new Object[0]), fs4Var);
                    bs4Var3.d.setTag(sparseArray);
                    arrayList.add(bs4Var3);
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                        bs4 bs4Var4 = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f035f, new Object[0]), fs4Var);
                        bs4Var4.d.setTag(sparseArray);
                        arrayList.add(bs4Var4);
                    }
                }
            } else {
                bs4 bs4Var5 = new bs4(-1, lx7.k(R.string.obfuscated_res_0x7f0f035c, new Object[0]), fs4Var);
                bs4Var5.d.setTag(sparseArray);
                arrayList.add(bs4Var5);
                if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                    bs4 bs4Var6 = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f035e, new Object[0]), fs4Var);
                    bs4Var6.d.setTag(sparseArray);
                    arrayList.add(bs4Var6);
                }
            }
            bs4 bs4Var7 = new bs4(-3, lx7.k(R.string.obfuscated_res_0x7f0f0fdd, new Object[0]), fs4Var);
            bs4Var7.d.setTag(sparseArray);
            arrayList.add(bs4Var7);
            bs4 bs4Var8 = new bs4(-4, lx7.k(R.string.obfuscated_res_0x7f0f1125, new Object[0]), fs4Var);
            bs4Var8.d.setTag(sparseArray);
            arrayList.add(bs4Var8);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static List<bs4> d(List<bs4> list, AgreeData agreeData, SparseArray<Object> sparseArray, fs4 fs4Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, list, agreeData, sparseArray, fs4Var)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 2) {
                    if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                        bs4 bs4Var = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f0087, new Object[0]), fs4Var);
                        bs4Var.d.setTag(sparseArray);
                        arrayList.add(bs4Var);
                    }
                } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                    bs4 bs4Var2 = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f035f, new Object[0]), fs4Var);
                    bs4Var2.d.setTag(sparseArray);
                    arrayList.add(bs4Var2);
                }
            } else if (sparseArray == null || sparseArray.get(R.id.obfuscated_res_0x7f0917b5) == null || !((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0917b5)).booleanValue()) {
                bs4 bs4Var3 = new bs4(-2, lx7.k(R.string.obfuscated_res_0x7f0f0087, new Object[0]), fs4Var);
                bs4Var3.d.setTag(sparseArray);
                arrayList.add(bs4Var3);
            }
            bs4 bs4Var4 = new bs4(-3, lx7.k(R.string.obfuscated_res_0x7f0f0fdd, new Object[0]), fs4Var);
            bs4Var4.d.setTag(sparseArray);
            arrayList.add(0, bs4Var4);
            bs4 bs4Var5 = new bs4(-4, lx7.k(R.string.obfuscated_res_0x7f0f1125, new Object[0]), fs4Var);
            bs4Var5.d.setTag(sparseArray);
            arrayList.add(1, bs4Var5);
            list.addAll(0, arrayList);
            return list;
        }
        return (List) invokeLLLL.objValue;
    }

    public static void e(Activity activity, @Nullable d9<?> d9Var, ur4.e eVar, ur4.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, d9Var, eVar, eVar2) == null) {
            ur4 ur4Var = new ur4(activity);
            ur4Var.setMessageId(R.string.obfuscated_res_0x7f0f04a7);
            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ee, eVar);
            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04e9, eVar2);
            ur4Var.setCancelable(true);
            ur4Var.create(d9Var);
            ur4Var.show();
        }
    }

    public static List<bs4> f(List<bs4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return list;
            }
            for (bs4 bs4Var : list) {
                bs4Var.l(h(bs4Var));
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    public static SpannableStringBuilder g(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, postData)) == null) {
            if (postData == null) {
                return null;
            }
            String tbRichText = postData.V() != null ? postData.V().toString() : "";
            SpannableString n = n(postData.s().getName_show() + ZeusCrashHandler.NAME_SEPERATOR, SkinManager.getColor(R.color.CAM_X0109));
            SpannableString n2 = n(tbRichText, SkinManager.getColor(R.color.CAM_X0107));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) n);
            spannableStringBuilder.append((CharSequence) n2);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeL.objValue;
    }

    public static Drawable h(bs4 bs4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bs4Var)) == null) {
            switch (bs4Var.f()) {
                case -4:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080986, SkinManager.getColor(R.color.CAM_X0107), null);
                case -3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080970, SkinManager.getColor(R.color.CAM_X0107), null);
                case -2:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f035e, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080974, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080975, SkinManager.getColor(R.color.CAM_X0107), null);
                case -1:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f035c, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097d, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08097e, SkinManager.getColor(R.color.CAM_X0301), null);
                case 0:
                default:
                    return null;
                case 1:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080976, SkinManager.getColor(R.color.CAM_X0107), null);
                case 2:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080985, SkinManager.getColor(R.color.CAM_X0107), null);
                case 3:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080971, SkinManager.getColor(R.color.CAM_X0107), null);
                case 4:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f0a90, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096e, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096f, SkinManager.getColor(R.color.CAM_X0305), null);
                case 5:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f0ff6, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080984, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lx7.k(R.string.obfuscated_res_0x7f0f0b33, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080982, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 6:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f0ff6, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080984, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lx7.k(R.string.obfuscated_res_0x7f0f04ab, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080973, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 7:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080969, SkinManager.getColor(R.color.CAM_X0107), null);
                case 8:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080979, SkinManager.getColor(R.color.CAM_X0107), null);
                case 9:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095c, SkinManager.getColor(R.color.CAM_X0107), null);
                case 10:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f04b6, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080973, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lx7.k(R.string.obfuscated_res_0x7f0f04ab, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080973, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 11:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08096d, SkinManager.getColor(R.color.CAM_X0107), null);
                case 12:
                    if (lx7.k(R.string.obfuscated_res_0x7f0f0b2f, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080980, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    if (lx7.k(R.string.obfuscated_res_0x7f0f1497, new Object[0]).equals(bs4Var.g())) {
                        return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080981, SkinManager.getColor(R.color.CAM_X0107), null);
                    }
                    return null;
                case 13:
                    return WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095b, SkinManager.getColor(R.color.CAM_X0107), null);
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static boolean i(PbModel pbModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, pbModel)) == null) ? (pbModel == null || pbModel.Q1() == null || !pbModel.Q1().j0()) ? false : true : invokeL.booleanValue;
    }

    public static boolean j(vt7 vt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, vt7Var)) == null) ? vt7Var != null && vt7Var.q() : invokeL.booleanValue;
    }

    public static boolean k(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, postData)) == null) ? (postData == null || postData.s() == null || StringUtils.isNull(postData.s().getUserId()) || !postData.s().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true : invokeL.booleanValue;
    }

    public static List<bs4> l(List<bs4> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, list, z)) == null) {
            if (list != null && !z) {
                Iterator<bs4> it = list.iterator();
                while (it.hasNext()) {
                    bs4 next = it.next();
                    if (next.f() == 2 || next.f() == 1 || next.f() == 3) {
                        it.remove();
                    }
                }
            }
            return list;
        }
        return (List) invokeLZ.objValue;
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
