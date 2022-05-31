package com.repackage;

import android.util.SparseArray;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p54 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<n54> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755458942, "Lcom/repackage/p54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755458942, "Lcom/repackage/p54;");
                return;
            }
        }
        SparseArray<n54> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new n54(5, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new n54(35, R.string.obfuscated_res_0x7f0f00e8, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new n54(39, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new n54(4, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new n54(37, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new n54(38, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new n54(42, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new n54(49, R.string.obfuscated_res_0x7f0f1256, R.drawable.obfuscated_res_0x7f08114c, true));
        a.put(50, new n54(50, R.string.obfuscated_res_0x7f0f12da, R.drawable.obfuscated_res_0x7f08114b, true));
        a.put(43, new n54(43, R.string.obfuscated_res_0x7f0f00e9, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new n54(9, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new n54(46, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new n54(47, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static n54 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? n54.k(a.get(i)) : (n54) invokeI.objValue;
    }

    public static List<n54> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(n54.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(n54.k(a.get(38)));
                                arrayList.add(n54.k(a.get(4)));
                                arrayList.add(n54.k(a.get(39)));
                                arrayList.add(n54.k(a.get(35)));
                                arrayList.add(n54.k(a.get(5)));
                                arrayList.add(n54.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(n54.l(a.get(38), false));
                                arrayList.add(n54.l(a.get(4), false));
                                arrayList.add(n54.k(a.get(39)));
                                arrayList.add(n54.l(a.get(35), false));
                                arrayList.add(n54.k(a.get(5)));
                                arrayList.add(n54.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(n54.k(a.get(38)));
                                arrayList.add(n54.k(a.get(4)));
                                arrayList.add(n54.k(a.get(39)));
                                arrayList.add(n54.k(a.get(35)));
                                arrayList.add(n54.k(a.get(5)));
                                arrayList.add(n54.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(n54.k(a.get(43)));
                    }
                }
                arrayList.add(n54.k(a.get(38)));
                arrayList.add(n54.k(a.get(4)));
                arrayList.add(n54.k(a.get(39)));
                arrayList.add(n54.k(a.get(35)));
                arrayList.add(n54.k(a.get(5)));
                arrayList.add(n54.k(a.get(49)));
            } else {
                arrayList.add(n54.k(a.get(38)));
                arrayList.add(n54.k(a.get(5)));
                arrayList.add(n54.k(a.get(4)));
                arrayList.add(n54.k(a.get(35)));
                arrayList.add(n54.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
