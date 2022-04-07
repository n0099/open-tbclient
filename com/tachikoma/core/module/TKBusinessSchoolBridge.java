package com.tachikoma.core.module;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Function;
import com.tachikoma.annotation.TK_EXPORT_CLASS;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.module.handler.IBusinessSchoolBridge;
import com.tachikoma.core.utility.V8Proxy;
import java.util.List;
@TK_EXPORT_CLASS
/* loaded from: classes8.dex */
public class TKBusinessSchoolBridge implements IBusinessSchoolBridge {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TKBusinessSchoolBridge";
    public transient /* synthetic */ FieldHolder $fh;
    public TKJSContext mTKJSContext;

    public TKBusinessSchoolBridge(Context context, List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTKJSContext = V8Proxy.getTKContext(list);
    }

    private IBusinessSchoolBridge getBridge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? (IBusinessSchoolBridge) this.mTKJSContext.getHandler(IBusinessSchoolBridge.class) : (IBusinessSchoolBridge) invokeV.objValue;
    }

    @Override // com.tachikoma.core.module.handler.IBusinessSchoolBridge
    public void getBusinessCourseFeedList(V8Function v8Function, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, v8Function, str, str2) == null) {
            IBusinessSchoolBridge bridge = getBridge();
            if (bridge != null) {
                bridge.getBusinessCourseFeedList(v8Function, str, str2);
            } else {
                Log.e(TAG, "bridge is null");
            }
        }
    }

    @Override // com.tachikoma.core.module.handler.IBusinessSchoolBridge
    public void getBusinessCourseInfo(V8Function v8Function) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Function) == null) {
            IBusinessSchoolBridge bridge = getBridge();
            if (bridge != null) {
                bridge.getBusinessCourseInfo(v8Function);
            } else {
                Log.e(TAG, "bridge is null");
            }
        }
    }

    @Override // com.tachikoma.core.module.handler.IBusinessSchoolBridge
    public void navigateNativePage(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj) == null) {
            IBusinessSchoolBridge bridge = getBridge();
            if (bridge != null) {
                bridge.navigateNativePage(str, obj);
            } else {
                Log.e(TAG, "bridge is null");
            }
        }
    }
}
