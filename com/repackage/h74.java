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
public class h74 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<f74> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755695348, "Lcom/repackage/h74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755695348, "Lcom/repackage/h74;");
                return;
            }
        }
        SparseArray<f74> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new f74(5, R.string.obfuscated_res_0x7f0f00fa, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(35, new f74(35, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(39, new f74(39, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(4, new f74(4, R.string.obfuscated_res_0x7f0f00fb, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(37, new f74(37, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(38, new f74(38, R.string.obfuscated_res_0x7f0f00f8, R.drawable.obfuscated_res_0x7f0800d3, true));
        a.put(42, new f74(42, R.string.obfuscated_res_0x7f0f00f0, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(49, new f74(49, R.string.obfuscated_res_0x7f0f1247, R.drawable.obfuscated_res_0x7f081127, true));
        a.put(50, new f74(50, R.string.obfuscated_res_0x7f0f12cb, R.drawable.obfuscated_res_0x7f081126, true));
        a.put(43, new f74(43, R.string.obfuscated_res_0x7f0f00ee, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(9, new f74(9, R.string.obfuscated_res_0x7f0f00f9, R.drawable.obfuscated_res_0x7f0800e4, true));
        a.put(46, new f74(46, R.string.obfuscated_res_0x7f0f00f1, R.drawable.obfuscated_res_0x7f0800e9, true));
        a.put(47, new f74(47, R.string.obfuscated_res_0x7f0f00f2, R.drawable.obfuscated_res_0x7f0800ec, true));
    }

    public static f74 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? f74.k(a.get(i)) : (f74) invokeI.objValue;
    }

    public static List<f74> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(f74.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(f74.k(a.get(38)));
                                arrayList.add(f74.k(a.get(4)));
                                arrayList.add(f74.k(a.get(39)));
                                arrayList.add(f74.k(a.get(35)));
                                arrayList.add(f74.k(a.get(5)));
                                arrayList.add(f74.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(f74.l(a.get(38), false));
                                arrayList.add(f74.l(a.get(4), false));
                                arrayList.add(f74.k(a.get(39)));
                                arrayList.add(f74.l(a.get(35), false));
                                arrayList.add(f74.k(a.get(5)));
                                arrayList.add(f74.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(f74.k(a.get(38)));
                                arrayList.add(f74.k(a.get(4)));
                                arrayList.add(f74.k(a.get(39)));
                                arrayList.add(f74.k(a.get(35)));
                                arrayList.add(f74.k(a.get(5)));
                                arrayList.add(f74.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(f74.k(a.get(43)));
                    }
                }
                arrayList.add(f74.k(a.get(38)));
                arrayList.add(f74.k(a.get(4)));
                arrayList.add(f74.k(a.get(39)));
                arrayList.add(f74.k(a.get(35)));
                arrayList.add(f74.k(a.get(5)));
                arrayList.add(f74.k(a.get(49)));
            } else {
                arrayList.add(f74.k(a.get(38)));
                arrayList.add(f74.k(a.get(5)));
                arrayList.add(f74.k(a.get(4)));
                arrayList.add(f74.k(a.get(35)));
                arrayList.add(f74.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
