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
public class ln9 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadPoolExecutor a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755523174, "Lcom/repackage/ln9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755523174, "Lcom/repackage/ln9;");
                return;
            }
        }
        a = new ThreadPoolExecutor(1, 5, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue(30));
    }

    public static String a(Context context, String str, String str2, List list, en9 en9Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, list, en9Var)) == null) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                File file = new File(str2, String.valueOf(str3.hashCode()));
                if (file.exists()) {
                    if (file.length() == ym9.b(context).a(str3)) {
                        str = str.replace(str3, "file://" + file.getAbsolutePath());
                        atomicInteger.addAndGet(1);
                    }
                }
            }
            if (en9Var != null) {
                if (atomicInteger.get() <= 0) {
                    en9Var.a(0);
                } else if (atomicInteger.get() == list.size()) {
                    en9Var.a(2);
                } else {
                    en9Var.a(1);
                }
            }
            return str;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static void b(Context context, String str, List list, bn9 bn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, list, bn9Var) == null) {
            try {
                a.execute(new vm9(context, str, list, bn9Var));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
