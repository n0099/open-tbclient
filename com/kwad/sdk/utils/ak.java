package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.config.item.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class ak {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ak f73886a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f73887b;

    /* renamed from: c  reason: collision with root package name */
    public o.a f73888c;

    public ak() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73887b = false;
    }

    public static ak a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f73886a == null) {
                synchronized (ak.class) {
                    if (f73886a == null) {
                        f73886a = new ak();
                    }
                }
            }
            return f73886a;
        }
        return (ak) invokeV.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Class.forName(str) != null;
        }
        return invokeL.booleanValue;
    }

    private boolean a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, list)) == null) {
            if (list != null && list.size() >= 1) {
                for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                    String className = stackTraceElement.getClassName();
                    if (className != null) {
                        for (String str : list) {
                            if (className.contains(str)) {
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void c() {
        o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (aVar = this.f73888c) == null) {
            return;
        }
        if (!this.f73887b && aVar.f71518c.size() > 0) {
            for (String str : this.f73888c.f71518c) {
                boolean a2 = a(str);
                this.f73887b = a2;
                if (a2) {
                    break;
                }
            }
        }
        if (this.f73887b) {
            ArrayList arrayList = new ArrayList();
            if (this.f73888c.f71516a.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.f73888c.f71516a.entrySet()) {
                    if (a(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.sdk.core.report.d.a(a(this.f73888c.f71517b), arrayList);
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("ksadsdk_config", 0);
        if (sharedPreferences != null) {
            c.a.aE.a(sharedPreferences);
            this.f73888c = c.a.aE.a();
        }
        if (this.f73888c != null) {
            c();
        }
    }

    public boolean a(KsScene ksScene, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksScene, str)) == null) {
            boolean a2 = this.f73887b ? a(this.f73888c.f71517b) : false;
            com.kwad.sdk.core.report.d.a(ksScene, a2, str);
            return a2;
        }
        return invokeLL.booleanValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o.a aVar = this.f73888c;
            if (aVar != null) {
                return aVar.f71519d;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
