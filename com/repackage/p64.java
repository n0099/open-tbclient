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
public class p64 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<n64> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755457981, "Lcom/repackage/p64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755457981, "Lcom/repackage/p64;");
                return;
            }
        }
        SparseArray<n64> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new n64(5, R.string.obfuscated_res_0x7f0f00f7, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(35, new n64(35, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(39, new n64(39, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(4, new n64(4, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(37, new n64(37, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(38, new n64(38, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800d3, true));
        a.put(42, new n64(42, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(49, new n64(49, R.string.obfuscated_res_0x7f0f125c, R.drawable.obfuscated_res_0x7f0810bd, true));
        a.put(50, new n64(50, R.string.obfuscated_res_0x7f0f12e0, R.drawable.obfuscated_res_0x7f0810bc, true));
        a.put(43, new n64(43, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(9, new n64(9, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800e4, true));
        a.put(46, new n64(46, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800e9, true));
        a.put(47, new n64(47, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800ec, true));
    }

    public static n64 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? n64.k(a.get(i)) : (n64) invokeI.objValue;
    }

    public static List<n64> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(n64.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(n64.k(a.get(38)));
                                arrayList.add(n64.k(a.get(4)));
                                arrayList.add(n64.k(a.get(39)));
                                arrayList.add(n64.k(a.get(35)));
                                arrayList.add(n64.k(a.get(5)));
                                arrayList.add(n64.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(n64.l(a.get(38), false));
                                arrayList.add(n64.l(a.get(4), false));
                                arrayList.add(n64.k(a.get(39)));
                                arrayList.add(n64.l(a.get(35), false));
                                arrayList.add(n64.k(a.get(5)));
                                arrayList.add(n64.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(n64.k(a.get(38)));
                                arrayList.add(n64.k(a.get(4)));
                                arrayList.add(n64.k(a.get(39)));
                                arrayList.add(n64.k(a.get(35)));
                                arrayList.add(n64.k(a.get(5)));
                                arrayList.add(n64.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(n64.k(a.get(43)));
                    }
                }
                arrayList.add(n64.k(a.get(38)));
                arrayList.add(n64.k(a.get(4)));
                arrayList.add(n64.k(a.get(39)));
                arrayList.add(n64.k(a.get(35)));
                arrayList.add(n64.k(a.get(5)));
                arrayList.add(n64.k(a.get(49)));
            } else {
                arrayList.add(n64.k(a.get(38)));
                arrayList.add(n64.k(a.get(5)));
                arrayList.add(n64.k(a.get(4)));
                arrayList.add(n64.k(a.get(35)));
                arrayList.add(n64.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
