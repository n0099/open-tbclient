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
public class q64 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<o64> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755428190, "Lcom/repackage/q64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755428190, "Lcom/repackage/q64;");
                return;
            }
        }
        SparseArray<o64> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new o64(5, R.string.obfuscated_res_0x7f0f00f7, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(35, new o64(35, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(39, new o64(39, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(4, new o64(4, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(37, new o64(37, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(38, new o64(38, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800d3, true));
        a.put(42, new o64(42, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(49, new o64(49, R.string.obfuscated_res_0x7f0f120b, R.drawable.obfuscated_res_0x7f0810c1, true));
        a.put(50, new o64(50, R.string.obfuscated_res_0x7f0f128f, R.drawable.obfuscated_res_0x7f0810c0, true));
        a.put(43, new o64(43, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(9, new o64(9, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800e4, true));
        a.put(46, new o64(46, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800e9, true));
        a.put(47, new o64(47, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800ec, true));
    }

    public static o64 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? o64.k(a.get(i)) : (o64) invokeI.objValue;
    }

    public static List<o64> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(o64.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(o64.k(a.get(38)));
                                arrayList.add(o64.k(a.get(4)));
                                arrayList.add(o64.k(a.get(39)));
                                arrayList.add(o64.k(a.get(35)));
                                arrayList.add(o64.k(a.get(5)));
                                arrayList.add(o64.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(o64.l(a.get(38), false));
                                arrayList.add(o64.l(a.get(4), false));
                                arrayList.add(o64.k(a.get(39)));
                                arrayList.add(o64.l(a.get(35), false));
                                arrayList.add(o64.k(a.get(5)));
                                arrayList.add(o64.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(o64.k(a.get(38)));
                                arrayList.add(o64.k(a.get(4)));
                                arrayList.add(o64.k(a.get(39)));
                                arrayList.add(o64.k(a.get(35)));
                                arrayList.add(o64.k(a.get(5)));
                                arrayList.add(o64.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(o64.k(a.get(43)));
                    }
                }
                arrayList.add(o64.k(a.get(38)));
                arrayList.add(o64.k(a.get(4)));
                arrayList.add(o64.k(a.get(39)));
                arrayList.add(o64.k(a.get(35)));
                arrayList.add(o64.k(a.get(5)));
                arrayList.add(o64.k(a.get(49)));
            } else {
                arrayList.add(o64.k(a.get(38)));
                arrayList.add(o64.k(a.get(5)));
                arrayList.add(o64.k(a.get(4)));
                arrayList.add(o64.k(a.get(35)));
                arrayList.add(o64.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
