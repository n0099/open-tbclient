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
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;
/* loaded from: classes10.dex */
public class OuterBinderAdapter extends BinderAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object LOCK_OBJECT_INIT;
    public static final int MSG_CONN_TIMEOUT = 1001;
    public static final int MSG_DELAY_DISCONNECT = 1002;
    public static final String TAG = "OuterBinderAdapter";
    public static BinderAdapter adapter;
    public static String sActionName;
    public static String sServiceName;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1002;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1437504510, "Lcom/huawei/hms/adapter/OuterBinderAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1437504510, "Lcom/huawei/hms/adapter/OuterBinderAdapter;");
                return;
            }
        }
        LOCK_OBJECT_INIT = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuterBinderAdapter(Context context, String str, String str2) {
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034 A[Catch: all -> 0x004f, TryCatch #0 {, blocks: (B:6:0x000e, B:8:0x0012, B:18:0x004b, B:19:0x004d, B:9:0x001e, B:11:0x0026, B:17:0x0034), top: B:28:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BinderAdapter getInstance(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        boolean z;
        BinderAdapter binderAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, str2)) == null) {
            HMSLog.i(TAG, "OuterBinderAdapter getInstance.");
            synchronized (LOCK_OBJECT_INIT) {
                if (adapter == null) {
                    sActionName = str;
                    sServiceName = str2;
                    adapter = new OuterBinderAdapter(context, str, str2);
                } else {
                    if (Objects.equal(sActionName, str) && Objects.equal(sServiceName, str2)) {
                        z = false;
                        if (z) {
                            HMSLog.i(TAG, "OuterBinderAdapter getInstance refresh adapter");
                            sActionName = str;
                            sServiceName = str2;
                            adapter.unBind();
                            adapter = new OuterBinderAdapter(context, str, str2);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                binderAdapter = adapter;
            }
            return binderAdapter;
        }
        return (BinderAdapter) invokeLLL.objValue;
    }
}
