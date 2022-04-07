package com.yy.gslbsdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.util.GlobalTools;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class GslbEvent {
    public static final /* synthetic */ GslbEvent[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final GslbEvent INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public GslbEventListener listener;

    /* loaded from: classes8.dex */
    public interface GslbEventListener {
        void onMessage(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1742596687, "Lcom/yy/gslbsdk/GslbEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1742596687, "Lcom/yy/gslbsdk/GslbEvent;");
                return;
            }
        }
        GslbEvent gslbEvent = new GslbEvent("INSTANCE", 0);
        INSTANCE = gslbEvent;
        $VALUES = new GslbEvent[]{gslbEvent};
    }

    public GslbEvent(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GslbEvent valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (GslbEvent) Enum.valueOf(GslbEvent.class, str) : (GslbEvent) invokeL.objValue;
    }

    public static GslbEvent[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (GslbEvent[]) $VALUES.clone() : (GslbEvent[]) invokeV.objValue;
    }

    public void onMessage(String str) {
        GslbEventListener gslbEventListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (gslbEventListener = this.listener) == null) {
            return;
        }
        gslbEventListener.onMessage("gslb id:" + DataCacheMgr.INSTANCE.getIdentity(GlobalTools.APP_CONTEXT) + " msg:" + str);
    }

    public void setListener(GslbEventListener gslbEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gslbEventListener) == null) {
            this.listener = gslbEventListener;
        }
    }
}
