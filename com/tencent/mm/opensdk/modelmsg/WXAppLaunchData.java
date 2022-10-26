package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class WXAppLaunchData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
    public static final String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
    public static final String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
    public transient /* synthetic */ FieldHolder $fh;
    public int launchType;
    public String message;

    /* loaded from: classes8.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Builder() {
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

        public static WXAppLaunchData fromBundle(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bundle)) == null) {
                WXAppLaunchData wXAppLaunchData = new WXAppLaunchData();
                wXAppLaunchData.launchType = bundle.getInt("_wxapplaunchdata_launchType");
                wXAppLaunchData.message = bundle.getString("_wxapplaunchdata_message");
                return wXAppLaunchData;
            }
            return (WXAppLaunchData) invokeL.objValue;
        }

        public static Bundle toBundle(WXAppLaunchData wXAppLaunchData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, wXAppLaunchData)) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("_wxapplaunchdata_launchType", wXAppLaunchData.launchType);
                bundle.putString("_wxapplaunchdata_message", wXAppLaunchData.message);
                return bundle;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    public WXAppLaunchData() {
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
}
