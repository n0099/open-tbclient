package com.repackage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class pr9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755400166, "Lcom/repackage/pr9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755400166, "Lcom/repackage/pr9;");
                return;
            }
        }
        a = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(30));
    }

    public static String a(Context context, String str, String str2, List list, ir9 ir9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, list, ir9Var)) == null) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                File file = new File(str2, String.valueOf(str3.hashCode()));
                if (file.exists()) {
                    if (file.length() == cr9.b(context).a(str3)) {
                        str = str.replace(str3, "file://" + file.getAbsolutePath());
                        atomicInteger.addAndGet(1);
                    }
                }
            }
            if (ir9Var != null) {
                if (atomicInteger.get() <= 0) {
                    ir9Var.a(0);
                } else if (atomicInteger.get() == list.size()) {
                    ir9Var.a(2);
                } else {
                    ir9Var.a(1);
                }
            }
            return str;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static void b(Context context, String str, List list, fr9 fr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, list, fr9Var) == null) {
            try {
                a.execute(new zq9(context, str, list, fr9Var));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
