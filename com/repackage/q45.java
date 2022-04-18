package com.repackage;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class q45 {
    public static /* synthetic */ Interceptable $ic;
    public static q45 h;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<MaintabBottomIndicator> a;
    public View b;
    public Object c;
    public View d;
    public View e;
    public View f;
    public View g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755430081, "Lcom/repackage/q45;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755430081, "Lcom/repackage/q45;");
        }
    }

    public q45() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
    }

    public static q45 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (h == null) {
                synchronized (q45.class) {
                    if (h == null) {
                        h = new q45();
                    }
                }
            }
            return h;
        }
        return (q45) invokeV.objValue;
    }

    public MaintabBottomIndicator a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.isEmpty()) {
                return null;
            }
            MaintabBottomIndicator maintabBottomIndicator = this.a.get(0);
            this.a.remove(maintabBottomIndicator);
            return maintabBottomIndicator;
        }
        return (MaintabBottomIndicator) invokeV.objValue;
    }

    public void c(MaintabBottomIndicator maintabBottomIndicator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, maintabBottomIndicator) == null) {
            this.a.add(maintabBottomIndicator);
        }
    }
}
