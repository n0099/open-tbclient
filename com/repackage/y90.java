package com.repackage;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class y90 {
    public static /* synthetic */ Interceptable $ic;
    public static y90 b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public y90() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
        new PorterDuffColorFilter(PullViewHelper.IMAGE_COLORFILTER_NIGHT, PorterDuff.Mode.MULTIPLY);
    }

    public static y90 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (y90.class) {
                if (b == null) {
                    b = new y90();
                }
            }
            return b;
        }
        return (y90) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
