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
/* loaded from: classes5.dex */
public class c74 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<a74> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755844303, "Lcom/repackage/c74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755844303, "Lcom/repackage/c74;");
                return;
            }
        }
        SparseArray<a74> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new a74(5, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f5, true));
        a.put(35, new a74(35, R.string.obfuscated_res_0x7f0f00e7, R.drawable.obfuscated_res_0x7f0800d5, true));
        a.put(39, new a74(39, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(4, new a74(4, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800fb, true));
        a.put(37, new a74(37, R.string.obfuscated_res_0x7f0f00e9, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(38, new a74(38, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(42, new a74(42, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800f8, true));
        a.put(49, new a74(49, R.string.obfuscated_res_0x7f0f1244, R.drawable.obfuscated_res_0x7f08113a, true));
        a.put(50, new a74(50, R.string.obfuscated_res_0x7f0f12c8, R.drawable.obfuscated_res_0x7f081139, true));
        a.put(43, new a74(43, R.string.obfuscated_res_0x7f0f00e8, R.drawable.obfuscated_res_0x7f0800d9, true));
        a.put(9, new a74(9, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800e5, true));
        a.put(46, new a74(46, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800ea, true));
        a.put(47, new a74(47, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800ed, true));
    }

    public static a74 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? a74.k(a.get(i)) : (a74) invokeI.objValue;
    }

    public static List<a74> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(a74.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(a74.k(a.get(38)));
                                arrayList.add(a74.k(a.get(4)));
                                arrayList.add(a74.k(a.get(39)));
                                arrayList.add(a74.k(a.get(35)));
                                arrayList.add(a74.k(a.get(5)));
                                arrayList.add(a74.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(a74.l(a.get(38), false));
                                arrayList.add(a74.l(a.get(4), false));
                                arrayList.add(a74.k(a.get(39)));
                                arrayList.add(a74.l(a.get(35), false));
                                arrayList.add(a74.k(a.get(5)));
                                arrayList.add(a74.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(a74.k(a.get(38)));
                                arrayList.add(a74.k(a.get(4)));
                                arrayList.add(a74.k(a.get(39)));
                                arrayList.add(a74.k(a.get(35)));
                                arrayList.add(a74.k(a.get(5)));
                                arrayList.add(a74.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(a74.k(a.get(43)));
                    }
                }
                arrayList.add(a74.k(a.get(38)));
                arrayList.add(a74.k(a.get(4)));
                arrayList.add(a74.k(a.get(39)));
                arrayList.add(a74.k(a.get(35)));
                arrayList.add(a74.k(a.get(5)));
                arrayList.add(a74.k(a.get(49)));
            } else {
                arrayList.add(a74.k(a.get(38)));
                arrayList.add(a74.k(a.get(5)));
                arrayList.add(a74.k(a.get(4)));
                arrayList.add(a74.k(a.get(35)));
                arrayList.add(a74.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
