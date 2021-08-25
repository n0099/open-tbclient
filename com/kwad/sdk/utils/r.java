package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
/* loaded from: classes10.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Handler f73802a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f73803b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1510835198, "Lcom/kwad/sdk/utils/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1510835198, "Lcom/kwad/sdk/utils/r;");
                return;
            }
        }
        f73802a = new Handler(Looper.getMainLooper());
        f73803b = false;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            a(context, str, R.layout.ksad_content_alliance_toast_2);
        }
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, str, i2) == null) {
            a(context, str, i2, 800L);
        }
    }

    public static void a(Context context, String str, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || f73803b) {
            return;
        }
        f73803b = true;
        View inflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
        f73802a.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.r.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean unused = r.f73803b = false;
                }
            }
        }, j2);
    }
}
