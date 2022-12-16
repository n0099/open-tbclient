package com.googlecode.mp4parser.util;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class AndroidLogger extends Logger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "isoparser";
    public transient /* synthetic */ FieldHolder $fh;
    public String name;

    public AndroidLogger(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.name = str;
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logDebug(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            Log.d(TAG, String.valueOf(this.name) + ":" + str);
        }
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Log.e(TAG, String.valueOf(this.name) + ":" + str);
        }
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logWarn(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Log.w(TAG, String.valueOf(this.name) + ":" + str);
        }
    }
}
