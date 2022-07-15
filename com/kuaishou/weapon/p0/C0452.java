package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* renamed from: com.kuaishou.weapon.p0.ﹶ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0452 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0452() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m1014(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (C0306.m180(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE"})) {
                String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4"};
                for (int i = 0; i < 2; i++) {
                    if (new File(strArr[i]).exists()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
