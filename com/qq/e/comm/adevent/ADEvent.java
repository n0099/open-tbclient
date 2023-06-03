package com.qq.e.comm.adevent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes10.dex */
public class ADEvent {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final Object[] b;

    public ADEvent(int i, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {Integer.valueOf(i), objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = objArr;
        if (i < 100) {
            a("EventId 错误" + i);
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            GDTLogger.e(str);
        }
    }

    public <T> T getParam(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? (T) getParam(0, cls) : (T) invokeL.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
    }

    public <T> T getParam(int i, Class<T> cls) {
        InterceptResult invokeIL;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, cls)) == null) {
            if (cls == null || (objArr = this.b) == null || objArr.length <= i) {
                return null;
            }
            T t = (T) objArr[i];
            if (t == null) {
                GDTLogger.e("ADEvent 参数为空,type:" + this.a);
                return null;
            } else if (!cls.isInstance(objArr[i])) {
                GDTLogger.e("ADEvent" + this.a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t.getClass().getName());
                return null;
            } else {
                return t;
            }
        }
        return (T) invokeIL.objValue;
    }
}
