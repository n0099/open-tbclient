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
/* loaded from: classes7.dex */
public class r64 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<p64> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755398399, "Lcom/repackage/r64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755398399, "Lcom/repackage/r64;");
                return;
            }
        }
        SparseArray<p64> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new p64(5, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new p64(35, R.string.obfuscated_res_0x7f0f00e5, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new p64(39, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new p64(4, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new p64(37, R.string.obfuscated_res_0x7f0f00e7, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new p64(38, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new p64(42, R.string.obfuscated_res_0x7f0f00e8, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new p64(49, R.string.obfuscated_res_0x7f0f1223, R.drawable.obfuscated_res_0x7f081124, true));
        a.put(50, new p64(50, R.string.obfuscated_res_0x7f0f12a7, R.drawable.obfuscated_res_0x7f081123, true));
        a.put(43, new p64(43, R.string.obfuscated_res_0x7f0f00e6, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new p64(9, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new p64(46, R.string.obfuscated_res_0x7f0f00e9, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new p64(47, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static p64 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? p64.k(a.get(i)) : (p64) invokeI.objValue;
    }

    public static List<p64> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(p64.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(p64.k(a.get(38)));
                                arrayList.add(p64.k(a.get(4)));
                                arrayList.add(p64.k(a.get(39)));
                                arrayList.add(p64.k(a.get(35)));
                                arrayList.add(p64.k(a.get(5)));
                                arrayList.add(p64.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(p64.l(a.get(38), false));
                                arrayList.add(p64.l(a.get(4), false));
                                arrayList.add(p64.k(a.get(39)));
                                arrayList.add(p64.l(a.get(35), false));
                                arrayList.add(p64.k(a.get(5)));
                                arrayList.add(p64.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(p64.k(a.get(38)));
                                arrayList.add(p64.k(a.get(4)));
                                arrayList.add(p64.k(a.get(39)));
                                arrayList.add(p64.k(a.get(35)));
                                arrayList.add(p64.k(a.get(5)));
                                arrayList.add(p64.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(p64.k(a.get(43)));
                    }
                }
                arrayList.add(p64.k(a.get(38)));
                arrayList.add(p64.k(a.get(4)));
                arrayList.add(p64.k(a.get(39)));
                arrayList.add(p64.k(a.get(35)));
                arrayList.add(p64.k(a.get(5)));
                arrayList.add(p64.k(a.get(49)));
            } else {
                arrayList.add(p64.k(a.get(38)));
                arrayList.add(p64.k(a.get(5)));
                arrayList.add(p64.k(a.get(4)));
                arrayList.add(p64.k(a.get(35)));
                arrayList.add(p64.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
