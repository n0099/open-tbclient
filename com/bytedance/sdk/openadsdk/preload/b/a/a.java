package com.bytedance.sdk.openadsdk.preload.b.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends Exception {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<Throwable> f68955a;

    public a(List<Throwable> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68955a = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Throwable th : list) {
            a(th, arrayList);
        }
        setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
    }

    private void a(Throwable th, List<StackTraceElement> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, this, th, list) == null) || th == null) {
            return;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        for (int i2 = 0; i2 < length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (i2 == 0) {
                String message = th.getMessage();
                StringBuilder sb = new StringBuilder();
                sb.append("\b\b\b\nCaused by:");
                if (message == null) {
                    message = "";
                }
                sb.append(message);
                sb.append("\n\t");
                sb.append(stackTraceElement.getClassName());
                list.add(new StackTraceElement(sb.toString(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
            } else {
                list.add(stackTraceElement);
            }
        }
        a(th.getCause(), list);
    }
}
