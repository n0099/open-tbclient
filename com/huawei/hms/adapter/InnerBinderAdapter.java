package com.huawei.hms.adapter;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes9.dex */
public class InnerBinderAdapter extends BinderAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INNER_MSG_CONN_TIMEOUT = 2001;
    public static final int INNER_MSG_DELAY_DISCONNECT = 2002;
    public static final Object LOCK_OBJECT_INIT;
    public static final String TAG = "InnerBinderAdapter";
    public static BinderAdapter innerAdapter;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2001;
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 2002;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1805992291, "Lcom/huawei/hms/adapter/InnerBinderAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1805992291, "Lcom/huawei/hms/adapter/InnerBinderAdapter;");
                return;
            }
        }
        LOCK_OBJECT_INIT = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static BinderAdapter getInstance(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        BinderAdapter binderAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            HMSLog.i(TAG, "InnerBinderAdapter getInstance.");
            synchronized (LOCK_OBJECT_INIT) {
                if (innerAdapter == null) {
                    innerAdapter = new InnerBinderAdapter(context, str, str2);
                }
                binderAdapter = innerAdapter;
            }
            return binderAdapter;
        }
        return (BinderAdapter) invokeLLL.objValue;
    }
}
