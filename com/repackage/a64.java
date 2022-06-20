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
public class a64 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseArray<y54> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755904846, "Lcom/repackage/a64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755904846, "Lcom/repackage/a64;");
                return;
            }
        }
        SparseArray<y54> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(5, new y54(5, R.string.obfuscated_res_0x7f0f00f5, R.drawable.obfuscated_res_0x7f0800f4, true));
        a.put(35, new y54(35, R.string.obfuscated_res_0x7f0f00e8, R.drawable.obfuscated_res_0x7f0800d4, true));
        a.put(39, new y54(39, R.string.obfuscated_res_0x7f0f00ef, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(4, new y54(4, R.string.obfuscated_res_0x7f0f00f6, R.drawable.obfuscated_res_0x7f0800fa, true));
        a.put(37, new y54(37, R.string.obfuscated_res_0x7f0f00ea, R.drawable.obfuscated_res_0x7f0800d7, true));
        a.put(38, new y54(38, R.string.obfuscated_res_0x7f0f00f3, R.drawable.obfuscated_res_0x7f0800d3, true));
        a.put(42, new y54(42, R.string.obfuscated_res_0x7f0f00eb, R.drawable.obfuscated_res_0x7f0800f7, true));
        a.put(49, new y54(49, R.string.obfuscated_res_0x7f0f1263, R.drawable.obfuscated_res_0x7f08113d, true));
        a.put(50, new y54(50, R.string.obfuscated_res_0x7f0f12e7, R.drawable.obfuscated_res_0x7f08113c, true));
        a.put(43, new y54(43, R.string.obfuscated_res_0x7f0f00e9, R.drawable.obfuscated_res_0x7f0800d8, true));
        a.put(9, new y54(9, R.string.obfuscated_res_0x7f0f00f4, R.drawable.obfuscated_res_0x7f0800e4, true));
        a.put(46, new y54(46, R.string.obfuscated_res_0x7f0f00ec, R.drawable.obfuscated_res_0x7f0800e9, true));
        a.put(47, new y54(47, R.string.obfuscated_res_0x7f0f00ed, R.drawable.obfuscated_res_0x7f0800ec, true));
    }

    public static y54 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? y54.k(a.get(i)) : (y54) invokeI.objValue;
    }

    public static List<y54> b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i != 12) {
                    if (i != 13) {
                        switch (i) {
                            case 16:
                                arrayList.add(y54.k(a.get(5)));
                                break;
                            case 17:
                            case 18:
                                arrayList.add(y54.k(a.get(38)));
                                arrayList.add(y54.k(a.get(4)));
                                arrayList.add(y54.k(a.get(39)));
                                arrayList.add(y54.k(a.get(35)));
                                arrayList.add(y54.k(a.get(5)));
                                arrayList.add(y54.k(a.get(49)));
                                break;
                            case 19:
                                arrayList.add(y54.l(a.get(38), false));
                                arrayList.add(y54.l(a.get(4), false));
                                arrayList.add(y54.k(a.get(39)));
                                arrayList.add(y54.l(a.get(35), false));
                                arrayList.add(y54.k(a.get(5)));
                                arrayList.add(y54.l(a.get(49), false));
                                break;
                            case 20:
                                arrayList.add(y54.k(a.get(38)));
                                arrayList.add(y54.k(a.get(4)));
                                arrayList.add(y54.k(a.get(39)));
                                arrayList.add(y54.k(a.get(35)));
                                arrayList.add(y54.k(a.get(5)));
                                arrayList.add(y54.k(a.get(49)));
                                break;
                        }
                    } else {
                        arrayList.add(y54.k(a.get(43)));
                    }
                }
                arrayList.add(y54.k(a.get(38)));
                arrayList.add(y54.k(a.get(4)));
                arrayList.add(y54.k(a.get(39)));
                arrayList.add(y54.k(a.get(35)));
                arrayList.add(y54.k(a.get(5)));
                arrayList.add(y54.k(a.get(49)));
            } else {
                arrayList.add(y54.k(a.get(38)));
                arrayList.add(y54.k(a.get(5)));
                arrayList.add(y54.k(a.get(4)));
                arrayList.add(y54.k(a.get(35)));
                arrayList.add(y54.k(a.get(42)));
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }
}
