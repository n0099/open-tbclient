package com.repackage;

import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.cpu.booster.utils.CpuType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes5.dex */
public class ek3 {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<wj3> a;
    public static CpuType b;
    public static int c;
    public static xj3 d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String name = file.getName();
                if (name.startsWith("cpu")) {
                    int length = name.length();
                    for (int i = 3; i < length; i++) {
                        if (!Character.isDigit(name.charAt(i))) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755734780, "Lcom/repackage/ek3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755734780, "Lcom/repackage/ek3;");
                return;
            }
        }
        a = new SparseArray<>();
        c = -1;
    }

    public static wj3 a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            wj3 wj3Var = a.get(i);
            if (wj3Var != null) {
                return wj3Var;
            }
            try {
                wj3 wj3Var2 = new wj3(i, k("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_min_freq"), k("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq"));
                a.put(i, wj3Var2);
                return wj3Var2;
            } catch (Exception unused) {
                return new wj3(i, -1, -1);
            }
        }
        return (wj3) invokeI.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            File[] listFiles = new File("/sys/devices/system/cpu").listFiles(new a());
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        }
        return invokeV.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int d2 = d(readLine);
                fileInputStream.close();
                return d2;
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            int indexOf = str.indexOf(45);
            if (indexOf == -1) {
                if (TextUtils.isDigitsOnly(str)) {
                    return m(str) + 1;
                }
                return -1;
            }
            int m = m(str.substring(indexOf + 1));
            if (m != -1) {
                return m + 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            int i = c;
            if (i != -1) {
                return i;
            }
            int c2 = c("/sys/devices/system/cpu/possible");
            if (c2 != -1) {
                c = c2;
                return c2;
            }
            int c3 = c("/sys/devices/system/cpu/present");
            if (c3 != -1) {
                c = c3;
                return c3;
            }
            int b2 = b();
            if (b2 == -1) {
                b2 = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            c = b2;
            return b2;
        }
        return invokeV.intValue;
    }

    public static xj3 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            xj3 xj3Var = d;
            if (xj3Var != null) {
                return xj3Var;
            }
            int e = e();
            if (e <= 0) {
                return new xj3();
            }
            if (e == 1) {
                xj3 xj3Var2 = new xj3();
                xj3Var2.h = false;
                xj3Var2.a = e;
                xj3Var2.l = a(0);
                d = xj3Var2;
                return xj3Var2;
            }
            ArrayList<wj3> arrayList = new ArrayList(e);
            for (int i = 0; i < e; i++) {
                arrayList.add(a(i));
            }
            SparseArray sparseArray = new SparseArray();
            SparseIntArray sparseIntArray = new SparseIntArray();
            ArrayList arrayList2 = new ArrayList();
            for (wj3 wj3Var : arrayList) {
                int i2 = wj3Var.c;
                if (sparseArray.get(i2) != null) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                } else {
                    sparseArray.put(i2, wj3Var);
                    arrayList2.add(wj3Var);
                    sparseIntArray.put(i2, 1);
                }
            }
            Collections.sort(arrayList2);
            xj3 xj3Var3 = new xj3();
            xj3Var3.a = e;
            boolean z = arrayList2.size() > 1;
            xj3Var3.h = z;
            if (!z) {
                xj3Var3.l = (wj3) (arrayList2.size() <= 0 ? arrayList.get(0) : arrayList2.get(0));
                d = xj3Var3;
                return xj3Var3;
            }
            xj3Var3.j = (wj3) arrayList2.get(0);
            xj3Var3.c = ((wj3) arrayList2.get(0)).a;
            xj3Var3.b = sparseIntArray.get(xj3Var3.j.c);
            xj3Var3.i = (wj3) arrayList2.get(1);
            xj3Var3.e = ((wj3) arrayList2.get(1)).a;
            xj3Var3.d = sparseIntArray.get(xj3Var3.i.c);
            if (arrayList2.size() > 2) {
                xj3Var3.k = (wj3) arrayList2.get(2);
                xj3Var3.g = ((wj3) arrayList2.get(2)).a;
                xj3Var3.f = sparseIntArray.get(xj3Var3.k.c);
            }
            d = xj3Var3;
            return xj3Var3;
        }
        return (xj3) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String a2 = gk3.a("ro.board.platform");
            if (TextUtils.isEmpty(a2)) {
                a2 = Build.HARDWARE;
            }
            return a2 != null ? a2.trim() : a2;
        }
        return (String) invokeV.objValue;
    }

    public static CpuType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            CpuType cpuType = b;
            return cpuType != null ? cpuType : i(g());
        }
        return (CpuType) invokeV.objValue;
    }

    public static CpuType i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                CpuType cpuType = CpuType.Unknown;
                b = cpuType;
                return cpuType;
            }
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("kirin") && !lowerCase.startsWith("hi")) {
                if (!lowerCase.startsWith("qcom") && !lowerCase.startsWith("kona") && !lowerCase.startsWith("lahaina") && !lowerCase.startsWith("msm") && !lowerCase.startsWith("sdm") && !lowerCase.startsWith("apq") && !lowerCase.startsWith("sm")) {
                    if (lowerCase.startsWith("mt")) {
                        CpuType cpuType2 = CpuType.Mtk;
                        b = cpuType2;
                        return cpuType2;
                    }
                    CpuType cpuType3 = CpuType.Unknown;
                    b = cpuType3;
                    return cpuType3;
                }
                CpuType cpuType4 = CpuType.QualComm;
                b = cpuType4;
                return cpuType4;
            }
            CpuType cpuType5 = CpuType.Hisilicon;
            b = cpuType5;
            return cpuType5;
        }
        return (CpuType) invokeL.objValue;
    }

    public static int j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return k("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
        }
        return invokeI.intValue;
    }

    public static int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    return m(l(readLine));
                } catch (Exception unused) {
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            int i = 0;
            while (i < length && Character.isDigit(str.charAt(i))) {
                i++;
            }
            return str.substring(0, i);
        }
        return (String) invokeL.objValue;
    }

    public static int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }
}
